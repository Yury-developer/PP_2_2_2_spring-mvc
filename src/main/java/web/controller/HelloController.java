package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {

		System.out.println("@GetMapping(value = \"/\")");

		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("ru: Практическая задача 2.2.2 Java pre-project.");
		messages.add("en: Practical task 2.2.2 Java pre-project.");
		messages.add("The task was completed by: Yuri Lapitsky");
		model.addAttribute("messages", messages);
		return "index";
	}
	
}