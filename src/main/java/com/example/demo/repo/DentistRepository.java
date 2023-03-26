package com.example.demo.repo;

import com.example.demo.entity.Dentist;
import org.springframework.data.repository.CrudRepository;


public interface DentistRepository extends CrudRepository<Dentist, Long> {


}
