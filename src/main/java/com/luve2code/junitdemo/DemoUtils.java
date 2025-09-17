package com.luve2code.junitdemo;

public class DemoUtils {

    private String academy = "Lub2Code Academy";
    private String academyDupilicate = academy;

    public String getAcademy() {
        return academy;
    }
    public String getAcademyDupilicate() {
        return academyDupilicate;
    }


    public int add(int a, int b) {
        return a + b ;
    }
    
    public Object checkNull(Object obj) {
        if(obj != null) {
            return obj;
        }
        return null;
    }

    public Boolean isGreater(int a, int b) {
        return a > b;
    }
}
