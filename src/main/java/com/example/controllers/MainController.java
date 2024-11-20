package com.example.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.services.ImageService;

@Controller
public class MainController {

    private final ImageService imageService;

    public MainController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/main")
    public String main() {
        return "main.html";
    }

    @GetMapping("/output")
    public String output(
            @RequestParam Integer numRequest,
            Model model) {
        System.out.println("Entering output method");
        List<String> images = imageService.getRandomImages(numRequest);
        System.out.println(images); // why is this printing 2 lists?? -> sth to do with browser

        model.addAttribute("numRequest", numRequest);
        model.addAttribute("images", images);

        return "output.html";
    }

}
