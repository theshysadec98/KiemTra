<%--
  Created by IntelliJ IDEA.
  User: HOANG
  Date: 8/9/2021
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


    <h2>Show San Pham</h2>
    <a href="/sanpham?action=create" class="btn btn-success">Create</a>
    <br>
    <br>
    <form action="/sanpham" method="get">
        <input type="text" class="form-control" placeholder="tìm kiếm" name="findName">
        <input type="text" hidden name="action" value="findName"><br>
        <button type="submit" class="btn btn-success">Find</button>
    </form>

    <br>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>price</th>
            <th>quantity</th>
            <th>color</th>
            <th>description</th>
            <th>directory</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSanPham}" var="sanpham" varStatus="loop">
            <tr>
                <td>${sanpham.id}</td>
                <td>${sanpham.name}</td>
                <td>${sanpham.price}</td>
                <td>${sanpham.quantity}</td>
                <td>${sanpham.color}</td>
                <td>${sanpham.description}</td>
                <td>${sanpham.directory}</td>
                <td><a href="/sanpham?action=edit&index=${loop.index}" class="btn btn-warning">Edit</a></td>
                <td><a href="/sanpham?action=delete&index=${loop.index}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div>
        <form action="/sanpham">
            <button type="submit" class="btn btn-success"> Back to san pham</button>
        </form>
    </div>
</div>

</body>
</html>

