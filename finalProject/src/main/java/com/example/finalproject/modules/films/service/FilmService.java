package com.example.finalproject.modules.films.service;

import com.example.finalproject.modules.films.dto.FilmCreateDto;
import com.example.finalproject.modules.films.entity.FilmEntity;
import com.example.finalproject.modules.tickets.entity.TicketEntity;

import java.util.List;

public interface FilmService {

    void saveFilm(FilmCreateDto film);

    FilmEntity getFilmById(Long filmId);

    List<FilmEntity> getAllFilms();

    void addTicket(Long filmId, Integer place, Long userId);

    List<TicketEntity> findAllTicketsByFilm_Id(Long filmId);

    void deleteFilm(Long filmId);

    void updateFilmDto(Long filmId, FilmCreateDto filmData);

    void updateTicket(Long ticketId, Integer place);


}
