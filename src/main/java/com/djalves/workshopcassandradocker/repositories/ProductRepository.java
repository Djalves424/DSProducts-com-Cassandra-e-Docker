package com.djalves.workshopcassandradocker.repositories;

import com.djalves.workshopcassandradocker.model.entities.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

    @AllowFiltering
    List<Product> findByDepartment(String department);

    @Query("SELECT * FROM products WHERE description LIKE :text")
    List<Product> findByDescription(String text);
}
