package rpn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = evaluate(expression);
        System.out.println("> " + result);
    }

    static long evaluate(String expression) {
        String[] exploded =  expression.split(" ");
        int lenght = exploded.length;
        int j = 0;
        Long resultat = 0L;
        if(lenght == 1) {
            return Long.parseLong(exploded[0]);
        }
        else if (lenght > 1){
            System.out.println("lenght : " + lenght);
            for(int i = lenght ; i > 3 ; i--){
                System.out.println("value array : " + exploded[i-1]);
                if(exploded[i-1].equals("+")){
                    resultat = resultat + Long.parseLong(exploded[j]) + Long.parseLong(exploded[j+1]);
                }
                j++ ;

            }
            return resultat;
        }

        return 0;
    }
}
