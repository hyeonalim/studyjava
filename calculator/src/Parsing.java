public class Parsing {

    // 연산식 나누기
    public void numberSentenceParsing(String line) {

        // 계산식 나누기 (첫번째 숫자, 연산자, 두번째 숫자)
        String operator = getOperator(line); // 연산자 가져오기

        int operatorNum = line.indexOf(operator);

        String firstLine = line.substring(0, operatorNum);
        String secondLine = line.substring(operatorNum + 1, line.length());

        new DataType().setCalculateNum(firstLine, operator, secondLine);

    }

    private String getOperator(String line) {

        char operatorNum = 0;
        String operator = null;

        // 연산자가 있는 곳이 어딘지 값 가져오기
        for (int i = 0; i < line.length(); i++) {

            operatorNum = line.charAt(i);

            if (operatorNum == '+' || operatorNum == '-' || operatorNum == '*' || operatorNum == '/'
                    || operatorNum == '%') {

                operator = String.valueOf(operatorNum);

            }
        }

        return operator;

    }

}