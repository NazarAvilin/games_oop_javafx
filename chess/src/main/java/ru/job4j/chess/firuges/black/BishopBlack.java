package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {

    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps= new Cell[0];
        if (isDiagonal(source, dest)) {
            int size = dest.y > source.y ? dest.y - source.y : source.y - dest.y;
            steps = new Cell[size];
            int deltaX = dest.x - source.x < 0 ? -1 : 1;
            int deltaY = dest.y - source.y < 0 ? -1 : 1;
            int x = source.x;
            int y = source.y;
            for (int index = 0; index < size; index++) {
                x += deltaX;
                y += deltaY;
                steps[index] = Cell.findBy(x, y);
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.y - source.y) == Math.abs(dest.x - source.x);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
