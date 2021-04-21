package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        assertThat(bishopBlack.position(), is(Cell.A3));
    }

    @Test
    public void copy() {
        BishopBlack firstBishopBlack = new BishopBlack(Cell.A3);
        Figure secondBishopBlack = firstBishopBlack.copy(Cell.B2);
        assertThat(secondBishopBlack.position(), is(Cell.B2));
    }

    @Test
    public void wayRightA1ToD4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.way(Cell.D4), is(new Cell[] {Cell.B2, Cell.C3, Cell.D4}));
    }

    @Test
    public void wayRightH2oC7() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H2);
        assertThat(bishopBlack.way(Cell.C7), is(new Cell[] {Cell.G3, Cell.F4, Cell.E5, Cell.D6, Cell.C7}));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void wayWrong() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack.way(Cell.C1);
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack firstBishopBlack = new BishopBlack(Cell.A4);
        Cell destination = Cell.D1;
        boolean result = firstBishopBlack.isDiagonal(firstBishopBlack.position(), destination);
        assertTrue(result);
    }

    @Test
    public void whenNotDiagonal() {
        BishopBlack firstBishopBlack = new BishopBlack(Cell.A4);
        Cell destination = Cell.C4;
        boolean result = firstBishopBlack.isDiagonal(firstBishopBlack.position(), destination);
        assertFalse(result);
    }
}