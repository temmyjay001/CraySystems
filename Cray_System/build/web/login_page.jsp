<%-- 
    Document   : login_page
    Created on : Aug 1, 2019, 8:03:01 AM
    Author     : VitaKing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
  </head>
  <body>
      <div class="container">
      <h1>Login</h1>
      
      <form action="login_validation" method="POST">
        <div style="padding: 10px;"><span class="alert alert-danger">${messages.message}</span></div>
        <div class="form-group">
          <label for="Username">User Name</label>
          <input
            name="username"
            type="text"
            class="form-control"
            id=""
            placeholder="Enter username"
            required
          />
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input
            name="password"
            type="password"
            class="form-control"
            id=""
            placeholder="Password"
            required
          />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
  </body>
</html>