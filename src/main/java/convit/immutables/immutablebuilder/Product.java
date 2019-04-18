package convit.immutables.immutablebuilder;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@JsonDeserialize(builder = ImmutableProductBuilder.class)
class Product {

    private final String name;
    private final Price price;
    private final ImmutableList<String> images;

    Product(String name, Price price, ImmutableList<String> images) {
        this.name = name;
        this.price = price;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public ImmutableList<String> getImages() {
        return images;
    }

    public static ImmutableProductBuilder builder()  {
        return new ImmutableProductBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
            Objects.equals(price, product.price) &&
            Objects.equals(images, product.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, images);
    }
}
