package br.com.supera.domain.useCases;

import br.com.supera.domain.models.Cart;

public interface RemoveProduct {
    Cart remove(long cartId, long productId);
}
