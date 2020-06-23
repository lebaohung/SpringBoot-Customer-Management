package com.codegym.demo.controller;

import com.codegym.demo.model.Province;
import com.codegym.demo.repository.ProvinceRepository;
import com.codegym.demo.service.province.IProvinceService;
import com.codegym.demo.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
@RequestMapping("/provinces")
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/")
    public ModelAndView listProvinces(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/province/list");
        Page<Province> provinces = provinceService.findAll(pageable);
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/province/create", "province", new Province());
    }

    @PostMapping("/create")
    public ModelAndView saveProvince(@ModelAttribute Province province) {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        provinceService.save(province);
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "Create Province successfully");
        return modelAndView;
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm() {
//        return new ModelAndView()
//    }

}
