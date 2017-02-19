<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users:</title>
</head>
<body>
<table>
    <c:forEach items="${list}" var="user">
        <c:if test="${user.getName() != null && user.getSurname() != null && user.getMiddleName() != null}">

            <tr>
                <td>
                        ${user.getName()}
                </td>
                <td>
                        ${user.getSurname()}
                </td>
                <td>
                        ${user.getMiddleName()}
                </td>
                <td>
                        ${user.getBirthday()}
                </td>
                <td>
                        ${user.getGender()}
                </td>
            </tr>

        </c:if>
    </c:forEach>
</table>
</body>
</html>
