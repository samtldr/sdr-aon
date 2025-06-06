package aon;

public class Main {
    public static void main(String [] args) {
        TimedMyIncDec mid = new TimedMyIncDec(new MyIncDec(0));

        mid.increment();
        mid.decrement();
        
    }
}
