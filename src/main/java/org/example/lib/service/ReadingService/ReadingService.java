package org.example.lib.service.ReadingService;

import lombok.AllArgsConstructor;
import org.example.lib.dao.entity.Book;
import org.example.lib.dao.entity.Client;
import org.example.lib.dao.entity.Reading;
import org.example.lib.dao.repository.BookRepository;
import org.example.lib.dao.repository.ClientRepository;
import org.example.lib.dao.repository.ReadingRepository;
import org.example.lib.dto.ReadingDto;
import org.example.lib.exception.EntityNotFoundException;
import org.example.lib.service.ReadingService.i.IReadingService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReadingService implements IReadingService {

    private final ReadingRepository readingRepository;
    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;

    @Override
    @Cacheable("readings")
    public List<Reading> findAllReadings() {
        return readingRepository.findAll();
    }

    @Override
    public Reading saveReading(Reading reading, Long bookId, Long clientId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Invalid book Id: " + bookId));
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Invalid client Id: " + clientId));

        reading.setBook(book);
        reading.setClient(client);
        reading.setDateTaken(LocalDate.now());
        return readingRepository.save(reading);
    }

    @Override
    @Cacheable("books")
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Cacheable("clients")
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }


    @Override
    @Cacheable("restReadings")
    public List<ReadingDto> getAllReadings() {
        return readingRepository.findAll().parallelStream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
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
