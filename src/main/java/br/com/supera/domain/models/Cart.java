package br.com.supera.domain.models;

import java.math.BigDecimal;
import java.util.List;

public class Cart {
    public long id;

    public BigDecimal shipping_price;

    public List<Product> products;
}
