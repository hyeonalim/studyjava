import file.Book;
import file.Member;

public class FileIO {

    Book book = new Book();
    Member member = new Member();

    protected void run() throws Exception{

        String bookFileName = "src/file/book.txt";
        String memberFileName = "src/file/member.txt";

        while(true){

            System.out.println("1. 읽기 2. 찾기 3. 쓰기");
            int menu = Check.menuCheck();

            if(menu == 1){

                //1. 책, 사람 읽기
                System.out.println("읽기 방식을 선택하셨습니다.");
                System.out.println("1. 책 2. 회원");

                int sideMenuCheck = Check.sideMenuCheck();

                if(sideMenuCheck == 1){
                    
                    book.read(bookFileName);

                }else{

                    member.read(memberFileName);

                }

            }else if(menu == 2){
            
                //2. 책, 사람 찾기
                System.out.println("찾기 방식을 선택하셨습니다.");
                System.out.println("1. 책 2. 회원");

                int sideMenuCheck = Check.sideMenuCheck();

                if(sideMenuCheck == 1){
                    
                    book.find(bookFileName);

                }else{

                    member.find(memberFileName);
                    
                }

            }else if(menu == 3){

                //3. 책, 사람 쓰기
                System.out.println("쓰기 방식을 선택하셨습니다.");
                System.out.println("1. 책 2. 회원");

                int sideMenuCheck = Check.sideMenuCheck();

                if(sideMenuCheck == 1){
                    
                    book.write(bookFileName);

                }else{

                    member.write(memberFileName);
                    
                }
                
            }
        }
    }

}