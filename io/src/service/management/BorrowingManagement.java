package service.management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import input.Check;
import input.Input;
import service.ui.BorrowingUI;

public class BorrowingManagement extends CommonManagement {
    
    String fileName = "/tmp/book.csv";
    CommonManagement commonManagement = new CommonManagement();

    //전체 프로세스
    public void proccess(){

        int borrowingMenuInput = BorrowingUI.menuPrint();
        int borrowingMenu = Check.numCheck(borrowingMenuInput);

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

        BorrowingUI.searchUser();
        commonManagement.find(fileName, 1); //DB 순서: 아이디, 유저 아이디, 책 아이디, 대출 유무

    }

    private void searchBook(){

        BorrowingUI.searchBook();
        commonManagement.find(fileName, 2); //DB 순서: 아이디, 유저 아이디, 책 아이디, 대출 유무
        
    }

    private void checkOut(){

        BorrowingUI.checkOut();

        try{

            //파일 작성
            BufferedWriter fioWriter = new BufferedWriter(new FileWriter(fileName, true));

            System.out.println("회원 이름: ");
            String user_id = Input.inputString();
            
            boolean isXxexist = commonManagement.find(fileName, user_id, 1);

            //회원유무
            if(isXxexist == true){

                System.out.println("이미 회원이 있습니다.");

            }else{
                
                System.out.println("책 이름: ");
                String book_name = Input.inputString();

                isXxexist = commonManagement.find(fileName, book_name, 2);

                //책 유무
                if(isXxexist == true){

                    System.out.println("이미 책이 있습니다.");

                }else{
                    
                    String book_id = null;
                    int isReturned = 0;

                    String bookFileName = "/tmp/book.csv";
                    BufferedReader fioReader = new BufferedReader(new FileReader(bookFileName));

                    String line = null;
                    int id = 0;

                    while((line = fioReader.readLine()) != null) {
            
                        String[] lineArray = line.split(", ");
                        id++;

                        while(book_name.equals(lineArray[1])){
        
                            book_id = lineArray[0];                            

                            break;

                        }
                    }

                    fioReader.close();

                    fioWriter.write(id + ", " + user_id + ", " + book_id + ", " + isReturned);
                    fioWriter.newLine();
        
                }
            }

            fioWriter.close();

        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
        }

    }

    private void check(){

        BorrowingUI.check();
        commonManagement.delete(fileName);

    }
    
}