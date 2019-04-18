package convit.immutables.product;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@JsonDeserialize(builder = ProductBuilder.class)
class Product {

    private final String name;
    private final ImmutableList<String> images;
    private final Price price;

    Product(String name, ImmutableList<String> images, Price price) {
        this.name = name;
        this.images = images;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ImmutableList<String> getImages() {
        return images;
    }

    public Price getPrice() {
        return price;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
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
            Objects.equals(images, product.images) &&
            Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, images, price);
    }
}
