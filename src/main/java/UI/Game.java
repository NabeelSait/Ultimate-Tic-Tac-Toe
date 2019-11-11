package UI;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javax.swing.*;

public class Game extends JFrame {
    private Menu _menu;
    private GameScreen _gameScreen;
    private ReplayScreen _replayScreen;
    private FileManager _fileManager;

    public Game() {
        EventBus eventBus = new EventBus();
        eventBus.register(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        _menu = new Menu(eventBus);
        _gameScreen = new GameScreen(eventBus);

        // Default to showing the menu
        getContentPane().add(_menu);
        setMenuCharacteristics();
    }

    private void setMenuCharacteristics() {
        setTitle("Menu");
        setVisible(true);
        setBounds(250, 250, 600, 600);
    }

    private void setGameScreenCharacteristics() {
        setTitle("Ultimate Tic Tac Toe");
        setVisible(true);
        setBounds(250, 250, 600, 600);
    }

    @Subscribe
    public void buttonEvent(JButton button) {
        // Construct GameBoard and begin playing!
        if (button.getText().compareTo("   Play Against a Computer   ") == 0) {
            getContentPane().remove(_menu);
            getContentPane().add(_gameScreen);
            setGameScreenCharacteristics();
        }
        // Go back to the main menu
        else if (button.getText().compareTo("Forfeit") == 0) {
            System.out.println("got here");
            getContentPane().remove(_gameScreen);
            getContentPane().add(_menu);
            setMenuCharacteristics();
        }
    }
}
