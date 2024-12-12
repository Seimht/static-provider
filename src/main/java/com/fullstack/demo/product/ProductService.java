package com.fullstack.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        System.out.println("Products fetched: " + products);
        return products;
    }

    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int productId, Product updatedProduct) {
        return productRepository.findById(productId)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setProviderId(updatedProduct.getProviderId());
                    product.setStock(updatedProduct.getStock());
                    return productRepository.save(product);
                }).orElseGet(() -> {
                    updatedProduct.setProductId(productId);
                    return productRepository.save(updatedProduct);
                });
    }

    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}
