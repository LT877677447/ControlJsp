<%--suppress XmlPathReference --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>云控后台主页</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="<c:url value="/assets/i/favicon2.png"/> ">
  <link rel="apple-touch-icon-precomposed" href="<c:url value="/assets/i/app-icon72x72@2x.png"/> ">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<c:url value='/assets/css/amazeui.min.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/assets/css/admin.css'/>">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong>Amaze UI</strong> <small>云控后台主页</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#" disabled=""><span class="am-icon-commenting"></span>功能开发中，敬请期待</a></li>
        </ul>
      </li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="<c:url value="/index/todayResult?pageIndex=1&pageSize=10&order=result_time desc"/>" target="mainContent"><span class="am-icon-home"></span> 广告结果统计</a></li>
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 广告管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <li><a href="<c:url value="/index/APKList?pageIndex=1&pageSize=10"/>" class="am-cf" target="mainContent"><span class="am-icon-apple"></span> APK包管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="<c:url value="/index/AdvList?pageIndex=1&pageSize=10"/>" class="am-cf" target="mainContent"><span class="am-icon-puzzle-piece"></span> 任务管理</a></li>
            <li><a href="<c:url value="/index/Devactstatus?pageIndex=1&pageSize=10"/>" class="am-cf" target="mainContent"><span class="am-icon-th"></span> 设备状态<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
            <li><a href="<c:url value="/index/DeviceInfos?pageIndex=1&pageSize=10"/>" class="am-cf" target="mainContent"><span class="am-icon-book"></span> 设备任务</a></li>
            <%--<li><a href="<c:url value="/index/gaiden?pageIndex=1&pageSize=10"/>" class="am-cf" target="mainContent"><span class="am-icon-book"></span> 设备任务</a></li>--%>
          </ul>
        </li>
      </ul>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>
        </div>
      </div>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-tag"></span> wiki</p>
          <p>Welcome to the Amaze UI wiki!</p>
        </div>
      </div>
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <iframe name="mainContent" src="<c:url value="/index/todayResult?pageIndex=1&pageSize=10&order=result_time desc"/>" width="85%" height="100%">

  </iframe>


  <!-- content end -->

</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="<c:url value='/assets/js/amazeui.ie8polyfill.min.js'/> "></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<c:url value="/js/jquery-2.2.2.js"/> "></script>
<!--<![endif]-->
<script src="<c:url value="/assets/js/amazeui.min.js"/> "></script>
<script src="<c:url value="/assets/js/app.js"/> "></script>
<script>
  // $('#am-icon-envelope-o').on(click)




</script>



</body>
</html>
