package com.djalves.workshopcassandradocker.services;

import com.djalves.workshopcassandradocker.model.dto.DepartmentDTO;
import com.djalves.workshopcassandradocker.model.entities.Department;
import com.djalves.workshopcassandradocker.repositories.DepartmentRepository;
import com.djalves.workshopcassandradocker.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDTO> findAll() {
        List<Department> list = repository.findAll();
        return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }

    public DepartmentDTO findById(UUID id) {
        Department entity = getById(id);
        return new DepartmentDTO(entity);
    }

    private Department getById(UUID id) {
        Optional<Department> result = repository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
    }

    public DepartmentDTO insert(DepartmentDTO dto) {
        Department entity = new Department();
        entity.setId(UUID.randomUUID());
        copyDtoEntity(dto, entity);
        entity = repository.save(entity);
        return new DepartmentDTO(entity);
    }

    public DepartmentDTO update(UUID id, DepartmentDTO dto) {
        Department entity = getById(id);
        copyDtoEntity(dto, entity);
        entity = repository.save(entity);
        return new DepartmentDTO(entity);
    }

    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id inexistente");
        }
        repository.deleteById(id);
    }

    private void copyDtoEntity(DepartmentDTO dto, Department entity) {
        entity.setName(dto.getName());
    }
}
