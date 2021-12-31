package service.ui;

public class BookUI {
    private BookUI(){}

    public static int menuPrint(){
        
        System.out.println("1. 책입고");
        System.out.println("2. 책삭제");
        System.out.println("3. 책검색");

        return 3; //선택지 수 리턴
        
    }

    public static void addBook(){

        System.out.println("책 입고를 진행합니다.");

    }

    public static void removeBook(){

        System.out.println("책 삭제를 진행합니다.");

    }

    public static void searchBook(){

        System.out.println("책 검색을 진행합니다.");
        System.out.println("검색어를 입력해주세요.");

    }

}
