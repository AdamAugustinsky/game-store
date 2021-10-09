package br.com.supera.data.interfaces;

import java.util.List;

import br.com.supera.domain.dtos.AddProductDTO;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.models.Product;

public interface CartRepository {
    Cart findById(long cartId);
    Cart create();
    Cart addProduct(long cartId, AddProductDTO addProductDTO);
    Cart removeProduct(long cartId, long productId);
    List<Product> listProducts(long cartId);
}
