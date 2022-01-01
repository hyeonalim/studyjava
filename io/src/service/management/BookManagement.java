/*

1. 책입고 (완)
2. 책삭제
3. 책검색 (완)

*/
package service.management;

import input.Check;
import input.Input;
import service.ui.BookUI;

public class BookManagement extends CommonManagement {

    String fileName = "/tmp/book.csv";

    //전체 프로세스
    public void proccess(){

        int bookMenuInput = BookUI.menuPrint();
        int bookMenu = Check.numCheck(bookMenuInput);

        if(bookMenu == 1){

            //책등록
            add(fileName);

        }else if(bookMenu == 2){

            //책 삭제
            delete(fileName);

        }else{

            //책 검색
            find(fileName);

        }

    }
    
    private void add(String fileName){

        BookUI.addBook();

        //책아이디, 책이름, 재고, 삭제여부
        System.out.println("책이름: ");
        String name = Input.inputString();
            
        int isExist = find(fileName, name, 1);

        if(isExist > 0){
                
            System.out.println("이미 책이 존재합니다.");

        }else{

            int totalStock = 1;
            int isNotDeleted = 1;

            int id = getNextID(fileName);
                
            if(id != -1){

                String item = id + ", " + name + ", " + totalStock + ", " + isNotDeleted;
                
                add(fileName, item);

            }
        }
    }

    private void delete(String fileName){
        
        //책아이디, 책이름, 재고, 삭제여부
        String findItem = Input.inputString();
        
        boolean isDelete = delete(fileName, findItem, 1);

        if(isDelete == true){

            System.out.println(findItem + "이 삭제되었습니다.");

        }else{

            System.out.println("삭제되지 않았습니다.");

        }
    }

    private void find(String fileName){

        BookUI.searchBook();
        find(fileName, 1, 3); //DB 순서: 책아이디, 책이름, 재고, 삭제여부

    }

}