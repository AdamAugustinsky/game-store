package br.com.supera.presentation;

import javax.inject.Inject;
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

import br.com.supera.domain.dtos.CartCheckoutDTO;
import br.com.supera.main.CartCheckoutService;
import br.com.supera.shared.ErrorResponse;

@Path("/cart")
@Tag(name = "Cart")
@Produces(MediaType.APPLICATION_JSON)
public class CartCheckoutResource {

    @Inject
    CartCheckoutService cartCheckoutService;

    @Path("/{cartId}/checkout")
    @GET
    @APIResponse(
        responseCode = "200",
        description = "Checked out Successfully",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = CartCheckoutDTO.class)
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
    public Response create(@PathParam("cartId") long cartId) {
        CartCheckoutDTO cartCheckout = cartCheckoutService.handle(cartId);

        return Response.ok(cartCheckout).status(Status.OK).build();
    }

}

