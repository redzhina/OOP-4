package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;


public class AfishaManagerTest {
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

    public void shouldAddToEmptyFeed() {
        manager.add(first);
        MovieItem[] expected = new MovieItem[]{first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldRemoveIfExists() {
        AfishaManager manager = new AfishaManager();
        int idToRemove = 1;
        MovieItem first = new MovieItem(1, "Афиша", "Бладшот", "Боевик");
        MovieItem second = new MovieItem(2, "Афиша", "Вперед", "Мультфильм");
        MovieItem third = new MovieItem(3, "Афиша", "Отель Белград", "Комедия");
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{third, second};
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldGetAll() {
        setUp();
        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldAddToFeedWithOneItem() {
        manager.add(first);
        MovieItem[] expected = new MovieItem[]{first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        manager.add(second);
        MovieItem[] expectedWasAdded = new MovieItem[]{second, first};
        MovieItem[] actualWasAdded = manager.getAll();
        assertArrayEquals(expectedWasAdded, actualWasAdded);
    }


    @Test

    public void shouldAddMoviesForFeed() {
        setUp();
        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getMoviesForFeed();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldAddMoviesForFlexibleFeed() {
        manager = new AfishaManager(3);
        setUp();
        MovieItem[] expected = new MovieItem[] {fifth, fourth, third};
        MovieItem[] actual = manager.getMoviesForFeed();
        assertArrayEquals(expected, actual);
    }
}


