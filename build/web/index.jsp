<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    
    <!-- State variables -->
    
    <head>
        <link rel="stylesheet" type="text/css" href="general.css">
        <script type="text/javascript" src="general.js"></script>
        <script type="text/javascript" src="utilities.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <title>Debate Platform</title>
    </head>
    
    <body>
        
        <div class="leftpanel">
            <h1>Debate Platform</h1>
            <h5>${message}</h5>
            <form action="./mainServlet" method="POST">
                <input type="submit" name="reload" value="Home" />
            </form>
            
            <br>
            
            <!-- Topic table -->
            <div id="topicDiv" class="backgroundbox" style="float: left; height: auto; overflow: hidden;">
                <h4>Topics</h4>
                <c:forEach items="${allTopics}" varStatus="row">
                    <tr>
                        <script>createTopicElement("${allTopics[row.index].TOPICID}", "${allTopicContent[row.index]}");</script>
                    </tr>
                </c:forEach>
                <br>
                <form action="./postServlet" method="POST">
                    <table>
                        <tr>
                            <td>New Topic:</td>
                            <td><input type="text" name="CONTENT" value="${topic.CONTENT}" /></td>
                        </tr>
                    </table>
                    <input type="submit" name="action" value="addTopic" />
                </form>
            </div>
        </div>
        
        <div class="toppanel">
            
            <div id="userDiv" class="backgroundbox" style="width: 250px; height: auto; float: right;">
                <table style="" id="userTable">
                    <th>userId</th>
                    <th>username</th>
                    <c:forEach items="${allUsers}" var="user">
                        <tr>
                            <td>${user.USERID}</td>
                            <td>${user.USERNAME}</td>
                        </tr>
                    </c:forEach>
                </table>
                <form action="./postServlet" method="POST">         
                    <h4>Register:</h4>
                    <table>
                        <tr>
                            <td>Username</td>
                            <td><input type="text" name="USERNAME" value="${user.USERNAME}" /></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="text" name="PASSWORD" value="${user.PASSWORD}" /></td>
                        </tr>
                    </table>
                    <input type="submit" name="action" value="addUser" />
                </form>
            </div>
        </div>
        
        <div class="mainpanel">
            <c:choose>
                <c:when test="${not empty param.topicId}">
                    <div id="postDivWrapper" class="backgroundbox" style="width: 1050px; height: auto; overflow: hidden;">
                        <div id="postDiv" style="float: left;">
                            <h4>Posts</h4>
                            <c:forEach items="${allPosts}" var="post">
                                <script>createPostElement("${post.POSTID}", "${post.USERID}", "${post.CONTENT}");</script>
                            </c:forEach>
                            <br>
                            <form action="./postServlet" method="POST">   
                                <table>
                                    <tr>
                                        <td>Reply:</td>
                                        <td><input type="text" name="CONTENT" value="${post.CONTENT}" /></td>
                                    </tr>
                                </table>
                                <input type="submit" name="action" value="addPost" />
                            </form>
                        </div>
                    </div>
                </c:when>
            </c:choose>
        </div>
                    
    </body>
    
</html>