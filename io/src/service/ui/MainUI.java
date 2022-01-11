package service.ui;

public class MainUI {

    private MainUI() {
    }

    public static int printMenuAndReturnNumOfMenu() {

        System.out.println("1. 회원메뉴");
        System.out.println("2. 책관리메뉴");
        System.out.println("3. 대출관리메뉴");

        return 3; // 선택지 수 리턴

    }

}