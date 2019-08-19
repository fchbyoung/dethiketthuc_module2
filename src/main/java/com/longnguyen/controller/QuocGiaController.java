package com.longnguyen.controller;

import com.longnguyen.model.QuocGia;
import com.longnguyen.service.QuocGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuocGiaController {

    @Autowired
    QuocGiaService quocGiaService;

    @GetMapping("/quocgias")
    public ModelAndView danhSachQuocGia() {
        Iterable<QuocGia> quocGias = quocGiaService.findAll();
        ModelAndView modelAndView = new ModelAndView("/quocgia/list");
        modelAndView.addObject("quocgias", quocGias);
        return modelAndView;
    }

    @GetMapping("/create-quocgia")
    public ModelAndView showCreateProvinceForm() {
        ModelAndView modelAndView = new ModelAndView("/quocgia/create");
        modelAndView.addObject("quocgia", new QuocGia());
        return modelAndView;
    }

    @PostMapping("/create-quocgia")
    public ModelAndView saveQuocGia(@ModelAttribute("quocgia") QuocGia quocgia) {
        quocGiaService.save(quocgia);

        ModelAndView modelAndView = new ModelAndView("/quocgia/create");
        modelAndView.addObject("quocgia", new QuocGia());
        modelAndView.addObject("message", "Created.");
        return modelAndView;
    }

    @GetMapping("/edit-quocgia/{id}")
    public ModelAndView hienThiForm(@PathVariable Long id) {
        QuocGia quocgia = quocGiaService.findById(id);
        if (quocgia != null) {
            ModelAndView modelAndView = new ModelAndView("/quocgia/edit");
            modelAndView.addObject("quocgia", quocgia);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-quocgia")
    public ModelAndView updateProvince(@ModelAttribute("quocgia") QuocGia quocgia) {
        quocGiaService.save(quocgia);
        ModelAndView modelAndView = new ModelAndView("/quocgia/edit");
        modelAndView.addObject("quocgia", quocgia);
        modelAndView.addObject("message", "Updated.");
        return modelAndView;
    }

    @GetMapping("/delete-quocgia/{id}")
    public ModelAndView showDeleteProvinceForm(@PathVariable Long id) {
        QuocGia quocgia = quocGiaService.findById(id);

        if (quocgia != null) {
            ModelAndView modelAndView = new ModelAndView("/quocgia/delete");
            modelAndView.addObject("quocgia", quocgia);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-quocgia")
    public String deleteProvice(@ModelAttribute("quocgia") QuocGia quocgia) {
        quocGiaService.remove(quocgia.getId());
        return "redirect:quocgias";
    }
}
