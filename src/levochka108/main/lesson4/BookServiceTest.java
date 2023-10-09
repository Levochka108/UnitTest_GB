package levochka108.main.lesson4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Инициализация моков

        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById() {
        long bookId = 1;

        // Создаем мок-объект Book
        Book expectedBook = mock(Book.class);

        // Определяем поведение мока
        when(bookRepository.findById(bookId)).thenReturn(expectedBook);

        // Вызываем метод, который мы хотим протестировать
        Book actualBook = bookService.findBookById(bookId);

        // Проверяем, что вернулся ожидаемый мок-объект
        assertEquals(expectedBook, actualBook);
    }

    @Test
    public void testAddBook() {
        Book bookToAdd = new Book();
        bookToAdd.setId(1);
        bookToAdd.setTitle("New Title");
        bookToAdd.setAuthor("New Author");

        bookService.addBook(bookToAdd);

        verify(bookRepository).save(bookToAdd); // Проверяем, что метод save был вызван с соответствующим аргументом
    }

    @Test
    public void testRemoveBook() {
        long bookIdToRemove = 1;

        bookService.removeBook(bookIdToRemove);

        verify(bookRepository).delete(bookIdToRemove); // Проверяем, что метод delete был вызван с соответствующим аргументом
    }

}

