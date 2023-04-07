import java.util.*;
public class SharedMemory {
    static private List<Token> tokens=new ArrayList<>();
    public SharedMemory(int n) {
        for(int i=1; i<=n*n*n ; i++)
            tokens.add(new Token(i));
            Collections.shuffle(tokens);
            System.out.println(tokens);
    }
    public static synchronized java.util.List<Token> extractTokens(int n) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (tokens.isEmpty()) {
                System.out.println("S-au terminat");
                System.exit(1);
                break;
            }
            extracted.add(tokens.get(0));
            tokens.remove(0);
        }
        return extracted;
    }

}
