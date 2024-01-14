package ru.tests.hw.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * У вас есть класс BookService, который использует интерфейс BookRepository
 * для получения информации о книгах из базы данных. Ваша задача написать
 * unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
 */

class BookServiceTest {
    BookService bookService;
    static BookRepository mockBookRepository;
    static Book book1, book2;

    @BeforeEach
    void setup() {
        bookService = new BookService(mockBookRepository);
    }

    @BeforeAll
    static void init() {
        mockBookRepository = mock(BookRepository.class);
        book1 = mock(Book.class);
        book2 = mock(Book.class);
    }

    /**
     * Поиск книги по id (число > 0)
     */
    @Test
    void findBookByIdTest() {
        when(mockBookRepository.findById(anyString()))
                .thenAnswer(id -> {
                    String res = id.getArgument(0);
                    if (res.equals("1")) return book1;
                    if (res.equals("2")) return book2;
                    return null;
        });

        assertEquals(book1, bookService.findBookById("1"));
        assertEquals(book2, bookService.findBookById("2"));
        assertNull(bookService.findBookById("5"));
    }

    /**
     * Поиск книги по id (число < 1)
     */
    @Test
    void findBookByNotExistNumberIdTest() {
        when(mockBookRepository.findById("-5"))
                .thenThrow(IllegalArgumentException.class);

        assertThatThrownBy(() -> bookService.findBookById("-5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Поиск книги по id (не число)
     */
    @Test
    void findBookByNotExistNotNumberIdTest() {
        when(mockBookRepository.findById("abc"))
                .thenThrow(NumberFormatException.class);

        assertThatThrownBy(() -> bookService.findBookById("abc"))
                .isInstanceOf(NumberFormatException.class);
    }

    /**
     * Поиск книги по id (пустая строка)
     */
    @Test
    void findBookByEmptyIdTest() {
        when(mockBookRepository.findById(""))
                .thenThrow(NumberFormatException.class);

        assertThatThrownBy(() -> bookService.findBookById(""))
                .isInstanceOf(NumberFormatException.class);
    }

    /**
     * Поиск книги по id (null)
     */
    @Test
    void findBookByNullIdTest() {
        when(mockBookRepository.findById(null))
                .thenThrow(NullPointerException.class);

        assertThatThrownBy(() -> bookService.findBookById(null))
                .isInstanceOf(NullPointerException.class);
    }

    /**
     * Получение списка всех книг
     */
    @Test
    void findAllBooksTest() {
        List<Book> mockBooks = List.of(book1, book2);
        when(mockBookRepository.findAll()).thenReturn(mockBooks);

        List<Book> books = bookService.findAllBooks();

        assertThat(books)
                .isNotEmpty()
                .hasSize(2)
                .containsAll(mockBooks);
    }

    /**
     * Получение списка всех книг, если список пустой
     */
    @Test
    void findAllBooksEmptyListTest() {
        when(mockBookRepository.findAll()).thenReturn(new ArrayList<>());

        List<Book> books = bookService.findAllBooks();

        assertThat(books).isEmpty();
    }

    /**
     * Получение списка всех книг (null)
     */
    @Test
    void findAllBooksNullTest() {
        when(mockBookRepository.findAll()).thenReturn(null);

        List<Book> books = bookService.findAllBooks();

        assertThat(books).isNull();
    }

}