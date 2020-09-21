package com.project.crud.maven.appServiceWebApp.service;

import com.project.crud.maven.appServiceWebApp.dao.ProvinsiDao;
import com.project.crud.maven.appServiceWebApp.entity.Provinsi;
import com.project.crud.maven.appServiceWebApp.repository.ProvinsiRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinsiService {

    @Autowired
    private ProvinsiRepositories provrepo;

    @Autowired
    private ProvinsiDao dao;


    public Optional<Provinsi> findById(Integer id) throws EmptyResultDataAccessException{
        return dao.findById(id);
    }

    public List<Provinsi> findAll() throws EmptyResultDataAccessException{
        return dao.findAll();
    }

    public void delete(Provinsi provinsi) throws DataAccessException {
        dao.deleteProvinsi(provinsi);
    }

//    public Provinsi findById(Integer id) throws EmptyResultDataAccessException {
//
//        Provinsi provinsi = provrepo.findById(id).orElse(null);
//
//        if (provinsi==null) {
//
//            throw new EmptyResultDataAccessException();
//
//        }
//
//        else return contact;
//
//    }
}
