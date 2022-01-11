public class Calculations {

    public Object setCalculate(Object firstObject, String operator, Object secondObject) {

        String firstDataType = firstObject.getClass().getSimpleName();
        String secondDataType = secondObject.getClass().getSimpleName();

        Object result = null;

        if (firstDataType.equals(secondDataType)) {

            if (firstDataType.equals("Integer")) {

                int firstInt = (int) firstObject;
                int secondInt = (int) secondObject;

                result = calculate(firstInt, operator, secondInt);

            } else if (firstDataType.equals("Float")) {

                float firstFloat = (float) firstObject;
                float secondFloat = (float) secondObject;

                result = calculate(firstFloat, operator, secondFloat);

            } else if (firstDataType.equals("String")) {

                String firstString = (String) firstObject;
                String secondString = (String) secondObject;

                result = calculate(firstString, operator, secondString);

            }
        } else if (firstDataType.equals("Integer") && secondDataType.equals("Float")) {

            int firstInt = (int) firstObject;
            float secondFloat = (float) secondObject;

            result = calculate(firstInt, operator, secondFloat, 0);

        } else if (firstDataType.equals("Float") && secondDataType.equals("Integer")) {

            float firstFloat = (float) firstObject;
            int secondInt = (int) secondObject;

            result = calculate(secondInt, operator, firstFloat, 1);

        } else if (firstDataType.equals("String") && secondDataType.equals("Integer")) {

            String firstString = (String) firstObject;
            int secondInt = (int) secondObject;

            result = calculate(firstString, operator, secondInt, 0);

        } else if (firstDataType.equals("String") && secondDataType.equals("Float")) {

            String firstString = (String) firstObject;
            float secondFloat = (float) secondObject;

            result = calculate(firstString, operator, secondFloat, 0);

        } else if (firstDataType.equals("Integer") && secondDataType.equals("String")) {

            int firstInt = (int) firstObject;
            String secondString = (String) secondObject;

            result = calculate(secondString, operator, firstInt, 1);

        } else if (firstDataType.equals("Float") && secondDataType.equals("String")) {

            float firstFloat = (float) firstObject;
            String secondString = (String) secondObject;

            result = calculate(secondString, operator, firstFloat, 1);

        }

        return result;
    }

    /**
     * int 계산기
     * 
     * @param first    첫 문구
     * @param operator 연산자
     * @param second   두번째 문구
     * @return 계산 결과 return
     */
    public int calculate(int first, String operator, int second) {

        int result = 0;

        if (operator.equals("+")) {

            result = first + second;

        } else if (operator.equals("-")) {

            result = first - second;

        } else if (operator.equals("*")) {

            result = first * second;

        } else if (operator.equals("/")) {

            result = first / second;

        } else if (operator.equals("%")) {

            result = first % second;

        }

        return result;

    }

    /**
     * float 계산기
     * 
     * @param first    첫 문구
     * @param operator 연산자
     * @param second   두번째 문구
     * @return 계산 결과 return
     */
    public float calculate(float first, String operator, float second) {

        float result = 0;

        if (operator.equals("+")) {

            result = first + second;

        } else if (operator.equals("-")) {

            result = first - second;

        } else if (operator.equals("*")) {

            result = first * second;

        } else if (operator.equals("/")) {

            result = first / second;

        } else if (operator.equals("%")) {

            result = first % second;

        }

        return result;

    }

    /**
     * String 계산기
     * 
     * @param first    첫 문구
     * @param operator 연산자
     * @param second   두번째 문구
     * @return 계산 결과 return
     */
    public String calculate(String first, String operator, String second) {

        String result = null;

        result = first + operator + second;

        return result;

    }

    /**
     * float 계산기 (int, float 혼합)
     * 
     * @param first      첫 문구
     * @param operator   연산자
     * @param second     두번째 문구
     * @param typeChange
     * @return 계산결과
     */
    public float calculate(int first, String operator, float second, int typeChange) {

        float result = 0;

        if (typeChange == 0) {

            if (operator.equals("+")) {

                result = first + second;

            } else if (operator.equals("-")) {

                result = first - second;

            } else if (operator.equals("*")) {

                result = first * second;

            } else if (operator.equals("/")) {

                result = first / second;

            } else if (operator.equals("%")) {

                result = first % second;

            }

        } else {

            if (operator.equals("+")) {

                result = second + first;

            } else if (operator.equals("-")) {

                result = second - first;

            } else if (operator.equals("*")) {

                result = second * first;

            } else if (operator.equals("/")) {

                result = second / first;

            } else if (operator.equals("%")) {

                result = second % first;

            }

        }
        return result;

    }

    /**
     * String 계산기(int, String 혼합)
     * 
     * @param first      첫 문구
     * @param operator   연산자
     * @param second     두번째 문구
     * @param typeChange
     * @return 계산 결과 return
     */
    public String calculate(String first, String operator, int second, int typeChange) {

        String result = null;

        if (typeChange == 0) {

            result = first + operator + second;

        } else {

            result = second + operator + first;

        }

        return result;

    }

    /**
     * String 계산기 (float, String 혼합)
     * 
     * @param first
     * @param operator
     * @param second
     */
    public String calculate(String first, String operator, float second, int typeChange) {

        String result = null;

        if (typeChange == 0) {

            result = first + operator + second;

        } else {

            result = second + operator + first;

        }

        return result;

    }

}