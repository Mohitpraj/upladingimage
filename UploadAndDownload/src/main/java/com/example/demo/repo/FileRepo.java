package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.File;

public interface FileRepo extends JpaRepository<File, Integer>   {

}
