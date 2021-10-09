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

    public static Comparator<Product> COMPARE_BY_PRICE = new Comparator<Product>() {
        public int compare(Product one, Product other) {
            return one.price.compareTo(other.price);
        }
    };

    public static Comparator<Product> COMPARE_BY_SCORE = new Comparator<Product>() {
        public int compare(Product one, Product other) {
            Short oneScore = one.score;
            Short otherScore = other.score;

            return oneScore.compareTo(otherScore);
        }
    };
}
