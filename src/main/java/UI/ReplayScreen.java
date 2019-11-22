package UI;

import Model.Replayer;
import Model.Move;
import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;
import java.io.File;

class ReplayScreen extends JPanel
{
   private JButton _prev, _next, _quit;
   private GameBoard _gameBoard;
   private EventBus _bus;
   private Replayer _replayer;

   ReplayScreen(EventBus bus) {
      _bus = bus;

      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();

      _gameBoard = new GameBoard(bus);
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
      _quit.addActionListener(e -> _bus.post(_quit));
      c.anchor = GridBagConstraints.CENTER;
      c.gridx = 0;
      c.gridy = 2;
      add(_quit, c);
   }

   void loadReplay(File replayFile) {
      _replayer = new Replayer(replayFile);
   }

   private void nextMove() {
      _gameBoard.buttonEvent(_replayer.nextMove());
      if (!_replayer.hasNextMove()) {
         _next.setEnabled(false);
      }
      if(_replayer.hasPrevMove()) {
         _prev.setEnabled(true);
      }
   }

   private void previousMove() {
      Move prev = _replayer.previousMove();
      Move pprev = new Move(-1,-1);
      if (_replayer.hasPrevMove()){
         pprev = _replayer.previousMove();
         Move m = _replayer.nextMove();
      }
      _gameBoard.undoMove(prev, pprev);
      if(!_replayer.hasPrevMove()) {
         _prev.setEnabled(false);
      }
   }
}
