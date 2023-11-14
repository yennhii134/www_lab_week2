package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.services.CustomerService;

import java.util.List;
import java.util.Optional;

@Path("/customer")
public class CustomerResource {
    private final CustomerService customerService;
    public CustomerResource(){
        customerService = new CustomerService();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") long cusId){
        Optional<Customer> customerOptional = customerService.findById(cusId);
        if(customerOptional.isPresent()){
            return Response.ok(customerOptional.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAll(){
        List<Customer> customers = customerService.getAllCustomer();
        return Response.ok(customers).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insertCustomer(Customer customer){
        customerService.insertEmp(customer);
        return Response.ok(customer).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") long id){
        if(customerService.deleteCustomer(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
