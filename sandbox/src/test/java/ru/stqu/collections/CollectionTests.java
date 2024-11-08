package ru.stqu.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionTests {

    @Test
    void arrayTests() {
        var array = new String[] {"a", "b", "c"}; //создан массив
        // var array = new String[3]; - пустой массив с 3 элементами (все элементы = 0)
        Assertions.assertEquals("a", array[0]); //проверка, что первый (0) элемент массива =  "а"

        array [0] = "n"; //первый элемент массива изменен на "b"
        Assertions.assertEquals("n", array[0]);
        Assertions.assertEquals(3, array.length); //проверка на величину массива = 3
    }

    @Test
    void listTest() {
        var list = new ArrayList<>(List.of("a", "b", "c")); //Создан список с эелементами

        // list.add("m"); //добавление строки в список

        Assertions.assertEquals(3, list.size()); //проверка на длину списка = 3

        Assertions.assertEquals("a", list.get(0)); //проверка, что первый элемент списка = "а"

        list.set(0, "n"); //первый элемент списка изменен на значение "n"
    }

    @Test
    void setTests(){
        var set = new HashSet<>(List.of("a", "b", "c", "a"));
        Assertions.assertEquals(3, set.size());
        var element = set.stream().findAny().get();
        set.add("a");
    }

    @Test
    void testMap(){
        var digits = new HashMap<Character, String>();
        digits.put('1', "one");
        digits.put('2', "two");
        digits.put('3', "three");
    }
}
