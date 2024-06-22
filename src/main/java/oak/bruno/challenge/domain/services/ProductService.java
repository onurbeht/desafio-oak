package oak.bruno.challenge.domain.services;

import jakarta.persistence.EntityNotFoundException;
import oak.bruno.challenge.domain.entities.Product;
import oak.bruno.challenge.domain.repositories.ProductRepository;
import oak.bruno.challenge.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(ProductDTO product) {
        Product newProduct = new Product(product.name(), product.info(), product.price_in_cents(), product.available());

        return repository.save(newProduct);
    }

    public Product findById(String id) {
        var possibleProd = repository.findById(id);

        if(possibleProd.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return possibleProd.get();
    }

    public List<Product> findAll(String direction) {
        Sort sort = Sort.by("priceInCents");
        if (direction.equalsIgnoreCase("DESC")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        return repository.findAll(sort);
    }
}
