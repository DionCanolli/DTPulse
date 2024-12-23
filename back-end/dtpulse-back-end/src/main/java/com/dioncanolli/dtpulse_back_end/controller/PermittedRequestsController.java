package com.dioncanolli.dtpulse_back_end.controller;

import com.dioncanolli.dtpulse_back_end.dto.PaginatedProductsDTO;
import com.dioncanolli.dtpulse_back_end.dto.ProductDTO;
import com.dioncanolli.dtpulse_back_end.entity.Category;
import com.dioncanolli.dtpulse_back_end.entity.User;
import com.dioncanolli.dtpulse_back_end.service.MyService;
import com.dioncanolli.dtpulse_back_end.utility.JWTTokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/permitted")
public class PermittedRequestsController {

    private final MyService myService;

    public PermittedRequestsController(MyService myService) {
        this.myService = myService;
    }

    @PostMapping(value = "/users/signup")
    public ResponseEntity<Boolean> signUp(@RequestBody User user){
        boolean result = myService.insertUser(user);
        return !result
                ? new ResponseEntity<>(false, HttpStatus.BAD_REQUEST) : new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @GetMapping(value = "/products/find")
    public ResponseEntity<PaginatedProductsDTO> getProducts(@RequestParam(required = false) String categoryName,
                                                  @RequestParam(required = false) String productName,
                                                  @RequestParam int page){
        PaginatedProductsDTO productDTOS = myService.getAllProducts(categoryName, productName, page);
        if (productDTOS != null){
            if (productDTOS.getAllProducts() != null){
                return (productDTOS.getAllProducts().isEmpty())
                        ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(productDTOS, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/products/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productDTOS = myService.getAllProductsNotPaginated();
        if (productDTOS != null){
                return (productDTOS.isEmpty())
                        ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(productDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/product/find")
    public ResponseEntity<ProductDTO> getProduct(@RequestParam String productName){
        ProductDTO productDTO = myService.findProduct(productName);
        return productDTO != null ? new ResponseEntity<>(productDTO, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/categories/all")
    public ResponseEntity<List<Category>> findAllCategories(){
        List<Category> categories = myService.findAllCategories();
        return (categories.isEmpty()) ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
