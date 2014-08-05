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
    
    // Attach the url input to the preview div
    $(".add-url").preview({
      key: "7cee569de4e94c758b3e94ae6d248eb5",
      success: function(data){
        console.log(data);
        var preview = $(".add-url-preview");
        preview.show();
        var thumbnailUrl = data.thumbnail_url;
        $(".preview-thumbnail").attr("src", thumbnailUrl);
        var title = data.title;
        $(".preview-title").html(title);
        var description = data.description;
        $(".preview-description").html(description);
      }
    });
    $(".add-url").on("change", function(){
      $(".add-url-preview").addInputs($(".add-url").data("preview"));
    });
    
  };
  
  var initSubmitTopicHandlers = function(){
    $(".submitTopic").on("click", function(){submit();});
  };

  var submit = function() {
    // Get textarea content
    var title = $(".add-topic-title").val();
    var content = $(".add-topic-body").val();
    var url = $(".add-url").val();
    $.ajax({
      url: "postServlet",
      data: {
        action: "addTopic",
        USERID: config.currentUserId,
        currentCategory: config.currentCategory,
        CONTENT: content,
        TITLE: title,
        URL: url
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