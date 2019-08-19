package com.longnguyen.controller;

import com.longnguyen.model.QuocGia;
import com.longnguyen.model.ThanhPho;
import com.longnguyen.service.QuocGiaService;
import com.longnguyen.service.ThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ThanhPhoController {

    @Autowired
    ThanhPhoService thanhPhoService;

    @Autowired
    QuocGiaService quocGiaService;

    @ModelAttribute("quocgias")
    public Iterable<QuocGia> provinces() {
        return quocGiaService.findAll();
    }

    @GetMapping("/thanhphos")
    public ModelAndView listCustomer(@RequestParam("search") Optional<String> search){
        Iterable<ThanhPho> thanhphos;

        if (search.isPresent()) {
            thanhphos = thanhPhoService.findAllByTenThanhPhoContaining(search.get());
        } else {
            thanhphos = thanhPhoService.findAll();
        }

        ModelAndView modelAndView = new ModelAndView("/thanhpho/list");
        modelAndView.addObject("thanhphos", thanhphos);
        return modelAndView;

    }

    @GetMapping("/create-thanhpho")
    public ModelAndView hienThiFormThemMoi() {
        ModelAndView modelAndView = new ModelAndView("/thanhpho/create");
        modelAndView.addObject("thanhpho", new ThanhPho());
        return modelAndView;
    }

    @PostMapping("/create-thanhpho")
    public ModelAndView saveCustomer(@ModelAttribute("thanhpho") ThanhPho thanhpho) {
        thanhPhoService.save(thanhpho);
        ModelAndView modelAndView = new ModelAndView("/thanhpho/create");
        modelAndView.addObject("thanhpho", thanhpho);
        modelAndView.addObject("message", "Created.");
        return modelAndView;
    }

    @GetMapping("/edit-thanhpho/{id}")
    public ModelAndView hienThiFormSua(@PathVariable Long id) {
        ThanhPho thanhpho = thanhPhoService.findById(id);
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
    public ModelAndView LuuThanhPho(@ModelAttribute("thanhpho") ThanhPho thanhpho) {
        thanhPhoService.save(thanhpho);
        ModelAndView modelAndView = new ModelAndView("/thanhpho/edit");
        modelAndView.addObject("thanhpho", thanhpho);
        modelAndView.addObject("message", "Updated.");
        return modelAndView;
    }

    @GetMapping("/delete-thanhpho/{id}")
    public ModelAndView hienThiFormXoa(@PathVariable Long id) {
        ThanhPho thanhpho = thanhPhoService.findById(id);
        if (thanhpho == null) {
            return new ModelAndView("/error-404");
        }
        ModelAndView modelAndView = new ModelAndView("/thanhpho/delete");
        modelAndView.addObject("thanhpho", thanhpho);
        return modelAndView;

    }

    @PostMapping("/delete-thanhpho")
    public String xoaThanhPho(@ModelAttribute("thanhpho") ThanhPho thanhpho) {
        thanhPhoService.remove(thanhpho.getId());
        return "redirect:thanhphos";
    }

    @GetMapping("/view-thanhpho/{id}")
    public ModelAndView thongTinThanhPho(@PathVariable Long id) {
        ThanhPho thanhpho = thanhPhoService.findById(id);
        if (thanhpho == null) {
            return new ModelAndView("/error-404");
        }
        ModelAndView modelAndView = new ModelAndView("/thanhpho/view");
        modelAndView.addObject("thanhpho", thanhpho);
        return modelAndView;
    }

}
