package test.java.com.hillel.elementary.javageeks.artem.homework5;


public class Convertation {

    public String convertation(double number){
        try{
           String str = Double.toString(number);
           return str;
        }catch (Exception exception){
           String str = exception.toString();
           return str;
        }
    }

}
