<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String path = request.getContextPath();%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>编辑个人资料-知乎</title>
        <link rel="icon" href="../images/logo.jpg" type="image/x-icon">
        <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="../css/personal.css" />
        <link rel="stylesheet" type="text/css" href="../css/Font-Awesome-3.2.1/css/font-awesome.css" />
        <link rel="stylesheet" type="text/css" href="../css/personaledit.css" />
        <link rel="stylesheet" type="text/css" href="../css/index.css" />
        <script type="text/javascript" src="../js/jquery-3.2.0.min.js"></script>
        <script type="text/javascript" src="../js/personaledit.js"></script>
        <script type="text/javascript" src="../js/raiseQuestions.js"></script>
    </head>
    <script>
        var path = "<%=path%>";
        var address = "${userInfo.userAddress }";
    </script>
    <body>
        <header>
            <div class="header-inner">
                <div class="peologo"></div>
                <div class="menu">
                    <a href="#">首页</a>
                    <a href="<%=path %>/jsp/statistics.jsp">统计</a>
                    <a href="<%=path%>/jsp/topicdynamics.jsp">话题</a>
                </div>
                <div class="search">
                    <form action="<%=path%>/jsp/topicdynamics.jsp" method="post">
                        <input class="search-input" type="text" name="searchContent" placeholder="搜索你感兴趣的内容..."/>
                        <input type="submit" value="" class="searbtn"/>
                    </form>
                </div>  
                <div class="btnwen">提问</div>             
                <div class="info">
                    <a href="#" class="userinfo">
                        <span class="icon-bell-alt icon-large"></span>
                    </a>
                    <a href="#" class="userinfo">
                        <span class="icon-comments icon-large"></span> 
                    </a>
                    <a href="<%=path%>/jsp/personal.jsp" class="userinfo"><img src="${userInfo.imageUrl}" width="35" height="35"/></a>
                    <a href="javascript:location.href='<%=path %>/logoutServlet'" class="userinfo">退出</a>
                </div>   
            </div>
        </header>
        <!-- 知乎头部开始 -->
        <div class="header" hidden>
            <div class="wrap">
                <div class="col-2"><div class="logo"></div></div>
                <div class="col-6"><div class="search">
                    <form action="">
                        <input class="search-input" type="text" name="searchContent" placeholder="搜索你感兴趣的内容"/>
                        <input type="submit" value="" class="searbtn"/>
                    </form>
                </div></div>
                 <div class="col-2"><div class="menu">
                    <ul>
                        <li><a href="<%=path %>/jsp/topicdynamics.jsp">首页</a></li>
                        <li><a href="<%=path %>/jsp/topicdynamics.jsp">话题</a></li>
                        <li><a href="<%=path %>/jsp/statistics.jsp">统计</a></li>
                        <li><a href="#">消息</a></li>
                        <li><a href="#">我</a></li>
                    </ul>
                </div></div>
                
                <div class="info">
                    <a href="#" class="userinfo">
                        <span> ${userInfo.userName }</span>
                        <img src="${userInfo.imageUrl}" alt="${userInfo.userName }" width="35" height="35"/>
                    </a>
                    <ul class="down">
                        <li><a href="#">我的主页</a></li>
                        <li><a href="#">私信</a></li>
                        <li><a href="#">设置</a></li>
                        <li><a href="#">退出</a></li>
                    </ul>
                </div>
                <div class="btnwen btn">提问</div>
            </div>
        </div>
        <!-- 知乎头部结束 -->
        <form action="/EditServlet" >
        <div class="main">
            <div class="card">
                <div class="usercover">
                    <button class="icon-camera"> 编辑封面图片</button>
                </div>
                <div class="peopleinfo">
                    <img class="photo" id="ava" src="${userInfo.imageUrl}" alt="">
                    <div class="photo">
                        <span class="icon-camera xiugai"></span>
                        <span class="xiugaizi">修改我的头像</span>
                    </div>
                    <h1 class="mar-zuo">
                        ${userInfo.userName }
                        <a href="<%=path %>/jsp/personal.jsp" class="back">
                            返回我的主页
                            <span class="icon-angle-right"></span>
                        </a>
                    </h1>
                    <button class="modify">
                        <span class="icon-edit"></span>
                        修改
                    </button>
                    <input type="file" name="file" id="file" class="file" accept="image/png,image/jpeg" onchange="upload()">
                </div>
                    <div class="intruduce">
                        <div class="xinxi">
                            <div class="fild">
                                <h3 class="fildlabel">性别</h3>
                                <div class="fildcontent">
                                    <input type="radio" name="sex" id="0" value="女" disabled="disabled" checked="${userInfo.userGender==0 }" />女
                                    <input type="radio" name="sex" id="1" value="男" disabled="disabled" checked="${userInfo.userGender==1 }"/>男
                                </div>
                            </div>
                            <div class="fild">
                                <h3 class="fildlabel">居住地</h3>
                                <div class="fildcontent">
                                    <select name="province" id="province" class="select fildtext" disabled="disabled">
                                        <option value="">请选择</option>
                                    </select>
                                    <select name="city" id="city" class="select fildtext" disabled="disabled">
                                        <option value="">请选择</option>
                                    </select>
                                    <!-- <textarea class="fildtext" id="address" rows="3" cols="30" readonly="true">大东北</textarea> -->
                                </div>
                            </div>
                            <div  class="fild">
                                <h3 class="fildlabel">所在行业</h3>
                                <div class="fildcontent">
                                    <input type="text" class="fildtext" id="job" name="job" readonly="true" value="${userInfo.userIndustry }"/>
                                </div>
                            </div>
                            <div  class="fild">
                                <h3 class="fildlabel">邮箱</h3>
                                <div class="fildcontent">
                                    <input type="email" class="fildtext" id="email"   name="email" readonly="true" value="${userInfo.userEmail }"/>
                                </div>
                            </div>
                            <div  class="fild">
                                <h3 class="fildlabel">教育经历</h3>
                                <div class="fildcontent">
                                    <input type="text" class="fildtext" id="education" name="education" readonly="true" value="${userInfo.userEducation }" />
                                </div>
                            </div>
                            <div  class="fild">
                                <h3 class="fildlabel">出生年月</h3>
                                <div class="fildcontent">
                                    <input type="date" id="birthday" name="birthday" readonly="true" class="fildtext" value="${userInfo.userBirthday }"/>
                                </div>
                            </div>
                            <div  class="fild">
                                <h3 class="fildlabel">电话</h3>
                                <div class="fildcontent">
                                    <input type="tel" class="fildtext" id="phone"  name="phone" readonly="true" value="${userInfo.userPhone }" />
                                </div>
                            </div>
                            <div  class="fild">
                                <h3 class="fildlabel">个人简介</h3>
                                <div class="fildcontent">
                                     <textarea class="fildtext" id="introduce"  name="introduce" readonly="true" rows="3" cols="30">${userInfo.userIntroduce }</textarea>
                                </div>
                            </div>
                            <div  class="fild">
                                <h3 class="fildlabel">关注话题</h3>
                                <div class="fildcontent" id="topicContainer">
                                </div>
                            </div>
                        </div>
                    </div>
                <div class="save-btn"><!-- <button class="save" id="save" hidden>保存</button> -->
                <input type="submit"  class="save" id="save" >保存               
                </div>
            </div>
        </div>
        </form>
        
        <!-- 提问的弹出框 -->
        <div class="Modal-wrapper" id="Modal-wrapper">
            <div class="Modal-backdrop"></div>
            <div class="Modal-large">
                <div class="Modal-inner">
                    <span class="icon-remove guanbi"></span>
                    <h3 class="Modal-title">写下你的问题</h3>
                    <div class="Modal-subtitle">描述精确的问题更易得到解答</div>
                    <div class="Modal-content">
                        <div class="askquestion">
                            <div class="QuestionAsk-section">
                                <div class="asktitle">
                                    <textarea required="required" id="questionTitle" rows="2" class="Input" placeholder="问题标题"></textarea>
                                </div>
                            </div>
                            <div class="QuestionAsk-section">
                                <div class="asktitle">
                                    <select name="questionTopic" id="questionTopic" class="Input" style="color: #757575">
                                        <option value="">添加话题</option>
                                    </select>
                                </div>
                            </div>
                            <div class="QuestionAsk-section">
                                <div class="askhead">问题描述：</div>
                                <div class="asktitle">
                                    <textarea required="required" id="questionIntroduce" rows="2" class="Input" placeholder="问题背景、条件等详细信息"></textarea>
                                </div>
                            </div>
                            <%--<div class="QuestionAsk-section">
                                <div class="chec"><input type="checkbox" class="checkbox"/>匿名提问</div>
                            </div>--%>
                            <div class="tijiao">
                                <button class="tijiaobtn">提交问题</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>  
        </div>
        <!-- 提问的弹出框结束 -->
        <script type="text/javascript" src="../js/common.js"></script>
    </body>

</html>