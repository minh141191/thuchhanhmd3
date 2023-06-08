<%--
  Created by IntelliJ IDEA.
  User: Minh Tran
  Date: 6/8/2023
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>From Update Employees</h1>
<form action="/employees?action=update&&id=${employee.id}" method="post">
    <label for="name">Name</label>
    <input type="text" name="name" id="name" placeholder="Enter name" value="${employee.name}"><br>
    <label for="email">Email</label>
    <input type="text" name="email" id="email" placeholder="Enter email" value="${employee.email}"><br>
    <label for="address">Address</label>
    <input type="text" name="address" id="address" placeholder="Enter address" value="${employee.address}"><br>
    <label for="phone_number">Phone</label>
    <input type="text" name="phone_number" id="phone_number" placeholder="Enter phone_number" value="${employee.phone_number}"><br>
    <label for="salary">Salary</label>
    <input type="text" name="salary" id="salary" placeholder="Enter salary" value="${employee.salary}"><br>
    <label for="department" class="form-label">Department</label>
    <select class="form-select" id="department" name="department"
            aria-label="Default select example">
        <option selected>--- Choice department ---</option>
        <c:forEach items="${department}" var="d">
            <option value="${d.id}">${d.name}</option>
        </c:forEach>
    </select><br>
    <button type="submit">Update</button>
    <a href="/employees">Back to home</a>
</form>
</body>
</html>
