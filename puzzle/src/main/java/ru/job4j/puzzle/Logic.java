package ru.job4j.puzzle;


import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;
import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {

    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        System.out.println(index);
        Cell[] steps = this.figures[index].way(source, dest);
        boolean free = true;
        for (Cell step : steps) {
            if (findBy(step) != -1) {
                free = false;
                break;
            }
        }
        if (free) {
            figures[index] = figures[index].copy(dest);
            rst = true;
        }
        return rst;
    }

    public void clean() {
        Arrays.fill(this.figures, null);
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }

    private boolean isFree(Cell[] steps) {
        boolean rst = true;
        for (Cell cell : steps
        ) {
            if (this.findBy(cell) >= 0) {
                rst = false;
                break;
            }
        }
        return rst;
    }
}
