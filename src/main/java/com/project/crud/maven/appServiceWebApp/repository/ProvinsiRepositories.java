package com.project.crud.maven.appServiceWebApp.repository;

import com.project.crud.maven.appServiceWebApp.entity.Provinsi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinsiRepositories extends CrudRepository<Provinsi, Integer>{
}
