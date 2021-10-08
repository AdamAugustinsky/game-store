package br.com.supera.data.interfaces;

import java.math.BigDecimal;

import br.com.supera.domain.dtos.AddProductDTO;
import br.com.supera.domain.models.Cart;

public interface CartRepository {
    Cart findById(long cartId);
    Cart create();
    Cart addProduct(long cartId, AddProductDTO addProductDTO);
    Cart increaseShippingPrice(long cartId, BigDecimal value);
    Cart removeProduct(long cartId, long productId);
}
