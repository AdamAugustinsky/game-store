package br.com.supera.main;

import javax.enterprise.context.ApplicationScoped;

import br.com.supera.data.useCases.CreateCartImpl;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.useCases.CreateCart;
import br.com.supera.infra.panache.repositories.PanacheCartRepository;

@ApplicationScoped
public class CreateCartService {

    CreateCart createCart; 

    public CreateCartService() {
        PanacheCartRepository panacheCartRepository = new PanacheCartRepository();
        this.createCart = new CreateCartImpl(panacheCartRepository);
    }

    public Cart handle() {
        return createCart.create();
    }
    
}
