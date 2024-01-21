package com.example.lib_management;


import com.example.lib_management.AAA.model.PhoneDTO;

import java.util.*;

public class Main_Test {


    public static void main(String[] args){
        System.out.println("salam");
        List<PhoneDTO> list=new ArrayList<PhoneDTO>();
        Set<PhoneDTO> set= new HashSet<PhoneDTO>();
//
//        PhoneDTO s1=new PhoneDTO()  ;
//        PhoneDTO s2=new PhoneDTO() ;

//        s1.setCountryCode("123");
//        s1.setUserNumber("911");
//
//        s2.setCountryCode("123");
//        s2.setUserNumber("911");
//
//
//        set.add(s1);
//        set.add(s2);

//        HashSet<String> stringSet=new HashSet<>();
//        String s1="1";
//        String s2="1";
//        stringSet.add(s1);
//        stringSet.add(s2);
//        stringSet.add("3");
//
//
//
//        Iterator iterator = stringSet.iterator();
//
//        iterator.forEachRemaining((element) -> {
//            System.out.println(element);
//        });
//

        HashMap<String , Integer> hashMap=new HashMap<>();


        Integer int1=new Integer(1);
        Integer int2=new Integer(2);

        int2=int1;
        hashMap.put("Ea" , int1);
        hashMap.put("FB" , int2);




    }



}

