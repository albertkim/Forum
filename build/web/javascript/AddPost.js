AddPost = (function() {
  // config parameters passed in from index.jsp
  // currentUserId
  // currentCategory
  // currentTopic
  // currentPostId
  var config = {};

  var init = function(settings) {
    $.extend(config, settings);
  };

  var submit = function() {
    $.ajax({
      url: "postServlet",
      data: {
        action: "addPost",
        USERID: config.currentUserId,
        POSTID: config.currentPostId,
        topicId: config.currentTopicId,
        CONTENT: config.content
      },
      success: function(){
        location.reload();
      }
    });
  };
  
  return {
    init: init,
    submit: submit
  };
  
})();