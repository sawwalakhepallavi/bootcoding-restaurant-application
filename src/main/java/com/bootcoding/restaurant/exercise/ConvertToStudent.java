package com.bootcoding.restaurant.exercise;

import jdk.nashorn.internal.parser.Token;

public class ConvertToStudent{
    public static void main(String[] args) {
        ConvertToStudent sm = new ConvertToStudent();
        Student st= sm.Convert("Ramesh,76,65,88");
        System.out.println("Average Marks: " + st.getAverage());
        System.out.println("Percentage: " + st.getPercent());
    }
    public Student Convert(String text){
        Student st=new Student();
        String[] tokens=text.split(",");
        st.setName(tokens[0]);
        st.setPhysics(Integer.parseInt(tokens[1]));
        st.setChemistry(Integer.parseInt(tokens[2]));
        st.setMaths(Integer.parseInt(tokens[3]));
        int totalMark=(st.getPhysics()+st.getChemistry()+st.getMaths());

        st.setAverage(totalMark/3);
        st.setPercent(totalMark*100/300);
        return st;


    }
}
