<!-- Read current category from URL and set accordingly -->
<div class="currentCategory" category="${currentCategory}">
  <div style="float: left;"><h1>${currentCategory}</h1></div>
</div>

<div  style="float: left;">
  <c:forEach items="${allCategories}" var="category">
    <div class="category" categoryId="${category.CATEGORYID}">${category.NAME}</div>
  </c:forEach>
</div>