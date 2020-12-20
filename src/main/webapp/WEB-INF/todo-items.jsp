<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
  <body>

  <c:choose>
    <c:when test="${toDoItems.size() == 1}">
      <h2>Hello, there is ${toDoItems.size()} item in the to-do list.</h2>
    </c:when>
    <c:otherwise>
      <h2>Hello, there are ${toDoItems.size()} items in the to-do list.</h2>
    </c:otherwise>
  </c:choose>

  <table>
    <tr>
      <th>Todo Item</th>
      <th>Action</th>
    </tr>

    <c:forEach items="${toDoItems}" var="toDoItem">
      <c:url var="show_update_item_url" value="/show-update-todo-item/${toDoItem.getId()}" />

      <c:url var="delete_item_url" value="/delete-todo-item/${toDoItem.getId()}" />
      <c:choose>
        <c:when test="${toDoItem.getId() == updateID}">
          <c:url var="update_item_url" value="/update-todo-item/${toDoItem.getId()}" />
          <form:form method="POST" action="${update_item_url}">
            <tr>
              <td><input name="item" value="${toDoItem.getItem()}"/></td>
              <td>
              <input type="Submit" value="Update" />
              </td>
            </tr>
          </form:form>
        </c:when>
        <c:otherwise>
          <tr>
            <td>${toDoItem.getItem()}</td>
            <td>
              <a href="${show_update_item_url}">Update</a>
              /
              <form:form method="POST" action="${delete_item_url}">
                <input type="submit" value="Delete">
              </form:form>
            </td>
          </tr>
        </c:otherwise>
      </c:choose>

    </c:forEach>
  </table>

  <c:url var="add_item_url" value ="/add-todo-item" />
  <form:form method="POST" action="${add_item_url}">
    <input name="todo-item"/>
    <input type="submit" value="Submit"/>
  </form:form>
  </body>
</html>
