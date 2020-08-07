<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>
<head>
    <title>
        <tiles:insertAttribute name="title" ignore="true"/>
    </title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="left">
    <tr>
        <td colspan="2" align="center">
            <tiles:insertAttribute name="header"/>
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="menu"/>
        </td>
        <td>
            <tiles:insertAttribute name="body"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <tiles:insertAttribute name="footer"/>
        </td>
    </tr>
</table>
</body>
</html>
