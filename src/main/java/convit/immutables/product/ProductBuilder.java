package convit.immutables.product;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;

@JsonPOJOBuilder(withPrefix = "")
class ProductBuilder {

    private String name;
    private Price price;
    private List<String> images = new ArrayList<>();

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder images(List<String> images) {
        this.images = images;
        return this;
    }

    public ProductBuilder price(Price price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(name, ImmutableList.copyOf(images), price);
    }

}
