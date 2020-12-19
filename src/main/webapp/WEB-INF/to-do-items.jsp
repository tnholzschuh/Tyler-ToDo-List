<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<body>
<h2>Hello World! There are ${toDoItems.size()} items in the to-do list.</h2>

<c:forEach items="${toDoItems}" var="toDoItem">
<p>${toDoItem.getItem()}</p>
</c:forEach>
</body>
</html>
