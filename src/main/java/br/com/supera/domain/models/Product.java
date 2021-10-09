package br.com.supera.domain.models;

import java.math.BigDecimal;
import java.util.Comparator;

public class Product {
    public long id;

    public String name;

    public BigDecimal price;

    public short score;

    public String image; 

    public static Comparator<Product> COMPARE_BY_NAME = new Comparator<Product>() {
        public int compare(Product one, Product other) {
            return one.name.compareTo(other.name);
        }
    };
}
