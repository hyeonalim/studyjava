/*

기능: 회원 관련 관리

1.회원등록
- id, 전화번호가 존재하는 경우 => 가입거절,
2. 회원삭제
3. 회원검색

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
import service.ui.UserUI;

public class UserManagement extends CommonManagement {

    String fileName = "/tmp/user.csv";
    CommonManagement commonManagement = new CommonManagement();

    //전체 프로세스
    public void proccess(){

        int userMenuInput = UserUI.menuPrint();
        int userMenu = Check.numCheck(userMenuInput);

        if(userMenu == 1){

            //회원등록
            add(fileName);

        }else if(userMenu == 2){

            //회원 삭제
            delete(fileName);

        }else{

            //회원 검색
            find(fileName);

        }

    }

    private void add(String fileName){

        UserUI.addUser();

        try{

            //파일 작성
            BufferedWriter fioWriter = new BufferedWriter(new FileWriter(fileName, true));

            System.out.println("회원 아이디: ");
            String id = Input.inputString();
            
            boolean isXxexist = commonManagement.find(fileName, id, 0);

            if(isXxexist == true){
                
                System.out.println("이미 아이디가 존재합니다.");

            }else{

                System.out.println("회원 이름: ");
                String name = Input.inputString();

                System.out.println("전화번호: ");
                String phone = Input.inputString();

                isXxexist = commonManagement.find(fileName, phone, 0);

                if(isXxexist == true){

                    System.out.println("이미 전화번호가 존재합니다.");

                }else{

                    int isX = 0;

                    fioWriter.write(id + ", " + name + ", " + phone + ", " + isX);
                    fioWriter.newLine();
    
                    fioWriter.close();
    
                }
            }
        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
        }
    }

    //이유를 알 수 없는 에러
    public void delete(String fileName){

        UserUI.removeUser();
        commonManagement.delete(fileName);
    }

    private void find(String fileName){

        UserUI.searchUser();
        commonManagement.find(fileName, 1); //DB 순서: 아이디, 이름, 전화번호, 삭제여부

    }

}
