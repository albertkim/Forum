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
    console.log(config);
    postElement = $(".postElement[postid=" + config.postId + "]");
    // console.log($(postElement));
    this.initHandlers();
  };
  
  this.initHandlers = function(){
    // Post expanding/collapsing handlers
    $(postElement).on("click", function() {
      // Remove selected class and reply elements from all other posts
      $(".postElement").not($(postElement)).removeClass("selected");
      $(".postElement").not($(postElement)).find(".detailsWrapper").hide();
      if ($(postElement).hasClass("selected")) {
        // Give some option to remove the selected state of the post
      } else {
        // Add selected tag and reply element
        $(postElement).addClass("selected");
        $(postElement).find(".detailsWrapper").show();
      }
    });
    
    // Post deletion handlers
    $(postElement).find(".deletePost").on("click", function(event){
      console.log(config);
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
  };
  
  return this;
  
};