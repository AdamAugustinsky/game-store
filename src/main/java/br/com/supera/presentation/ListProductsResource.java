package br.com.supera.presentation;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.supera.domain.models.Product;
import br.com.supera.main.ListProductsService;
import br.com.supera.shared.ErrorResponse;

@Path("/cart")
@Tag(name = "Cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ListProductsResource {

    @Inject
    ListProductsService listProductsService;

    @Path("/{cartId}")
    @GET
    @APIResponse(
        responseCode = "200",
        description = "Products listed succesfully",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Product[].class)
        )
    )
    @APIResponse(
        responseCode = "404",
        description = "Cart not found",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorResponse.class)
        )
    )
    public Response addProduct(@PathParam("cartId") long cartId) {
        List<Product> products = listProductsService.handle(cartId);

        return Response.ok(products).status(Status.OK).build();
    }

}