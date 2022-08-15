package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/welcome")
    @ApiOperation(value = "-Responsável por retornar uma mensagem de boas vindas.", response = String.class)
    public String welcome() {
        return "BEM VINDO À PRODUCT REST API.";
    }

    @GetMapping(value = "/allProducts")
    @ApiOperation(value = "-Responsável por retornar uma lista de produtos.", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products."),
    })
    public List<Product> allProducts() {
        return productRepository.getAllProducts();
    }

    @GetMapping(value = "/findProductById/{id}")
    @ApiOperation(value = "-Responsável por retornar um produto pelo id", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 12, message = "The field id not informed. This information is required."),
    })
    public Product findProductById(@PathVariable Integer id ) {
        return productRepository.getProductById(id);
    }

    @PostMapping(value = "/addProduct")
    @ApiOperation(value = "-Responsável por adicionar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 10, message = "Required fields not informed."),
    })
    public void addProduct(@RequestBody Product produto) {
        productRepository.addProduct(produto);
    }

    @PutMapping(value = "/updateProduct")
    @ApiOperation(value = "-Responsável por atualizar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database."),
    })
    public void updateProduct(@RequestBody Product produto) {
        productRepository.updateProduct(produto);
    }

    @DeleteMapping(value = "/removeProduct")
    @ApiOperation(value = "-Responsável por remover um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category."),
    })
    public void removeProduct(@RequestBody Product produto) {
        productRepository.removeProduct(produto);
    }

}
