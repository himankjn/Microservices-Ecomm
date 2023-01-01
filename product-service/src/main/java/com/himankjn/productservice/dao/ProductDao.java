package com.himankjn.productservice.dao;

import com.himankjn.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDao extends MongoRepository<Product,String> {

}
