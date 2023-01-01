package com.himankjn.productservice.service;

import com.himankjn.productservice.dao.ProductDao;
import com.himankjn.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDao productDao;

    //lombok takes care of constructor
//    public ProductService(ProductDao productDao) {
//        this.productDao = productDao;
//    }


    public void createProduct(Product product){
        productDao.save(product);
        log.info("Product "+product.getId()+ " is saved");
    }

    public List<Product> getAllProducts() {
        List<Product> products=productDao.findAll();
        return products;
    }
}
