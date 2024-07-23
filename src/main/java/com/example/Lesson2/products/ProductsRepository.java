package com.example.Lesson2.products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    // Здесь можно добавить дополнительные методы, если необходимо
    //int getPriceOfProductByProductId(Long productId);

}