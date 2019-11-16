package Model;

public class HumanPlayer extends Player {
    private String _name;

    public HumanPlayer(String t, int n) {
        super(t, n);
    }

    public void setName(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public Move takeTurn()
    {
      return new Move(-1,-1);
    }


}//end class
