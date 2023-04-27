import java.util.ArrayList;
import java.util.List;

public class Cell {
    List<Token> tokens=new ArrayList<>();
    private int vizited=0;

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void setVizited(int vizited) {
        this.vizited = vizited;
    }

    public Cell() {
        this.vizited=0;
    }

    public int getVizited() {
        return vizited;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "tokens=" + tokens +
                ", vizited=" + vizited +
                '}';
    }
}
