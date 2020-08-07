
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bank Management System</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="../static/style.css"/>">
</head>
<body>

<h1>Open Account Form</h1>

<form method="post">
    Account Name:<br>
    <input name="name"><br>
    Initial Balance:<br>
    <input name="balance"><br><br>
    <input type="submit" value="Open Account">
</form>

</body>
</html>