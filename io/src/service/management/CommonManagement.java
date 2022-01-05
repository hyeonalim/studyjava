package service.management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
     * 데이터를 새로 추가할 때 그 다음으로 올 id 값을 구하기 위한 메소드입니다.
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
    public boolean delete(String fileName, String findItem, int arrayNum, int isNotDelete){

        try(BufferedReader fioReader = new BufferedReader(new FileReader(fileName))){
            
            //파일 작성

            //파일 한줄씩 쓰도록 변경(ex. 버저닝 versioning v_1, v_2 형식)
            //1. 한 파일에 내용이 모두 데이터에 저장할 때 걸리는 속도 문제
            //2. 메모리도 제한적이라 모든 데이터를 올리기엔 역부족

            //삭제하고자 하는 id 가져오기
            int id = 0;
            String item = "";
            String line = null; //읽으며 이동
            int loopNum = 0;

            //파일 전체 읽기
            while((line = fioReader.readLine())!=null){

                id = getID(fileName, findItem, arrayNum, isNotDelete);

                if(id >= 0){
                    if(loopNum > 0){

                    item += System.lineSeparator();

                    }

                    if(loopNum == id){

                        //삭제하는 파일 부분 읽어와서 삭제 부분만 수정 ( 0 -> 1)
                        String[] lineArray = line.split(", ");
    
                        if(findItem.equals(lineArray[arrayNum])) {
        
                            for(int i=0; i<lineArray.length - 1; i++) {
    
                                item += lineArray[i] + ", ";

                            }

                            item += "0";

                        }
                    }else{

                        //삭제 부분 제외한 파일 부분 읽어오기
                        item += line;

        		    }

                    loopNum++;

                } 
            }
        
            //파일이 존재하면 파일 삭제
            if(new File(fileName).exists()){

                new File(fileName).delete();

            }

    		//수정할 문구 받아서 파일 재작성
            add(fileName, item);

            return true;

        }catch(IOException e){

            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
            
            return false;

        }
    }

    /**
     * 파일 내에 찾는 내용이 있는지 확인하는 메소드
     * @param fileName : 읽어올 파일
     * @param findItem : 찾을 문구
     * @param arrayNum : 찾을 내용의 위치
     * @param isNotDelete : 삭제 여부
     * @return true 면, 삭제되지 않아서 찾았다는 의미, false면 삭제되어 못 찾았다는 의미
     */
    public boolean find(String fileName, String findItem, int arrayNum, int isNotDelete){

        boolean isExist = false;

        try(BufferedReader fio = new BufferedReader(new FileReader(fileName))){

            //BufferedReader 사용
            String line = null;

            while((line = fio.readLine()) != null) {
            
                String[] lineArray = line.split(", ");

                if(findItem.equals(lineArray[arrayNum])){

                    if(lineArray[isNotDelete].equals("1")){

                        isExist = true;
    
                    }

                }
            }

            return isExist;

        }catch(IOException e){
    
            if(e instanceof FileNotFoundException){
                    
                System.out.println("파일이 없습니다.");
    
            }else{
    
                System.out.println("다시 확인해주세요.");
    
            }

            return false;

        }
        
    }

    /**
     * 파일 안 데이터를 등록 / 삭제할 때 사용, 파일 안에 찾는 내용이 있는지 확인하는 메소드
     * @param fileName : 읽어올 파일
     * @param findItem : 찾는 내용
     * @param arrayNum : 찾는 내용의 위치
     * @return 0 이상이면 id 값, -1 이면 찾을 수 없을 때, -10 이면 파일이 없거나 에러인 상황
     */
    public int getID(String fileName, String findItem, int arrayNum, int isNotDelete){

        try(BufferedReader fio = new BufferedReader(new FileReader(fileName))){
    
            //BufferedReader 사용
            String line = null;

            while((line = fio.readLine()) != null) {
            
                String[] lineArray = line.split(", ");


                if(findItem.equals(lineArray[arrayNum])){

                    if(lineArray[isNotDelete].equals("1")){

                        return Integer.parseInt(lineArray[0]);
    
                    }
                }
             }

            System.out.println();

            return -1; //찾을 수 없을 때

        }catch(IOException e){
    
            if(e instanceof FileNotFoundException){
                    
                System.out.println("파일이 없습니다.");
    
            }else{
    
                System.out.println("다시 확인해주세요.");
    
            }

            return -10; //파일의 에러
            
        }
        
    }

}
