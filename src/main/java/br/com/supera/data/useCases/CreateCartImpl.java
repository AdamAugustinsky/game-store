package br.com.supera.data.useCases;

import br.com.supera.data.interfaces.CartRepository;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.useCases.CreateCart;

public class CreateCartImpl implements CreateCart {

    private CartRepository cartRepository;

    public CreateCartImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart create() {
        return cartRepository.create();
    }
}
