package com.nowcoder.util;

import java.io.File;
import java.util.UUID;

public class FileUtil {
    public static boolean isImg(String fileName){
        String[] imgsSubstring={"jpg","jpeg","png"};
        String substring = getFileSuffix(fileName);
        if(substring!=null){
            for (String str:imgsSubstring){
                if(str.equals(substring.toLowerCase())){
                    return true;
                }
            }
        }
        return false;
    }
    public static String fileName(){
        String s = UUID.randomUUID().toString();
        String str = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        return str;
    }
    public static String getFileSuffix(String fileName){
        int indexOf = fileName.lastIndexOf(".");
        String substring = fileName.substring(indexOf+1);
        return substring;
    }

    public static void creatDir(String path){
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
    }

}
