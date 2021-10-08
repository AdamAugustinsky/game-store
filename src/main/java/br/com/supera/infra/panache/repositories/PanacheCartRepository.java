package br.com.supera.infra.panache.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.supera.data.interfaces.CartRepository;
import br.com.supera.domain.dtos.AddProductDTO;
import br.com.supera.domain.models.Cart;
import br.com.supera.infra.panache.entities.PanacheCart;
import br.com.supera.infra.panache.entities.PanacheProduct;

public class PanacheCartRepository implements CartRepository {

    private PanacheCart findPanacheEntityById(long cartId) {
        return PanacheCart.findById(cartId);
    }

    private PanacheProduct createPanacheProduct(AddProductDTO addProductDTO) {
        PanacheProduct panacheProduct = new PanacheProduct();
        panacheProduct.name = addProductDTO.name;
        panacheProduct.price = addProductDTO.price;
        panacheProduct.score = addProductDTO.score;
        panacheProduct.image = addProductDTO.image;

        panacheProduct.persist();

        return panacheProduct;
    }

    @Override
    public Cart findById(long cartId) {
        PanacheCart panacheCart = PanacheCart.findById(cartId);

        if(panacheCart == null)
            return null;
        
        return panacheCart.toCart();
    }

    @Override
    public Cart create() {
        PanacheCart panacheCart = new PanacheCart();

        panacheCart.shipping_price = new BigDecimal(0);
        panacheCart.products = new ArrayList<PanacheProduct>();

        panacheCart.persist();

        return panacheCart.toCart();
    }
    
    @Override
    public Cart addProduct(long cartId, AddProductDTO addProductDTO) {
        PanacheCart panacheCart = findPanacheEntityById(cartId);

        panacheCart.products.add(
            createPanacheProduct(addProductDTO)
        );

        return panacheCart.toCart();
    }

    @Override
    public Cart increaseShippingPrice(long cartId, BigDecimal value) {
        PanacheCart panacheCart = findPanacheEntityById(cartId);

        panacheCart.shipping_price = panacheCart.shipping_price.add(value);

        panacheCart.persist();

        return panacheCart.toCart();
    }


    
}
