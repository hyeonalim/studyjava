package service.management;

import input.Check;
import input.Input;
import service.ui.BorrowingUI;

public class BorrowingManagement extends CommonManagement {
    
    String fileName = "/tmp/checkOutList.csv";

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
        String userName = Input.inputString();
        boolean isExist = find(fileName, userName, 1, 3); //DB 순서: 아이디, 유저 아이디, 책 아이디, 대출 유무
        
        if(isExist == true){

            System.out.println("찾았습니다.");

        }else{

            System.out.println("찾지 못했습니다.");

        }

    }

    private void searchBook(){

        BorrowingUI.printSearchingBookProcess();
        String bookName = Input.inputString();
        boolean isExist = find(fileName, bookName, 2, 3); //DB 순서: 아이디, 유저 아이디, 책 아이디, 대출 유무
        
        if(isExist == true){

            System.out.println("찾았습니다.");

        }else{

            System.out.println("찾지 못했습니다.");

        }
    }

    private void checkOut(){

        BorrowingUI.printCheckOutProcess();

        System.out.println("회원 이름: ");
        String userName = Input.inputString();

        boolean isBorrowExist = find(fileName, userName, 1, 3); //대출 리스트에 존재 여부

        //대출 리스트에 회원 네임 여부
        //true: 회원 네임 있는 경우, false: 회원 네임이 없는 경우
        if(isBorrowExist == false){

            String userFileName = "/tmp/user.csv";
            boolean isUserExist = find(userFileName, userName, 2, 4); ///회원 리스트에 존재 여부  

            //회원 리스트에 회원 네임이 있는지 확인
            if(isUserExist == true){

                boolean isListInUser = find(fileName, userName, 1, 3);

                //대출 리스트에 회원 네임 여부 재확인
                if(isListInUser == true){

                    System.out.println("이미 회원이 있습니다.");

                }else{
                
                    System.out.println("책 이름: ");
                    String bookName = Input.inputString();
                
                    String bookFileName = "/tmp/book.csv";
                    boolean isBookExist = find(bookFileName, bookName, 1, 3); //도서 리스트에 존재 여부 

                    //도서 리스트에 도서 네임이 있는지 확인
                    if(isBookExist == true){

                        boolean isListInBook = find(fileName, bookName, 2, 3);

                        //대출 리스트에 도서 여부 확인
                        if(isListInBook == true){

                            System.out.println("이미 책이 있습니다.");

                        }else{
                    
                            int isReturned = 1;
                            int nextID = getNextID(fileName);

                            if(nextID >= 0){
                                //DB 순서: 아이디, 유저 아이디, 책 아이디, 대출 유무
                                //책 아이디 -> 책 이름 (임시)
                                StringBuilder item = new StringBuilder();
                                item.append(nextID + ", " + userName + ", " + bookName + ", " + isReturned);

                                add(fileName, item.toString());
                            }
                        }    
                    }else{

                        System.out.println("도서가 도서관에 없습니다.");

                    }
                }
            }else{

                System.out.println("회원이 등록되어있지 않습니다.");

            }
        }else{
        
            System.out.println("이미 책을 빌리고 있습니다.");

        }

    }

    private void check(){

        BorrowingUI.printCheckProcess();

        System.out.println("회원 이름: ");
        String userId = Input.inputString();
        
        int id = getID(fileName, userId, 1, 3);

        //회원유무
        if(id >= 0){

            System.out.println("책 이름: ");
            String bookName = Input.inputString();
            
            boolean isListInBook = find(fileName, bookName, 2, 3);

            if(isListInBook == true){

                boolean isDelete = delete(fileName, bookName, 2, 3);
                
                if(isDelete == true){

                    System.out.println(userId + "가 대여한 " + bookName + "을 반납하였습니다");

                }else{

                    System.out.println("반납되지 않았습니다.");

                }
            }else{

                System.out.println("도서가 대여된 기록이 없습니다.");

            }
        }else{

            System.out.println("회원이 대여한 기록이 없습니다.");

        }
    }
}