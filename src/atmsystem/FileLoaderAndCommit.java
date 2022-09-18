package atmsystem;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class FileLoaderAndCommit {
    private String fileName;
    public FileLoaderAndCommit(String fileName){
        this.fileName = fileName;
    }
    public HashMap<String, User> loadFile(){
        HashMap<String, User> userBox = new HashMap();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            File file = new File(fileName);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String value = bufferedReader.readLine();
            while(value != null){
                String[] valArr = value.split("-");
                User user = new User(valArr[0], valArr[1], Float.parseFloat(valArr[2]));
                userBox.put(user.getName(),user);
                value = bufferedReader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader != null){
                    fileReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return userBox;
    }
    public void commit(HashMap<String, User> userBox){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try{
            File file = new File(fileName);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Iterator<String> names = userBox.keySet().iterator();
            while(names.hasNext()){
                String name = names.next();
                User user = userBox.get(name);
                StringBuilder builder = new StringBuilder(user.getName());
                builder.append("-");
                builder.append(user.getPassword());
                builder.append("-");
                builder.append(user.getBalance());
                bufferedWriter.write(builder.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(fileWriter != null){
                    fileWriter.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
