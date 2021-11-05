import java.util.List;

public class PairOfLists<E> {
    private final  List<E> smallerThanPivot;
    private final  List<E> biggerThanPivot;

    public PairOfLists(List<E> smallerThanPivot, List<E> biggerThanPivot) {
        this.smallerThanPivot = smallerThanPivot;
        this.biggerThanPivot = biggerThanPivot;
    }

    public List<E> getSmallerThanPivotArray(){
        return this.smallerThanPivot;
    }

    public List<E> getBiggerThanPivotArray() {
        return this.biggerThanPivot;
    }
}
