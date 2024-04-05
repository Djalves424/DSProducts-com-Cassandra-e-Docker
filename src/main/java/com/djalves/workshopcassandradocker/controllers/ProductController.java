package com.djalves.workshopcassandradocker.controllers;

import com.djalves.workshopcassandradocker.model.dto.ProductDTO;
import com.djalves.workshopcassandradocker.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
        ProductDTO obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findByDepartment(@RequestParam(name = "department", defaultValue = "") String department) {
        List<ProductDTO> list = service.findByDepartment(department);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/description")
    public ResponseEntity<List<ProductDTO>> findByDescription(
            @RequestParam(name = "text", defaultValue = "") String text) {
        List<ProductDTO> list = service.findByDescription(text);
        return ResponseEntity.ok(list);
    }
}
