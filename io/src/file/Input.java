package file;
import java.util.Scanner;

public class Input {
    
    static Scanner scn = new Scanner(System.in);

    public static int inputInt(){
        int n = scn.nextInt();
        scn.nextLine();

        return n;
    }

    public static String inputString(){
        String name = scn.nextLine();

        return name;
    }

}
