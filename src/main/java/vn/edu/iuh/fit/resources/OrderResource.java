package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.services.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderResource {
    private final OrderService orderService;
    public OrderResource(){
        orderService = new OrderService();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response findById(@PathParam("id") long id){
        Optional<Order> optional = orderService.findById(id);
        if(optional.isPresent()){
            return Response.ok(optional.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAll(){
        List<Order> orders = orderService.getAll();
        return Response.ok(orders).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Order order){
        orderService.insert(order);
        return Response.ok(order).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(Order order){
        Optional<Boolean> update = orderService.update(order);
        if(update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        if(update.get())
            return Response.ok().build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
