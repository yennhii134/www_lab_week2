package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.OrderDetail;
import vn.edu.iuh.fit.services.OrderDetailService;

import java.util.List;
import java.util.Optional;

@Path("/order-details")
public class OrderDetailResource {
    private final OrderDetailService orderDetailService;
    public OrderDetailResource(){
        orderDetailService = new OrderDetailService();
    }
    @GET
    @Produces("application/json")
    @Path("/{orderId}/{productId}")
    public Response findById(@PathParam("orderId") long orderId, @PathParam("productId") long productId){
        Optional<OrderDetail> optional = orderDetailService.findById(orderId,productId);
        if(optional.isPresent()){
            return Response.ok(optional.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAll(){
        List<OrderDetail> orderDetails = orderDetailService.getAll();
        return Response.ok(orderDetails).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(OrderDetail orderDetail){
        orderDetailService.insert(orderDetail);
        return Response.ok(orderDetail).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(OrderDetail orderDetail){
        Optional<Boolean> update = orderDetailService.update(orderDetail);
        if(update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        if(update.get())
            return Response.ok().build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
