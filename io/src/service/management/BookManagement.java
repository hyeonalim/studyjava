/*

1. 책입고 (완)
2. 책삭제
3. 책검색 (완)

*/
package service.management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import input.Check;
import input.Input;
import service.ui.BookUI;

public class BookManagement {

    String fileName = "/tmp/book.csv";
    CommonManagement commonManagement = new CommonManagement();

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

        try{

            //파일 작성
            BufferedWriter fioWriter = new BufferedWriter(new FileWriter(fileName, true));
            BufferedReader fioReader = new BufferedReader(new FileReader(fileName));

            //책아이디, 책이름, 재고, 삭제여부
            System.out.println("책이름: ");
            String name = Input.inputString();
            
            boolean isXxexist = commonManagement.find(fileName, name, 0);

            if(isXxexist == true){
                
                System.out.println("이미 책이 존재합니다.");

            }else{

                int totalStock = 1;
                int isX = 0;

                String line = null;
                int id = 0;

                while((line = fioReader.readLine()) != null) {
        
                    id++;

                }
                
                fioWriter.write(id + ", " + name + ", " + totalStock + ", " + isX);
                fioWriter.newLine();
    
                fioWriter.close();
                fioReader.close();
                
            }
        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
        }

    }

    private void delete(String fileName){

        BookUI.removeBook();
        commonManagement.delete(fileName);

    }

    private void find(String fileName){

        BookUI.searchBook();
        commonManagement.find(fileName, 1); //DB 순서: 책아이디, 책이름, 재고, 삭제여부

    }

}