package samples;

public class ArrayInvariant {
    public static void main(String[] args) {
        Integer[] ints = new Integer[5];
        Number[] numbers = ints;
        numbers[0] = 3.14;
    }
}
