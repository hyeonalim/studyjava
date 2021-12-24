import file.Input;

public class Check {

    //숫자 입력받기
    protected static int menuCheck(){

        System.out.println("1 ~ 3 를 입력해주세요.");

        int menu = Input.inputInt();

        while(menu < 1 || menu > 3){

            System.out.println("잘못 입력하셨습니다.");
            System.out.println("1 ~ 3 을 입력해주세요.");

            menu = Input.inputInt();

        }

        return menu;
    }

    protected static int sideMenuCheck(){

        System.out.println("1 ~ 2 를 입력해주세요.");

        int check = Input.inputInt();

        while(check < 1 || check > 2){

            System.out.println("잘못 입력하셨습니다.");
            System.out.println("1 ~ 2 를 입력해주세요.");

            check = Input.inputInt();

        }

        return check;
    }
}
