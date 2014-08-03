<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

  <head>
    <link rel="stylesheet" type="text/css" href="css/general.css">
    <link rel="stylesheet" type="text/css" href="css/LeftPanel.css">
    <link rel="stylesheet" type="text/css" href="css/MainPanel.css">
    <link rel="stylesheet" type="text/css" href="css/Home.css">
    <link rel="stylesheet" type="text/css" href="css/TopPanel.css">
    <link rel="stylesheet" type="text/css" href="css/Popup.css">
    <script type="text/javascript" src="javascript/Handlers.js"></script>
    <script type="text/javascript" src="javascript/Home.js"></script>
    <script type="text/javascript" src="javascript/Post.js"></script>
    <script type="text/javascript" src="javascript/MainPanel.js"></script>
    <script type="text/javascript" src="javascript/Login.js"></script>
    <script type="text/javascript" src="javascript/AddPost.js"></script>
    <script type="text/javascript" src="javascript/AddTopic.js"></script>
    <script type="text/javascript" src="javascript/Rating.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.embed.ly/jquery.embedly-3.0.5.min.js" type="text/javascript"></script>
    <script src="http://cdn.embed.ly/jquery.preview-0.3.2.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="http://cdn.embed.ly/jquery.preview-0.3.2.css" />
    <title>Debate</title>
  </head>

  <body>
    <%@ include file="WEB-INF/Popups/Register.jsp"%>
    <%@ include file="WEB-INF/Popups/AddPost.jspf"%>
    <%@ include file="WEB-INF/Popups/AddReply.jspf"%>
    <%@ include file="WEB-INF/Popups/AddTopic.jspf"%>
    
    <c:set var="currentCategory" value="${param.category}"/>
    <c:set var="currentTopicId" value="${param.topicId}"/>
    <c:set var="currentTopic" value="${currentTopic}"/>
    
    <script type="text/javascript">
      MainPanel.init({
        currentUser: {
          userId: "${currentUser.USERID}",
          username: "${currentUser.USERNAME}"
        },
        currentCategory: "${currentCategory}",
        currentTopicId: "${currentTopicId}"
      });
    </script>

    <div class="upperleftpanel">
      <%@ include file="WEB-INF/Elements/UpperLeftPanel.jsp"%>
    </div>

    <div class="leftpanel">
      <%@ include file="WEB-INF/Elements/LeftPanel.jsp"%>
    </div>

    <div class="toppanel">
      <%@ include file="WEB-INF/Elements/TopPanel.jsp"%>
    </div>

    <div class="upperrightpanel">
      <%@ include file="WEB-INF/Elements/UpperRightPanel.jsp"%>
    </div>

    <div class="mainpanel">
      <c:choose>
        <c:when test="${not empty currentCategory}">
          <%@ include file="WEB-INF/Elements/MainPanel.jspf"%>
        </c:when>
        <c:otherwise>
          <div>
            <%@ include file="WEB-INF/Elements/Home.jspf"%>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </body>

  <script type="text/javascript">
    
    MainPanel.initGeneralHandlers();
    
    Handlers.init({
      currentCategory: "${currentCategory}",
      currentTopicId: "${currentTopicId}"
    });
    
    $(".submitPost").on("click", function() {
      AddPost.init({
        currentUserId: "${currentUser.USERID}",
        currentCategory: "${currentCategory}",
        currentTopicId: "${currentTopicId}",
        currentPostId: 0,
        content: $(".add-post-body").val()
      });
      AddPost.submit();
    });

    $(".submitReply").on("click", function() {
      AddPost.init({
        currentUserId: "${currentUser.USERID}",
        currentCategory: "${currentCategory}",
        currentTopicId: "${currentTopicId}",
        currentPostId: $(".postElement.selected").attr("postId"),
        content: $(".reply-body").val()
      });
      AddPost.submit();
    });
    
    AddTopic.init({
      currentUserId: "${currentUser.USERID}",
      currentCategory: "${currentCategory}"
    });

    // Popup close button should close popup
    $(".popupCloseButton").on("click", function() {
      $(".reply-wrapper").hide();
    });
    
    Rating.init({
      currentUserId: "${currentUser.USERID}"
    });
    
  </script>

</html>