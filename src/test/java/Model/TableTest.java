package Model;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;


import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.RED;
import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    @org.junit.jupiter.api.Test
    void getOldCoordinateX()
    {
        Table table = new Table();

        table.setOldCoordinate('3','4');

        assertEquals(3, table.getOldCoordinateX());
    }

    @org.junit.jupiter.api.Test
    void getOldCoordinateY()
    {
        Table table = new Table();

        table.setOldCoordinate('3','4');

        assertEquals(4, table.getOldCoordinateY());
    }

    @org.junit.jupiter.api.Test
    void getCurrentPlayer()
    {
        Table table = new Table();
        table.setCurrentPlayer(RED);

        assertEquals(RED, table.getCurrentPlayer());

        table.setCurrentPlayer(BLUE);

        assertEquals(BLUE, table.getCurrentPlayer());
    }

    @org.junit.jupiter.api.Test
    void getCurrentColor()
    {
        Table table = new Table();
        table.setCurrentColor(RED);

        assertEquals(RED, table.getCurrentColor());

        table.setCurrentColor(BLUE);

        assertEquals(BLUE, table.getCurrentColor());
    }


    @org.junit.jupiter.api.Test
    void generateTable() {

        String[][] tabla = {{"R","B","R","B",},
                            {"X","X","X","X",},
                            {"X","X","X","X",},
                            {"X","X","X","X",},
                            {"B","R","B","R",}};

        assertArrayEquals(tabla, Table.generateTable());

    }

    @org.junit.jupiter.api.Test
    void modifier() {

        String[][] tabla = {{"B","X","X","X",},
                            {"X","B","X","X",},
                            {"X","X","B","X",},
                            {"X","X","X","X",},
                            {"X","X","X","X",}};

        assertEquals("X", Table.modifier(4, 6, tabla));

    }

    @org.junit.jupiter.api.Test
    void checkTable() {

        String[][] tabla = {{"B","X","X","X",},
                            {"X","B","X","X",},
                            {"X","X","B","X",},
                            {"X","X","X","X",},
                            {"X","X","X","X",}};

        assertFalse(Table.checkTable(tabla));

        String[][] tabla2 = {{"R","X","R","R",},
                            {"X","X","X","X",},
                            {"X","R","X","X",},
                            {"X","R","X","X",},
                            {"X","R","X","X",}};

        assertFalse(Table.checkTable(tabla2));


        String[][] tabla3 = {{"R","X","R","R",},
                            {"X","X","X","X",},
                            {"X","B","X","B",},
                            {"X","B","X","X",},
                            {"X","X","X","B",}};

        assertTrue(Table.checkTable(tabla3));

        String[][] tabla4 = {{"X","X","X","X",},
                            {"X","X","X","X",},
                            {"X","X","X","X",},
                            {"X","X","X","X",},
                            {"X","X","X","X",}};

        assertTrue(Table.checkTable(tabla4));

    }
}