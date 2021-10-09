package br.com.supera.infra.panache.entities;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.supera.domain.models.Cart;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "cart")
public class PanacheCart extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<PanacheProduct> products;

    public Cart toCart() {
        Cart cart = new Cart();

        cart.id = this.id;
        if(this.products != null)
            cart.products = this.products
                .stream()
                .map(product -> product.toProduct())
                .collect(Collectors.toList());

        return cart;
    }
}
