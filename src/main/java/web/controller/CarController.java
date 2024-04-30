package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;
import web.model.Car;


@Controller
@RequestMapping(value = "/cars")
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }




    @RequestMapping(value = "/", method = RequestMethod.HEAD) // HEAD - Возвращает только заголовки ответа для ресурса с указанным идентификатором, без тела ответа.
    public String ping() {
        System.out.println("\nметод CarController: ping");
        return carService.ping();
    }

    // РЕДАКТИРОВАТЬ   ***** ***** ***** РАБОТАЕТ ***** ***** *****
    @GetMapping(value = "/edit/{id}") // будет возвращать страницу редактирования Car
    public String edit(Model model, @PathVariable("id") Integer id) {
        System.out.println("\nметод CarController: edit");

        model.addAttribute("carEdit", carService.get(id));        // Берем Car с номером "id", Засовываем в модель и выплевываем в форму для редактирования
        return "carPages/edit";
    }

    // GET - Получает ресурс по его идентификатору.   // согласно условию задачи
    @GetMapping(value = "/")
    public String get(@RequestParam(required = false) Integer count, Model model) {
        System.out.println("\nметод CarController: get"); // выдаю список машин в соответствии с условием

        model.addAttribute("arrCars", carService.getSeveral(count != null ? count : 0));
        return "carPages/index";
    }



    // ***** ***** ***** РАБОТАЕТ ***** ***** *****
    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        System.out.println("\nметод CarController: show");

        model.addAttribute("showCar", carService.get(id));
        return "carPages/show";
    }




    // ***** ***** ***** РАБОТАЕТ ***** ***** *****
    @GetMapping("/new")
    public String newCar(@ModelAttribute("newCar") Car car) {
        return "carPages/new";
    }

    // ***** ***** ***** РАБОТАЕТ ***** ***** *****
    @PostMapping(value = "/")
    public String add(@ModelAttribute("newCar") Car car) {
        System.out.println("\nметод CarController: add");

        carService.save(car);
        return "redirect:/cars/";
    }



    // принимаем объект Car ИЗ формы // через @PathVariable принимаем "id" из Car // обновляет
    @PatchMapping(value = "/{id}")
    public String update(@ModelAttribute("carEdit") Car car, @PathVariable("id") Integer id) {
        System.out.println("\nCarController: update");

        // теперь нужно найти Car bиз БД с таким "id" и поменять его на те значения, которые  пришли из формы
        carService.update(id, car);
        return "redirect:/cars/";
    }




    // ***** ***** ***** РАБОТАЕТ ***** ***** *****
    @DeleteMapping(value = "/{id}")
    public String remove(@PathVariable Integer id) {
        System.out.println("\nCarController: remove");

        carService.remove(id);
        return "redirect:/cars/";
    }
}
