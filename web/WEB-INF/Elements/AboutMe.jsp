<%-- 
    Document   : AboutMe
    Created on : Jul 29, 2014, 10:45:12 PM
    Author     : Albert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  
  <body>
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
  </body>
  
</html>