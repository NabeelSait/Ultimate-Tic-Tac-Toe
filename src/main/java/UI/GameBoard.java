package UI;

import javax.swing.*;
import java.awt.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class GameBoard extends JPanel {
    private GamePanel[] boards;
    private GameBoardModel _model;

    public GameBoard(EventBus e) {
        setLayout(new GridLayout(3, 3, 10, 10));
        GamePanel[] _boards = new GamePanel[9];
        for (int i = 0; i < 9; i++) {
            _boards[i] = new GamePanel();
            add(_boards[i]);
        }
    }
}
