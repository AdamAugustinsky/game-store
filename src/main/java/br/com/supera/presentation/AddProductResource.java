package br.com.supera.presentation;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.supera.domain.dtos.AddProductDTO;
import br.com.supera.domain.models.Cart;
import br.com.supera.main.AddProductService;
import br.com.supera.shared.ErrorResponse;

@Path("/carts")
@Tag(name = "Carts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddProductResource {

    @Inject
    AddProductService addProductService;


    @Path("/{cartId}")
    @PUT
    @Transactional
    @APIResponse(
        responseCode = "201",
        description = "Product added to cart",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Cart.class)
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
    public Response addProduct(@PathParam("cartId") long cartId, @RequestBody @Valid AddProductDTO addProductDTO) {
        Cart cart = addProductService.handle(cartId, addProductDTO);

        return Response.ok(cart).status(Status.CREATED).build();
    }

}

