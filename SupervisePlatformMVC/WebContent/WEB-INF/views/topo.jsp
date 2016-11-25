<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<link href="<%=basePath%>static/css/esm-topo.css" rel="stylesheet">
<link href="<%=basePath%>static/css/sb-admin.css" rel="stylesheet">
<link href="<%=basePath%>static/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<body>

	<div id="wrapper">
		<jsp:include page="head.jsp" />



		<!-- 这里开始显示所有设备信息 -->
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row show-grid" style="background-image: url(static/img/demo4.jpg);margin-left: -24px;margin-top: -8px;margin-right: -24px">
					<div class="col-lg-12">
						 <h3 class="page-header" style="color: #ff5454;font-size: x-large">
                        <b>机房运行可视化界面</b>
                        <small></small>
                    </h3>
					</div>

					<!--这里用来数据传递到查询页面-->
					<input type="hidden" id="jumpToFindPage" />

					<!--这里是开始显示拓扑图-->
					<div style="margin-top: 60px">
                    <div style="height: 400px;width: 100%;">
                        <div style="background-image: url(static/img/pic1.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left">

                        </div>
                        <div style="background-image: url(static/img/pic2.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left">

                        </div>
                        <div style="background-image: url(static/img/pic3.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets3">

                            <div style="float: left;">
                                <div style="height: 11px;float: left">
                                    <img src="static/img/up1.png" style="margin-left: 17px;margin-top: 10px" id="3_SWITCH_1_0" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="3_SWITCH_1_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="3_SWITCH_1_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="3_SWITCH_1_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="3_SWITCH_1_8" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="3_SWITCH_1_10" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="3_SWITCH_1_12" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="3_SWITCH_1_14" onclick="imgShowInfo(this);">
                                </div>
                                <div style="height: 9px;float: left">
                                    <img src="static/img/down1.png" style="margin-left: 17px;" id="3_SWITCH_1_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="3_SWITCH_1_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="3_SWITCH_1_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="3_SWITCH_1_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="3_SWITCH_1_9" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="3_SWITCH_1_11" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="3_SWITCH_1_13" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="3_SWITCH_1_15" onclick="imgShowInfo(this);">
                                </div>
                            </div>
                            <div style="float: left;margin-left: 19px;margin-top: 18px">
                                <div style="height: 10px;float: left">
                                    <img src="static/img/up11.png" style="float: left;margin-left: 0px" id="3_SWITCH_2_0" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_14" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_16" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_18" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_22" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_26" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_28" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_30" onclick="imgShowInfo(this);">
                                </div>
                                <div style="height: 10px;float: left">
                                    <img src="static/img/down11.png" style="float: left;margin-left: 0px" id="3_SWITCH_2_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_3" onclick="imgShowInfo(this);">
                                    <!--5  7端口为空-->
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_7" onclick="imgShowInfo(this);">

                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_17" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_19" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_23" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_25" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_27" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_29" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_2_31" onclick="imgShowInfo(this);">
                                </div>
                            </div>
                            <div style="float: left;margin-left: 19px;margin-top: 5px">
                                <div style="height: 10px;float: left">
                                    <img src="static/img/up11.png" style="float: left;margin-left: 0px" id="3_SWITCH_3_0" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_8" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_10" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_12" onclick="imgShowInfo(this);">
                                    <!--只有这四个数据-->
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_32" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_34" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_36" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_38" onclick="imgShowInfo(this);">
                                </div>
                                <div style="height: 10px;float: left">
                                    <img src="static/img/down11.png" style="float: left;margin-left: 0px" id="3_SWITCH_3_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_9" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_11" onclick="imgShowInfo(this);">
                                    <!--这里有5个数据-->
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_31" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_33" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_35" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_37" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="3_SWITCH_3_39" onclick="imgShowInfo(this);">
                                </div>
                            </div>
                            
                            <img src="static/img/dpx.png" style="margin-left: 19px">
                            <img src="static/img/h3cs12508.gif" style="margin-left: 19px">
                            <!--跟4类似-->
                        </div>
                        <div style="background-image: url(static/img/pic4.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets4">
                            <div style="float: left;margin-left: 19px;margin-top: 30px">
                                <!--机柜4的排线信息还不确定-->
                                <div style="height: 10px;float: left">
                                    <img src="static/img/up11.png" style="float: left;margin-left: 0px" id="4_SWITCH_1_0" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px"id="4_SWITCH_1_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_8" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_10" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_12" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_14" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_16" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_18" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_20" onclick="imgShowInfo(this);">
                                </div>
                                <div style="height: 10px;float: left">
                                    <img src="static/img/down11.png" style="float: left;margin-left: 0px" id="4_SWITCH_1_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_9" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_11" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_13" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_15" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_17" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_19" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_1_21" onclick="imgShowInfo(this);">
                                </div>
                            </div>
                            <div style="float: left;margin-left: 19px;margin-top: 5px">
                                <div style="height: 10px;float: left">
                                    <img src="static/img/up11.png" style="float: left;margin-left: 0px" id="4_SWITCH_2_0" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_8" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_10" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_12" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_14" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_16" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_18" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_20" onclick="imgShowInfo(this);">
                                </div>
                                <div style="height: 10px;float: left">
                                    <img src="static/img/down11.png" style="float: left;margin-left: 0px" id="4_SWITCH_2_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_9" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_11" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_13" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_15" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_17" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_19" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="4_SWITCH_2_21" onclick="imgShowInfo(this);">
                                </div>
                            </div>
                            <img src="static/img/dpx.png" style="margin-left: 19px;margin-top: 10px">
                            <img src="static/img/h3cs12508.gif" style="margin-left: 19px">
                            <!--直接参考图片-->
                        </div>
                        <div style="background-image: url(static/img/pic5.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets5">
                            <!--机柜为空-->
                        </div>
                        <div style="background-image: url(static/img/pic6.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets6">
                            <img src="static/img/device5.gif" style="margin-left: 19px;margin-top: 200px">
                            <!--手机图片-->
                        </div>
                        <div style="background-image: url(static/img/pic7.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets7">
                            <div style="float: left;">
                                <div style="height: 11px;float: left">
                                    <img src="static/img/up1.png" style="margin-left: 13px;margin-top: 10px" id="7_SWITCH_1_0" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="7_SWITCH_1_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="7_SWITCH_1_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="7_SWITCH_1_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="7_SWITCH_1_8" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="7_SWITCH_1_10" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="7_SWITCH_1_12" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="7_SWITCH_1_14" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="7_SWITCH_1_16" onclick="imgShowInfo(this);">

                                </div>
                                <div style="height: 9px;float: left">
                                    <img src="static/img/down1.png" style="margin-left: 13px;" id="7_SWITCH_1_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="7_SWITCH_1_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="7_SWITCH_1_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="7_SWITCH_1_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="7_SWITCH_1_9" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="7_SWITCH_1_11" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="7_SWITCH_1_13" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="7_SWITCH_1_15" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="7_SWITCH_1_17" onclick="imgShowInfo(this);">
                                </div>
                            </div>
                            <div style="float: left;margin-left: 19px;margin-top: 30px">
                                <div style="height: 10px;float: left">
                                    <img src="static/img/up11.png" style="float: left;margin-left: 0px" id="7_SWITCH_2_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_21" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_22" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_23" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_2_24" onclick="imgShowInfo(this);">
                                </div>
                                <div style="height: 10px;float: left;margin-top: 1px">
                                    <img src="static/img/down11.png" style="float: left;margin-left: 0px" id="7_SWITCH_3_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_21" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_22" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_23" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="7_SWITCH_3_24" onclick="imgShowInfo(this);">
                                </div>
                            </div>

                            <img src="static/img/1u_yellow.png" style="margin-left: 17px;margin-top: 13px" id="7_SERVER_4" onclick="imgShowInfo(this);">

                            <img src="static/img/1u_yellow.png" style="margin-left: 17px;margin-top: 13px" id="7_SERVER_5" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_yellow.png" style="margin-left: 17px;margin-top: 13px" id="7_SERVER_6" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_yellow.png" style="margin-left: 17px;margin-top: 13px" id="7_SERVER_7" onclick="imgShowInfo(this);">


                            <!--塔式服务器-->
                            <img src="static/img/server塔式1.png" style="margin-left: 50px;margin-top: 35px" id="G07U14_left" onclick="imgShowInfo(this);">
                            <img src="static/img/server塔式1.png" style="margin-left: 50px;margin-top: 35px" id="G07U14_right" onclick="imgShowInfo(this);">
                        </div>
                    </div>
                </div>
                <div style="margin-top: 40px">
                    <div style="height: 400px;width: 100%;">
                        <div style="background-image: url(static/img/pic8.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets8">
                            <img src="static/img/1u_yellow.png" style="margin-left: 17px;margin-top: 13px" id="G08U41" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_green.png" style="margin-left: 17px;margin-top: 33px" id="G08U35" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_green.png" style="margin-left: 17px;margin-top: 15px" id="G08U32" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_green.png" style="margin-left: 17px;margin-top: 10px" id="G08U29" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_green.png" style="margin-left: 17px;margin-top: 13px" id="G08U26" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_green.png" style="margin-left: 17px;margin-top: 10px" id="G08U23" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_green.png" style="margin-left: 17px;margin-top: 35px" id="G08U17" onclick="imgShowInfo(this);">
                            <img src="static/img/4u_green.png" style="margin-left: 17px;margin-top: 12px" id="G08U12" onclick="imgShowInfo(this);">
                            <img src="static/img/4u_green.png" style="margin-left: 17px;margin-top: 15px" id="G08U07" onclick="imgShowInfo(this);">
                            <img src="static/img/4u_green.png" style="margin-left: 17px;margin-top: 15px" id="G08U02" onclick="imgShowInfo(this);">
                        </div>
                        <div style="background-image: url(static/img/pic9.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets9">
                            <div style="float: left;margin-left: 19px;margin-top: 10px">
                                <div style="height: 10px;float: left">
                                    <img src="static/img/up11.png" style="float: left;margin-left: 0px" id="9_SWITCH_1_0" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_8" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_10" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_12" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_14" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_16" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_18" onclick="imgShowInfo(this);">
                                    <img src="static/img/up1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_20" onclick="imgShowInfo(this);">
                                </div>
                                <div style="height: 10px;float: left">
                                    <img src="static/img/down11.png" style="float: left;margin-left: 0px" id="9_SWITCH_1_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_9" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_11" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_13" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_15" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_17" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_19" onclick="imgShowInfo(this);">
                                    <img src="static/img/down1中.png" style="float: left;margin-left: 2px" id="9_SWITCH_1_21" onclick="imgShowInfo(this);">
                                </div>
                            </div>
                            <div style="float: left;">
                                <div style="height: 11px;float: left">
                                    <img src="static/img/up1.png" style="margin-left: 17px;margin-top: 10px" id="9_SWITCH_2_0" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="9_SWITCH_2_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="9_SWITCH_2_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="9_SWITCH_2_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="9_SWITCH_2_8" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="9_SWITCH_2_10" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="9_SWITCH_2_12" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="9_SWITCH_2_14" onclick="imgShowInfo(this);">
                                </div>
                                <div style="height: 9px;float: left">
                                    <img src="static/img/down1.png" style="margin-left: 17px;" id="9_SWITCH_2_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="9_SWITCH_2_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="9_SWITCH_2_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="9_SWITCH_2_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="9_SWITCH_2_9" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="9_SWITCH_2_11" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="9_SWITCH_2_13" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="9_SWITCH_2_15" onclick="imgShowInfo(this);">
                                </div>
                            </div>

                            <img src="static/img/2u_red.png" style="margin-top: 10px;margin-left: 17px" id="9_SERVER_3" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_red.png" style="margin-top: 1px;margin-left: 17px" id="9_SERVER_4" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_red.png" style="margin-top: 10px;margin-left: 17px" id="9_SERVER_5" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" style="margin-top: 10px;margin-left: 17px" id="9_SERVER_6" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_yellow.png" style="margin-top: 10px;margin-left: 17px" id="9_SERVER_7" onclick="imgShowInfo(this);">

                            <!--塔式服务器，17-22u -->
                            <img src="static/img/server_塔式.png" style="margin-top: 10px;margin-left: 50px" id="9_SERVER_8" onclick="imgShowInfo(this);">

                        </div>
                        <div style="background-image: url(static/img/pic10.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets10">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 200px" id="10_STOR_1" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 12px" id="10_STOR_2" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 10px" id="10_STOR_3" onclick="imgShowInfo(this);">

                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 55px" id="10_SERVER_4" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 3px" id="10_SERVER_5" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 3px" id="10_SERVER_6" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 3px" id="10_SERVER_7" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 3px"id="10_SERVER_8" onclick="imgShowInfo(this);">

                        </div>
                        <div style="background-image: url(static/img/pic11.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets11">
                            <div style="float: left;">
                                <div style="height: 11px;float: left">
                                    <img src="static/img/up1.png" style="margin-left: 17px;margin-top: 10px" id="11_SWITCH_1_1" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="11_SWITCH_1_3" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="11_SWITCH_1_5" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="11_SWITCH_1_7" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="11_SWITCH_1_9" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="11_SWITCH_1_11" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="11_SWITCH_1_13" onclick="imgShowInfo(this);">
                                    <img src="static/img/up中.png" style="margin-top: 10px" id="11_SWITCH_1_15" onclick="imgShowInfo(this);">
                                </div>
                                <div style="height: 9px;float: left">
                                    <img src="static/img/down1.png" style="margin-left: 17px;" id="11_SWITCH_1_2" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="11_SWITCH_1_4" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="11_SWITCH_1_6" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="11_SWITCH_1_8" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="11_SWITCH_1_10" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="11_SWITCH_1_12" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="11_SWITCH_1_14" onclick="imgShowInfo(this);">
                                    <img src="static/img/down中.png" style="" id="11_SWITCH_1_16" onclick="imgShowInfo(this);">
                                </div>
                            </div>
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 40px" id="11_STOR_2" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 8px" id="11_STOR_3" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 8px" id="11_STOR_4" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top:8px" id="11_STOR_5" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 20px" id="11_STOR_6" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 15px" id="11_STOR_7" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 15px" id="11_STOR_8" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 10px" id="11_STOR_9" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 50px" id="11_SERVER_10" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 6px" id="11_SERVER_11" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 6px" id="11_SERVER_12" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 6px" id="11_SERVER_13" onclick="imgShowInfo(this);">

                        </div>
                        <div style="float: inherit">
                            <div style="background-image: url(static/img/pic12.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                                 id="Cabinets12">
                                <img src="static/img/2u_red.png" class="img-responsive"
                                     style="margin-top: 115px;margin-left: 17px" id="12_SERVER_1" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_green.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_2" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_red.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_3" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_green.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_4" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_yellow.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_5" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_green.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_6" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_yellow.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_7" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_green.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_8" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_red.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_9" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_yellow.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_10" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_red.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_11" onclick="imgShowInfo(this);">
                                <img src="static/img/2u_green.png" class="img-responsive"
                                     style="margin-top: 6px;margin-left: 17px" id="12_SERVER_12" onclick="imgShowInfo(this);">
                            </div>
                        </div>
                        <div style="background-image: url(static/img/pic13.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets13">
                            <img src="static/img/2u_green.png" class="img-responsive"
                                 style="margin-top: 68px;margin-left: 17px" id="G13U40" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_red.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U37" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_yellow.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U34" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_red.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U31" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_red.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U29" onclick="imgShowInfo(this);">
                            <img src="static/img/1u_green.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U28" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_yellow.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U25" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_green.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U23" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_yellow.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U20" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_red.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U17" onclick="imgShowInfo(this);">
                            <img src="static/img/4u_green.png" class="img-responsive"
                                 style="margin-top: 5px;margin-left: 17px" id="G13U13" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_yellow.png" class="img-responsive"
                                 style="margin-top: 3px;margin-left: 17px" id="G13U10" onclick="imgShowInfo(this);">
                            <img src="static/img/4u_red.png" class="img-responsive"
                                 style="margin-top: 3px;margin-left: 17px" id="G13U06" onclick="imgShowInfo(this);">
                            <img src="static/img/4u_yellow.png" class="img-responsive"
                                 style="margin-top: 3px;margin-left: 17px" id="G13U01"
                                 onclick="imgShowInfo(this);">
                        </div>
                        <div style="background-image: url(static/img/pic14.gif);width: 220px;border: solid;height: 400px;margin-left: 18px;float: left"
                             id="Cabinets14">
                            <img src="static/img/2u_red.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 100px" id="G14U30" onclick="imgShowInfo(this);">
                            <img src="static/img/2u_red.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 10px" id="G14U27" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 12px" id="G14U24" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 12px" id="G14U21" onclick="imgShowInfo(this);">
                            <img src="static/img/mem_yellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 12px" id="G14U18" onclick="imgShowInfo(this);">
                            <img src="static/img/mem4ugreen.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 12px" id="G14U13" onclick="imgShowInfo(this);">
                            <img src="static/img/mem4ured.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 12px" id="G14U08" onclick="imgShowInfo(this);">
                            <img src="static/img/mem4uyellow.png" class="img-responsive"
                                 style="margin-left: 17px;margin-top: 12px" id="G14U01" onclick="imgShowInfo(this);">
                        </div>
                    </div>
                </div>
						<div style="margin-top: 10px">
							<div style="height: 400px; width: 100%">
								<div
									style="background-image: url(static/img/pic5.gif); width: 220px; border: solid; height: 400px; margin-left: 18px; float: left"
									id="Cabinets15"></div>
								<div
									style="background-image: url(static/img/pic5.gif); width: 220px; border: solid; height: 400px; margin-left: 18px; float: left"
									id="Cabinets16"></div>
							</div>
						</div>


					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- /#page-wrapper -->
			<div id="page-floor">
				<div>@2016 版权所有：中国电建集团成都勘测设计研究院有限公司</div>
			</div>
		</div>
		<!-- /#wrapper -->
		<jsp:include page="foot.jsp" />

		<div class="modal fade" id="show_Server_modal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">服务器当前信息：</h4>
					</div>
					<div class="modal-body">

						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">设备ID：</label>
								<label class="col-md-2 " id="lblToID" style="text-align: center"></label>
								<label class="col-md-3 text-success" style="text-align: right">CPU：</label>
								<label class="col-md-2 " id="lblToCPU"
									style="text-align: center">dfdfdfdfsdf</label>

							</div>
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">AllMem：</label>
								<label class="col-md-2 " id="lblToAllMem"
									style="text-align: center">192.168.1.109</label> <label
									class="col-md-3 text-success" style="text-align: right">Mem：</label>
								<label class="col-md-4 " id="lblToMemo"
									style="text-align: center">2-34-232-232-232</label>

							</div>
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">AllStor：</label>
								<label class="col-md-2 " id="lblToAllStor"
									style="text-align: center">19</label> <label
									class="col-md-3 text-success" style="text-align: right">Stor：</label>
								<label class="col-md-4 " id="lblToStori"
									style="text-align: center">3.98GB/2.56GB</label>
							</div>
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">UpFlow：</label>
								<label class="col-md-2 " id="lblToUpFlow"
									style="text-align: center">368GB/356.34GB</label> <label
									class="col-md-3 text-success" style="text-align: right">UpFlowAvg：</label>
								<label class="col-md-4 " id="lblToUpFlowAvg"
									style="text-align: center">3.98KB/2.56KB</label>
							</div>
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">DownFlow：</label>
								<label class="col-md-2 " id="lblToDownFlow"
									style="text-align: center">368GB/356.34GB</label> <label
									class="col-md-3 text-success" style="text-align: right">DownFlowAvg：</label>
								<label class="col-md-4 " id="lblToDownFlowAvg"
									style="text-align: center">3.98KB/2.56KB</label>
							</div>

						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" id="alter_close"
							data-dismiss="modal">关闭</button>
						<!-- 这里进行页面跳转，跳转到查询页面进行具体操作 -->
						<button type="button" class="btn btn-primary"
							onClick="JumpToServerQuery();">详情</button>
					</div>
				</div>
			</div>
		</div>
		<!--显示服务器相关信息-->

		<div class="modal fade" id="show_Switch_modal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="switchModalLabel">交换机当前信息：</h4>
					</div>
					<div class="modal-body">

						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">交换机ID：</label>
								<label class="col-md-2 " id="lblSwitchToID"
									style="text-align: center"></label> <label
									class="col-md-3 text-success" style="text-align: right">位置：</label>
								<label class="col-md-4 " id="lblSwitchToLoc"
									style="text-align: center">2-34-232-232-232</label>
							</div>
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">端口编号：</label>
								<label class="col-md-2 " id="lblSwitchToPort"
									style="text-align: center">19</label> <label
									class="col-md-3 text-success" style="text-align: right">端口IP：</label>
								<label class="col-md-4 " id="lblSwitchToPortIp"
									style="text-align: center">192.168.1.1</label>
							</div>
							<div class="form-group">
								<label class="col-md-3 text-success" style="text-align: right">上行/下行流量：</label>
								<label class="col-md-4 " id="lblSwitchToFlow"
									style="text-align: center">3.98KB/2.56KB</label>
							</div>
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">连接信息：</label>
								<label class="col-md-2" id="lblSwitchToConn"
									style="text-align: center"></label>
							</div>

						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
							id="Switch_Modal_close" data-dismiss="modal">关闭</button>
						<!-- 这里进行页面跳转，跳转到查询页面进行具体操作 -->
						<button type="button" class="btn btn-primary"
							onClick="JumpToSwitchQuery();">详情</button>
					</div>
				</div>
			</div>
		</div>
		<!--关于交换机的一些信息-->

		<div class="modal fade" id="show_Stor_modal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="StorModalLabel">存储设备当前信息：</h4>
					</div>
					<div class="modal-body">

						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">设备名称：</label>
								<label class="col-md-2 " id="lblStorToName"
									style="text-align: center"></label> <label
									class="col-md-3 text-success" style="text-align: right">设备IP：</label>
								<label class="col-md-2 " id="lblStorToIp"
									style="text-align: center">192.168.1.1</label>

							</div>
							<div class="form-group">
								<label class="col-md-2 text-success" style="text-align: right">总容量：</label>
								<label class="col-md-2 " id="lblStorTotalMem"
									style="text-align: center">1024M</label> <label
									class="col-md-3 text-success" style="text-align: right">位置：</label>
								<label class="col-md-4 " id="lblStorLaveMem"
									style="text-align: center">500M</label>

							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
							id="Stor_Modal_close" data-dismiss="modal">关闭</button>
						<!--这里进行页面跳转，跳转到查询页面进行具体操作-->
						<button type="button" class="btn btn-primary"
							onClick="JumpToStorQuery();">详情</button>
					</div>
				</div>
			</div>
		</div>
		<!--显示存储设备相关信息-->

		<!-- jQuery -->
		<script src="<%=basePath%>static/js/jquery-1.11.1.min.js"
			type="text/javascript"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="<%=basePath%>static/js/bootstrap.min.js"
			type="text/javascript"></script>

		<!--esm-topo.js-->
		<script src="<%=basePath%>static/js/esm-topo.js"
			type="text/javascript"></script>

		<!-- Morris Charts JavaScript
<script src="js/plugins/morris/raphael.min.js"></script>
<script src="js/plugins/morris/morris.min.js"></script>
<script src="js/plugins/morris/morris-data.js"></script> -->
		<script type="text/javascript">
			//$("#a_allstatus").show();
			// $('#a_allstatus').load('c.html');

			$(document).ready(function() {
				$("#m_allstatus").click(function() {
					hideAllDiv();
					$("#a_allstatus").show();
					$('#a_allstatus').load('c.html');
				});
				$("#m_servicestatus").click(function() {
					hideAllDiv();
					$("#a_servicestatus").show();
					$('#a_servicestatus').load('topo.html');
				});
				$("#m_userman").click(function() {
					hideAllDiv();
					$("#a_userman").show();
					$('#a_userman').load('userman.html');
				});
			});
			function hideAllDiv() {

				if (document.getElementById) {
					var ar = document.getElementsByTagName("div");
					var i;
					for (i = 0; i < ar.length; i++) {
						if (ar[i].className == "a_content")
							ar[i].style.display = "none";
					}
				}
			}
		</script>
</body>
</html>
