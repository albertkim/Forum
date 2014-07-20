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
          <a href="#" class="deleteTopic" topicId="${allTopics[row.index].TOPICID}" currentTopicId="param.topicId"></a>
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