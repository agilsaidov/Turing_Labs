package projects;

import java.util.NoSuchElementException;
import java.util.Objects;

public class OptionalCustom <T> {

    private final T value;
    private static final OptionalCustom<?> EMPTY = new OptionalCustom<>(null);

    public OptionalCustom(T value) {
        this.value = value;
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public static <T> OptionalCustom<T> empty() {
        return(OptionalCustom<T>) EMPTY;
    }

    public static <T> OptionalCustom<T> of(T value) {
        if(value == null) {
            throw new NullPointerException("Null value");
        }
        return(new OptionalCustom<T>(value));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OptionalCustom<?> that = (OptionalCustom<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "OptionalCustom{" +
                "value=" + value +
                '}';
    }
}
