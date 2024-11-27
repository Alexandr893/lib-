package org.example.lib.controller;

import lombok.AllArgsConstructor;
import org.example.lib.dao.entity.Reading;
import org.example.lib.dao.repository.BookRepository;
import org.example.lib.dao.repository.ClientRepository;
import org.example.lib.dao.repository.ReadingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
@RequestMapping("/readings")
public class ReadingController {


    private ReadingRepository readingRepository;
    private BookRepository bookRepository;
    private ClientRepository clientRepository;

    @GetMapping
    public String listReadings(Model model) {
        model.addAttribute("readings", readingRepository.findAll());
        return "readings";
    }

    @GetMapping("/new")
    public String showNewReadingForm(Model model) {
        model.addAttribute("reading", new Reading());
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("clients", clientRepository.findAll());
        return "new-reading";
    }

    @PostMapping
    public String saveReading(@ModelAttribute("reading") Reading reading) {
        reading.setDateTaken(LocalDate.now());
        readingRepository.save(reading);
        return "redirect:/readings";
    }

}
