package service.management;

import input.Check;
import input.Input;
import service.ui.BorrowingUI;

public class BorrowingManagement extends CommonManagement {
    
    String fileName = "/tmp/book.csv";

    //전체 프로세스
    public void proccess(){

        int borrowingMenuInput = BorrowingUI.printMenuAndReturnNumOfMenu();
        int borrowingMenu = Check.getNumInRangeUntilValid(borrowingMenuInput);

        if(borrowingMenu == 1){

            //대출자로 검색
            searchUser();

        }else if(borrowingMenu == 2){

            //책으로 검색
            searchBook();

        }else if(borrowingMenu == 3){

            //대출
            checkOut();

        }else{

            //반납
            check();

        }

    }

    private void searchUser(){

        BorrowingUI.printSearchingUserProcess();
        find(fileName, 1, 3); //DB 순서: 아이디, 유저 아이디, 책 아이디, 대출 유무

    }

    private void searchBook(){

        BorrowingUI.printSearchingBookProcess();
        find(fileName, 2, 3); //DB 순서: 아이디, 유저 아이디, 책 아이디, 대출 유무
        
    }

    private void checkOut(){

        BorrowingUI.printCheckOutProcess();

        System.out.println("회원 이름: ");
        String userId = Input.inputString();
            
        int isExist = find(fileName, userId, 1);

        //회원유무
        if(isExist > 0){

            System.out.println("이미 회원이 있습니다.");

        }else{
                
            System.out.println("책 이름: ");
            String bookName = Input.inputString();

            isExist = find(fileName, bookName, 2);

            //책 유무
            if(isExist > 0){

              System.out.println("이미 책이 있습니다.");

            }else{
                    
                int isReturned = 0;

                int id = getNextID(fileName);

                if(id != -1){
                    //DB 순서: 아이디, 유저 아이디, 책 아이디, 대출 유무
                    //책 아이디 -> 책 이름 (임시)
                    String item = id + ", " + userId + ", " + bookName + ", " + isReturned;

                    add(fileName, item);
                }    
            }
        }

    }

    private void check(){

        BorrowingUI.printCheckProcess();

        System.out.println("회원 이름: ");
        String userId = Input.inputString();
        
        int isExist = find(fileName, userId, 1);

        //회원유무
        if(isExist > 0){

            System.out.println("책 이름: ");
            String bookName = Input.inputString();
            
            boolean isDelete = delete(fileName, bookName, 2);
                
            if(isDelete == true){

                System.out.println( userId + "가 대여한 " + bookName + "을 반납하였습니다");

            }else{

                System.out.println("반납되지 않았습니다.");

            }
        }else{

            System.out.println("회원이 대여한 기록이 없습니다.");

        }
    }
}