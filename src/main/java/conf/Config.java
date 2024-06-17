package conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Config {
    public String url;
    public String username1;
    public String username2;
    public String username3;
    public String username4;
    public String username5;
    public String username6;
    public String username7;
    public String username8;
    public String username9;
    public String username10;
    public String username11;
    public String username12;
    public String username13;
    public String username14;
    public String username15;
    public String password;
    public String vercode;
    public String company;
    public ArrayList<String> project1;
    public ArrayList<String> project2;
    public HashMap<String,ArrayList<String>> policyname;
    public HashMap<String,ArrayList<String>> noticename;
    public HashMap<String,ArrayList<String>> policyfilename;
    public ArrayList<String> dictionary;

    public static Config load(String path){
        try{
            ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
            return objectMapper.readValue(Config.class.getResource(path),Config.class);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
