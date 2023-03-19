package com.example.demo.repo;

import com.example.demo.entity.Journal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends CrudRepository<Journal, Long> {

}
