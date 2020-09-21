package com.project.crud.maven.appServiceWebApp.entity;


import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Validated
@Entity
@Table(name = "provinsi")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Provinsi  {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kodeBps;

    @NotEmpty
    @Size(max = 20)
    private String namaProvinsi;
}