public class CheckData {

    /**
     * 숫자와 연산자가 있는지 확인
     * 
     * @param line 계산식
     * @return 숫자, 연산자가 없으면 false, 있으면 true
     */
    private boolean isNumberOrOperator(String line) {

        char number;

        for (int i = 0; i < line.length(); i++) {

            number = line.charAt(i);

            if (!(('0' <= number && number <= '9')
                    || number == '+' || number == '-' || number == '*' || number == '/' || number == '%')) {

                return false;

            }
        }

        return true;

    }
}
