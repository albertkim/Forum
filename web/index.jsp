<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

  <!-- State variables -->

  <head>
    <link rel="stylesheet" type="text/css" href="general.css">
    <script type="text/javascript" src="PostsPage.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <title>Debate Platform</title>
  </head>

  <body>
    
    <div class="upperleftpanel">
       <form action="./mainServlet" method="POST">
        <input type="submit" name="reload" value="Home" />
      </form>
    </div>
    
    <div class="leftpanel">
      <h5>${message}</h5>
      <!-- Topic table -->
      <div id="topicDiv" class="backgroundbox" style="float: left; height: auto; overflow: hidden;">
        <h4>Topics</h4>
        <c:forEach items="${allTopics}" varStatus="row">
          <tr>
            <div class="topicElement">
              <div class="categoryWrapper">${allTopics[row.index].TOPICID}</div>
              <div class="topicWrapper">${allTopics[row.index].CONTENT}</div>
            </div>
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
      <h1>DEBATE PLATFORM</h1>
    </div>
            
    <div class="upperrightpanel">
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
              <td><input type="text" name="USERNAME" value="${user.USERNAME}"/></td>
            </tr>
            <tr>
              <td>Password</td>
              <td><input type="text" name="PASSWORD" value="${user.PASSWORD}"/></td>
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
              <c:forEach items="${allPosts}" var="post">
                <div class="postElement">
                  <div style="width: auto; height: auto; overflow: hidden;">
                    <div class="userWrapper">${post.USERID}/${post.POSTID}</div>
                    <div class="contentWrapper">${post.CONTENT}</div>
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