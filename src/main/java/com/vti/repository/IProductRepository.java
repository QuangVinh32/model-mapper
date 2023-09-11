package com.vti.repository;
import com.vti.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> , JpaSpecificationExecutor<Product> {
    Product findByName( String name);
    Product existsByName(String name);
    Product existsById(int id);
}
