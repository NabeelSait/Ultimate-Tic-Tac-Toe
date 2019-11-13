package Model;

public class HumanPlayer extends Player {

    private String name;

    public HumanPlayer(char t, int n) {
        super(t, n);
    }

    public void setName(String nm) {
        name = nm;
    }

    public String getName() {
        return name;
    }

    public Move takeTurn()
    {
      return new Move(0,0);
    }


}//end class
