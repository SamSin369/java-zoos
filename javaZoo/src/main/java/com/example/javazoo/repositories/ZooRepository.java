package com.example.javazoo.repositories;

import com.example.javazoo.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long> {


}
