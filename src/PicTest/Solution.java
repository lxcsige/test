package PicTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by lxcfour on 2017/3/28.
 */
public class Solution {
    public static void main(String[] args) {
        File file = new File("/data/appdatas/download_temp/temp375.jpg");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
