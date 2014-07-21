<c:choose>
  <c:when test="${not empty param.topicId}">
    <div id="postDivWrapper" class="backgroundbox" style="width: 1050px; height: auto; overflow: hidden;">
      <div id="postDiv" style="float: left;">
        <c:forEach items="${allPosts}" var="post">
          <div class="postElement" postId="${post.POSTID}" userId="${post.USERID}">
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
        <div class="button addPostButton">Add Post</div>
        <script type="text/javascript">
          AddPost.init({
            currentCategory: "${currentCategory}",
            currentTopic: "${currentTopic}"
          });
        </script>
      </div>
    </div>
  </c:when>
</c:choose>