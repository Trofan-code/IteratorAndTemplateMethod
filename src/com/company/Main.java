package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //impl template method
        Template welcomePage = new WelcomPage();
        Template newsPage = new NewsPage();

        welcomePage.showPage();
        System.out.println("\n################\n");
        newsPage.showPage();
        System.out.println("\n\n**********\n");


        //impl iterator
        String[] skills = {"Java","Spring","Hibernate","Maven"};
        JavaDeveloper javaDeveloper = new JavaDeveloper("Żenia",skills);

        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Developer: " + javaDeveloper.getName());
        System.out.println("\nSkills: ");

        while (iterator.hasNext()){
            System.out.println(iterator.next().toString()+ " ");
        }

        //One of the key methods of the Collection interface is the Iterator <E> iterator () method. Implementation below =>
        /*ArrayList arrayList = new ArrayList();
        arrayList.iterator();*/
    }



}
