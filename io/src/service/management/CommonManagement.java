package service.management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import input.Input;

public abstract class CommonManagement {
    
    /**
     * 파일을 읽어와서 그 파일 안에 내용을 더하는 메소드입니다.
     * 
     * @param fileName : 읽어올 파일
     * @param item : 파일에 더할 내용
     */
    public void add(String fileName, String item){

        try(BufferedWriter fioWriter = new BufferedWriter(new FileWriter(fileName, true))){
            //파일 작성
            fioWriter.write(item);
            fioWriter.newLine();

        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
        }

    }

    /**
     * 
     * 파일을 더할 때 그 다음으로 올 id 값을 구하기 위한 메소드입니다.
     * @param fileName : 읽어올 파일
     * @return : id 값으로, -1 이면 에러, 0 이상으로는 다음의 id 값
     */
    public int getNextID(String fileName){

        try(BufferedReader fioReader = new BufferedReader(new FileReader(fileName))){

            //id 생성하기
            int id = 0;

            while(fioReader.readLine() != null) {
            
                id++;

            }

            return id;

        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                            
                System.out.println("파일이 없습니다.");
            
             }else{
            
            System.out.println("다시 확인해주세요.");
            
            }

            return -1;
        }
    }

    /**
     * 파일을 읽어와서 내용의 일부를 삭제하는 메소드
     * @param fileName : 읽어올 파일
     * @param findItem : 찾아서 삭제할 내용
     * @param arrayNum : 내용의 위치
     * @return : true 면 정상 삭제, false 면 에러, 삭제되지 않았을 때
     */
    public boolean delete(String fileName, String findItem, int arrayNum){

        try(BufferedReader fioReader = new BufferedReader(new FileReader(fileName))){
            
            //파일 작성
            //1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
            int id = find(fileName, findItem, arrayNum);

            String item = "";

            if(id > 0){

                String line = null;

                for(int i=0; i<id; i++) {

                    line = fioReader.readLine(); //읽으며 이동
    
                    item += (line + "\r\n");
    
                }

                //2. 변경되는 데이터 저장
                while((line = fioReader.readLine()) != null) {
            
                    String[] lineArray = line.split(", ");
    
                    while(findItem.equals(lineArray[arrayNum])){
    
                        for(int i=0; i<lineArray.length - 1; i++) {

                            item += lineArray[i];
            
                        }

                        item += (", 1" + "\r\n");
                        
                        break;

                    }
                }

    			//3. 삭제하고자 하는 position 이후부터 dummy에 저장
	    		while((line = fioReader.readLine())!=null) {

		    		item += (line + "\r\n" ); 

			    }

                if(new File(fileName).exists()){   //파일이 존재하면 파일 삭제

                    new File(fileName).delete();

                }

    			//4. FileWriter를 이용해서 덮어쓰기
                add(fileName, item);

                return true;

            }

            return false;

        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
            
            return true;

        }
    }

    /**
     * 파일 내에 찾는 내용이 있는지 확인하는 메소드
     * @param fileName : 읽어올 파일
     * @param arrayNum : 찾을 내용의 위치
     * @param isExit : 삭제 여부
     */
    public void find(String fileName, int arrayNum, int isExit){

        try(BufferedReader fio = new BufferedReader(new FileReader(fileName))){
    
            String findItem = Input.inputString();
            boolean isXxexist = false; //유무 판단

            //BufferedReader 사용
            String line = null;

            while((line = fio.readLine()) != null) {
            
                String[] lineArray = line.split(", ");

                while(findItem.equals(lineArray[arrayNum])){

                    if(lineArray[isExit].equals("0")){

                        System.out.print(lineArray[arrayNum] + "을 찾았습니다.");
                        isXxexist = true;
    
                    }

                    break;
                }
            }

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

    /**
     * 파일 안 데이터를 등록 / 삭제할 때 사용, 파일 안에 찾는 내용이 있는지 확인하는 메소드
     * @param fileName : 읽어올 파일
     * @param findItem : 찾는 내용
     * @param arrayNum : 찾는 내용의 위치
     * @return -1 이면 에러, 0 이상이면 id 값
     */
    public int find(String fileName, String findItem, int arrayNum){

        try(BufferedReader fio = new BufferedReader(new FileReader(fileName))){
    
            //BufferedReader 사용
            String line = null;
            int id = 0;

            while((line = fio.readLine()) != null) {
            
                String[] lineArray = line.split(", ");

                while(findItem.equals(lineArray[arrayNum])){

                    id++;

                    break;
                }
            }

            System.out.println();

            return id;

        }catch(IOException e){
    
            if(e instanceof FileNotFoundException){
                    
                System.out.println("파일이 없습니다.");
    
            }else{
    
                System.out.println("다시 확인해주세요.");
    
            }

            return -1;
            
        }
        
    }

}
