<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

  <head>
    <link rel="stylesheet" type="text/css" href="css/general.css">
    <link rel="stylesheet" type="text/css" href="css/LeftPanel.css">
    <link rel="stylesheet" type="text/css" href="css/MainPanel.css">
    <link rel="stylesheet" type="text/css" href="css/MainPanelHome.css">
    <link rel="stylesheet" type="text/css" href="css/TopPanel.css">
    <link rel="stylesheet" type="text/css" href="css/Popup.css">
    <script type="text/javascript" src="javascript/PostsPage.js"></script>
    <script type="text/javascript" src="javascript/MainPanelHome.js"></script>
    <script type="text/javascript" src="javascript/Login.js"></script>
    <script type="text/javascript" src="javascript/AddPost.js"></script>
    <script type="text/javascript" src="javascript/utilities.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <title>Debate</title>
  </head>

  <body>
    <%@ include file="WEB-INF/Popups/Register.jsp"%>
    <%@ include file="WEB-INF/Popups/AddPost.jspf"%>
    <%@ include file="WEB-INF/Popups/Reply.jspf"%>
    <c:set var="currentCategory" value="${param.category}"/>
    <c:set var="currentTopic" value="${param.topic}"/>

    <div class="upperleftpanel">
      <%@ include file="WEB-INF/Elements/UpperLeftPanel.jsp"%>
    </div>

    <div class="leftpanel">
      <c:choose>
        <c:when test="${not empty currentCategory}">
          <%@ include file="WEB-INF/Elements/LeftPanel.jsp"%>
        </c:when>
        <c:otherwise>
          <div>
            Select a category
          </div>
        </c:otherwise>
      </c:choose>
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
          <%@ include file="WEB-INF/Elements/MainPanel.jsp"%>
        </c:when>
        <c:otherwise>
          <div>
            <%@ include file="WEB-INF/Elements/MainPanelHome.jsp"%>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </body>

  <script type="text/javascript">
    
    PostsPage.init({
      currentCategory: "${currentCategory}",
      currentTopic: "${currentTopic}"
    });
    
    // Bring up the 'Add Posts' popup
    $(".addPostButton").on("click", function() {
      console.log("clicked");
      $(".reply-wrapper").hide();
      $(".add-post-wrapper").show();
    });

    // Popup close button should close popup
    $(".popupCloseButton").on("click", function() {
      $(".add-post-wrapper").hide();
    });

    // Bring up the 'Reply' popup
    $(".replyButton").on("click", function() {
      console.log("clicked");
      $(".add-post-wrapper").hide();
      $(".reply-wrapper").show();
    });

    $(".submitReply").on("click", function() {
      AddPost.init({
        currentUserId: "${currentUser.USERID}",
        currentCategory: "${currentCategory}",
        currentTopic: "${currentTopic}",
        currentPost: $(".postElement.selected").attr("postId"),
        content: $(".reply-body").val()
      });
      AddPost.submit();
    });

    // Popup close button should close popup
    $(".popupCloseButton").on("click", function() {
      $(".reply-wrapper").hide();
    });
    
  </script>

</html>