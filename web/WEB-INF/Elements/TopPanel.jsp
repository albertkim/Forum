<!-- Read current category from URL and set accordingly -->
<div class="categoryLabel" style="float: left;">
  <a class="categoryLabelLink" href="/Debate_Platform/mainServlet?category=${currentCategory}"></a>
  <h2>${currentCategory}</h2>
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