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

        int bookMenuInput = BookUI.printMenuAndReturnNumOfMenu();
        int bookMenu = Check.getNumInRangeUntilValid(bookMenuInput);

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

        BookUI.printAddingProcess();

        //책아이디, 책이름, 재고, 삭제여부
        System.out.println("책이름: ");
        String name = Input.inputString();
            
        int id = getID(fileName, name, 1, 3);

        if(id >= 0){
                
            System.out.println("이미 책이 존재합니다.");

        }else{

            int totalStock = 1;
            int isNotDeleted = 1;

            int nextID = getNextID(fileName);
                
            if(nextID >= 0){

                StringBuilder item = new StringBuilder();
                item.append(nextID + ", " + name + ", " + totalStock + ", " + isNotDeleted);
                
                add(fileName, item.toString());

            }
        }
    }

    private void delete(String fileName){
        
        BookUI.printDeleteingProcess();
        String findItem = Input.inputString();
        
        String checkOutListFileName = "/tmp/checkOutList.csv";
        boolean isListInBook = find(checkOutListFileName, findItem, 2, 3); //대출 리스트에 해당 회원 네임이 있는지 확인

        if(isListInBook == true){

            System.out.println("대출 중인 책이 있어 삭제 불가합니다.");

        }else{
         
            boolean isDelete = delete(fileName, findItem, 1, 3);
        
            if(isDelete == true){

                System.out.println(findItem + "을 삭제하였습니다.");

            }else{

                System.out.println("삭제하지 못하였습니다.");

            }
        }
    }

    private void find(String fileName){

        BookUI.printSearchingProcess();
        String bookName = Input.inputString();
        boolean isExist = find(fileName, bookName, 1, 3); //DB 순서: 책아이디, 책이름, 재고, 삭제여부

        if(isExist == true){

            System.out.println("찾았습니다.");

        }else{

            System.out.println("찾지 못했습니다.");

        }
    }

}