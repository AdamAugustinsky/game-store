package br.com.supera.presentation;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import br.com.supera.domain.models.Cart;
import br.com.supera.main.RemoveProductService;
import br.com.supera.shared.ErrorResponse;

@Path("/cart")
@Tag(name = "Cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RemoveProductResource {

    @Inject
    RemoveProductService removeProductService;



    @Path("/{cartId}/{productId}")
    @DELETE
    @Transactional
    @APIResponse(
        responseCode = "200",
        description = "Product removed from cart",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Cart.class)
        )
    )
    @APIResponse(
        responseCode = "404",
        description = "Cart or Product not found",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorResponse.class)
        )
    )
    public Response addProduct(@PathParam("cartId") long cartId, @PathParam("productId") long productId){
        Cart cart = removeProductService.handle(cartId, productId);

        return Response.ok(cart).status(Status.OK).build();
    }

}