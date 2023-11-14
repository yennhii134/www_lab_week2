package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.services.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductResource {
    private final ProductService productService;
    public ProductResource(){
        productService = new ProductService();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response findById(@PathParam("id") long id){
        Optional<Product> optional = productService.findById(id);
        if(optional.isPresent()){
            return Response.ok(optional.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAll(){
        List<Product> products = productService.getAll();
        return Response.ok(products).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product product){
        productService.insert(product);
        return Response.ok(product).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(Product product){
        Optional<Boolean> update = productService.update(product);
        if(update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        if(update.get())
            return Response.ok().build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
