package com.example.javazoo.services;

import com.example.javazoo.models.Zoo;
import com.example.javazoo.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ZooServiceImplementation implements ZooService {
    @Autowired
    private ZooRepository zooRepository;

    @Override
    public List<Zoo> findAll()
    {
        List<Zoo> list = new ArrayList<>();

        zooRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);

        return list;
    }
    @Override
    public Zoo findZooById(long id)
    {
        return zooRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo " + id + " Not Found"));
    }
}
