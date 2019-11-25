package Model;

public class HumanPlayer extends Player {
    private String _name;

    public HumanPlayer(String t, int n) {
        super(t, n);
    }

    void setName(String name) {
        _name = name;
    }

    String getName() {
        return _name;
    }

}//end class
