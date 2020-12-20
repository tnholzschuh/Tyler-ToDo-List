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
      <form:form method="post" action="${authenticate_user_url}">
        <h2>Please sign in</h2>
        <p>
          <label for="username">Username</label>
          <input type="text" id="username" name="username" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password">Password</label>
          <input type="password" id="password" name="password" placeholder="Password" required>
        </p>
        <button type="submit">Sign in</button>
      </form:form>
    </div>

    <br/>
    <c:url var="register_url" value="/register" />
    <h3> Or <a href="${register_url}"> register.</h3>
  </body>
</html>
