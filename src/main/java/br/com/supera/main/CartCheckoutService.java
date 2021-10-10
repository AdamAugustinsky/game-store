package br.com.supera.main;

import javax.enterprise.context.ApplicationScoped;

import br.com.supera.data.useCases.CartCheckoutImpl;
import br.com.supera.domain.dtos.CartCheckoutDTO;
import br.com.supera.domain.useCases.CartCheckout;
import br.com.supera.infra.panache.repositories.PanacheCartRepository;

@ApplicationScoped
public class CartCheckoutService {

    private CartCheckout cartCheckout;

    public CartCheckoutService() {
        PanacheCartRepository panacheCartRepository = new PanacheCartRepository();
        this.cartCheckout = new CartCheckoutImpl(panacheCartRepository);
    } 


    public CartCheckoutDTO handle(long cartId) {
        return cartCheckout.checkout(cartId);
    }
    
}
