package br.com.supera.domain.useCases;

import br.com.supera.domain.dtos.CartCheckoutDTO;

public interface CartCheckout {
    CartCheckoutDTO checkout(long cartId);
}
