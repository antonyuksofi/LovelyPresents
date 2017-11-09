<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart filling</title>
</head>
<body>
    <p>Adding product to the cart (testing):</p>
    <form action="/cart/add" method="post" enctype="application/x-www-form-urlencoded">
        <%--<input type="hidden" name="id" value="123">--%>
        <input type="hidden" name="userId" value="1">
        <p>Product:</p>
        <select name="productId">
            <option selected value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select>
        <input type="hidden" name="image" value="test">
        <p>Amount:</p>
        <select name="count">
            <option selected value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select>
        <input type="submit" value="Add">
    </form>
</body>
</html>
