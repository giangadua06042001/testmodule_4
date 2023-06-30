package com.example.test_module_4.controller;

import com.example.test_module_4.model.City;
import com.example.test_module_4.service.ICityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("")
public class CityController {
    @Autowired
    private ICityService cityService;
    @GetMapping("/")
    private ModelAndView listCity(){
     ModelAndView modelAndView=new ModelAndView("/listCity");
     modelAndView.addObject("listCity",cityService.findAll());
     return modelAndView;
    }
    @GetMapping("/create")
    private ModelAndView FromCreate(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/create")
    private ModelAndView create(@ModelAttribute ("city")City city){
     cityService.save(city);
     ModelAndView modelAndView=new ModelAndView("/create");
     modelAndView.addObject("city",new City());
        modelAndView.addObject("message","Tạo thành phố thành công");
        return modelAndView;
    }
    @GetMapping("{id}/view")
    private ModelAndView viewCity(@PathVariable("id")Long id){
        Optional<City>city=cityService.findById(id);
      if(city.isPresent()){
       ModelAndView modelAndView=new ModelAndView("/view");
       modelAndView.addObject("city",city.get());
       return modelAndView;
      }
      else {
          return new ModelAndView("/error");
      }
    }
    @GetMapping("{id}/delete")
    private ModelAndView formDelete(@PathVariable("id")Long id){
        Optional<City>city=cityService.findById(id);
        if(city.isPresent()){
            ModelAndView modelAndView=new ModelAndView("/delete");
            modelAndView.addObject("city",city.get());
            return modelAndView;
        }
        else {
            return new ModelAndView("/error");
        }
    }
   @PostMapping("/delete")
    private ModelAndView delete(@ModelAttribute("city")City city){
      cityService.remove(city.getId());
      return new ModelAndView("/listCity");
   }
   @GetMapping("{id}/edit")
   public ModelAndView showFormEdit(@PathVariable("id")Long id){
       Optional<City>city=cityService.findById(id);
       if(city.isPresent()){
           ModelAndView modelAndView=new ModelAndView("/edit");
           modelAndView.addObject("city",city.get());
           return modelAndView;

       }else {
           return new ModelAndView("/error");
       }
   }
    @PostMapping("/edit")
    public ModelAndView updateEmployee(@Valid @ModelAttribute("employee") City city){

        cityService.save(city);
        ModelAndView modelAndView=new ModelAndView("/listCity");
        modelAndView.addObject("city",city);
        modelAndView.addObject("message","Successful employee correction");
        return modelAndView;
    }

}
