package com.example.javazoo.repositories;

import com.example.javazoo.models.EmailList;
import org.springframework.data.repository.CrudRepository;



public interface EmailRepository extends CrudRepository<EmailList, Long> {

}
