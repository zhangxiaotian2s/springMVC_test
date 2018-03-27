<%--
  Created by IntelliJ IDEA.
  User: zhangxiaotian
  Date: 18/2/6
  Time: 下午5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%
    String basePath= request.getContextPath();
%>
<html>

<head>
    <title><tiles:getAsString name="title"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta content="telephone=no" name="format-detection">
    <meta content="email=no" name="format-detection">
    <meta content="no" name="apple-touch-fullscreen">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <link rel="stylesheet" href="<%=basePath%>/Static/css/base/base.css">
    <link rel="stylesheet" href="<%=basePath%>/Static/css/base/iconfont.css">
    <tiles:insertAttribute name="header_css" ignore="true"></tiles:insertAttribute>
    <script>
        !function(e,t){function i(){var t=n.getBoundingClientRect().width;t/d>s&&(t=s*d);var i=t/7.5;n.style.fontSize=i+"px",c.rem=e.rem=i}var a,r=e.document,n=r.documentElement,o=r.querySelector('meta[name="viewport"]'),m=r.querySelector('meta[name="flexible"]'),l=r.querySelector('meta[name="max-width"]'),s=1024,d=0,p=0,c=t.flexible||(t.flexible={});if(o){console.warn("将根据已有的meta标签来设置缩放比例");var u=o.getAttribute("content").match(/initial\-scale=([\d\.]+)/);u&&(p=parseFloat(u[1]),d=parseInt(1/p))}else if(m){var v=m.getAttribute("content");if(v){var f=v.match(/initial\-dpr=([\d\.]+)/),h=v.match(/maximum\-dpr=([\d\.]+)/);f&&(d=parseFloat(f[1]),p=parseFloat((1/d).toFixed(2))),h&&(d=parseFloat(h[1]),p=parseFloat((1/d).toFixed(2)))}}if(l){var g=l.getAttribute("content");g&&(s=parseInt(g))}if(!d&&!p){var w=e.navigator.userAgent.match(/Android[\S\s]+AppleWebkit\/(\d{3})/i),x=e.navigator.userAgent.match(/U3\/((\d+|\.){5,})/i),b=x&&parseInt(x[1].split(".").join(""),10)>=80,A=e.navigator.appVersion.match(/(iphone|ipad|ipod)/gi);e.navigator.appVersion.match(/OS 9_3/),e.devicePixelRatio;d=e.devicePixelRatio||1,A||w&&w[1]>534||b||(d=1),p=1/d}if(n.setAttribute("data-dpr",d),!o)if(o=r.createElement("meta"),o.setAttribute("name","viewport"),o.setAttribute("content","width=device-width,initial-scale="+p+", maximum-scale="+p+", minimum-scale="+p+", user-scalable=no,user-scalable=0,viewport-fit=cover"),n.firstElementChild)n.firstElementChild.appendChild(o);else{var F=r.createElement("div");F.appendChild(o),r.write(F.innerHTML)}e.addEventListener("resize",function(){clearTimeout(a),a=setTimeout(i,300)},!1),e.addEventListener("pageshow",function(e){e.persisted&&(clearTimeout(a),a=setTimeout(i,300))},!1),i(),c.dpr=e.dpr=d,c.refreshRem=i,c.rem2px=function(e){var t=parseFloat(e)*this.rem;return"string"==typeof e&&e.match(/rem$/)&&(t+="px"),t},c.px2rem=function(e){var t=parseFloat(e)/this.rem;return"string"==typeof e&&e.match(/px$/)&&(t+="rem"),t}}(window,window.lib||(window.lib={}));
    </script>

</head>
<body>
<tiles:insertAttribute name="body"></tiles:insertAttribute>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
<tiles:insertAttribute name="footer_js" ignore="true"></tiles:insertAttribute>

</body>
</html>
