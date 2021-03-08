package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;


public class AfishaManagerTestNonEmpty {
    private AfishaManager manager = new AfishaManager();
    MovieItem first = new MovieItem(1, "Афиша", "Бладшот", "Боевик");
    MovieItem second = new MovieItem(2, "Афиша", "Вперед", "Мультфильм");
    MovieItem third = new MovieItem(3, "Афиша", "Отель Белград", "Комедия");
    MovieItem fourth = new MovieItem(4, "Афиша", "Джентльмены", "Боевик");
    MovieItem fifth = new MovieItem(5, "Афиша", "Человек-невидимка", "Ужасы");

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test

    public void shouldGetEmpty() {
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldAddToEmptyCart() {
        manager.add(first);
        MovieItem[] expected = new MovieItem[]{first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldGetAll() {
        setUp();
        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}


