package br.com.supera.data.useCases;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Product> listAll(long cartId, boolean alphabeticalOrder, boolean priceOrder, boolean scoreOrder) {
        Cart cart = cartRepository.findById(cartId);

        if(cart == null) 
            throw new WebApplicationException("Cart not found", 404);

        List<Product> products = cartRepository.listProducts(cartId);

        if(alphabeticalOrder)
            return products.stream().sorted(Product.COMPARE_BY_NAME).collect(Collectors.toList());
        if(priceOrder)
            return products.stream().sorted(Product.COMPARE_BY_PRICE).collect(Collectors.toList());
        if(scoreOrder)
            return products.stream().sorted(Product.COMPARE_BY_SCORE).collect(Collectors.toList());

        return products;
    }
    
}
