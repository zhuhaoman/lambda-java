package com.zhuhaoman.lambdajava.lambda;

/**
 * @author zhuhaoman
 * @description:
 * @date 2019-01-28 21:12
 **/
public class RunnableMain {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("hello world 1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world 2");
            }
        };


    }
}
