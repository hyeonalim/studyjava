package input;

public class Check {

    private Check() {
    }

    // 숫자 입력받기
    public static int getNumInRangeUntilValid(int num) {

        System.out.println("1 ~ " + num + " 를 입력해주세요.");

        int menu = Input.inputInt();

        while (menu < 1 || menu > num) {

            System.out.println("잘못 입력하셨습니다.");
            System.out.println("1 ~ " + num + " 을 입력해주세요.");

            menu = Input.inputInt();

        }

        return menu;

    }

}