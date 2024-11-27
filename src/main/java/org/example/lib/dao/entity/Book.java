package org.example.lib.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Заголовок книги не может быть пустым")
    private String title;
    @NotBlank(message = "Поле автор не может быть пустым")
    private String author;
    @NotBlank(message = "поле ISBN не может быть пустым ")
    private String isbn;
}
