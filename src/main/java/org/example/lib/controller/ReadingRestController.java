package org.example.lib.controller;

import lombok.AllArgsConstructor;
import org.example.lib.dto.ReadingDto;
import org.example.lib.service.ReadingService.i.IReadingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/readings")
public class ReadingRestController {

    private IReadingService readingService;

    @GetMapping("/get")
    public List<ReadingDto> getAllReadings() {
        return readingService.getAllReadings();
    }

}
