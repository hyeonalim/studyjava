public class Calculations {
    
    public void onlyIntCalculate(int first, String operator, int second){

        int result = 0;

        if(operator.equals("+")){

            result = first + second;
            
        }else if(operator.equals("-")){

            result = first - second;
            
        }else if(operator.equals("*")){

            result = first * second;
            
        }else if(operator.equals("/")){

            result = first / second;
            
        }else if(operator.equals("%")){

            result = first % second;
            
        }

        System.out.println(first + operator + second + " = " + result);
        
    }

    public void onlyFloatCalculate(float first, String operator, float second){

        float result = 0;

        if(operator.equals("+")){

            result = first + second;
            
        }else if(operator.equals("-")){

            result = first - second;
            
        }else if(operator.equals("*")){

            result = first * second;
            
        }else if(operator.equals("/")){

            result = first / second;
            
        }else if(operator.equals("%")){

            result = first % second;
            
        }

        System.out.println(first + operator + second + " = " + result);
        
    }

    public void mixCalculate(int first, String operator, float second){

        float result = 0;

        if(operator.equals("+")){

            result = first + second;
            
        }else if(operator.equals("-")){

            result = first - second;
            
        }else if(operator.equals("*")){

            result = first * second;
            
        }else if(operator.equals("/")){

            result = first / second;
            
        }else if(operator.equals("%")){

            result = first % second;
            
        }

        System.out.println(first + operator + second + " = " + result);
        
    }

}
