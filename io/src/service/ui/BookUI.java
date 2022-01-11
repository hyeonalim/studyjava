package service.ui;

public class BookUI {
    private BookUI() {
    }

    public static int printMenuAndReturnNumOfMenu() {

        System.out.println("1. 책입고");
        System.out.println("2. 책삭제");
        System.out.println("3. 책검색");

        return 3; // 선택지 수 리턴

    }

    public static void printAddingProcess() {

        System.out.println("책 입고를 진행합니다.");

    }

    public static void printDeleteingProcess() {

        System.out.println("책 삭제를 진행합니다.");
        System.out.println("삭제할 책 이름을 입력해주세요.");

    }

    public static void printSearchingProcess() {

        System.out.println("책 검색을 진행합니다.");
        System.out.println("책 이름을 입력해주세요.");

    }

}