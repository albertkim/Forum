<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

  <!-- State variables -->

  <head>
    <link rel="stylesheet" type="text/css" href="css/general.css">
    <link rel="stylesheet" type="text/css" href="css/LeftPanel.css">
    <link rel="stylesheet" type="text/css" href="css/MainPanel.css">
    <link rel="stylesheet" type="text/css" href="css/TopPanel.css">
    <script type="text/javascript" src="javascript/PostsPage.js"></script>
    <script type="text/javascript" src="javascript/utilities.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <title>Debate</title>
  </head>

  <body>
    <%@ include file="WEB-INF/Elements/register.jsp"%>

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
      <%@ include file="WEB-INF/Elements/MainPanel.jsp"%>
    </div>
  </body>

  <script type="text/javascript">
    PostsPage.init({});
  </script>

</html>