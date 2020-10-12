package com.mk.repository;

import com.mk.data.entities.Genres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, Long> {

}