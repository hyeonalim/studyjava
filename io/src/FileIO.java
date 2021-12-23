import file.Input;
import file.Output;
import file.Scn;

public class FileIO {

    Input input = new Input();
    Output output = new Output();

    protected void run() throws Exception{

        String bookFileName = "src/file/book.txt";
        String memberFileName = "src/file/member.txt";

        while(true){

            System.out.println("1. 읽기 2. 찾기 3. 쓰기");
            int no = noCheck();

            if(no == 1){

                //1. 책, 사람 읽기
                System.out.println("읽기 방식을 선택하셨습니다.");
                input.reader(bookFileName, memberFileName);

            }else if(no == 2){
            
                //2. 책, 사람 찾기
                System.out.println("찾기 방식을 선택하셨습니다.");
                System.out.println("1. 책 2. 회원");

                input.finder(bookFileName, memberFileName);

            }else if(no == 3){

                //3. 책, 사람 쓰기
                System.out.println("쓰기 방식을 선택하셨습니다.");

                output.writer(bookFileName, memberFileName);
                
            }
        }
    }

    //숫자 잘못 입력한 경우
    private int noCheck(){

        Scn scn = new Scn();

        System.out.println("1 또는 3 를 입력해주세요.");

        int check = scn.scnInt();

        while(check < 1 || check > 3){

            System.out.println("1 또는 3 을 입력해주세요.");

            check = scn.scnInt();

        }

        return check;
    }

}