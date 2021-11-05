import java.util.Comparator;

public class FloatComparator implements Comparator<Float> {
    @Override
    public int compare(Float obj1, Float obj2) {
        return Float.compare(obj1, obj2);
    }
}
