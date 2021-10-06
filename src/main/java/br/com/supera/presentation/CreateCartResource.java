package br.com.supera.presentation;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.supera.domain.models.Cart;
import br.com.supera.main.CreateCartService;


@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
public class CreateCartResource {

    @Inject
    CreateCartService createCartService;

    @POST
    @Transactional
    public Response create() {
        Cart cart = createCartService.handle();

        return Response.ok(cart).status(Status.CREATED).build();
    }

}
