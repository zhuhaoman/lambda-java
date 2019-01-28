package com.zhuhaoman.lambdajava.service;

/**
 * @author zhuhaoman
 * @description:
 * @date 2018-12-26 23:43
 **/
public interface Predicate<T> {
    boolean test(T t);
}
