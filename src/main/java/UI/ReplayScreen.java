package UI;

import Model.Replayer;
import Model.Move;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Game Analysis screen
 */
class ReplayScreen extends JPanel
{
   private JButton _prev, _next, _quit;
   private GameBoard _gameBoard;
   private Replayer _replayer;

   /**
    * Basic Constructor
    */
   ReplayScreen() {
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();

      _gameBoard = new GameBoard(false);
      _gameBoard.closeAllBoards();
      c.gridx = 0;
      c.gridy = 0;
      c.anchor = GridBagConstraints.PAGE_START;
      c.insets = new Insets(20,0,0,0);
      add(_gameBoard, c);

      _prev = new JButton("Previous");
      _prev.addActionListener(e -> previousMove());
      c.gridy = 1;
      c.anchor = GridBagConstraints.LAST_LINE_START;
      _prev.setEnabled(false);
      add(_prev, c);

      _next = new JButton(" Next ");
      _next.addActionListener(e -> nextMove());
      c.anchor = GridBagConstraints.LAST_LINE_END;
      c.gridx = 0;
      c.gridy = 1;
      add(_next, c);

      _quit = new JButton("Quit to Menu");
      _quit.addActionListener(e -> Bus.getInstance().post(_quit));
      c.anchor = GridBagConstraints.CENTER;
      c.gridx = 0;
      c.gridy = 2;
      add(_quit, c);
   }

   /**
    * Load a replay file
    * @param replayFile File with a replay in it
    */
   void loadReplay(File replayFile) {
      _replayer = new Replayer(replayFile);
   }

   /**
    * Apply the next move
    * Check to update buttons
    */
   private void nextMove() {
      _gameBoard.stepMove(_replayer.nextMove());
      if (!_replayer.hasNextMove()) {
         _next.setEnabled(false);
      }
      if(_replayer.hasPrevMove()) {
         _prev.setEnabled(true);
      }
   }

   /**
    * Take back the latest move
    * Check to update buttons
    */
   private void previousMove() {
      if (_replayer.hasPrevMove()){
         Move prev = _replayer.previousMove();
         _gameBoard.undoMove(prev);
      }
      if(!_replayer.hasPrevMove()) {
         _prev.setEnabled(false);
      }
      if (_replayer.hasNextMove()) {
         _next.setEnabled(true);
      }
   }
}
