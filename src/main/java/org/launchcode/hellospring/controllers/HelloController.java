package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Bozo";
//    }

    // handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Bozo";
    }

    // /hello?name=name
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloQuery(@RequestParam String language, String name){
        return createMessage(language, name);
    }

    // /hello/LaunchCode
    @GetMapping("{name}")
    public String helloPath(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" + "<body>" + "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" + "<select name='language' id='language-select'> " +
                "<option value='english'>English</option>" +
                "<option value='polish'>Polish</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='russian'>Russian</option>" +
                "<option value='french'>French</option>" +
                "</select>"
                + "<input type='submit' value='Greet Me!'>" +
                "</form" + "</body>" + "</html>";
    }

    public static String createMessage(String language, String name){

        switch (language) {
            case "polish":
                return "Witaj, " + name + "!";
            case "french":
                return "Bonjour, " + name + "!";
            case "spanish":
                return "¡Hola, " + name + "!";
            case "russian":
                return "Привет, " + name + "!";
            default:
                return "Hello, " + name + "!";
        }
    }

}