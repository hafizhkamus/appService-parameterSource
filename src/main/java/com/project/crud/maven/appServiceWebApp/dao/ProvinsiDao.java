package com.project.crud.maven.appServiceWebApp.dao;

import com.project.crud.maven.appServiceWebApp.entity.Provinsi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProvinsiDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Optional<Provinsi> findById(Integer id) throws EmptyResultDataAccessException {
        String baseQuery = "select kodeBps, namaProvinsi from provinsi where kodeBps = :kodeBps";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("kodeBps", id);

        Provinsi prov = jdbcTemplate.queryForObject(baseQuery, parameterSource, new RowMapper<Provinsi>() {
            @Override
            public Provinsi mapRow(ResultSet resultSet, int i) throws SQLException {
                Provinsi provinsi = new Provinsi();
                provinsi.setKodeBps(resultSet.getInt("kodeBps"));
                provinsi.setNamaProvinsi(resultSet.getString("namaProvinsi"));
                return provinsi;
            }
        });
        return Optional.of(prov);
    }

    public List<Provinsi> findAll() throws EmptyResultDataAccessException{
        String baseQuery= "select kodeBps, namaProvinsi from provinsi where 1=1";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        return jdbcTemplate.query(baseQuery, parameterSource, new RowMapper<Provinsi>() {
            @Override
            public Provinsi mapRow(ResultSet resultSet, int i) throws SQLException {
                Provinsi provinsi = new Provinsi();
                provinsi.setKodeBps(resultSet.getInt("kodeBps"));
                provinsi.setNamaProvinsi(resultSet.getString("namaProvinsi"));
                return provinsi;
            }
        });
    }

    public void deleteProvinsi(Integer id) throws DataAccessException {
        String baseQuery = "delete from provinsi where kodeBps = :kodeBps";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("kodeBps", id);

        jdbcTemplate.update(baseQuery,parameterSource);
    }
}
