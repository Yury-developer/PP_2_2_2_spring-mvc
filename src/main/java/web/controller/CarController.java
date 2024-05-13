package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;
import web.model.Car;

import java.util.List;


/**
 * @Author: Yury Lapitski
 * 2024-05-13
 */
@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private CarService carService;


    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public String showInputPage(Model model) {
        model.addAttribute("size", carService.get(-1).length);
        return "cars";
    }

    @PostMapping
    public String showCarsInfoPage(@RequestParam(name = "count", required = false, defaultValue = "0") Integer num, Model model) {
        Car[] cars = carService.get(num);
        String message = "Вывожу количество машин = " + cars.length + ":";
        model.addAttribute("carMessage", message);
        model.addAttribute("carList", List.of(cars));
        return "view-cars";
    }
}
