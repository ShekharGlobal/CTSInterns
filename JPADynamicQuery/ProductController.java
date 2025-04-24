package com.cts.controller;

import com.cts.entity.Product;
import com.cts.service.ProductDynamicQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductDynamicQueryService productDynamicQueryService;

    // http://localhost:2024/api/products/search?name=Apple&category=Electronics&minPrice=100
    //http://localhost:2024/api/products/search?name=Banana&category=Grocery&maxPrice=20
    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return productDynamicQueryService.searchProducts(name, category, minPrice, maxPrice);
    }
}
