package vn.edu.iuh.fit.controllers;

import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.ProductImage;
import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.services.EmployeeService;
import vn.edu.iuh.fit.services.ProductImageService;
import vn.edu.iuh.fit.services.ProductPriceService;
import vn.edu.iuh.fit.services.ProductService;


@WebServlet(name = "week02", value = "/week02")
public class HelloServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();
    private ProductService productService = new ProductService();
    private ProductPriceService productPriceService = new ProductPriceService();
    private ProductImageService productImageService = new ProductImageService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if(action.equals("employee")){
            viewCustomer(request,response);
        }
        if(action.equals("product")){
            viewProduct(request,response);
        }
        if(action.equals("cart")){
            viewCart(request,response);
        }
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request,response);
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAll();
        List<ProductPrice> productPrices = productPriceService.getPriceLastest();
        List<ProductImage> productImages = productImageService.getAll();
        request.setAttribute("product", products);
        request.setAttribute("productPrice", productPrices);
        request.setAttribute("productImage", productImages);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product.jsp");
        dispatcher.forward(request,response);
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAll();

        request.setAttribute("employee", employees);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employee.jsp");
        dispatcher.forward(request,response);
    }


}