package br.com.supera.infra.panache.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.supera.data.interfaces.CartRepository;
import br.com.supera.domain.dtos.AddProductDTO;
import br.com.supera.domain.models.Cart;
import br.com.supera.infra.panache.entities.PanacheCart;
import br.com.supera.infra.panache.entities.PanacheProduct;

public class PanacheCartRepository implements CartRepository {

    @Override
    public Cart create() {
        PanacheCart panacheCart = new PanacheCart();

        panacheCart.shipping_price = new BigDecimal(0);
        panacheCart.products = new ArrayList<PanacheProduct>();

        panacheCart.persist();

        return panacheCart.toCart();
    }
}
