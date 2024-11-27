package org.example.lib.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull(message = "Поле Клиент не может быть пустым")
    private Client client;
    @ManyToOne
    @NotNull(message = "Поле Книга не может быть пустым")
    private Book book;
    private LocalDate dateTaken;
}
