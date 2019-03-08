<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page isELIgnored="false" %>
  <head>
    <title>Spitter</title>
  </head>
  <body>
  
    <div id="content">
      <h1>Welcome to Spitter</h1>
  
      <form method="POST" enctype="multipart/form-data">
        <input type="file" name="file"></input><br/>
        <input type="submit"></input>
      </form>
  
    </div>

  </body>
</html>

