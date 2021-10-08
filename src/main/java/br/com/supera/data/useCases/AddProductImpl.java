package br.com.supera.data.useCases;

import javax.ws.rs.WebApplicationException;

import br.com.supera.data.interfaces.CartRepository;
import br.com.supera.domain.dtos.AddProductDTO;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.useCases.AddProduct;

public class AddProductImpl implements AddProduct {

    private CartRepository cartRepository;


    public AddProductImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart add(Long cartId, AddProductDTO addProductDTO) {
        Cart cart = cartRepository.findById(cartId);

        if(cart == null) 
            throw new WebApplicationException("Cart not found", 404);

        return cartRepository.addProduct(cartId, addProductDTO);
    }
    
}
