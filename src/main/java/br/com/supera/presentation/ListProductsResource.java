package br.com.supera.presentation;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.supera.domain.models.Product;
import br.com.supera.main.ListProductsService;
import br.com.supera.shared.ErrorResponse;

@Path("/carts/products")
@Tag(name = "Products")
@Produces(MediaType.APPLICATION_JSON)
public class ListProductsResource {

    @Inject
    ListProductsService listProductsService;

    @Path("/{cartId}")
    @GET
    @Operation(summary = "List the products of cart in PathParam, with options of sorting by alphatibetical, price or score order")
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
    public Response listProducts(@PathParam("cartId") long cartId,
        @QueryParam("alphabetical_order") boolean alphabeticalOrder,
        @QueryParam("price_order") boolean priceOrder,
        @QueryParam("score_order") boolean scoreOrder
        ) {

        List<Product> products = listProductsService.handle(cartId, alphabeticalOrder, priceOrder, scoreOrder);

        return Response.ok(products).status(Status.OK).build();
    }

}