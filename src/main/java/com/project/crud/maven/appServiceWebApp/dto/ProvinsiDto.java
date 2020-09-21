package com.project.crud.maven.appServiceWebApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ProvinsiDto {


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class New{

        private Integer kodeBps;
        private String naaProvinsi;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Update{

        private String namaProvinsi;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Information{

        private Integer kodeBps;
        private String namaProvinsi;
    }

}
