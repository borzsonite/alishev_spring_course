package ru.alishev.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @RequestMapping("/calculate")
    public String calculate(@RequestParam(value = "a", required = false) int a,
                            @RequestParam("b") int b,
                            @RequestParam("action") String action, Model model) {

        int result = 0;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / b;
          }

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("action", action);
        model.addAttribute("result", result);

        return "/calculate/calculate";
    }

}
