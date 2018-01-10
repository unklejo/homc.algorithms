<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Detail Order</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>Detail Order - ${orderDetail.orderId}</h2>
    <tr><td><b>Customer Name:</b> ${orderDetail.customerName}</td></tr><br/>
    <tr><td><b>Invoice Number:</b> ${orderDetail.invoiceNo}</td></tr>
    <table>
        <tr>
            <td>Name</td><td>Price</td><td>Quantity</td>
        </tr>
        <c:forEach items="${orderDetail.itemList}" var="items">
            <tr>
            <td>${items.name}</td>
            <td>${items.price}</td>
            <td>${items.quantity}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/list-order' />">Back</a>
</body>
</html>