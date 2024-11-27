package org.example.lib.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ReadingDto {
    private String clientFullName;
    private LocalDate clientBirthDate;
    private String bookTitle;
    private String bookAuthor;
    private String bookIsbn;
    private LocalDate dateTaken;

}
