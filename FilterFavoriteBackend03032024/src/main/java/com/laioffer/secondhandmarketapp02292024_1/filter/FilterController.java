package com.laioffer.secondhandmarketapp02292024_1.filter;

import com.laioffer.secondhandmarketapp02292024_1.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/filter")
@CrossOrigin(origins = "http://localhost:3000")
public class FilterController {

    private final FilterService filterService;

    @Autowired
    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    @GetMapping("/products")
    //@CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductDto>> filterProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice) {

        List<ProductDto> filteredProducts = filterService.filterProducts(category, minPrice, maxPrice);
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }
}

