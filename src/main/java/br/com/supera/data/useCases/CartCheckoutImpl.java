package br.com.supera.data.useCases;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.WebApplicationException;

import br.com.supera.data.interfaces.CartRepository;
import br.com.supera.domain.dtos.CartCheckoutDTO;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.models.Product;
import br.com.supera.domain.useCases.CartCheckout;

public class CartCheckoutImpl implements CartCheckout {

    private CartRepository cartRepository;

    public CartCheckoutImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    private BigDecimal calculateSubTotal(List<Product> products) {
        BigDecimal subtotal = new BigDecimal(0);

        for(Product product : products)
            subtotal = subtotal.add(product.price);

        return subtotal;
    }

    private BigDecimal calculateShippingPrice(List<Product> products) {
        if(calculateSubTotal(products).intValue() > 250)
            return new BigDecimal(0);

        return new BigDecimal(products.size() * 10);
    }

    private BigDecimal calculateTotal(BigDecimal subtotal, BigDecimal shipping_price) {
        return subtotal.add(shipping_price);
    }

    @Override
    public CartCheckoutDTO checkout(long cartId) {
        Cart cart = cartRepository.findById(cartId);

        if(cart == null) 
            throw new WebApplicationException("Cart not found", 404);
        
        CartCheckoutDTO cartCheckoutDTO = new CartCheckoutDTO();

        cartCheckoutDTO.shipping_price = calculateShippingPrice(cart.products);
        cartCheckoutDTO.subtotal = calculateSubTotal(cart.products);
        cartCheckoutDTO.total = calculateTotal(cartCheckoutDTO.subtotal, cartCheckoutDTO.shipping_price);

        return cartCheckoutDTO;
    }
    
}
