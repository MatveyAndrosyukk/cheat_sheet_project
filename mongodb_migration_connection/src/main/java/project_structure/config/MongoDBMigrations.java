package project_structure.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import project_structure.model.Product;
import project_structure.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@ChangeLog
public class MongoDBMigrations {
    @ChangeSet(order = "001", id = "seedDatabase", author = "Matvey")
    public void seedDatabase(ProductRepository productRepository){
        List<Product> products = List.of(
                new Product("product_1", "product_desc", BigDecimal.valueOf(300)),
                new Product("product_2", "product_desc", BigDecimal.valueOf(400)),
                new Product("product_3", "product_desc", BigDecimal.valueOf(500)),
                new Product("product_4", "product_desc", BigDecimal.valueOf(600)),
                new Product("product_5", "product_desc", BigDecimal.valueOf(700)),
                new Product("product_6", "product_desc", BigDecimal.valueOf(800)));

        productRepository.insert(products);
    }
}
