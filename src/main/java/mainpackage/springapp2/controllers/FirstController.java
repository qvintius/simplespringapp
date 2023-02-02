package mainpackage.springapp2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Stream;

@Controller
public class FirstController {
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "hello_world";
    }
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a, @RequestParam("b") int b,
                             @RequestParam(value = "action") String action, Model model){
        double result;
        switch (action){
            case "add":
                result=a+b;
                break;
            case "sub":
                result=a-b;
                break;
            case "mul":
                result=a*b;
                break;
            case "div":
                result=a/(double)b;
                break;
            default:
                result=0;
                break;
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }

}
