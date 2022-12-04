package com.example.finalproject.modules.films.entity;


import com.example.finalproject.modules.tickets.entity.TicketEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FilmEntity {

    public enum State {
        DELETED, ACTIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Timestamp day;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "finish_time")
    private LocalTime finishTime;

    @Column(name = "amount_ticket")
    private Integer amountTicket;

    @OneToMany(mappedBy = "film")
    private Set<TicketEntity> tickets;

    @Enumerated(value = EnumType.STRING)
    private State state;
}
