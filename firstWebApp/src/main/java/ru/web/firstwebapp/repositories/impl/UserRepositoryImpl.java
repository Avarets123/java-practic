package ru.web.firstwebapp.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.web.firstwebapp.models.User;
import ru.web.firstwebapp.repositories.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_SELECT_ALL = "select * from account";
    private static final String SQL_INSERT = "insert into account (email, password, description)"
            + " values (?, ?, ?)";

    private static final String SQL_SELECT_BY_ID = "select * from account where id = ?";

    private final static RowMapper<User> userRowMapper = (row, num) ->
            User.builder()
                    .id(row.getLong("id"))
                    .password(row.getString("password"))
                    .description(row.getString("description"))
                    .email(row.getString("email"))
                    .build();

    @Override
    public List<User> findAll(String orderBy, String dir) {
        String resultQuery = SQL_SELECT_ALL;

        if (orderBy != null && !orderBy.equals(" ")) {
            resultQuery += " order by" + orderBy;

        }

        if (dir != null && (dir.equals("asc") || dir.equals("desc"))) {
            resultQuery += " " + dir;
        }

        return jdbcTemplate.query(resultQuery, userRowMapper);
    }

    @Override
    public void save(User newUser) {
        jdbcTemplate.update(SQL_INSERT, newUser.getEmail(), newUser.getPassword(), newUser.getDescription());
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id);
    }
}
