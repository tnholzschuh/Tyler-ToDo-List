<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Please sign in</title>
  </head>
  <body>
    <div>
      <c:url var="authenticate_user_url" value="authenticate-user" />
      <form:form method="POST" action="${authenticate_user_url}" modelAttribute="toDoUser">
        <h2>Please sign in</h2>
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
        <button type="submit">Sign in</button>
      </form:form>
    </div>

    <br/>
    <c:url var="register_form_url" value="register-form" />
    <h3> Or <a href="${register_form_url}"> register.</a></h3>
  </body>
</html>
