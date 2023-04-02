package com.example.demo.repo;

import com.example.demo.entity.Dentist;
import com.example.demo.entity.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepository extends CrudRepository<Service, Long> {
    List<Dentist> findByActive(Boolean isActive);
}
