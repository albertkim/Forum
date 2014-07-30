// This Javascript object will represent a single Post
// Used in MainPanel

var Post = function() {
  
  var config = {};
  var postElement;
  
  // Input:
    // postId
    // userId
    // topicId
    // content
    // replies
    // timeCreated
    // upvotes
    // downvotes
    // isAdmin
  this.init = function(settings){
    console.log("Post instantiated");
    $.extend(config, settings);
    // console.log(settings);
    postElement = $(".postElement[postid=" + config.postId + "]");
    // console.log($(postElement));
    this.initHandlers();
  };
  
  this.initHandlers = function(){
    // Post expanding/collapsing handlers
    $(postElement).find(".contentWrapper").on("click", postElement, function(event) {
      // Remove selected class and reply elements from all other posts
      var thisPostElement = $(event.data);
      console.log(thisPostElement);
      $(".postElement").not(thisPostElement).removeClass("selected");
      $(".postElement").not(thisPostElement).find(".detailsWrapper").hide();
      if (thisPostElement.hasClass("selected")) {
        // Give some option to remove the selected state of the post
        $(".postElement").removeClass("selected");
        $(".postElement").find(".detailsWrapper").hide();
      } else {
        // Add selected tag and reply element
        thisPostElement.addClass("selected");
        thisPostElement.find(".detailsWrapper").show();
      }
    });
    
    // Post deletion handlers
    $(postElement).find(".deletePost").on("click", function(event){
      // console.log(config);
      $.ajax({
        url: "postAction",
        data: {
          action: "deletePost",
          postId: config.postId,
          topicId: config.topicId
        },
        success: function(data){
          // console.log("data: " + data);
          location.reload();
        }
      });
      event.stopImmediatePropagation();
    });
    
    // Upvote handler
    $(postElement).find(".upvote-wrapper").on("click", function(){
      $.ajax({
        url: "ratingAction",
        type: "POST",
        data: {
          action: "upvote",
          userId: config.userId,
          postId: config.postId
        },
        success: function(data){
          // console.log("data: " + data);
          location.reload();
        }
      });
    });
    
    // Downvote handler
    $(postElement).find(".downvote-wrapper").on("click", function(){
      $.ajax({
        url: "ratingAction",
        type: "POST",
        data: {
          action: "downvote",
          userId: config.userId,
          postId: config.postId
        },
        success: function(data){
          // console.log("data: " + data);
          location.reload();
        }
      });
    });
    
    // Bring up the 'Reply' popup
    $(postElement).find(".replyButton").on("click", function() {
      $(".add-post-wrapper").hide();
      $(".reply-wrapper").show();
    });
    
  };
  
  return this;
  
};