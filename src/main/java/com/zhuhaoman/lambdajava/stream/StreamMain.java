package com.zhuhaoman.lambdajava.stream;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhuhaoman
 * @description:
 * @date 2019-01-31 21:50
 **/
public class StreamMain {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 计算i * i
        List<Integer> squares = numbers.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());
        System.out.println(squares.toString());


        //计算 int[i,j]
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        List<int[]> pairs = number1.stream()
                .flatMap(i -> number2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.forEach(e -> System.out.println(Arrays.toString(e)));


        //求和
        int result = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(result);
        int result1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(result1);
        Optional<Integer> result2 = numbers.stream().reduce(Integer::sum);
        System.out.println(result2.get());

        //数数组中元素个数（把每个元素映射成1，然后求和，棒）
        Optional<Integer> sum = numbers.stream().map(d -> 1).reduce(Integer::sum);
        System.out.println(sum.get());
        long sum1 = numbers.stream().count();
        System.out.println(sum1);


        List<Menu> menus = Arrays.asList();

        //取最大值
        OptionalInt max = menus.stream()
                .mapToInt(Menu::getCalories)
                .max();
        int maxC = max.orElse(1);
        System.out.println(maxC);


        IntStream intStream = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0);
        System.out.println(intStream.count());


        //勾股数
        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(b ->
                                                new double[]{a, b, Math.sqrt(a * a + b * b)}
                                        ).filter(t -> t[2] % 1 == 0));


        //you由值创建流
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        //由数组创建流
        int[] arrays = {2, 3, 4, 5, 6, 7, 8, 9};
        int arraySum = Arrays.stream(arrays).sum();
        System.out.println(arraySum);


        //由文件生成流
        //Files.lines得到一个流
        //每个元素都是文件中给定的一行
        long uniqueWords = 0;
        try(Stream<String> lines =
                    Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
                        uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                                .distinct()
                                .count();
        } catch(IOException e){
        }



        //无线流（没有固定大小）

        //斐波那契
        //iterate 迭代
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        //生成
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }
}
