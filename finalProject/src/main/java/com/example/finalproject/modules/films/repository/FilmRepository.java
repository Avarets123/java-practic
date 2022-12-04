package com.example.finalproject.modules.films.repository;

import com.example.finalproject.modules.films.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FilmRepository extends JpaRepository<FilmEntity, Long> {

    List<FilmEntity> findAllByStateNot(FilmEntity.State state);

    FilmEntity findByIdAndStateNot(Long filmId, FilmEntity.State state);
}