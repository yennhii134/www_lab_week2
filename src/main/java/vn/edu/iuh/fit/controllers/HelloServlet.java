package vn.edu.iuh.fit.controllers;

import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.services.EmployeeService;


@WebServlet(name = "week02", value = "/week02")
public class HelloServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if(action.equals("employee")){
            viewCustomer(request,response);
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAll();

        request.setAttribute("employee", employees);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employee.jsp");
        dispatcher.forward(request,response);
    }


}