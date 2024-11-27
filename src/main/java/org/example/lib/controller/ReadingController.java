package org.example.lib.controller;

import lombok.AllArgsConstructor;
import org.example.lib.dao.entity.Book;
import org.example.lib.dao.entity.Client;
import org.example.lib.dao.entity.Reading;
import org.example.lib.dao.repository.BookRepository;
import org.example.lib.dao.repository.ClientRepository;
import org.example.lib.dao.repository.ReadingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String saveReading(@ModelAttribute("reading") Reading reading,
                              @RequestParam("bookId") Long bookId,
                              @RequestParam("clientId") Long clientId) {


        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id: " + bookId));
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id: " + clientId));


        reading.setBook(book);
        reading.setClient(client);
        reading.setDateTaken(LocalDate.now());
        readingRepository.save(reading);
        return "redirect:/readings";
    }

}
