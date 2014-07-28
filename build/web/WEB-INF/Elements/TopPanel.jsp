<!-- Read current category from URL and set accordingly -->
<div class="currentCategory" category="${currentCategory}">
  <div class="categoryLabel" style="float: left;"><h2>${currentCategory}</h2></div>
</div>

<div class="categoryWrapper" style="float: left;">
  <c:forEach items="${allCategories}" var="category">
    <div class="category" categoryId="${category.CATEGORYID}">${category.NAME}</div>
  </c:forEach>
</div>