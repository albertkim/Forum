var url =  window.location.protocol + "//" + window.location.host + window.location.pathname;

function createPostElement(postId, userId, content) {
    
    var postIdTextNode = document.createTextNode(postId);
    var userIdTextNode = document.createTextNode(userId);
    var contentTextNode = document.createTextNode(content);
    
    var userWrapper = document.createElement("div");
    userWrapper.className = "userWrapper";
    userWrapper.appendChild(userIdTextNode);
    userWrapper.appendChild(postIdTextNode);
    
    var contentWrapper = document.createElement("div");
    contentWrapper.className = "contentWrapper";
    contentWrapper.appendChild(contentTextNode);
    
    var postElement = document.createElement("div");
    postElement.className = "postElement";
    postElement.appendChild(userWrapper);
    postElement.appendChild(contentWrapper);
    
    // If the element is clicked, expand the element to show additional options underneath
    $(postElement).on("click", function(){
        // Remove selected class and reply elements from all other posts
        $(".postElement").not($(this)).removeClass("selected");
        $(".postElement").not($(this)).find(".detailsWrapper").remove();
        
        if($(this).hasClass("selected")){
            // Give some option to remove the selected state of the post
        } else{
            // Add selected tag and reply element
            $(this).addClass("selected");
            var detailsWrapper = $("<div class=\"detailsWrapper\"\"></div>");
            var replyElement = $("<form class=\"responseForm\" action=\"./postServlet\" method=\"POST\"><table><tbody>\n\<tr>\n\
                                    <td>Reply:</td>\n\
                                    <td><input type=\"text\" name=\"CONTENT\" value=\"\"></td>\n\
                                    </tr></tbody></table>\n\
                                    <input type=\"submit\" name=\"action\" value=\"addPost\"></form>");
            $(detailsWrapper).append(replyElement);
            $(this).append(detailsWrapper);
        }
    });
    
    document.getElementById("postDiv").appendChild(postElement);
    
}

function createTopicElement(topicId, content){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "index.jsp", true);
    
    var topicTextNode = document.createTextNode(topicId);
    var categoryTextNode = document.createTextNode(content);
    
    var topicWrapper = document.createElement("div");
    topicWrapper.className = "topicWrapper";
    topicWrapper.appendChild(topicTextNode);
    
    var contentWrapper = document.createElement("div");
    contentWrapper.className = "categoryWrapper";
    contentWrapper.appendChild(categoryTextNode);
    
    var topicElement = document.createElement("div");
    topicElement.className = "topicElement";
    topicElement.appendChild(topicWrapper);
    topicElement.appendChild(contentWrapper);
    
    // Add click handler
    // TODO: Modify just query parameters, don't recreate whole string
    var parameters = "?" + "topicId=" + topicId.toString();
    $(topicElement).on("click", function() {
        location.href = (url + parameters);
    });
    
    document.getElementById("topicDiv").appendChild(topicElement);
    
}