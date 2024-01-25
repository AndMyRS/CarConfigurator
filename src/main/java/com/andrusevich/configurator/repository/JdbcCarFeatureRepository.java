package com.andrusevich.configurator.repository;

import com.andrusevich.configurator.model.CarFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JdbcCarFeatureRepository implements CarFeatureRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<CarFeature> findAll() {
        return jdbcTemplate.query("select * from car_feature", this::mapRowToFeature);
    }

    @Override
    public Optional<CarFeature> findById(String id) {
        List<CarFeature> result = jdbcTemplate.query("select * from feature where id = ?", this::mapRowToFeature, id);
        return result.size() == 0 ?
        Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public CarFeature save(CarFeature carFeature) {
        jdbcTemplate.update("insert into feature values (?, ?, ?)", carFeature.getId()
        , carFeature.getName(), carFeature.getFeatureType().toString());
        return carFeature;
    }

    private CarFeature mapRowToFeature(ResultSet resultSet, int i) throws SQLException {
        return new CarFeature(resultSet.getString("id"), resultSet.getString("name"),
                CarFeature.FeatureType.valueOf(resultSet.getString("type")));
    }
}
