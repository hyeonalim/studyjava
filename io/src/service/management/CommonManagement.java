package service.management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import input.Input;

public class CommonManagement {
    
    //삭제
    public void delete(String fileName){
        System.out.println("삭제를 원하는 값을 입력해주세요.");

        /*try{
            
            //파일 작성
            BufferedWriter fioWriter = new BufferedWriter(new FileWriter(fileName, true));

        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
        }*/
    }

    //검색
    public void find(String fileName, int arrayNum){

        try{
    
            String findItem = Input.inputString();
            boolean isXxexist = false; //유무 판단

            //BufferedReader 사용
            BufferedReader fio = new BufferedReader(new FileReader(fileName));
            String line = null;

            while((line = fio.readLine()) != null) {
            
                String[] lineArray = line.split(", ");

                while(findItem.equals(lineArray[arrayNum])){

                    System.out.print(lineArray[arrayNum] + "을 찾았습니다.");
                    isXxexist = true;

                    break;
                }
            }

            fio.close();

            System.out.println();

            if(isXxexist == false){

                System.out.println("찾지 못했습니다.");


            }
    
        }catch(IOException e){
    
            if(e instanceof FileNotFoundException){
                    
                System.out.println("파일이 없습니다.");
    
            }else{
    
                System.out.println("다시 확인해주세요.");
    
            }
        }
        
    }

    //유무 체크 검색
    public boolean find(String fileName, String findName, int arrayNum){

        boolean isXxexist = false; //유무 판단

        try{
    
            //BufferedReader 사용
            BufferedReader fio = new BufferedReader(new FileReader(fileName));
            String line = null;

            while((line = fio.readLine()) != null) {
            
                String[] lineArray = line.split(", ");

                while(findName.equals(lineArray[arrayNum])){

                    isXxexist = true;

                    break;
                }
            }

            fio.close();

            System.out.println();

        }catch(IOException e){
    
            if(e instanceof FileNotFoundException){
                    
                System.out.println("파일이 없습니다.");
    
            }else{
    
                System.out.println("다시 확인해주세요.");
    
            }
        }

        if(isXxexist == true){

            return true;

        }else{

            return false;
            
        }
        
    }

}
