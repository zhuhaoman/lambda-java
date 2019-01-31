package com.zhuhaoman.lambdajava.lambda.process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhuhaoman
 * @description:
 * @date 2019-01-28 22:54
 **/
public class ProcessMain {

    public static String processFile(BufferedReaderProcessor p) {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String result = processFile((BufferedReader br) -> br.readLine()+br.readLine());

    }


}
