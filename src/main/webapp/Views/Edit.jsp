<%--
  Created by IntelliJ IDEA.
  User: HOANG
  Date: 8/9/2021
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>San Pham</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Edit San Pham</h2>
    <form method="post">
        <table class="table">
            <tbody>
            <tr>
                <td><input placeholder="nhập ID" name="id" value="${sanpham.id}"></td>
            </tr>
            <tr>
                <td><input placeholder="nhập Name" name="name" value="${sanpham.name}"></td>
            </tr>
            <tr>
                <td><input placeholder="nhập Price" name="price" value="${sanpham.price}"></td>
            </tr>
            <tr>
                <td><input placeholder="nhập Quantity" name="quantity" value="${sanpham.quantity}"></td>
            </tr>
            <tr>
                <td><input placeholder="nhập Color" name="color" value="${sanpham.color}"></td>
            </tr>
            <tr>
                <td><input placeholder="nhập Description" name="description" value="${sanpham.description}"></td>
            </tr>
            <tr>
                <td><input placeholder="nhập Directory" name="directory" value="${sanpham.directory}"></td>
            </tr>

            </tbody>
        </table>
        <button type="submit" class="btn btn-success">Edit San Pham</button>

    </form>
</div>

</body>
</html>

