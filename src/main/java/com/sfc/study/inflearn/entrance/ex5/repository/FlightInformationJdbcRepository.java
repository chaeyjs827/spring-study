package com.sfc.study.inflearn.entrance.ex5.repository;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FlightInformationJdbcRepository  implements FlightInformationRepository {

    private final JdbcTemplate jdbcTemplate;

    public FlightInformationJdbcRepository(
            DataSource dataSource
    ) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(FlightInformation flightInformation) {
        System.out.println("JDBC save 실행");
    }

    @Override
    public List<FlightInformation> getFlightList() {
        System.out.println("JDBC getFlightList 실행");
        return List.of();
    }

    @Override
    public FlightInformation getFlight() {
        System.out.println("JDBC getFlight 실행");
        return null;
    }
}
