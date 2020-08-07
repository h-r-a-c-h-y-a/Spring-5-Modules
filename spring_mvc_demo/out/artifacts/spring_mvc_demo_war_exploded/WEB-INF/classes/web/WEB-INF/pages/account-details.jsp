<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bank Management System</title>
    <link rel="stylesheet" type="text/css" href="<c:url
value="../static/style.css" />" >
</head>
<body>
<h1>${message} Account Details</h1>
<%--@elvariable id="account" type="com.gitc.mvc_demo.model.Account"--%>
<c:if test="${not empty account}">
    <table border="1" style="padding: 0.5em">
        <tr>
            <td>Account Number</td>
            <td>Account Name</td>
            <td>Account Balance</td>
        </tr>
        <tr>
            <td>${account.id}</td>
            <td>${account.name}</td>
            <td>${account.balance}</td>
        </tr>
    </table>
</c:if>
</body>
</html>