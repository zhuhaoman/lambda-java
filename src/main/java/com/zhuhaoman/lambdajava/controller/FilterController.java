package com.zhuhaoman.lambdajava.controller;

import com.zhuhaoman.lambdajava.domain.Apple;
import com.zhuhaoman.lambdajava.service.Predicate;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuhaoman
 * @description:
 * @date 2018-12-26 23:30
 **/
@RestController
public class FilterController {


    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple:inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


}
