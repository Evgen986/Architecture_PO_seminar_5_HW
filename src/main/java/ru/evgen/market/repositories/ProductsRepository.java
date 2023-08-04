package ru.evgen.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evgen.market.models.Product;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
    List<Product> findDistinctByNameOrNumberOrderByName(String name, String number);

    List<Product> findDistinctByApplyingIgnoreCaseOrderByName(String applying);
}
