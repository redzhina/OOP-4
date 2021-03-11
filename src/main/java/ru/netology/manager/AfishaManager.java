package ru.netology.manager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import ru.netology.domain.MovieItem;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AfishaManager {
    private MovieItem[] items = new MovieItem[0];
    private int moviesFeed = 10;

    public AfishaManager(int moviesFeed) {
        this.moviesFeed = moviesFeed;
    }


    // наивная реализация
    public void removeById(int id) {
        int length = items.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        items = tmp;
    }


    public void add(MovieItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll() {
        MovieItem[] result = new MovieItem[items.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public MovieItem[] getMoviesForFeed() {
        int feed = this.moviesFeed;
        if (feed > items.length)
            feed = items.length;
        MovieItem[] result = new MovieItem[feed];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}