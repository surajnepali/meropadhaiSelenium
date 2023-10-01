import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamDemo {
    public static void namesUsingFor(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Mishan");
        names.add("Kiran");
        names.add("Aashbin");
        names.add("Anuvab");
        names.add("Bishal");
        names.add("Suraj");
        names.add("Adarsha");
        names.add("Bishal Backend");
        names.add("Saugat");
        
        int count = 0;
        for(String name: names){
            if(name.startsWith("A")){
                count++;
            }
        }
        System.out.println("Count using For loop: " + count);
    }

    public static void namesUsingStream(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Mishan");
        names.add("Kiran");
        names.add("Aashbin");
        names.add("Anuvab");
        names.add("Bishal");
        names.add("Suraj");
        names.add("Adarsha");
        names.add("Bishal Backend");
        names.add("Saugat");

        // Java Streams
        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println("Count using stream: " + c);

        names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));

        long d = Stream.of("Mishan", "Kiran", "Aashbin", "Anuvab", "Bishal", "Suraj", "Adarsha", "Bishal Backend", "Saugat").filter(s->{
            s.startsWith("S");
            return true; // terminal operation will execute only if inter op (filter) returns true
        }).count();

        System.out.println(d);
    }

    public static void streamMap(){

        // A arrayList is filtered if it ends with n -> Uppercasing it and printing the result
        Stream.of("Mishan", "Kiran", "Aashbin", "Anuvab", "Bishal", "Suraj", "Adarsha", "Bishal Backend", "Saugat").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
        System.out.println("---------***************----------");
        Stream.of("Aashish", "Khom", "Amit", "Pabita", "Prabina", "Bikal", "Rabin", "Sushil", "Karun").filter(s->s.startsWith("B")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
        System.out.println("---------***************----------");

        // Merging two streams
        List<String> names1 = Arrays.asList("Aashish", "Khom", "Amit", "Pabita", "Prabina", "Bikal", "Rabin", "Sushil", "Karun");
        List<String> names2 = Arrays.asList("Mishan", "Kiran", "Aashbin", "Anuvab", "Bishal", "Suraj", "Adarsha", "Bishal Backend", "Saugat");

        // Adding two streams to make a big stream
        Stream<String> concatinatedStream = Stream.concat(names1.stream(), names2.stream());
        // concanitatedStream.sorted().forEach(s->System.out.println(s)); // It prints each string available in new stram 'concatinatedStream'

        // Check whether the name lies in the list and return true
        boolean flag = concatinatedStream.anyMatch(s->s.equalsIgnoreCase("Suraj"));
        System.out.println(flag);
        
        // assertTrue() means it checks whether the boolean is true. It is true if the boolean is true only
        Assert.assertTrue(flag);

    }

    public static void streamCollect(){
        // Basically, the collect() method collects the manipulated data and helps to add the data to another list
        List<String> names1 = Arrays.asList("Amit", "Khom", "Aashish", "Pabita", "Prabina", "Bikal", "Rabin", "Sushil", "Karun");
        List<String> lists = names1.stream().filter(s->s.startsWith("A")).sorted().collect(Collectors.toList());
        lists.stream().forEach(s->System.out.println(s));

        List<Integer> numList = Arrays.asList(4,8,2,3,6,7,3,7,3,3,1,9,0,5);
        numList.stream().distinct().sorted().forEach(s->System.out.println(s));
    }

    public static void main(String[] args) {
        namesUsingFor();
        namesUsingStream();
        streamMap();
        streamCollect();
    }
}