package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.KingWhite;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class LogicTest {

    @Ignore
    @Test
    public void move() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }

    @Test
    public void whenMoveTrue() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A1));
        boolean rsl = logic.move(Cell.A1, Cell.D4);
        assertThat(rsl, is(true));
    }

    @Test
    public void whenMoveFalse() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A1));
        logic.add(new KingWhite(Cell.C3));
        boolean rsl = logic.move(Cell.A1, Cell.D4);
        assertThat(rsl, is(false));
    }

    @Test
    public void moveNotDiagonal() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.C5);
        assertThat(rsl, is(false));
    }

    @Test
    public void whenMoveDiagonal() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F2));
        boolean rsl = logic.move(Cell.F2, Cell.A7);
        assertThat(rsl, is(true));
    }


}