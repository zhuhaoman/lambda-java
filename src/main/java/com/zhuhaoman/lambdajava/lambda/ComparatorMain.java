package com.zhuhaoman.lambdajava.lambda;

import com.zhuhaoman.lambdajava.domain.Apple;

import java.util.Comparator;

/**
 * @author zhuhaoman
 * @description:
 * @date 2019-01-28 21:05
 **/
public class ComparatorMain {

    public static void main(String[] args) {
        //before
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };

        //after
        Comparator<Apple> byWeight1 = (Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        //and then
        Comparator<Apple> byWeight2 = Comparator.comparing(Apple::getWeight);

    }



}
