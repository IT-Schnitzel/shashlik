package ag.selm.manager.service;

import ag.selm.manager.entity.Product;
import ag.selm.manager.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private  final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return this.productRepository.save(new Product(null,title,details));
    }

    @Override
    public Optional<Product> findProduct(int productID) {
        return this.productRepository.findByID(productID);
    }

    @Override
    public void updateProduct(Integer id, String title, String details) {
        this.productRepository.findByID(id)
                .ifPresentOrElse(product -> {
                    product.setTitle(title);
                    product.setDetails(details);
                }, () -> {
                    throw  new NoSuchElementException();
                        }
                );
    }


}