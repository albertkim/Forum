AddTopic = (function() {
  // config parameters passed in from index.jsp
  // currentUserId
  // currentCategory
  var config = {};

  var init = function(settings) {
    $.extend(config, settings);
    initAddTopicHandlers();
    initSubmitTopicHandlers();
  };
  
  var initAddTopicHandlers = function(){
    // Bring up the 'Add Posts' popup
    $(".addTopicButton").on("click", function() {
      $(".add-topic-wrapper").show();
    });

    // Popup close button should close popup
    $(".popupCloseButton").on("click", function() {
      $(".add-topic-wrapper").hide();
    });
  };
  
  var initSubmitTopicHandlers = function(){
    $(".submitTopic").on("click", function(){submit();});
  };

  var submit = function() {
    // Get textarea content
    var title = $(".add-topic-body").val();
    var content = $(".add-topic-body").val();
    $.ajax({
      url: "postServlet",
      data: {
        action: "addTopic",
        USERID: config.currentUserId,
        currentCategory: config.currentCategory,
        CONTENT: content,
        TITLE: title
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