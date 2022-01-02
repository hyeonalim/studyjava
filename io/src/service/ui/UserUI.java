package service.ui;

public class UserUI {
    private UserUI(){}

    public static int printMenuAndReturnNumOfMenu(){

        System.out.println("1. 회원등록");
        System.out.println("2. 회원삭제");
        System.out.println("3. 회원검색");

        return 3; //선택지 수 리턴
        
    }

    public static void printAddingProcess(){

        System.out.println("회원 등록을 진행합니다.");

    }

    public static void printDeleteingProcess(){

        System.out.println("회원 삭제를 진행합니다.");
        System.out.println("삭제할 회원명을 입력해주세요.");

    }

    public static void printSearchingProcess(){

        System.out.println("회원 검색을 진행합니다.");
        System.out.println("검색어를 입력해주세요.");

    }
    
}
