import com.sun.security.jgss.GSSUtil;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main  {
    public static void main(String[] args) {

//        Person sara = new Person("Sara", 4, "India");
//        Person viktor = new Person("Viktor", 40, "America");
//        Person eva = new Person("Eva", 42, "India");
//        List<Person> collection = Arrays.asList(sara, viktor,eva);

//        collection.stream().
//                forEach(s-> System.out.println(s.getAge()+" "+s.getName()));
//
//        var groupby = collection.stream().collect(Collectors.groupingBy(Person::getNationality));
//        System.out.println(groupby);
//
//        var personAge = collection.stream().collect(Collectors.partitioningBy(person -> person.getAge()>18));
//        System.out.println(personAge);

//        var personName = collection.stream().map(Person::getName).collect(Collectors.joining(",","Names comma seperated ","."));
//        String namesss = personName.stream().joi
//        String namesCommaSeperated = personName.stream().reduce((s, s2) -> s+","+s2).orElse("");
//        System.out.println("names comma seperated "+personName);

//        int[] arr = {1,2,3,4,5,5,6,2,4,5,5,2,5,2,4,5,2,5,2,5,4,2,5,4,2,35};
//        int[] arr = {1,2,3,5,5,5,5};
//        List<Integer> list = Arrays.stream(arr).boxed().collect(toList());

//        System.out.println(list.stream().mapToInt(p->p*p).filter(p-> p>20).average());

//        var ans = Arrays.stream(arr).map(number-> number*number).filter(number-> number>20).average();
//        System.out.println("Square ans =" +ans);

//        var parallelStream = Arrays.stream(arr).parallel().sum();
//        System.out.println(parallelStream);
//                .forEach(s-> System.out.println(String.format("%s , %s", s, Thread.currentThread().getName()) ));

//        Optional<Character> c=getNonRepeatedCharacterOpt("SASAAABS");
//        if (c.isPresent())
//            System.out.println("Non repeated character is :"+ c);
//        else
//            System.out.println("null");
//
//        Actionable actionable = (a, b) -> System.out.println(a+ " "+ b);
//        actionable.print(12,Integer.valueOf(12));




//        String[] names = {"james","Antony", "audrey","paul","tom", "john","usama", "raylee", "Tomas", "Angelique", "Maaike" };
//        String[][] names2d = {names, names};
//
//        List<String> startsWithA = Arrays.stream(names).filter(name-> name.toLowerCase().startsWith("a")).collect(Collectors.toList());
//        System.out.println(startsWithA);
//
//        Arrays.stream(names).map(s ->
////            if(s!= "Maaike")
////                s= s + " student";
////            return s;
//
//            s.equalsIgnoreCase(("maaike"))?s:  String.format("%s student", s)
//        );
//
//        var startsWithAModified =  startsWithA.stream().filter(name->!name.equalsIgnoreCase("antony")).collect(Collectors.toList());
//        System.out.println(startsWithAModified);



//        StringMappable stringMappable = str -> str.toUpperCase();
//        System.out.println(stringMappable.mapString("Hello Wrold !"));
//        System.out.println(convertToUpperCase("usama"));
//        conveString(str -> str.toLowerCase(), "Hii usama");
//
//        Actionable actionable = () -> System.out.println("hello World");
//        actionable.print();


//        Runnable runnable1 = () -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(" I am Thread 1 "+i);
//            }
//        };
//        Thread t1 = new Thread(runnable1);
//        Runnable runnable2 = () -> {
//            for (int i = 100; i < 200; i++) {
//                System.out.println(" I am Thread 2 "+i);
//            }
//        };
//        Thread t2 = new Thread(runnable2);
//        t1.start();
//        t2.start();

//        int[] arr = {1,2,3,4,5};
////        Arrays.stream(arr).filter(p-> p%2!=0).forEach(p-> System.out.println(p));
//        List<Integer> al = Arrays.stream(arr).boxed().collect(Collectors.toList());
//        var arr5 = al.stream().mapToInt(p-> p.intValue()).toArray();
////        Collections.addAll(al, arr);
////        System.out.println(Arrays.toString(al));
////        int[] arr = new int[]{1, 2, 3, 4, 5};
//        List<Integer> list = new ArrayList<>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
//        System.out.println(list);
////        Arrays.stream(arr).boxed().toArray(Integer[] i=new Integer[])
//
//        Integer[] arr2 = new Integer[]{1,4,5};
//        List<Integer> list2 = Arrays.asList(arr2);
//        System.out.println("List2 "+list2);
//
//        double[] d1 = new double[]{1.1,2.2,3.3};
//
//        Double[] arr3 = Arrays.stream(d1).boxed().toArray(Double[]::new);
//        List<Double> list3 = Arrays.asList(arr3);
//        System.out.println(Arrays.toString(arr3)+" "+list3);
////        List<Double> list4 = (List<Double>) Arrays.stream(d1).collect(Collectors.toList());
////        System.out.println(list4);
//
//        var max = Arrays.stream(arr).reduce(Integer::max).getAsInt();
//        var max = Arrays.stream(arr).max().getAsInt();
//        System.out.println(Arrays.stream(arr2).mapToInt(p->p.intValue()).sum());
////        System.out.println(max.getAsInt());
//        List<String> list4 = Arrays.asList(new String[]{"usama", "is", "doing","work"});
//
//        List<String> result = list4.stream().map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println(result);
//
//        var ans = list2.stream().reduce(Integer::max);
//        System.out.println(ans.get().intValue());
//
//        StringMappable stringMappable = value -> value.replaceAll("[aeiou]","_");
//        System.out.println(stringMappable.mapString("usama"));
//
//        System.out.println("usama".replaceAll("[aeiou]", "_"));
//
//        String result2 = list4.stream().reduce("",(s, s2) -> s.concat(s2));
//        System.out.println(result2);
//        System.out.println(list3.stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
//
//        System.out.println(Arrays.stream(arr).map(value -> value*value).sum());

//        String newString = Arrays.stream(names).filter(p->!p.equalsIgnoreCase("usama")).reduce((s, s2) -> s+s2).orElse("");
//        List<String> newString = Arrays.stream(names).filter(p->!p.equalsIgnoreCase("usama")).map(s -> s+" Student").collect(Collectors.toList());
//         names = Arrays.stream(names).(s -> !s.equalsIgnoreCase("usama")).map(s -> s+" Student").toArray(String[] :: new);
//        System.out.println(newString);

//        Stream<Integer> generateStream = Stream.generate(() -> 5);
//        Stream<Integer> iterateStream = Stream.iterate(1,integer -> integer+2);
//
//        boolean resutl = Arrays.stream(names).allMatch(s -> s.length()>6);
//
////        System.out.println(generateStream.+"\n"+iterateStream);
//        System.out.println(Arrays.toString(names)+" "+resutl);


//        var chars = Arrays.stream(names).max((o1, o2) -> o1-o2));
//        System.out.println(chars.);

//        var ans = al.stream().reduce(0, (x, y)-> x+y);
//        System.out.println(ans);
//
//        var names1d = Arrays.stream(names2d).flatMap(strings -> Arrays.stream(strings)).collect(Collectors.toSet());
//        System.out.println(names1d);


//        LocalDateTime ld = LocalDateTime.now();
//        MonthDay md = MonthDay.of(ld.getMonth(), ld.getDayOfMonth());
//
//        MonthDay cmd = MonthDay.now();
//        LocalTime lt = LocalTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD, MMM YYYY ");
//        String formattedDate = ld.format(dtf);
//        System.out.println(formattedDate);
//        List<String> words = Arrays.asList("apple", "banana", "cherry");
//        String result = words.stream()
//                .map(String::toUpperCase)
//                .reduce("", String::concat);
//        System.out.println(result);

//        List<Integer> list1 = List.of(1,2,3,4,5);
//        int[] list1 = {2,3,5,1,3};
//        int extraC = 3;
//        var max= Arrays.stream(list1).mapToDouble(value -> value).reduce(Double::max).orElse(0.0);
//        System.out.println(max);
//        var result1 = Arrays.stream(list1).mapToObj(operand -> (operand+extraC)>=max).collect(toList());
//        System.out.println(result1);
//
//        List < Integer > numbers2 = Arrays.asList (1, 2, 3, 4, null);
//
//        Optional<List<Integer>> ol = Optional.of(numbers2);
//        int sum =
//                numbers2.stream ().filter (n->n % 2 ==
//                        0).mapToInt (Integer::intValue).sum ();

//        ol.stream().forEach(System.out::println);
//        HashSet<Integer> hs= new HashSet<>(Arrays.asList(12,11,4,11,12,3,5));
//        var anshs = hs.stream().filter(integer -> integer%2==0).collect(Collectors.toCollection(HashSet::new));
//        System.out.println(hs);

//        System.out.println ("Optional sum"+sum);




//        System.out.println(ld +" " +md+" "+cmd+" "+lt.plus( 1, ChronoUnit.WEEKS));

//        Stack<String> st = new Stack<>();
//        st.push("home");
//        st.push("home2");
//        st.push("home3");
//        st.push("home4");
//
//        var answer2 = st.stream().collect(Collector.of(
//                StringBuilder::new, (stringBuilder, stringBuilder2) -> stringBuilder.append("/").append(stringBuilder2), (stringBuilder, stringBuilder2) -> stringBuilder.append("/").append(stringBuilder2), StringBuilder::toString
//        ));
//        System.out.println("Ansewer 2 = "+answer2);


//        var ans1 = st.stream().map(character -> character.toString()).collect(Collectors.joining());
//        System.out.println("Stack Stream " +ans1);

tempCheck(1, AreaOfShapes::square);

    }

//    private static <T> void tempCheck(int radius, Function<AreaOfShapes,T> circle) {
//    }

    public static <T> T tempCheck(int radius, Function<AreaOfShapes , T> methods ) {
         AreaOfShapes areaOfShapes = new AreaOfShapes();
        return methods.apply(areaOfShapes);
    }


    public static Optional<Character> getNonRepeatedCharacterOpt(String str) {
        Map<Character, Integer> countCharacters = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!countCharacters.containsKey(c)) {
                countCharacters.put(c, 1);
            } else {
                countCharacters.put(c, countCharacters.get(c) + 1);
            }
        }
        // As LinkedHashMap maintains insertion order, first character with
        // count 1 should return first non repeated character
        for (Map.Entry<Character, Integer> e : countCharacters.entrySet()) {
            if (e.getValue() == 1)
                return Optional.of(e.getKey());

        }
        return null;

    }



//    private static void conveString(StringMappable stringMappable, String str) {
//        System.out.println(stringMappable.mapString(str));
//    }
//
//    private static String convertToUpperCase (String str) {
//        StringMappable stringMappable = value -> value.toUpperCase();
//        return stringMappable.mapString(str);
//
//    }


}