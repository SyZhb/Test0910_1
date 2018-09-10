<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<% String path = request.getContextPath();%>
    <head>
        <meta charset="utf-8">
        <title>我的主页-知乎</title>
        <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
        <link rel="icon" href="<%=path %>/images/logo.jpg" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/personal.css" />
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/index.css" />
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/Font-Awesome-3.2.1/css/font-awesome.css" />
        <script type="text/javascript" src="<%=path %>/js/jquery-3.2.0.min.js"></script>
        <script type="text/javascript" src="<%=path %>/js/personal.js"></script>
        <script type="text/javascript" src="../js/raiseQuestions.js"></script>
    </head>
    <script type="text/javascript">
    	var path = "<%=path%>";
        var userId = "${UserLogin.userId}";
    	var userName = "${UserLogin.userName}";
    	var userContent = "${UserInfo.userContent}";
    	var userImgUrl = "${UserLogin.imageUrl}";
    </script>
    <body>
        <header>
            <div class="header-inner">
                <div class="peologo"></div>
                <div class="menu">
                    <a href="#">首页</a>
                    <a href="<%=path %>/page/statistics.jsp">统计</a>
                    <a href="<%=path %>/page/topicdynamics.jsp">话题</a>
                </div>
                <div class="search">
                    <form action="<%=path %>/page/topicdynamics.jsp" method="post">
                        <input class="search-input1" name="searchContent" type="text" placeholder="搜索你感兴趣的内容"/>
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
                    <a href="#" class="userinfo"><img src="${userInfo.imageUrl}" width="35" height="35"/></a>
                    <a href="javascript:location.href='<%=path %>/LogoutServlet'" class="userinfo">退出</a>
                </div>   
            </div>
        </header>
            <!-- 知乎头部开始 -->
        <div class="header" hidden>
            <div class="wrap">
                <div class="col-2"><div class="logo"></div></div>
                <div class="col-6"><div class="search">
                    <form action="">
                        <input class="search-input" type="text" placeholder="搜索你感兴趣的内容"/>
                        <div class="searbtn"></div>
                    </form>
                </div></div>
                 <div class="col-2"><div class="menu">
                    <ul>
                        <li><a href="<%=path %>/jsp/topicdynamics.jsp">首页</a></li>
                        <li><a href="<%=path %>/jsp/topicdynamics.jsp">话题</a></li>
                        <li><a href="#">发现</a></li>
                        <li><a href="#">消息</a></li>
                        <li><a href="#">我</a></li>
                    </ul>
                </div></div>
                
                <div class="info">
                    <a href="#" class="userinfo">
                        <span>${UserLogin.userName }</span>
                        <img src="${userInfo.imageUrl}" alt="${UserLogin.userName }" />
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
        <div class="main">
            <div class="card">
                <div class="usercover">
                    <button class="icon-camera"> 编辑封面图片</button>
                </div>
                <div class="peopleinfo">
                    <img class="photo" id="ava" src="${userInfo.imageUrl}" alt="">
                    <div class="intruduce">
                        <h1>${UserLogin.userName }<a href="<%=path %>/jsp/personaledit.jsp" hidden class="back xianshi">编辑个人主页 <span class="icon-angle-right"></span></a> <span class="intrspan">${userInfo.userContent }</span></h1>
                        <!-- jQuery 动画实现开始 -->
                        <!-- <div id="bian" style="height:50px; overflow:hidden;">
                            <div class="zhuanye"><span class="icon-briefcase gong"></span>计算机软件</div>
                            <div class="xueli"><span class="icon-user gong"></span>本科学历　|　网络工程专业</div>
                        
                            <div class="zhuanye"><span class="gong">居住地</span>现居大东北</div>
                            <div class="xueli"><span class="gong">所在行业</span>计算机软件</div>
                            <div class="xueli"><span class="gong">个人简介</span>没啥可说的</div>
                        </div> -->
                        <!-- jQuery 动画实现结束 -->
                        <!-- jQuery 滑动实现开始 -->
                        <div>
                            <div class="zhuanye"><span class="icon-briefcase gong"></span>${UserInfo.userIndustry }</div>
                            <div class="xueli"><span class="icon-user gong"></span>${UserInfo.userEducation }</div>
                        </div>
                        <div id="bian" hidden>
                            <div class="zhuanye"><span class="gong">居住地</span>${UserInfo.userAddress }</div>
                            <div class="xueli"><span class="gong">所在行业</span>${UserInfo.userIndustry }</div>
                            <div class="xueli"><span class="gong">个人简介</span>${UserInfo.userIntroduce }</div>
                        </div>
                        <!-- jQuery 滑动实现结束 -->
                        <div class="detail"><span class=" icon-angle-down gong"></span ><span class="view">查看详细资料</span></div>
                        <div class="anniu">
                            <button><a href="<%=path %>/jsp/personaledit.jsp">编辑个人资料</a></button>
                        </div>
                    </div>
                    <div class="detail">
                        
                    </div>
                </div>
            </div>
            <div class="card">
                <ul class="tabs" id="tabs">
                    <li class="active"><a>动态</a></li>
                    <li><a>回答</a></li>
                    <li><a>提问</a></li>
                </ul>
                <div class="dongtai">
                    <div class="list-container selected" id="dynamic">
                        <h4>我的动态</h4>
                    </div>
                    <div class="list-container" id="answer">
                        <h4>我的回答</h4>
                    </div>
                    <div class="list-container" id="question">
                        <h4>我的提问</h4>
                    </div>
                </div>
            </div>
        </div>
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
    </body>
</html>