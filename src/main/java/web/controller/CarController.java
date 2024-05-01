package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;
import web.model.Car;


/**
 * @Author: Yury Lapitski
 * 2024-05-01
 */
@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private CarService carService;


    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    /* HEAD
    Возвращает только заголовки, использую для проверки доступности ресурса.
     */
    @RequestMapping(method = RequestMethod.HEAD)
    public String ping() {
        return carService.ping();
    }

    /* GET
    Возвращает страницу редактирования Car.
    (вытаскиваем Car по его id, засовываем в модель и отправляем в html форму для редактирования)
     */
    @GetMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("carEdit", carService.get(id));
        return "carPages/edit";
    }

    /* GET
    Возвращает список Car исходя из запрашиваемого количества
     */
    @GetMapping
    public String get(@RequestParam(name = "count", required = false, defaultValue = "0") Integer count, Model model) {
        model.addAttribute("arrCars", carService.getSeveral(count != null ? count : 0));
        return "carPages/index";
    }

    /* GET
    Возвращает страницу с подробной информацией об интересующем Car по tего id.
     */
    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("showCar", carService.get(id));
        return "carPages/show";
    }

    /* GET
    Возвращает страницу для добавления нового Car.
     */
    @GetMapping("/new")
    public String newCar(@ModelAttribute("newCar") Car car) {
        return "carPages/new";
    }

    /* POST
    Вносит новый Car в имеющуюся базу.
     */
    @PostMapping(value = "/")
    public String add(@ModelAttribute("newCar") Car car) {
        carService.save(car);
        return "redirect:/cars/";
    }

    /* PATCH
    Обновляет/ перезаписывает имеющийся Car gпо его id.
     */
    @PatchMapping(value = "/{id}")
    public String update(@ModelAttribute("carEdit") Car car, @PathVariable("id") Integer id) {
        carService.update(id, car);
        return "redirect:/cars/";
    }

    /* DELETE
    Удаляет Car bиз базы по его id.
     */
    @DeleteMapping(value = "/{id}")
    public String remove(@PathVariable Integer id) {
        carService.remove(id);
        return "redirect:/cars/";
    }
}
