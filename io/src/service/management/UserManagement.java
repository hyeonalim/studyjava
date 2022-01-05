/*

기능: 회원 관련 관리

1.회원등록
- id, 전화번호가 존재하는 경우 => 가입거절,
2. 회원삭제
3. 회원검색

*/
package service.management;

import input.Check;
import input.Input;
import service.ui.UserUI;

public class UserManagement extends CommonManagement {

    String fileName = "/tmp/user.csv";

    //전체 프로세스
    public void proccess(){

        int userMenuInput = UserUI.printMenuAndReturnNumOfMenu();
        int userMenu = Check.getNumInRangeUntilValid(userMenuInput);

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

        UserUI.printAddingProcess();

    
        System.out.println("회원 아이디: ");
        String idName = Input.inputString();
        
        int id = getID(fileName, idName, 1, 4);

        if(id >= 0){
                
            System.out.println("이미 아이디가 존재합니다.");

        }else{

            System.out.println("회원 이름: ");
            String name = Input.inputString();

            System.out.println("전화번호: ");
            String phone = Input.inputString();

            id = getID(fileName, phone, 0, 4);

            if(id >= 0){

                System.out.println("이미 전화번호가 존재합니다.");

            }else{

                id = getNextID(fileName);
                int isNotDeleted = 1;

                String item = id + ", " + idName + ", " + name + ", " + phone + ", " + isNotDeleted;

                add(fileName, item);
            }
        }
        
    }

    private void delete(String fileName){

        UserUI.printDeleteingProcess();

        String findItem = Input.inputString();
        
        String checkOutListFileName = "/tmp/checkOutList.csv";
        boolean isListInUser = find(checkOutListFileName, findItem, 1, 3); //대출 리스트에 해당 회원 네임이 있는지 확인

        if(isListInUser == true){

            System.out.println("대출 중인 책이 있어 삭제 불가합니다.");

        }else{
         
            boolean isDelete = delete(fileName, findItem, 2, 4);
        
            if(isDelete == true){

                System.out.println(findItem + "을 삭제하였습니다.");

            }else{

                System.out.println("삭제하지 못하였습니다.");

            }
        }
    }

    private void find(String fileName){

        UserUI.printSearchingProcess();
        String userID = Input.inputString();
        boolean isExist = find(fileName, userID, 2, 4); //DB 순서: 아이디, 아이디 이름, 이름, 전화번호, 삭제여부

        if(isExist == true){

            System.out.println("찾았습니다.");

        }else{

            System.out.println("찾지 못했습니다.");

        }

    }

}
