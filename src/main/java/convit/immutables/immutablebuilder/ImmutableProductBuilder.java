package convit.immutables.immutablebuilder;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;

@JsonPOJOBuilder(withPrefix = "")
class ImmutableProductBuilder {

    private String name;
    private Price price;
    private ImmutableList<String> images;

    ImmutableProductBuilder() {
        this("", ImmutableList.of(), null);
    }

    ImmutableProductBuilder(String name, ImmutableList<String> images, Price price) {
        this.name = name;
        this.images = images;
        this.price = price;
    }

    public ImmutableProductBuilder name(String name) {
        return new ImmutableProductBuilder(name, images, price);
    }

    public ImmutableProductBuilder images(List<String> images) {
        return new ImmutableProductBuilder(name, ImmutableList.copyOf(images), price);
    }

    public ImmutableProductBuilder price(Price price) {
        return new ImmutableProductBuilder(name, images, price);
    }

    public Product build() {
        return new Product(name, price, images);
    }

}
