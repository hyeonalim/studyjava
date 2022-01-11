package service.ui;

public class BorrowingUI {
    private BorrowingUI() {
    }

    public static int printMenuAndReturnNumOfMenu() {

        System.out.println("1. 대출자로 검색");
        System.out.println("2. 책으로 검색");
        System.out.println("3. 대출처리");
        System.out.println("4. 반납처리");

        return 4; // 선택지 수 리턴

    }

    public static void printSearchingUserProcess() {

        System.out.println("대출자로 검색을 진행합니다.");
        System.out.println("검색어를 입력해주세요.");

    }

    public static void printSearchingBookProcess() {

        System.out.println("책으로 검색을 진행합니다.");
        System.out.println("검색어를 입력해주세요.");

    }

    public static void printCheckOutProcess() {

        System.out.println("대출 처리를 진행합니다.");

    }

    public static void printCheckProcess() {

        System.out.println("반납을 진행합니다.");

    }

}