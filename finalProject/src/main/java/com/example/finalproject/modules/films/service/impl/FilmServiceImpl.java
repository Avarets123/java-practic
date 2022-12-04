package com.example.finalproject.modules.films.service.impl;

import com.example.finalproject.modules.films.dto.FilmCreateDto;
import com.example.finalproject.modules.films.entity.FilmEntity;
import com.example.finalproject.modules.films.repository.FilmRepository;
import com.example.finalproject.modules.films.service.FilmService;
import com.example.finalproject.modules.tickets.entity.TicketEntity;
import com.example.finalproject.modules.tickets.repository.TicketRepository;
import com.example.finalproject.modules.users.entity.UserEntity;
import com.example.finalproject.modules.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;


    @Override
    public void saveFilm(FilmCreateDto film) {
        FilmEntity newFilm = FilmEntity.builder()
                .name(film.getName())
                .day(film.getDay())
                .amountTicket(film.getAmountTicket())
                .startTime(film.getStartTime())
                .finishTime(film.getFinishTime())
                .state(FilmEntity.State.ACTIVE)
                .build();
        filmRepository.save(newFilm);
    }

    @Override
    public FilmEntity getFilmById(Long filmId) {
        return filmRepository.findByIdAndStateNot(filmId, FilmEntity.State.DELETED);
    }

    @Override
    public List<FilmEntity> getAllFilms() {
        return filmRepository.findAllByStateNot(FilmEntity.State.DELETED);
    }

    @Override
    public List<TicketEntity> findAllTicketsByFilm_Id(Long filmId) {
        return ticketRepository.findAllByFilm_Id(filmId);
    }

    @Override
    public void deleteFilm(Long filmId) {
        FilmEntity film = filmRepository.findById(filmId).orElseThrow();
        film.setState(FilmEntity.State.DELETED);
        filmRepository.save(film);
    }

    @Override
    public void updateFilmDto(Long filmId, FilmCreateDto filmData) {
        FilmEntity film = filmRepository.findById(filmId).orElseThrow();
        film.setName(filmData.getName() != null ? filmData.getName() : film.getName());
        film.setStartTime(filmData.getStartTime() != null ? filmData.getStartTime() : film.getStartTime());
        film.setFinishTime(filmData.getFinishTime() != null ? filmData.getFinishTime() : film.getFinishTime());
        film.setAmountTicket(filmData.getAmountTicket() != null ? filmData.getAmountTicket() : film.getAmountTicket());
        film.setDay(filmData.getDay() != null ? filmData.getDay() : film.getDay());
        filmRepository.save(film);
    }

    @Override
    public void updateTicket(Long ticketId, Integer place) {
        TicketEntity ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.setPlace(place);
        ticketRepository.save(ticket);
    }

    @Override
    public void addTicket(Long filmId, Integer place, Long userId) {
        FilmEntity film = filmRepository.findById(filmId).orElseThrow();
        UserEntity user = userRepository.findById(userId).orElseThrow();
        TicketEntity ticket = TicketEntity.builder()
                .place(place)
                .build();

        ticket.setFilm(film);
        ticket.setUsers(List.of(user));
        ticketRepository.save(ticket);
    }
}
