<%@ page import="vn.edu.iuh.fit.models.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Customer</title>
</head>
<body>
<%
    List<Customer> customerList = (List<Customer>) request.getAttribute("customer");
%>
<table>
    <tr>
        <th>Full Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>
    <% for (Customer customer : customerList) { %>
    <tr>
        <td><%=customer.getName()%></td>
        <td><%=customer.getEmail()%></td>
        <td><%=customer.getPhone()%></td>
        <td><%=customer.getAddress()%></td>
    </tr>
    <% } %>
</table>
</body>

</html>