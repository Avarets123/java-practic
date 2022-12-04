package com.example.finalproject.modules.tickets.repository;

import com.example.finalproject.modules.tickets.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

    List<TicketEntity> findAllByFilm_Id(Long filmId);
}
