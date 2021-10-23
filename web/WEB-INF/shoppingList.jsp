<%-- 
    Document   : shoppingList
    Created on : Oct 22, 2021, 4:41:45 PM
    Author     : Tyler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p> 
        <a href="ShoppingList?action=logout">Logout</a>
        
        <h2>List</h2>
        <form method="POST" action="">
            <input type="hidden" name="action" value="add">
            <label>Add Item: </label>
            <input type="text" name="item" value="">
            <input type="submit" value="Add">        
        </form>
        <br>
        
        <form action="" method="POST">
            <table>
            <c:forEach var="items" items="${item}">
                
                <input type="radio" id="${items}" name="button" value ="${items}"
                       <label>${items}</label>
                <br>
            </c:forEach>
            <br>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
                 
            
            </table>
        </form>
        
        
    </body>
</html>
