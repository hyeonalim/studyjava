import java.util.Scanner;

public class Calculator {

    public void run() {

        System.out.println("계산식을 입력하세요.");

        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();

        if (line.equals("")) {

            System.out.println("계산식이 없습니다.");

        } else if (isNumberOrOperator(line) == false) {

            System.out.println("숫자가 아닌 값이 들어가 있습니다.");

        } else {

            // 연산식 나누기 (첫번째 숫자, 연산자, 두번째 숫자)
            new Parsing().numberSentenceParsing(line);

        }

    }

    private boolean isNumberOrOperator(String line) {

        char number;
        boolean isNumberOrOperator = false;

        for (int i = 0; i < line.length(); i++) {

            number = line.charAt(i);

            if ('0' <= number && number <= '9' && number == '+' || number == '-' || number == '*' || number == '/'
                    || number == '%') {

                isNumberOrOperator = true;

            } else {

                isNumberOrOperator = false;

            }
        }

        return isNumberOrOperator;

    }

}