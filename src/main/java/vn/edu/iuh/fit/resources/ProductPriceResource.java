package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.services.ProductPriceService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceResource {
    private final ProductPriceService productPriceService;
    public ProductPriceResource(){
        productPriceService = new ProductPriceService();
    }
    @GET
    @Produces("application/json")
    @Path("/{productId}/{priceDateTime}")
    public Response findById(@PathParam("productId") long productId, @PathParam("priceDateTime") LocalDateTime priceDateTime){
        Optional<ProductPrice> optional = productPriceService.findById(productId,priceDateTime);
        if(optional.isPresent()){
            return Response.ok(optional.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAll(){
        List<ProductPrice> productPrices = productPriceService.getAll();
        return Response.ok(productPrices).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(ProductPrice productPrice){
        productPriceService.insert(productPrice);
        return Response.ok(productPrice).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(ProductPrice productPrice){
        Optional<Boolean> update = productPriceService.update(productPrice);
        if(update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        if(update.get())
            return Response.ok().build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
