package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBlackCopy = bishopBlack.copy(Cell.C1);
        assertThat(bishopBlackCopy.position(), is(Cell.C1));
    }

    @Test
    public void thenWayC1G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expect = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] actual = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expect, is(actual));
    }

    @Test
    public void thenWayG5C1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Cell[] expect = bishopBlack.way(Cell.G5, Cell.C1);
        Cell[] actual = new Cell[]{Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(expect, is(actual));
    }

    @Test
    public void thenWayA1h8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell[] expect = bishopBlack.way(Cell.A1, Cell.H8);
        Cell[] actual = new Cell[]{Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(expect, is(actual));
    }


    @Test
    public void thenDiagonalWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean expect = bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        assertThat(expect, is(true));
    }

    @Test
    public void thenNotDiagonalWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean expect = bishopBlack.isDiagonal(Cell.C1, Cell.E2);
        assertThat(expect, is(false));
    }

}