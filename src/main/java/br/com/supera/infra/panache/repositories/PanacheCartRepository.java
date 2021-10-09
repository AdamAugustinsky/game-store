package br.com.supera.infra.panache.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.supera.data.interfaces.CartRepository;
import br.com.supera.domain.dtos.AddProductDTO;
import br.com.supera.domain.models.Cart;
import br.com.supera.domain.models.Product;
import br.com.supera.infra.panache.entities.PanacheCart;
import br.com.supera.infra.panache.entities.PanacheProduct;

public class PanacheCartRepository implements CartRepository {

    private PanacheCart findPanacheEntityById(long cartId) {
        return PanacheCart.findById(cartId);
    }

    private PanacheProduct createPanacheProduct(AddProductDTO addProductDTO) {
        PanacheProduct panacheProduct = new PanacheProduct();
        panacheProduct.name = addProductDTO.name;
        panacheProduct.price = addProductDTO.price;
        panacheProduct.score = addProductDTO.score;
        panacheProduct.image = addProductDTO.image;

        panacheProduct.persist();

        return panacheProduct;
    }

    @Override
    public Cart findById(long cartId) {
        PanacheCart panacheCart = PanacheCart.findById(cartId);

        if (panacheCart == null) return null;
        return panacheCart.toCart();
    }

    @Override
    public Cart create() {
        PanacheCart panacheCart = new PanacheCart();

        panacheCart.products = new ArrayList<PanacheProduct>();

        panacheCart.persist();

        return panacheCart.toCart();
    }

    @Override
    public Cart addProduct(long cartId, AddProductDTO addProductDTO) {
        PanacheCart panacheCart = findPanacheEntityById(cartId);

        panacheCart.products.add(createPanacheProduct(addProductDTO));

        return panacheCart.toCart();
    }

    @Override
    public Cart removeProduct(long cartId, long productId) {
        PanacheCart panacheCart = findPanacheEntityById(cartId);

        panacheCart.products.removeIf(product -> product.id == productId);

        return panacheCart.toCart();
    }

    @Override
    public List<Product> listProducts(long cartId) {
        PanacheCart panacheCart = findPanacheEntityById(cartId);

        List<Product> products = panacheCart.products
            .stream()
            .map(product -> product.toProduct())
            .collect(Collectors.toList());

        return products;
    }

}
