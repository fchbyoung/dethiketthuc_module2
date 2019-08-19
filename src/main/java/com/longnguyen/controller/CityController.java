package com.longnguyen.controller;

import com.longnguyen.model.Country;
import com.longnguyen.model.City;
import com.longnguyen.service.CountryService;
import com.longnguyen.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ThanhPhoController {

    @Autowired
    CityService cityService;

    @Autowired
    CountryService countryService;

    @ModelAttribute("quocgias")
    public Iterable<Country> provinces() {
        return countryService.findAll();
    }

    @GetMapping("/thanhphos")
    public ModelAndView listCustomer(@RequestParam("search") Optional<String> search){
        Iterable<City> thanhphos;

        if (search.isPresent()) {
            thanhphos = cityService.findAllByTenThanhPhoContaining(search.get());
        } else {
            thanhphos = cityService.findAll();
        }

        ModelAndView modelAndView = new ModelAndView("/thanhpho/list");
        modelAndView.addObject("thanhphos", thanhphos);
        return modelAndView;

    }

    @GetMapping("/create-thanhpho")
    public ModelAndView hienThiFormThemMoi() {
        ModelAndView modelAndView = new ModelAndView("/thanhpho/create");
        modelAndView.addObject("thanhpho", new City());
        return modelAndView;
    }

    @PostMapping("/create-thanhpho")
    public ModelAndView saveCustomer(@ModelAttribute("thanhpho") City thanhpho) {
        cityService.save(thanhpho);
        ModelAndView modelAndView = new ModelAndView("/thanhpho/create");
        modelAndView.addObject("thanhpho", thanhpho);
        modelAndView.addObject("message", "Created.");
        return modelAndView;
    }

    @GetMapping("/edit-thanhpho/{id}")
    public ModelAndView hienThiFormSua(@PathVariable Long id) {
        City thanhpho = cityService.findById(id);
        if (thanhpho != null) {
            ModelAndView modelAndView = new ModelAndView("/thanhpho/edit");
            modelAndView.addObject("thanhpho", thanhpho);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-thanhpho")
    public ModelAndView LuuThanhPho(@ModelAttribute("thanhpho") City thanhpho) {
        cityService.save(thanhpho);
        ModelAndView modelAndView = new ModelAndView("/thanhpho/edit");
        modelAndView.addObject("thanhpho", thanhpho);
        modelAndView.addObject("message", "Updated.");
        return modelAndView;
    }

    @GetMapping("/delete-thanhpho/{id}")
    public ModelAndView hienThiFormXoa(@PathVariable Long id) {
        City thanhpho = cityService.findById(id);
        if (thanhpho == null) {
            return new ModelAndView("/error-404");
        }
        ModelAndView modelAndView = new ModelAndView("/thanhpho/delete");
        modelAndView.addObject("thanhpho", thanhpho);
        return modelAndView;

    }

    @PostMapping("/delete-thanhpho")
    public String xoaThanhPho(@ModelAttribute("thanhpho") City thanhpho) {
        cityService.remove(thanhpho.getId());
        return "redirect:thanhphos";
    }

    @GetMapping("/view-thanhpho/{id}")
    public ModelAndView thongTinThanhPho(@PathVariable Long id) {
        City thanhpho = cityService.findById(id);
        if (thanhpho == null) {
            return new ModelAndView("/error-404");
        }
        ModelAndView modelAndView = new ModelAndView("/thanhpho/view");
        modelAndView.addObject("thanhpho", thanhpho);
        return modelAndView;
    }

}
