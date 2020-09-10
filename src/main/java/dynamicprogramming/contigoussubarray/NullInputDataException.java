package dynamicprogramming.contigoussubarray;

public class NullInputDataException extends RuntimeException {
    public NullInputDataException() {
        super("Input table shouldn't be null");
    }
}
