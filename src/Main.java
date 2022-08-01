//import java.io.File;  // Import the File class
//import java.io.FileNotFoundException;  // Import this class to handle errors
//import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private static List<String> getUnionOfLists(List<String> list1, List<String> list2) {

        Set<String> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<>(set);
    }

//    private static List<String> getIntersectOfLists1(List<String> list1, List<String> list2) {
//        List<String> intersectElements = list1.stream()
//                .filter(list2 :: contains)
//                .collect(Collectors.toList());
//
//        if(!intersectElements.isEmpty()) {
//            return intersectElements;
//        }else {
//            return Collections.emptyList();
//        }
//    }

    private static List<String> getIntersectOfLists2(List<String> list1, List<String> list2) {
        list1.retainAll(list2);

        return list1;
    }

    static ArrayList<Double> ll = new ArrayList<Double>();
    public static void Jaccard_similarity (String path , String Query) {

        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            String sss = s.next().replaceAll("\\p{Punct}", "");
            list.add(sss.replaceAll("[0-9]", ""));

        }
        s.close();

        List<String> myList = new ArrayList<String>(Arrays.asList(Query.split(" ")));
        List<String> Pre_Processing_Query = new ArrayList<String>();
        for (String value : myList) {
            String Query_sss = value.replaceAll("\\p{Punct}", "");
            Pre_Processing_Query.add(Query_sss.replaceAll("[0-9]", ""));
        }
        System.out.println("********* Pre_Processing_Query *********");
        for (String value : Pre_Processing_Query) {
            System.out.println(value);
        }

        System.out.println("..................... union & intersect ........................\n");
        //Find union of two lists
        System.out.println("Union of List1 and List2 :" + getUnionOfLists(Pre_Processing_Query, list));
        //Find intersect of lists using retainAll() method
        System.out.println("Intersection of List1 & List2 Method 2: " + getIntersectOfLists2(Pre_Processing_Query, list)+"\n");



        System.out.println(".................... SIZE of union & intersect.........................\n");


        Double union_size= Double.valueOf(getUnionOfLists(Pre_Processing_Query, list).size());
        Double intersect= Double.valueOf(getIntersectOfLists2(Pre_Processing_Query, list).size());

//        Double nn= Double.valueOf(union_size);
//        Double mm= Double.valueOf(intersect);
//        System.out.println("(((((((((((((((((((((((((((((((( :" + mm/nn);


        System.out.println("Union of List1 and List2 :" + union_size);
        System.out.println("Intersection of List1 & List2 : " + intersect);

        System.out.println("....................  Jaccard similarity.........................\n");


        Double Jaccard_similarity = Double.valueOf((intersect/union_size));

        ll.add(Jaccard_similarity);
        System.out.println("Jaccard similarity:" + Jaccard_similarity);


    }


    //=================================================================

    public static void main(String[] args) {
        System.out.println(" world!");

        //String Query = "Ehab Ezat ,Eman Nasr ,Gehad Mustafa ,Cat Dog";
        String Query ="Agile Software";



        List <String> Docs_list = new ArrayList <String> ();
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\100.txt");
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\101.txt");
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\102.txt");
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\103.txt");
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\104.txt");
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\105.txt");
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\106.txt");
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\107.txt");
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\108.txt");
        Docs_list.add("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\109.txt");

        for (String value : Docs_list) {
            System.out.println("\n\n\n\n\n ################################## "+value+"###########################\n");

            Jaccard_similarity(value,Query);
        }

        for(int i=0;i<ll.size();i++){
            System.out.println(ll.get(i));

        }


    }


}