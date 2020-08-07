<jsp:useBean id="message" scope="request" type="java.lang.String"/>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>

</head>
<body>

    <div>
        <h1>Spring Web JSP Example</h1>
        <h2>Message: ${message}</h2>
    </div>
    <a href="/open-account"><strong>to register</strong></a>
</body>

</html>