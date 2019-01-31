package com.zhuhaoman.lambdajava.lambda.process;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author zhuhaoman
 * @description:
 * @date 2019-01-28 23:02
 **/
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
