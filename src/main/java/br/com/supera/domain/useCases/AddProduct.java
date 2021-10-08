package br.com.supera.domain.useCases;

import br.com.supera.domain.dtos.AddProductDTO;
import br.com.supera.domain.models.Cart;

public interface AddProduct {
    Cart add(Long cartId,AddProductDTO addProductDTO);
}
