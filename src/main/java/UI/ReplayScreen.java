package UI;

import Model.Move;
import com.google.common.eventbus.EventBus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReplayScreen extends JPanel
{
   private JButton _prev, _next, _quit;
   private GameBoard _gameBoard;
   private int _moveIndex;
   private ArrayList<Move> _moves;
   private EventBus _bus;

   ReplayScreen(EventBus bus) {
      _moves = new ArrayList<>();
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
      try {
         Scanner sc = new Scanner(replayFile);

         while(sc.hasNext()) {
            _moves.add(new Move(sc.nextInt(), sc.nextInt()));
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   private void nextMove() {
      _gameBoard.buttonEvent(_moves.get(_moveIndex));
      _moveIndex++;
      if (_moveIndex == _moves.size()) {
         _next.setEnabled(false);
      }
      if(_moveIndex > 0) {
         _prev.setEnabled(true);
      }
   }

   private void previousMove() {
      _gameBoard.buttonEvent(_moves.get(_moveIndex));
      _moveIndex--;
      if (_moveIndex < 0) {
         _prev.setEnabled(false);
      }
   }
}
