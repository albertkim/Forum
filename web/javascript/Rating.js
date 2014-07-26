Rating = (function() {
  // config parameters passed in from post
  // currentUserId
  var config = {};

  var init = function(settings) {
    $.extend(config, settings);
    initRatingHandlers();
  };
  
  var initRatingHandlers = function(){
    $(".upvote-wrapper").on("click", function(){
      var userId = config.currentUserId;
      var postId = $(this).attr("postId");
      $.ajax({
        url: "ratingAction",
        type: "POST",
        data: {
          action: "upvote",
          userId: userId,
          postId: postId
        },
        success: function(data){
          console.log("data: " + data);
          location.reload();
        }
      });
    });
    $(".downvote-wrapper").on("click", function(){
      var userId = config.currentUserId;
      var postId = $(this).attr("postId");
      $.ajax({
        url: "ratingAction",
        type: "POST",
        data: {
          action: "downvote",
          userId: userId,
          postId: postId
        },
        success: function(data){
          console.log("data: " + data);
          location.reload();
        }
      });
    });
  };
  
  return {
    init: init
  };
})();