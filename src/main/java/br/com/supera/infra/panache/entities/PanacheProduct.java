package br.com.supera.infra.panache.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.supera.domain.models.Product;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "product")
public class PanacheProduct extends PanacheEntityBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public BigDecimal price;

    public short score;

    public String image; 

    public Product toProduct() {
        Product product = new Product();

        product.id = this.id;
        product.name = this.name;
        product.price = this.price;
        product.score = this.score;
        product.image = this.image;

        return product;
    }
}
