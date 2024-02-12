package com.Relearn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer boxedInteger = Integer.valueOf(16);     //preferred but unnecessary
        Integer deprecatedBoxing = new Integer(17);     //deprecated since JDK9
        int unboxedInteger = boxedInteger.intValue();   //unnecessary

        //Automatic

        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;

        System.out.println(autoBoxed.getClass().getName());     // -> java.lang.Integer
//        System.out.println(autoUnboxed.getClass().getName());  Primitive types do not allow these methods


        Double autoBoxing = getPrimitiveValue();    // automatically boxing the primitive data
        double autoUnBoxing = getDoubleObject();    //automatically unboxing the object data to a primitive tye but an object type...


        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;   //autoboxes the primitive value 50 to the Object.
        System.out.println(Arrays.toString(wrapperArray));      // prints [50, null, null, null, null] -> Object type
        System.out.println(wrapperArray[0].getClass().getName());

        int[] primitiveArray = new int[3];
        primitiveArray[0] = 30;
        System.out.println(Arrays.toString(primitiveArray));    // prints [50, 0, 0] -> primitive type

        Character[] characters = {'a', 'b', 'c', 'd','e'};
        System.out.println(Arrays.toString(characters));

        Character[] chars = new Character[3];
        chars[1] = 'g';
        System.out.println(Arrays.toString(chars)); // -> [null, g, null]

        char[] chars2 = new char[3];
        chars[1] = 'g';
        System.out.println(Arrays.toString(chars)); // -> [ , g,  ]



        var ourList = getList(1, 2, 3, 4, 5, 6, 7, 8, 9); // IntelliJ highlights the ourList as an "ArrayList<Integer>, even though we passed primitive ints to the method
        System.out.println(ourList);

        //we can also do this -> List.of(1...), and it will still compile
        //we can almost always use Integers and ints interchangeably, automatically. Java does the auto Boxing and Unboxing for us.
        // In fact, it is conventional to always allow Java do the Boxing and Unboxing, because it always knows the best mechanism to use. Except when manually is necessary, of course.
    }

    private static Double getDoubleObject() {
        return Double.valueOf(100.00);
    }

    private static double getPrimitiveValue(){
        return 100.0;
    }

    // this method returns a primitive type -> int, auto-unboxing the Object 'Integer' passed to an int
    private static int returnAnInt(Integer i){
        return i;
    }

    //  this method takes a primitive type 'int' and returns an object 'Integer', auto-boxing the int to an Integer.
    private static Integer returnAnInt(int i){
        return i;
    }

    //  takes one or more primitive integers, adds them to an ArrayList of Integers, and returns the ArrayList. It automatically 'boxes' these integer parameters to a wrapper type Integer - an Object
    private static ArrayList<Integer> getList(int... varArgs){
        ArrayList<Integer> a_list = new ArrayList<>();

        for (int i : varArgs){
            a_list.add(i);
        }

        return a_list;
    }

}
