package UI;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Game extends JFrame {
    private Menu _menu;
    private GameScreen _gameScreen;
    private ReplayScreen _replayScreen;

    public Game() {
        Bus.getInstance().register(this);

        setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        _menu = new Menu();

        // Default to showing the menu
        getContentPane().add(_menu);
        setMenuCharacteristics();
        setBounds(250, 250, 600, 600);
    }

    private void setMenuCharacteristics() {
        setTitle("Menu");
        setVisible(true);
    }

    private void setGameScreenCharacteristics() {
        setTitle("Ultimate Tic Tac Toe");
        setVisible(true);
    }

    private void setReplayCharacteristics() {
        setTitle("Replay Analysis");
        setVisible(true);
    }

    @Subscribe
    public void buttonEvent(JButton button) {
        // Construct GameBoard and begin playing!
        if (button.getText().compareTo("   Play Against a Computer   ") == 0) {
            getContentPane().remove(_menu);
            _gameScreen = new GameScreen(true);
            getContentPane().add(_gameScreen);
            setGameScreenCharacteristics();
        }
        else if (button.getText().compareTo("Play Against another Player") == 0) {
            getContentPane().remove(_menu);
            _gameScreen = new GameScreen(false);
            getContentPane().add(_gameScreen);
            setGameScreenCharacteristics();
         }
        // Go back to the main menu
        else if (button.getText().compareTo("Forfeit") == 0) {
            getContentPane().remove(_gameScreen);
            _menu = new Menu();
            getContentPane().add(_menu);
            setMenuCharacteristics();
            invalidate();
            validate();
            repaint();
        }
        else if (button.getText().compareTo("           Watch a Replay           ") == 0) {
            FileManager fileManager = new FileManager();
            fileManager.pickReplay();
        }
        else if (button.getText().compareTo("Quit to Menu") == 0) {
            getContentPane().remove(_replayScreen);
            _menu = new Menu();
            getContentPane().add(_menu);
            setMenuCharacteristics();
            invalidate();
            validate();
            repaint();
        }
        else if (button.getText().compareTo("Return to Main Menu") == 0) {
            getContentPane().remove(_gameScreen);
            _menu = new Menu();
            getContentPane().add(_menu);
            setMenuCharacteristics();
            invalidate();
            validate();
            repaint();
        }
    }

    @Subscribe
    public void replaySelected(File replayFile) {
        getContentPane().remove(_menu);
        _replayScreen = new ReplayScreen();
        _replayScreen.loadReplay(replayFile);
        getContentPane().add(_replayScreen);
        invalidate();
        validate();
        repaint();
        setReplayCharacteristics();
    }
}
