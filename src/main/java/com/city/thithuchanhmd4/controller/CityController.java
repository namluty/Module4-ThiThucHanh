package com.city.thithuchanhmd4.controller;

import com.city.thithuchanhmd4.model.City;
import com.city.thithuchanhmd4.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/city")

public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("")
    public ModelAndView showList() {
        List<City> listCity = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("list", listCity);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createFormCity() {
        ModelAndView createForm = new ModelAndView("create");
        City city = new City();
        createForm.addObject("city", city);
        return createForm;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        return showList();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editFormCity(@PathVariable Long id) {
        City city = cityService.findById(id);
        ModelAndView editForm = new ModelAndView("edit");
        editForm.addObject("city", city);
        return editForm;
    }

    @PostMapping("/edit")
    public ModelAndView editForm(@ModelAttribute("city") City city) {
        cityService.save(city);
        return showList();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteFormCity(@PathVariable Long id) {
        City city = cityService.findById(id);
        ModelAndView deleteForm = new ModelAndView("delete");
        deleteForm.addObject("city", city);
        return deleteForm;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("city") City city) {
        cityService.delete(city.getId());
        return showList();
    }

    @GetMapping("/view/{idCity}")
    public ModelAndView viewDetail(@PathVariable("idCity") Long id) {
        City city = cityService.findById(id);
        ModelAndView viewDetail = new ModelAndView("/detail");
        viewDetail.addObject("city", city);
        return viewDetail;
    }
}
