/*
기능: 
1. 전체적인 프로세스
- 책/유저/대출 선택까지만
- 책/유저/대출 클래스 가져오기
*/

package service;

import input.Check;
import service.management.BookManagement;
import service.management.BorrowingManagement;
import service.management.UserManagement;
import service.ui.MainUI;

public class Service {

    UserManagement userManagement = new UserManagement();
    BookManagement bookManagement = new BookManagement();
    BorrowingManagement borrowingManagement = new BorrowingManagement();

    public void run() {

        int mainInput = MainUI.printMenuAndReturnNumOfMenu(); // 메인 UI 노출
        int menu = Check.getNumInRangeUntilValid(mainInput);

        if (menu == 1) {

            userManagement.proccess();

        } else if (menu == 2) {

            bookManagement.proccess();

        } else {

            borrowingManagement.proccess();

        }

    }
}