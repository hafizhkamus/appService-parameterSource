package com.project.crud.maven.appServiceWebApp.controller;


import com.project.crud.maven.appServiceWebApp.entity.Provinsi;
import com.project.crud.maven.appServiceWebApp.repository.ProvinsiRepositories;
import com.project.crud.maven.appServiceWebApp.service.ProvinsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProvinsiController {

    @Autowired
    ProvinsiRepositories provrepo;

    @Autowired
    ProvinsiService service;

    @GetMapping("/list-provinsi")
    public ModelAndView getProvinsi(){
        Map<String, List<Provinsi>> map = new HashMap<>();
        map.put("provinsi", service.findAll());
        return new ModelAndView("provinsi", map);
    }

    @GetMapping(path = "/provinsidetails/{id}")
    public String getProvDetails(@PathVariable("id") Integer id, Model model){
        model.addAttribute("provinsi", service.findById(id).get());
        return "update-provinsi";
    }

    @GetMapping("/signup")
    public String newProvinsi(Provinsi provinsi) {
        return "addprovinsi";
    }

    @PostMapping("/addprovinsi")
    public String saveProvinsi(@Valid Provinsi provinsi, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addprovinsi";
        }

        provrepo.save(provinsi);
        model.addAttribute("provinsi", provrepo.findAll());
        return "redirect:/list-provinsi";
    }

    @PostMapping("/update/{id}")
    public String updateProvinsi(@PathVariable("id") Integer id, @Valid Provinsi provinsi,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            provinsi.setKodeBps(id);
            return "update-provinsi";
        }

        provrepo.save(provinsi);
        model.addAttribute("provinsi", provrepo.findAll());
        return "redirect:/list-provinsi";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        Provinsi prov = provrepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        service.delete(prov);
        model.addAttribute("provinsi", provrepo.findAll());
        return "list-provinsi";
    }

}
