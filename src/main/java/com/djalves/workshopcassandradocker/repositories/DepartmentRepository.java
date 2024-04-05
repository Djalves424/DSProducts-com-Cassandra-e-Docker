package com.djalves.workshopcassandradocker.repositories;

import com.djalves.workshopcassandradocker.model.entities.Department;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface DepartmentRepository extends CassandraRepository<Department, UUID> {
}
