<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Please register</title>
  </head>
  <body>
    <div>
      <c:url var="register_url" value="register" />
      <form:form method="POST" action="${register_url}" modelAttribute="toDoUser">
        <h2>Please register</h2>
        <p>
          <label for="username">Username</label>
          <form:input
            type="text"
            id="username"
            path="username"
            placeholder="Username"
            required="required"
            autofocus="autofocus"/>
        </p>
        <p>
          <label for="password">Password</label>
          <form:input
            type="password"
            id="password"
            path="password"
            placeholder="Password"
            required="required"/>
        </p>
        <button type="submit">Register</button>
      </form:form>
    </div>


  </body>
</html>
