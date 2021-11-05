import java.util.List;

public class PairOfListsInt {
    private final List<Integer> smallerThanPivot;
    private final  List<Integer> biggerThanPivot;

    public PairOfListsInt(List<Integer> smallerThanPivot, List<Integer> biggerThanPivot) {
        this.smallerThanPivot = smallerThanPivot;
        this.biggerThanPivot = biggerThanPivot;
    }

    public List<Integer> getSmallerThanPivotArray(){
        return this.smallerThanPivot;
    }

    public List<Integer> getBiggerThanPivotArray() {
        return this.biggerThanPivot;
    }
}
