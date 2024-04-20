package com.sfc.study.inflearn.entrance.ex4.repository;

import com.sfc.study.inflearn.entrance.ex4.domain.Ex4Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class Ex4JdbcTemplateEx4MemberRepository implements Ex4MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public Ex4JdbcTemplateEx4MemberRepository(
            DataSource dataSource
    ) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Ex4Member save(Ex4Member member) {
        return null;
    }

    @Override
    public Optional<Ex4Member> findById(Long id) {
        List<Ex4Member> result = jdbcTemplate.query("select * from member WHERE id = ?", memberRowMapper());
        return result.stream().findAny();
    }

    @Override
    public Optional<Ex4Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Ex4Member> findAll() {
        return List.of();
    }

    private RowMapper<Ex4Member> memberRowMapper() {
        return new RowMapper<>() {
            @Override
            public Ex4Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Ex4Member member = new Ex4Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                return member;
            }
        };
    }
}
