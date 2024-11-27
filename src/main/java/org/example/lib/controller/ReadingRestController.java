package org.example.lib.controller;

import org.example.lib.dao.entity.Reading;
import org.example.lib.dao.repository.ReadingRepository;
import org.example.lib.dto.ReadingDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/readings")
public class ReadingRestController {


    private ReadingRepository readingRepository;


    public List<ReadingDto> getAllReadings() {
        return readingRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private ReadingDto convertToDto(Reading reading) {
        return new ReadingDto(
                reading.getClient().getFullName(),
                reading.getClient().getBirthDate(),
                reading.getBook().getTitle(),
                reading.getBook().getAuthor(),
                reading.getBook().getIsbn(),
                reading.getDateTaken()
        );
    }


}
