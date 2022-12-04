package com.example.finalproject.modules.users.entity;



import com.example.finalproject.modules.tickets.entity.TicketEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity()
public class UserEntity {

    public enum Role {
        ADMIN, USER
    }

    public enum State {
        DELETED, ACTIVE
    }

    public UserEntity setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
        return this;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String name;

    @Column(nullable = false)
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<TicketEntity> tickets = new ArrayList<>();


    @ColumnDefault("ACTIVE")
    @Enumerated(EnumType.STRING)
    private State state;
}
