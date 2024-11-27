package org.example.lib.service.ReadingService;

import org.example.lib.dao.entity.Book;
import org.example.lib.dao.entity.Client;
import org.example.lib.dao.entity.Reading;
import org.example.lib.dto.ReadingDto;

import java.util.List;

public interface IReadingService {
    List<Reading> findAllReadings();
    Reading saveReading(Reading reading, Long bookId, Long clientId);
    List<Book> findAllBooks();
    List<Client> findAllClients();
    List<ReadingDto> getAllReadings();
}
