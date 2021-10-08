package br.com.supera.data.useCases;

import javax.ws.rs.WebApplicationException;

import br.com.supera.data.interfaces.CartRepository;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.models.Product;
import br.com.supera.domain.useCases.RemoveProduct;

public class RemoveProductImpl implements RemoveProduct {

    private CartRepository cartRepository;

    public RemoveProductImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    private boolean isProductInsideCart(Cart cart, long productId) {
        for(Product product : cart.products)
            if(product.id == productId) return true;
        return false;
    }

    @Override
    public Cart remove(long cartId, long productId) {
        Cart cart = cartRepository.findById(cartId);

        if(cart == null) 
            throw new WebApplicationException("Cart not found", 404);
        
        if(!isProductInsideCart(cart, productId))
            throw new WebApplicationException("Product is not inside cart", 404);

        return cartRepository.removeProduct(cartId, productId);
    }

}
