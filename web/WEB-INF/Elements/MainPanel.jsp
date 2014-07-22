<c:choose>
  <c:when test="${not empty param.topicId}">
    <div id="postDivWrapper" class="backgroundbox" style="width: 1050px; height: auto; overflow: hidden;">
      <div id="postDiv" style="float: left;">
        <c:forEach items="${allPosts}" var="post">
          <div class="postElement" postId="${post.POSTID}" userId="${post.USERID}">
            ${post.USERNAME}
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
              <div class="postData" style="width: auto;">
                <div style="float: right">${post.TIMECREATED} | ${post.REPLIES} Replies</div>
              </div>
              <div style="height: 20px; width: auto;">
                <div class="button replyButton" style="float: right">Reply</div>
              </div>
            </div>
          </div>
          <div style="height: 5px;"></div>
        </c:forEach>
        <div class="button addPostButton">Add Post</div>
      </div>
    </div>
  </c:when>
</c:choose>