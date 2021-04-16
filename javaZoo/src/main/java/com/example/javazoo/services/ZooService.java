package com.example.javazoo.services;

import com.example.javazoo.models.Zoo;

import java.util.List;

public interface ZooService {
 List<Zoo> findAll();
 Zoo findZooById(long id);
}
