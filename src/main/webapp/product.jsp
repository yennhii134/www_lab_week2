<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.models.Product" %>
<%@ page import="vn.edu.iuh.fit.models.ProductPrice" %>
<%@ page import="vn.edu.iuh.fit.models.ProductImage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="./js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="components/header.jsp" />
<% List<Product> products = (List<Product>) request.getAttribute("product"); %>
<% List<ProductPrice> productPrices = (List<ProductPrice>) request.getAttribute("productPrice"); %>
<% List<ProductImage> productImages = (List<ProductImage>) request.getAttribute("productImage"); %>
<div class="container mt-4">
    <div class="row">
        <% for(Product product : products) { %>
        <div class="col-md-6 mb-6">
            <div class="card">
                <div class="row g-0">
                    <div class="col-md-4">
                        <% for(ProductImage productImage : productImages) { %>
                            <% if(product.getId() == productImage.getProduct().getId()) { %>
                                <img src=<%=productImage.getPath()%> alt="Product_Image" class="img-fluid">
                            <% } %>
                        <% } %>
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title"><%=product.getName()%></h5>
                            <p class="card-text"><%=product.getManufacturerName()%></p>
                            <p class="card-text"><%=product.getDescription()%></p>
                            <% for(ProductPrice productPrice : productPrices) { %>
                                <% if(product.getId() == productPrice.getProduct().getId()) { %>
                                    <p class="card-text"><%=productPrice.getPrice()%></p>
                                <% } %>
                            <%}%>
                            <div class="col col-6 mt-4">
                                <div class="d-flex input-group mb-5">
                                    <span class="input-group-text minus pointer-event user-select-none">-</span>
                                    <input type="number" min="1" class="form-control text-center qty-input" value="1">
                                    <span class="input-group-text plus pointer-event user-select-none">+</span>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-outline-primary">Add to cart</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>
