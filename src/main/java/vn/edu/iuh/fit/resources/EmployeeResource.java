package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Path("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;
    public EmployeeResource(){
        employeeService = new EmployeeService();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response findById(@PathParam("id") long empId){
        Optional<Employee> empOpt = employeeService.findById(empId);
        if(empOpt.isPresent()){
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAll(){
        List<Employee> employees = employeeService.getAll();
        return Response.ok(employees).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee){
        employeeService.insert(employee);
        return Response.ok(employee).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(Employee employee){
        Optional<Boolean> update = employeeService.update(employee);
        if(update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        if(update.get())
            return Response.ok().build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if(employeeService.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
