package ag.selm.manager.repository;

import ag.selm.manager.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());

//    public InMemoryProductRepository() {
//        IntStream.range(1,16)
//                .forEach(i -> this.products.add(new Product(i, "Товар номер%d".formatted(i), "Описание товара номер%d".formatted(i))));
//
//    }

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(this.products);
    }

    @Override
    public Product save(Product product) {
        product.setId(this.products.stream().max(Comparator.comparingInt(Product::getId))
                .map(Product::getId)
                .orElse(0) +1);
        this.products.add(product);
        return  product;
    }

    @Override
    public Optional<Product> findByID(Integer productID) {
        return this.products.stream().filter(product -> Objects.equals(productID, product.getId()))
                .findFirst();
    }

    @Override
    public void deleteById(Integer id) {
        this.products.removeIf(product -> Objects.equals(id, product.getId()));
    }
}
