<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/general.css">
    <link rel="stylesheet" type="text/css" href="../css/LeftPanel.css">
    <link rel="stylesheet" type="text/css" href="../css/MainPanel.css">
    <link rel="stylesheet" type="text/css" href="../css/Home.css">
    <link rel="stylesheet" type="text/css" href="../css/TopPanel.css">
    <link rel="stylesheet" type="text/css" href="../css/Popup.css">
    <script type="text/javascript" src="../javascript/Handlers.js"></script>
    <script type="text/javascript" src="../javascript/Home.js"></script>
    <script type="text/javascript" src="../javascript/Post.js"></script>
    <script type="text/javascript" src="../javascript/MainPanel.js"></script>
    <script type="text/javascript" src="../javascript/Login.js"></script>
    <script type="text/javascript" src="../javascript/AddPost.js"></script>
    <script type="text/javascript" src="../javascript/AddTopic.js"></script>
    <script type="text/javascript" src="../javascript/Rating.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <title>About Me</title>
  </head>
  
  <body>
    
    <div class="upperleftpanel">
      <%@ include file="UpperLeftPanel.jsp"%>
    </div>

    <div class="leftpanel">
      
    </div>
    
    <div class="toppanel">
      <div class="categoryLabel">
        <a class="categoryLabelLink" href="/Debate_Platform/mainServlet/aboutMe"></a>
        <h2>About Me</h2>
      </div>
      <div class="categoryWrapper" style="float: left; bottom: 0px;">
        <div class="category" categoryId="1">
          <a class="categoryLink" href="/Debate_Platform/mainServlet?category=Debate"></a>
          Debate
        </div>
        <div class="category" categoryId="2">
          <a class="categoryLink" href="/Debate_Platform/mainServlet?category=Finance"></a>
          Finance
        </div>
        <div class="category" categoryId="3">
          <a class="categoryLink" href="/Debate_Platform/mainServlet?category=Technology"></a>
          Technology
        </div>
        <div class="category" categoryId="4">
          <a class="categoryLink" href="/Debate_Platform/mainServlet?category=Off-Topic"></a>
          Off-Topic
        </div>

        <div class="topLink about">
          <a class="categoryLink" href="/Debate_Platform/mainServlet/aboutMe"></a>
          About Me
        </div>
      </div>
    </div>

    <div class="mainpanel">
      
      <div class="announcement" style="height: 100px; font-size: 3.5em;">
        ALBERT KIM
      </div>
      <div style="text-align: center; font-size: 1.5em;">
        <br><br>
        3rd year Computer Science Major at UBC
        <br><br><br>
        Aspiring entrepreneur
        <br><br><br>
        Web developer
        <br><br><br>
      </div>
      <div class="announcement" style="height: 100px; font-size: 3.5em;">
        EXPERIENCE
      </div>
      <div style="text-align: center; font-size: 1.5em;">
        <br><br>
        Java web developer at AppNeta
        <br><br>
        (May - Aug 2014) (4 months)
        <br><br><br>
        <div style="width: 400px; height: 2px; background-color: #D0D0D0; margin-left: auto; margin-right: auto"></div>
        <br><br>
        QA at AppNeta
        <br><br>
        (Jan - Apr 2014) (4 months)
        <br><br><br>
        <div style="width: 400px; height: 2px; background-color: #D0D0D0; margin-left: auto; margin-right: auto"></div>
        <br><br>
        Forum web development project (this)
        <br><br>
        Built from scratch using:
        <br>
        Java EE, Postgres, HTML/JS, Amazon EC2
        <br><br>
        (Jul 2014 - present)
        <br><br><br>
      </div>
      <div class="announcement" style="height: 100px; font-size: 3.5em;">
        CONTACT
      </div>
      <div style="text-align: center; font-size: 1.5em;">
        <br><br>
        Email
        <br><br>
        albert275@gmail.com
        <br><br><br>
        <div style="width: 400px; height: 2px; background-color: #D0D0D0; margin-left: auto; margin-right: auto"></div>
        <br><br>
        Phone
        <br><br>
        778-989-8031
        <br><br><br>
      </div>
      <div class="announcement" style="height: 100px; font-size: 3.5em;">
        THANK YOU
      </div>
      <br><br><br>
      
    </div>

    <div class="upperrightpanel">
      <%@ include file="UpperRightPanel.jsp"%>
    </div>
  </body>
  
  <script type="text/javascript">
    
    Handlers.init({
      currentCategory: "${currentCategory}",
      currentTopicId: "${currentTopicId}"
    });
    
  </script>
  
</html>