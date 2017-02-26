<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
Enter your information:
<form:form action="/addUser" method="post">
    <form:input placeholder="Name" path="name"/>
    <form:input placeholder="Surname" path="surname"/>
    <form:input placeholder="Middle name" path="middleName"/>
    <form:input placeholder="Birthday" path="birthday"/>
    <form:input placeholder="Gender(male/female)" path="gender"/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
