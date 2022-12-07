package com.example.finalproject.modules.tickets.entity;


import com.example.finalproject.modules.films.entity.FilmEntity;
import com.example.finalproject.modules.users.entity.UserEntity;
import lombok.*;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column()
    @Check(constraints = "place >= 50 and place > 0")
    private Integer place;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", nullable = false)
    private FilmEntity film;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name = "ticket_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private List<UserEntity> users = new ArrayList<>();


}
