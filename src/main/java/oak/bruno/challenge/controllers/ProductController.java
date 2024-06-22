package oak.bruno.challenge.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import oak.bruno.challenge.domain.entities.Product;
import oak.bruno.challenge.domain.services.ProductService;
import oak.bruno.challenge.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//POST
    @PostMapping
    @Transactional
    public ResponseEntity<Product> create(@RequestBody @Valid ProductDTO product) throws URISyntaxException {

        var newProduct = productService.createProduct(product);

        var uri = new URI("api/products/" + newProduct.getId());

        return ResponseEntity.created(uri).body(newProduct);
    }

//GET
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) {
        var product = productService.findById(id);

        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(@RequestParam(defaultValue = "ASC") String direction) {
        return ResponseEntity.ok(productService.findAll(direction));
    }

}
