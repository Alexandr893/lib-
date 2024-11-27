package org.example.lib.service.ReadingService;

import org.example.lib.dao.entity.Book;
import org.example.lib.dao.entity.Client;
import org.example.lib.dao.entity.Reading;
import org.example.lib.dao.repository.BookRepository;
import org.example.lib.dao.repository.ClientRepository;
import org.example.lib.dao.repository.ReadingRepository;
import org.example.lib.exception.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReadingServiceTest {
    @Mock
    private ReadingRepository readingRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ReadingService readingService;

    private Book book;
    private Client client;
    private Reading reading;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        book = new Book();
        book.setId(10L);

        client = new Client();
        client.setId(10L);

        reading = new Reading();
    }

    @Test
    public void testSaveReadingSuccess() {
        when(bookRepository.findById(10L)).thenReturn(Optional.of(book));
        when(clientRepository.findById(10L)).thenReturn(Optional.of(client));
        when(readingRepository.save(any(Reading.class))).thenReturn(reading);

        Reading savedReading = readingService.saveReading(new Reading(), 10L, 10L);

        assertNotNull(savedReading);
        verify(readingRepository).save(any(Reading.class));
    }

    @Test
    public void testSaveReadingBookNotFound() {
        when(bookRepository.findById(10L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            readingService.saveReading(new Reading(), 10L, 10L);
        });

        assertEquals("Invalid book Id: 10", exception.getMessage());
    }

    @Test
    public void testSaveReadingClientNotFound() {
        when(bookRepository.findById(10L)).thenReturn(Optional.of(book));
        when(clientRepository.findById(10L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            readingService.saveReading(new Reading(), 10L, 10L);
        });

        assertEquals("Invalid client Id: 10", exception.getMessage());
    }
}