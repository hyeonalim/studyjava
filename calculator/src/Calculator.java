import java.util.Scanner;

public class Calculator {

    /**
     * 계산식 받기
     */
    public void run() {

        System.out.println("계산식을 입력하세요.");

        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();

        if (line.equals("")) {

            System.out.println("계산식이 없습니다.");

        } else {

            // 연산식 나누기 (첫번째 숫자, 연산자, 두번째 숫자)
            Parsing parsing = new Parsing();

            String operator = parsing.getOperator(line);
            Object firstLine = parsing.firstLineParsing(line);
            Object secondLine = parsing.secondLineParsing(line);

            // 계산기 세팅
            Object result = new Calculations().setCalculate(firstLine, operator, secondLine);

            System.out.println("' " + firstLine + " " + operator + " " + secondLine + " ' = " + result);

        }

    }

}