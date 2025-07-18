package com.memo;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class 람다테스트 {
    @Test
    void 람다테스트1() {
        List<String> list = List.of("apple", "banana", "cherry");
        list.stream()
                .filter(f -> f.startsWith("b"))
                .forEach(f -> log.info("#### {}", f));
    }

    @Test
    void 람다테스트2() {
        List<String> list = List.of("apple", "banana", "cherry");
        list = list.stream()
                .map(f -> f.toUpperCase())
                .collect(Collectors.toList()); // stream to list
        log.info(list.toString());

        // 메소드 레퍼런스
        list = List.of("apple", "banana", "cherry");
        list = list.stream()
                .map(String::toUpperCase)  // f -> f.toUpperCase()
                .collect(Collectors.toList());
        log.info("#### {}", list);
    }

    @ToString
    @AllArgsConstructor
    class Person {
        private String name;
        private int age;

        void printInfo() {
            log.info("### info: {}", this);
        }
    }

    @Test
    void 테스트() {
        List<Person> people = new ArrayList<>(
                List.of(new Person("신보람", 30),
                        new Person("김바다", 6)));

        people.forEach(p -> p.printInfo());  // lambda
        people.forEach(Person::printInfo); // method reference

        // 객체를 println으로 출력
        people.forEach(p -> System.out.println(p));
        people.forEach(System.out::println);
    }

}






