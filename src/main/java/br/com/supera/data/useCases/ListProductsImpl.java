package br.com.supera.data.useCases;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import br.com.supera.data.interfaces.CartRepository;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.models.Product;
import br.com.supera.domain.useCases.ListProducts;

public class ListProductsImpl implements ListProducts {

    private CartRepository cartRepository;

    public ListProductsImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Product> listAll(long cartId) {
        Cart cart = cartRepository.findById(cartId);

        if(cart == null) 
            throw new WebApplicationException("Cart not found", 404);

        return cartRepository.listProducts(cartId);
    }
    
}
