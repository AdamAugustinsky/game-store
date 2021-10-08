package br.com.supera.main;

import javax.enterprise.context.ApplicationScoped;

import br.com.supera.data.useCases.RemoveProductImpl;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.useCases.RemoveProduct;
import br.com.supera.infra.panache.repositories.PanacheCartRepository;

@ApplicationScoped
public class RemoveProductService {

    private RemoveProduct removeProduct;

    public RemoveProductService() {
        PanacheCartRepository panacheCartRepository = new PanacheCartRepository();
        this.removeProduct = new RemoveProductImpl(panacheCartRepository);
    }

    public Cart handle(long cartId, long productId) {
        return removeProduct.remove(cartId, productId);
    }
    
}
