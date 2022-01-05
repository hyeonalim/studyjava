package input;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    
    static Scanner scn = new Scanner(System.in);

    public static int inputInt(){
        
        int n = 0;
        int flag;
        
        do{

            flag = 1;

            try{
                
                n = scn.nextInt();
                scn.nextLine();
                 
            }catch(InputMismatchException e){
            
                flag = 0;
                scn.nextLine();

                System.out.println("숫자만 입력해주세요.");

            }
             
        }while(flag == 0);

        return n;

    }

    public static String inputString(){

        String name = scn.nextLine();

        while(name.equals("")){
            
            System.out.println("문자(한글, 영어 등) 를 입력해주세요.");

            name = scn.nextLine();

        }

        return name;

    }

}
