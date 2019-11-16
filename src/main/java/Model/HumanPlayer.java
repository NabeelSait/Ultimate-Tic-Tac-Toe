package Model;

public class HumanPlayer extends Player {

    private String name;

    public HumanPlayer(String t, int n) {
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
      return new Move(-1,-1);
    }


}//end class
