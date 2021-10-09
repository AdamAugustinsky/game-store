package br.com.supera.main;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.supera.data.useCases.ListProductsImpl;
import br.com.supera.domain.models.Product;
import br.com.supera.domain.useCases.ListProducts;
import br.com.supera.infra.panache.repositories.PanacheCartRepository;

@ApplicationScoped
public class ListProductsService {
    
    private ListProducts listProducts;

    public ListProductsService() {
        PanacheCartRepository panacheCartRepository = new PanacheCartRepository();
        this.listProducts = new ListProductsImpl(panacheCartRepository);
    }

    public List<Product> handle(long cartId, boolean alphabeticalOrder) {
        return listProducts.listAll(cartId, alphabeticalOrder);
    }
    
}
