public class DataType {
    
    public void setCalculateNum(String firstLine, String operator, String secondLine){

        String firstDataType = getDataType(firstLine);
        String secondDataType = getDataType(secondLine);

        Calculations calculations = new Calculations();

        if(firstDataType.equals("int") && secondDataType.equals("int")){

            int first = Integer.parseInt(firstLine);
            int second = Integer.parseInt(secondLine);

            calculations.onlyIntCalculate(first, operator, second);

        }else if(firstDataType.equals("float") && secondDataType.equals("float")){

            float first = Float.parseFloat(firstLine);
            float second = Float.parseFloat(secondLine);

            calculations.onlyFloatCalculate(first, operator, second);

        }else if(firstDataType.equals("int") && secondDataType.equals("float")){

            int first = Integer.parseInt(firstLine);
            float second = Float.parseFloat(secondLine);
            
            calculations.mixCalculate(first, operator, second);

        }else if(firstDataType.equals("float") && secondDataType.equals("int")){

            float first = Float.parseFloat(firstLine);
            int second = Integer.parseInt(secondLine);
            
            calculations.mixCalculate(second, operator, first);

        }
    }
    
    private String getDataType(String line){

        //연산자가 있는 곳이 어딘지 값 가져오기
        for(int i = 0; i < line.length(); i++){

            if(line.charAt(i) == '.'){

                return "float";

            }
        }

        return "int";

    }
}
