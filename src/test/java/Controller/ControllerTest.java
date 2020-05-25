package Controller;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {


    @Test
    void endGame() throws IOException {

        String[][] table = {{"B","X","X","X",},
                            {"X","B","X","X",},
                            {"X","X","B","X",},
                            {"X","X","X","B",},
                            {"X","X","X","X",}};

        Controller controller = new Controller();

        controller.endGame(table);
    }
}