package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.services.CustomerService;

import java.util.List;
import java.util.Optional;

@Path("/customers")
public class CustomerResource {
    private final CustomerService customerService;
    public CustomerResource(){
        customerService = new CustomerService();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response findById(@PathParam("id") long id){
        Optional<Customer> optional = customerService.findById(id);
        if(optional.isPresent()){
            return Response.ok(optional.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAll(){
        List<Customer> customers = customerService.getAll();
        return Response.ok(customers).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Customer customer){
        customerService.insert(customer);
        return Response.ok(customer).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(Customer customer){
        Optional<Boolean> update = customerService.update(customer);
        if(update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        if(update.get())
            return Response.ok().build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
