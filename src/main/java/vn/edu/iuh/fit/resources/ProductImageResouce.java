package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.ProductImage;
import vn.edu.iuh.fit.services.ProductImageService;

import java.util.List;
import java.util.Optional;

@Path("/product-images")
public class ProductImageResouce {
    private final ProductImageService productImageService;
    public ProductImageResouce(){
        productImageService = new ProductImageService();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response findById(@PathParam("id") long id){
        Optional<ProductImage> optional = productImageService.findById(id);
        if(optional.isPresent()){
            return Response.ok(optional.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAll(){
        List<ProductImage> productImages = productImageService.getAll();
        return Response.ok(productImages).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(ProductImage productImage){
        productImageService.insert(productImage);
        return Response.ok(productImage).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(ProductImage productImage){
        Optional<Boolean> update = productImageService.update(productImage);
        if(update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        if(update.get())
            return Response.ok().build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
