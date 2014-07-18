<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

  <!-- State variables -->

  <head>
    <link rel="stylesheet" type="text/css" href="css/general.css">
    <script type="text/javascript" src="javascript/PostsPage.js"></script>
    <script type="text/javascript" src="javascript/utilities.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <title>Debate Platform</title>
  </head>

  <body>
    
    <jsp:include page="WEB-INF/register.jsp"/>
    
    <div class="upperleftpanel">
      
    </div>
    
    <div class="leftpanel">
      <div>${message}</div>
      <!-- Topic table -->
      <div id="topicDiv" class="backgroundbox" style="float: left; height: auto; overflow: hidden;">
        <h4>TOPICS</h4>
        <div style="height: 1px; background-color: #D0D0D0;"></div>
        <c:forEach items="${allTopics}" varStatus="row">
          <tr>
            <c:choose>
              <c:when test="${allTopics[row.index].TOPICID == param.topicId}">
                <div class="topicElement selected" topicId="${allTopics[row.index].TOPICID}">
              </c:when>
              <c:otherwise>
                <div class="topicElement" topicId="${allTopics[row.index].TOPICID}">
              </c:otherwise>
            </c:choose>
              <div style="width: auto; height: auto; overflow: hidden;">
                <div class="categoryWrapper">${allTopics[row.index].TOPICID}</div>
                <div class="topicWrapper">${allTopics[row.index].CONTENT}</div>
                <c:choose>
                  <c:when test="${isAdmin == 'true'}">
                    <a href="#" class="deleteTopic"></a>
                  </c:when>
                </c:choose>
              </div>
              <div class="topicDetailsWrapper">${allTopics[row.index].DATECREATED} | 0 Replies</div>
            </div>
            <div style="height: 1px; background-color: #D0D0D0;"></div>
          </tr>
        </c:forEach>
        <form action="./postServlet" method="POST">
          <table>
            <tr>
              <td>New Topic:</td>
              <td><input type="text" name="CONTENT" value="${topic.CONTENT}"/></td>
              <!-- TODO: Get user from session -->
              <td><input type="hidden" name="USERID" value="1"/></td>
              <td><input type="hidden" name="CATEGORYID" value="1"/></td>
              <td><input type="submit" name="action" value="addTopic"/></td>
            </tr>
          </table>
        </form>
      </div>
    </div>

    <div class="toppanel">
      <div class="title"><h1>DEBATE PLATFORM</h1></div>
    </div>
            
    <div class="upperrightpanel">
      <div id="userDiv" class="backgroundbox" style="width: 250px; height: auto;">
        <form action="./loginServlet" method="POST">         
          <table>
            <tr>
              <td>Username</td>
              <td><input type="text" name="USERNAME" value="${user.USERNAME}"/></td>
            </tr>
            <tr>
              <td>Password</td>
              <td><input type="password" name="PASSWORD" value="${user.PASSWORD}"/></td>
            </tr>
          </table>
          <input  style="float: right;" type="submit" name="action" value="login"/>
          <input  style="float: right;" type="submit" name="action" value="logout"/>
          <!-- Functionality for this set through Javascript -->
          <button type="button" class="registerButton" style="float: left">Register</button>
        </form>
      </div>
    </div>

    <div class="mainpanel">
      <c:choose>
        <c:when test="${not empty param.topicId}">
          <div id="postDivWrapper" class="backgroundbox" style="width: 1050px; height: auto; overflow: hidden;">
            <div id="postDiv" style="float: left;">
              <c:forEach items="${allPosts}" var="post">
                <div class="postElement" postId="${post.POSTID}" userId="${post.USERID}">
                  <div style="width: auto; height: auto; overflow: hidden;">
                    <div class="userWrapper">${post.USERID}/${post.POSTID}</div>
                    <div class="contentWrapper">${post.CONTENT}</div>
                    <c:choose>
                      <c:when test="${isAdmin == 'true'}">
                        <a href="#" class="deletePost" postId="${post.POSTID}" topicId="${param.topicId}"></a>
                      </c:when>
                    </c:choose>
                  </div>
                  <div class="detailsWrapper" hidden>
                    <form class="responseForm" action="./postServlet" method="POST">
                      <table>
                        <tr>
                          <td>Reply:</td>
                          <td><input type="text" name="CONTENT" value=""/></td>
                          <td><input type="hidden" name="POSTID" value="${post.POSTID}"/></td>
                          <td><input type="hidden" name="USERID" value="1"/></td>
                          <td><input type="submit" name="action" value="addPost"/></td>
                        </tr>
                      </table>
                    </form>
                  </div>
                </div>
                <div style="height: 5px;"></div>
              </c:forEach>
              <br>
              <form action="./postServlet" method="POST">
                <table>
                  <tr>
                    <td>Reply:</td>
                    <td><input type="text" name="CONTENT" value="${post.CONTENT}"/></td>
                    <td><input type="hidden" name="POSTID" value="0"/></td>
                    <td><input type="hidden" name="USERID" value="1"/></td>
                    <td><input type="submit" name="action" value="addPost"/></td>
                  </tr>
                </table>
                
              </form>
            </div>
          </div>
        </c:when>
      </c:choose>
    </div>
  </body>
  
  <script type="text/javascript">
    PostsPage.init({});
  </script>

</html>