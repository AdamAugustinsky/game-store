package br.com.supera.main;

import javax.enterprise.context.ApplicationScoped;

import br.com.supera.data.useCases.AddProductImpl;
import br.com.supera.domain.dtos.AddProductDTO;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.useCases.AddProduct;
import br.com.supera.infra.panache.repositories.PanacheCartRepository;

@ApplicationScoped
public class AddProductService {

    private AddProduct addProduct;

    public AddProductService() {
        PanacheCartRepository panacheCartRepository = new PanacheCartRepository();
        this.addProduct = new AddProductImpl(panacheCartRepository);
    }

    public Cart handle(long cartId, AddProductDTO addProductDTO) {
        return addProduct.add(cartId, addProductDTO);
    }

}
