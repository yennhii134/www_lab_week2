<%@ page import="vn.edu.iuh.fit.models.Employee" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee</title>
</head>

<body>
    <% List<Employee> employeeList = (List<Employee>) request.getAttribute("employee"); %>
<table>
    <tr>
        <th>Name</th>
        <th>Day of birth</th>
        <th>Address</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
    </tr>
    <% for(Employee employee : employeeList) { %>
    <tr>
        <td><%=employee.getFullName()%></td>
        <td><%=employee.getDob()%></td>
        <td><%=employee.getAddress()%></td>
        <td><%=employee.getEmail()%></td>
        <td><%=employee.getPhone()%></td>
        <td><%=employee.getEmployeeStatus()%></td>
    </tr>
    <%}%>
</table>
</body>

</html>