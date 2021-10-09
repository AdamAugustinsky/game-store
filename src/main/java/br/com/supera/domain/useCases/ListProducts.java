package br.com.supera.domain.useCases;

import java.util.List;

import br.com.supera.domain.models.Product;

public interface ListProducts {
    List<Product> listAll(long cartId, boolean alphabeticalOrder);
}
