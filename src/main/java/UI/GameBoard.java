package UI;

import javax.swing.*;
import java.awt.*;

class GameBoard extends JPanel {
    private GamePanel[] boards;

    GameBoard() {
        setLayout(new GridLayout(3, 3, 10, 10));
        GamePanel[] _boards = new GamePanel[9];
        for (int i = 0; i < 9; i++) {
            _boards[i] = new GamePanel();
            add(_boards[i]);
	 //Forfeit Button
        JButton ff = new JButton("Forfeit");
        this.add(ff);
        ActionListener a = new ActionListener();
        ff.addActionListener(a);
	
        }
        //Forfeit button stuff. Delete it if you dont need it
	public void actionPerformed(ActionEvent e)
	{
	   //asks user about saving replay and exits the game.	
	}

        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        setPreferredSize(new Dimension(600, 600));
    }
}
