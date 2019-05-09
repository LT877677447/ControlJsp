package com.zfcom.cft.dao.provider;

import com.zfcom.cft.entity.TodayResult;
import com.zfcom.cft.utils.Constants;
import com.zfcom.cft.utils.MyDateTool;
import com.zfcom.cft.utils.PageModel;
import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TodayResultProvider {

    public String selectTodayResultByPage(Map<String, Object> params) {
        PageModel pageModel = (PageModel) params.get("pageModel");
        TodayResult todayResult = (TodayResult) params.get("todayResult");

        String sql = new SQL() {
            {
                SELECT("top " + pageModel.getPageSize() + " * ");
                FROM(Constants.TABLE_TodayResult);
                if (todayResult != null && todayResult.getTid() != null) {
                    WHERE(" tid = #{todayResult.tid}");
                }
                if (todayResult != null && todayResult.getIsremain() != null) {
                    WHERE(" isremain = #{todayResult.isremain}");
                }
                if (todayResult != null && todayResult.getAdvid() != null) {
                    WHERE(" advid = #{todayResult.advid}");
                }
                if (pageModel.getDate_1() != null && pageModel.getDate_2() != null) {
//                    WHERE("result_time between #{pageModel.date_1} and #{pageModel.date_2}");
                    WHERE("result_time between '"+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",pageModel.getDate_1())+"' and '"+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",pageModel.getDate_2())+"' ");
                }
                WHERE(selectTodayResultByPage_Subselect(pageModel, todayResult));

                if (pageModel.getOrder() != null) {
                    ORDER_BY(pageModel.getOrder());
                }
            }
        }.toString();
        return sql;
    }

    public String count(Map<String, Object> params){
        TodayResult todayResult = (TodayResult) params.get("todayResult");
        PageModel pageModel = (PageModel) params.get("pageModel");

        String sql = new SQL() {
         {
            SELECT("COUNT(*)");

            FROM(Constants.TABLE_TodayResult);
            if(null != todayResult) {
                if (null != todayResult.getAdvid()) {
                    WHERE("advid = #{todayResult.advid}");
                }
                if (null != todayResult.getIsremain()) {
                    WHERE("isremain = #{todayResult.isremain}");
                }
                if (pageModel.getDate_1() != null && pageModel.getDate_2() != null) {
                    WHERE("result_time between '"+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",pageModel.getDate_1())+"' and '"+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",pageModel.getDate_2())+"' ");
                }
            }
          }
        }.toString();
        return sql;
    }

    private String selectTodayResultByPage_Subselect(PageModel pageModel, TodayResult todayResult) {
        String sql = "tid not in (select top ";
        sql += (pageModel.getPageIndex() - 1) * pageModel.getPageSize();
        sql += " tid from " + Constants.TABLE_TodayResult;
        sql += " where 1=1 ";
        if (todayResult != null && todayResult.getTid() != null) {
            sql += " and tid = " + todayResult.getTid();
        }
        if (todayResult != null && todayResult.getIsremain() != null) {
            sql += " and isremain = " + todayResult.getIsremain();
        }
        if (todayResult != null && todayResult.getAdvid() != null) {
            sql += " and advid = " + todayResult.getAdvid();
        }
        if (pageModel.getDate_1() != null && pageModel.getDate_2() != null) {
//            sql += " and result_time between " + pageModel.getDate_1() + " and " + pageModel.getDate_2();
            sql += " and result_time between '" + MyDateTool.Format("yyyy-MM-dd HH:mm:ss",pageModel.getDate_1()) + "' and '" + MyDateTool.Format("yyyy-MM-dd HH:mm:ss",pageModel.getDate_2())+"' ";
        }
        if (pageModel.getOrder() != null) {
            sql += " order by " + pageModel.getOrder();
        }
        sql += " )";
        return sql;
    }

    @Test
    public void test1() {
        String sql = new SQL()
                .SELECT("id, name").FROM("PERSON A")
                .WHERE("name like ?")
                .WHERE("id = ?").toString();
        System.err.println(sql);
    }

    @Test
    public void test2() {
        List<Integer> tid = new ArrayList<>();
        tid.add(1);
        tid.add(2);
        tid.add(3);
        String sql = new SQL() {
            {
                SELECT("top " + 10 + " tid ");
                FROM(Constants.TABLE_TodayResult);
                WHERE(" tid = 15");
                WHERE(" isremain = '0'");
                WHERE(" advid = 1015");
                WHERE("tid not in " + tid);
                ORDER_BY("id desc");
            }
        }.toString();
        System.out.println(sql);

    }


}
