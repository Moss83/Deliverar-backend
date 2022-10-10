package com.example.adtpoapi.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adtpoapi.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer>{

}
