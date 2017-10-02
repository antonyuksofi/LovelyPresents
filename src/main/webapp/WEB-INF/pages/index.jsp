<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Вітаємо у магазині Lovely Presents.
    <a href="/category/">До списку товарів</a>

    <p>Додавання товару в корзину:</p>
    <form action="/cart/add" method="post" enctype="application/x-www-form-urlencoded">
        <%--<input type="hidden" name="id" value="123">--%>
        <input type="hidden" name="user_id" value="1">
        <p>Товар:</p>
        <select name="product_id">
            <option selected value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
        </select>
        <input type="hidden" name="image" value="test">
        <p>Кількість:</p>
        <select name="count">
            <option selected value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select>
        <input type="submit" value="Додати в корзину">
    </form>
</body>
</html>