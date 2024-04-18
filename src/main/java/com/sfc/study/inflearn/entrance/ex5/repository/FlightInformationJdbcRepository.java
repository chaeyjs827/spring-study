package com.sfc.study.inflearn.entrance.ex5.repository;

import com.sfc.study.inflearn.entrance.ex4.domain.Member;
import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FlightInformationJdbcRepository  implements FlightInformationRepository {

    private final JdbcTemplate jdbcTemplate;

    public FlightInformationJdbcRepository(
            DataSource dataSource
    ) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public FlightInformation save(FlightInformation flightInformation) {
        String sql = "INSERT INTO flight_information (flight_no, departure_time,arrival_time) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, flightInformation.getFlightNo(), flightInformation.getDepartureTime(), flightInformation.getArrivalTime());
        return null;
    }

    @Override
    public List<FlightInformation> findAll() {
        String sql = "SELECT * FROM flight_information";
        return jdbcTemplate.query(sql, flightInformationRowMapper());
    }

    @Override
    public Optional<FlightInformation> findById(Long id) {
        System.out.println("JDBC getFlight 실행");
        return null;
    }

    @Override
    public Optional<FlightInformation> findByFlightNo(String flightNo) {
        return Optional.empty();
    }

    private RowMapper<FlightInformation> flightInformationRowMapper() {
        return (rs, rowNum) -> {
            FlightInformation flightInfo = new FlightInformation();
            flightInfo.setId(rs.getLong("id"));
            flightInfo.setFlightNo(rs.getString("flight_no"));
            flightInfo.setDepartureTime(rs.getString("departure_time"));
            flightInfo.setArrivalTime(rs.getString("arrival_time"));
            return flightInfo;
        };
    }
}
