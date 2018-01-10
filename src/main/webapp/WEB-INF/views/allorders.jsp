<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Order</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Orders</h2>  
    <table>
        <tr>
            <td>Id</td><td>Customer Name</td><td>Invoice Number</td><td>Registered Time</td><td></td>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
            <td>${order.id}</td>
            <td>${order.customerName}</td>
            <td>${order.invoiceNo}</td>
            <td>${order.createOrder}</td>
            <td><a href="<c:url value='/detail-${order.invoiceNo}-orderDetail' />">Detail Item</a></td>
 
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/menu' />">Back To Menu</a>
</body>
</html>