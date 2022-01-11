public class Parsing {

    /**
     * 연산자의 좌측 문자 파싱
     * 
     * @param line 계산식
     */
    public Object firstLineParsing(String line) {

        // 계산식 나누기 (첫번째 숫자, 연산자, 두번째 숫자)
        String operator = getOperator(line); // 연산자 가져오기
        int operatorNum = line.indexOf(operator);

        Object firstLine = getDataType(line.substring(0, operatorNum));

        return firstLine;
    }

    /**
     * 연산자 우측의 문구 파싱
     * 
     * @param line 계산식
     */
    public Object secondLineParsing(String line) {

        // 계산식 나누기 (첫번째 숫자, 연산자, 두번째 숫자)
        String operator = getOperator(line); // 연산자 가져오기
        int operatorNum = line.indexOf(operator);

        Object secondLine = getDataType(line.substring(operatorNum + 1, line.length()));

        return secondLine;

    }

    /**
     * 계산식 내에 연산자 가져오기
     * 
     * @param line 계산식
     * @return 연산자가 있으면 연산자 가져오기, 없으면 null 값
     */
    public String getOperator(String line) {

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

    /**
     * 문자의 데이터 타입으로 바꿔주기
     * 
     * @param data 계산식 중 연산자를 제외한 문자 하나
     * @return 문자의 데이터 타입으로 바꿔 보내준다.
     */
    private Object getDataType(String data) {

        int findDotNum = getDotNum(data); // line에 dot 갯수

        // dot 갯수가 몇개인지 구분하기
        if (findDotNum == 0) {

            if (data.equals("")) {

                return data; // 빈 문자열은 String 값으로 사용

            }
            // line이 숫자인지 판별
            // true, 숫자 false, 숫자가 아닌 문자
            boolean isNumeric = data.matches("[+-]?\\d*(\\.\\d+)?");

            if (isNumeric == true) {

                return Integer.parseInt(data);

            } else {

                return data;

            }

        } else if (findDotNum == 1) {

            return Float.parseFloat(data);

        } else {

            return data; // 점이 2개 이상으로 String 값

        }
    }

    /**
     * 문자에 있는 점 갯수를 찾는 메소드
     * 
     * @param data 계산식 중 연산자를 제외한 문자 하나
     * @return 점 갯수를 return, -1이면 점이 맨 처음이거나 맨 마지막인 경우
     */
    private int getDotNum(String data) {

        int findDotNum = 0;

        // 연산자가 있는 곳이 어딘지 값 가져오기
        for (int i = 0; i < data.length(); i++) {

            if (data.charAt(i) == '.') {

                // 만약 점 위치가 처음이거나 마지막이면 String으로 구분
                if (i == 0 || i == data.length() - 1) {

                    return -1; // -1로 리턴해준다.

                } else {

                    findDotNum += 1;

                }
            }
        }

        return findDotNum;

    }

}