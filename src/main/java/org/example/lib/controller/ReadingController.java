package org.example.lib.controller;

import lombok.AllArgsConstructor;
import org.example.lib.dao.entity.Reading;
import org.example.lib.service.ReadingService.i.IReadingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/readings")
public class ReadingController {

    private final IReadingService readingService;

    @GetMapping
    public String listReadings(Model model) {
        model.addAttribute("readings", readingService.findAllReadings());
        return "readings";
    }

    @GetMapping("/new")
    public String showNewReadingForm(Model model) {
        model.addAttribute("reading", new Reading());
        model.addAttribute("books", readingService.findAllBooks());
        model.addAttribute("clients", readingService.findAllClients());
        return "new-reading";
    }

    @PostMapping
    public String saveReading(@ModelAttribute("reading") Reading reading,
                              @RequestParam("bookId") Long bookId,
                              @RequestParam("clientId") Long clientId) {

        readingService.saveReading(reading, bookId, clientId);
        return "redirect:/readings";
    }

}
