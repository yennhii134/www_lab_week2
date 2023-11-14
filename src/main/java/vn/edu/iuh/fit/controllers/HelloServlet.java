package vn.edu.iuh.fit.controllers;

import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.services.CustomerService;
import vn.edu.iuh.fit.services.EmployeeService;


@WebServlet(name = "week02", value = "/week02")
public class HelloServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    private CustomerService customerService = new CustomerService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if(action.equals("customer")){
            viewCustomer(request,response);
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.getAllCustomer();

        request.setAttribute("customer", customers);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/customer.jsp");
        dispatcher.forward(request,response);
    }

    private void viewEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String url ="";
        try{
            request.setAttribute("employee", employeeService.getAllEmp());
            url="/employee.jsp";
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }

}