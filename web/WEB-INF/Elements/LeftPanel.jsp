<!-- Topic table -->

<c:choose>
  <c:when test="${not empty currentCategory}">
    <h4>TOPICS</h4>
  </c:when>
  <c:otherwise>
    <h4>TOP THREADS</h4>
  </c:otherwise>
</c:choose>

<div id="topicDiv" class="backgroundbox" topicId="${allTopics[row.index].TOPICID}" style="float: left; height: auto; overflow: hidden;">

  <div style="height: 1px; background-color: black;"></div>
  <c:forEach items="${allTopics}" varStatus="row">
    
    <c:set var="topic" value="${allTopics[row.index]}"/>
    
    <c:choose>
      <c:when test="${allTopics[row.index].TOPICID == param.topicId}">
        <div class="topicElement selected" topicId="${allTopics[row.index].TOPICID}" category="${topic.CATEGORYNAME}">
      </c:when>
      <c:otherwise>
        <div class="topicElement" topicId="${allTopics[row.index].TOPICID}" category="${topic.CATEGORYNAME}">
      </c:otherwise>
    </c:choose>
      
      <div style="width: auto; height: auto; overflow: hidden;">
        <!-- <div class="topicUserWrapper"></div> -->
        <div class="topicWrapper">${allTopics[row.index].CONTENT}</div>
        <c:choose>
          <c:when test="${isAdmin == 'true'}">
            <a href="#" class="deleteTopic" topicId="${allTopics[row.index].TOPICID}" currentTopicId="${param.topicId}"></a>
          </c:when>
        </c:choose>
      </div>
      <div class="topicDetailsWrapper">${allTopics[row.index].DATECREATED} | ${allTopics[row.index].REPLIES} Replies</div>
      </div>
    <div style="height: 1px; background-color: black;"></div>
    
  </c:forEach>
  <div style="height: 10px"></div>
  
  <c:choose>
    <c:when test="${not empty param.category}">
      <div class="button addTopicButton" style="float: left;">Add Topic</div>
    </c:when>
    <c:otherwise>
      Select a category to make a thread
    </c:otherwise>
  </c:choose>
  
</div>