package Model;

import javafx.scene.paint.Paint;

import java.util.logging.Logger;

import static javafx.scene.paint.Color.*;

public class Table {

    private static Logger logger = Logger.getLogger(String.valueOf(Table.class));

    Paint player = RED;
    Paint currentColor = WHITE;
    int oldCoordinateX = 0;
    int oldCoordinateY = 0;
    int coordinateX = 0;
    int coordinateY = 0;

    public void setCoordinate(char x, char y)
    {
        coordinateX = Character.getNumericValue(x);
        coordinateY = Character.getNumericValue(y);

        logger.info("coordinate x and y are set");
    }
    public void setOldCoordinate(char x, char y)
    {
        oldCoordinateX = Character.getNumericValue(x);
        oldCoordinateY = Character.getNumericValue(y);

        logger.info("old coordinate x and y are set");
    }

    public int getOldCoordinateX()
    {
        logger.info("getting old coordinate x");
        return oldCoordinateX;
    }

    public int getOldCoordinateY()
    {
        logger.info("getting old coordinate y");
        return oldCoordinateY;
    }

    public void move()
    {
        oldCoordinateX = coordinateX;
        oldCoordinateY = coordinateY;
        logger.info("move coordinates to old coordinates");
    }

    public void setCurrentPlayer(Paint p)
    {
        player = p;
        logger.info("set current player to " + p);
    }

    public Paint getCurrentPlayer()
    {
        logger.info("getting current player");
        return player;
    }

    public void setCurrentColor(Paint color)
    {
        logger.info("set paint color: " + color);
        currentColor = color;
    }

    public Paint getCurrentColor()
    {
        logger.info("getting current color");
        return currentColor;
    }

    /**
     * generating the starting table
     * @return table is the already generated table ready to begin the game
     */

    public static String[][] generateTable()
    {
        logger.info("generating starting table");
        String[][] tabla = new String[5][4];

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                tabla[i][j] = "X";
            }
        }
        tabla[0][0] = "R";
        tabla[0][2] = "R";
        tabla[4][1] = "R";
        tabla[4][3] = "R";
        tabla[0][1] = "B";
        tabla[0][3] = "B";
        tabla[4][0] = "B";
        tabla[4][2] = "B";
        return tabla;
    }

    /**
     * writes the table out to the console
     * @param tabla this table will be written out to console
     */
    public static void showTable(String[][] tabla)
    {
        logger.info("showing starting table");
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    /**
     * sets the desired coordinate of the table to one of the specidfied colors
     * @param y this is the y coordinate
     * @param x this is the x coordinate
     * @param tabla this is the current table state that will be modified
     */

    public void setTable(int y, int x, String[][] tabla)
    {
        logger.info("Set table");
        if (currentColor == WHITE) {
            tabla[x][y] = "X";
            logger.info("set table to white");
        } else {
            if (currentColor == BLUE) {
                tabla[x][y] = "B";
                logger.info("set table to blue");
            } else {
                tabla[x][y] = "R";
                logger.info("set table to red");
            }
        }
    }

    /**
     * checks out of bound step at an exact coordinate of a table state
     * @param y this is the y coordinate
     * @param x this is the x coordinate
     * @param tabla this is the current table state
     * @return returns X if the step is out of bound or the desired coordinate of the current table state
     */

    public static String modifier(int y, int x, String[][] tabla)
    {
        if(x < 0 || y < 0 || x >= 5 || y >= 4)
        {
            return "X";
        }
        else
        {
            return tabla[x][y];
        }

    }

    /**
     * checks table if it is in a winning state
     * @param tabla this table will be checked
     * @return victoryState that will be used to determined if the game is at a winning condition
     */
    public static boolean checkTable(String[][] tabla) {
        boolean victoryState = true;
        logger.info("checking table");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (!modifier(i, j, tabla).equals("X") && modifier(i, j, tabla).equals(modifier(i, j + 1, tabla)) && modifier(i, j, tabla).equals(modifier(i, j + 2, tabla))) {
                    victoryState = false;
                    logger.info("in a column there are 4 circles in a row");
                }
                if (!modifier(i, j, tabla).equals("X") && modifier(i, j, tabla).equals(modifier(i + 1, j, tabla)) && modifier(i, j, tabla).equals(modifier(i + 2, j, tabla))) {
                    victoryState = false;
                    logger.info("in a row there are 4 circles in a row");
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                for (int d = -1; d <= 1; d += 2) {
                    if (!modifier(i, j, tabla).equals("X") && modifier(i, j, tabla).equals(modifier(i + d, j + 1, tabla)) && modifier(i, j, tabla).equals(modifier(i + 2 * d, j + 2, tabla))) {
                        victoryState = false;
                        logger.info("in a cross there are 4 circles in a row");
                        break;
                    }
                }
            }
        }

        return victoryState;
    }

}
