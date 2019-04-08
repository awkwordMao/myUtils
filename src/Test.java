
import utils.CountDown;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String args[]){
//        runable();
//        list();
//        map();
        /*List<String> list = Arrays.asList("qwq", "ere44", "dfd4");
        //map：将list中的String对象，换成了String对象的长度对象
        list.stream().map(String::length).collect(Collectors.toList()).forEach(System.out::println);
        //filter：过滤list中长度大于4的元素
        list.stream().filter(s -> s.length() > 4).collect(Collectors.toList()).forEach(System.out::println);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.toString());
        CountDown.timer();
*/
        System.out.println(8 & 8);
    }



    public static void runable(){
        new Thread(() -> System.out.println("it`s a lambda function")).start();
    }

    public static void list(){
        List<String> list = Arrays.asList("mai", "mimi", "gege");
        //before java8
        for (String string :
                list) {
            System.out.println(string);
        }
        //after java8
        list.forEach(System.out::println);
    }

    public static void map(){
        List<Integer> list = Arrays.asList(10, 20, 30);
        list.forEach(s -> {
            int i = 1;
            System.out.println(i + s);
        });
    }

}
