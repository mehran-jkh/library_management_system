package com.example.lib_management;

import javax.persistence.*;

import com.example.lib_management.AAA.Entity.Aarole;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.metamodel.Metamodel;

import java.util.Map;

public class Main_Test {

    public static void main(String[] args){
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_name");

        EntityManager entityManager= emf.createEntityManager();


        System.out.println("salam");

    }
}
