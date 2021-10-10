package br.com.supera.presentation;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.supera.domain.models.Cart;
import br.com.supera.main.CreateCartService;

@Path("/carts")
@Tag(name = "Carts")
@Produces(MediaType.APPLICATION_JSON)
public class CreateCartResource {

    @Inject
    CreateCartService createCartService;

    @POST
    @Transactional
    @APIResponse(
        responseCode = "201",
        description = "Cart Created",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Cart.class)
        )
    )
    public Response create() {
        Cart cart = createCartService.handle();

        return Response.ok(cart).status(Status.CREATED).build();
    }

}
