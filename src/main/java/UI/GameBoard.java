package UI;

import javax.swing.*;
import java.awt.*;

class GameBoard extends JPanel {
    private GamePanel _topLeft, _topMid, _topRight, _midLeft, _midMid, _midRight, _botLeft, _botMid, _botRight;

    GameBoard() {
        setLayout(new GridLayout(3, 3, 10, 10));

        _topLeft = new GamePanel();
        add(_topLeft);

        _topMid = new GamePanel();
        add(_topMid);

        _topRight = new GamePanel();
        add(_topRight);

        _midLeft = new GamePanel();
        add(_midLeft);

        _midMid = new GamePanel();
        add(_midMid);

        _midRight = new GamePanel();
        add(_midRight);

        _botLeft = new GamePanel();
        add(_botLeft);

        _botMid = new GamePanel();
        add(_botMid);

        _botRight = new GamePanel();
        add(_botRight);

        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        setPreferredSize(new Dimension(600, 600));
    }
}
