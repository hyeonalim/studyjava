package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Book {

    public void read(String book){
        System.out.println("책을 읽습니다.");

        try{

            //BufferedReader 사용
            BufferedReader fio = new BufferedReader(new FileReader(book));
            String line = null;

            while((line = fio.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println();
            fio.close();

        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
        }
    }
    
    public void find(String book){
        
        System.out.println("책을 찾습니다.");

        try{
    
            String fileName = Input.inputString();

            boolean isXxexist = false; //유무 판단

            //BufferedReader 사용
            BufferedReader fio = new BufferedReader(new FileReader(book));
            String line = null;

            while((line = fio.readLine()) != null) {
                if(fileName.equals(line)){

                    System.out.print(line + "을 찾았습니다.");
                    isXxexist = true;

                    break;
                }
            }

            fio.close();

            if(isXxexist == false){

                System.out.println("찾지 못했습니다.");

            }

            System.out.println();
    
        }catch(IOException e){
    
            if(e instanceof FileNotFoundException){
                    
                System.out.println("파일이 없습니다.");
    
            }else{
    
                System.out.println("다시 확인해주세요.");
    
            }
        }
        
    }

    public void write(String book){
        System.out.println("책을 작성합니다.");

        try{

            String fileName = Input.inputString();

            //BufferedWriter 사용
            BufferedWriter fio = new BufferedWriter(new FileWriter(book, true));
            fio.write(fileName);

            fio.newLine();
            fio.close();

        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
        }
    }

}
