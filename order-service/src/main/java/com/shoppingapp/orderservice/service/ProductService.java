package com.shoppingapp.orderservice.service;

import com.shoppingapp.productservice.dto.ProductRequest;
import com.shoppingapp.productservice.dto.ProductResponse;
import com.shoppingapp.productservice.model.Product;
import com.shoppingapp.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    //To save the product instance into the database
    //Inject ProductRepository into the service class
    //Constructor injection
    private final ProductRepository productRepository;

    //Instead of doing the below manually
    //can add an annotation from lombok "@RequiredArgsConstructor"
    //The annotation will create the below constructor at compile time

//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);//product will be saved to the database
//        log.info("Order "  + product.getId() +" is saved");
        //Slf4j allows us to have a placeholder {}, dynamically gets the ID
        log.info("Order {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        //products.stream().map(product -> mapToProductResponse(product))
        return products.stream().map(this::mapToProductResponse).toList();


    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
