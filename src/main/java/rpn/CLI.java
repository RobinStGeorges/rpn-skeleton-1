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
        System.out.println("lenght : " + lenght);
        if(lenght == 1) {
            return Long.parseLong(exploded[0]);
        }
        else if (lenght > 1){

            for(int i = lenght ; i > 2 ; i--){
                System.out.println("value array : " + exploded[i-1]);
                if(exploded[i-1].equals("+")){
                    if(lenght-j == 1){
                        System.out.println("legnth - j = 1");
                        resultat = resultat + Long.parseLong(exploded[j]);
                        System.out.println("resultat  = "+resultat);
                    }
                    else{
                        resultat = resultat + Long.parseLong(exploded[j]) + Long.parseLong(exploded[j+1]);
                    }

                }
                j++ ;
                j++;

            }
            return resultat;
        }

        return 0;
    }
}
