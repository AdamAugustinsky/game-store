package br.com.supera.domain.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddProductDTO {
    @NotBlank(message = "name cant be blank")
    public String name;

    @NotNull(message = "price cant be null")
    public BigDecimal price;

    @NotNull(message = "score cant be null")
    public short score;

    public String image; 
}
