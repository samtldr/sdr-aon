package aon;
public class TimedMyIncDec implements IncDec {
    private final IncDec wrapped;

    public TimedMyIncDec(IncDec wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void increment() {
        long start = System.currentTimeMillis();
        wrapped.increment();
        long end = System.currentTimeMillis();
        System.out.println("Incrememt took " + (end - start) + " ms");
    }

    @Override
    public void decrement() {
        long start = System.currentTimeMillis();
        wrapped.decrement();
        long end = System.currentTimeMillis();
        System.out.println("Decrement took " + (end - start) + " ms");
    }

}
