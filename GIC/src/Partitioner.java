import java.util.*;

public class Partitioner {

    public static PairOfListsInt partitionInt(List<Integer> src, int pivot){
        List<Integer> smallerThanPivot = new ArrayList<>();
        List<Integer> biggerThanPivot = new ArrayList<>();
        Iterator it = src.iterator();
        while (it.hasNext()){
            int number = (int)it.next();
            if (number <= pivot){
                smallerThanPivot.add(number);
            }else {
                biggerThanPivot.add(number);
            }
        }
        return new PairOfListsInt(smallerThanPivot, biggerThanPivot);
    }

    //<E extends Comparable> with that, we say that E implements Comparable so it has a compareTo function.
    //<E extends Comparable<? super E>> That way we tell that the superclass is the one that implements comparable and the childs inherit it.
    public static <E extends Comparable<? super E>> PairOfLists<E> partition(List<E> src, E pivot){
        ArrayList<E> smallerThanPivot = new ArrayList<>();
        ArrayList<E> biggerThanPivot = new ArrayList<>();
        Iterator<E> it = src.iterator();
        while (it.hasNext()){
            E number = it.next();
            if ((number.compareTo(pivot)) <= 0){
                smallerThanPivot.add(number);
            }else {
                biggerThanPivot.add(number);
            }
        }
        return new PairOfLists<>(smallerThanPivot, biggerThanPivot);
    }

    //E there because class is not generic(E) but this function is, so we have to specify it
    public static <E> PairOfLists<E> partition(List<E> src, E pivot, Comparator<E> comp){
        ArrayList<E> smallerThanPivot = new ArrayList<>();
        ArrayList<E> biggerThanPivot = new ArrayList<>();
        Iterator<E> it = src.iterator();
        while (it.hasNext()){
            E number = it.next();
            if (comp.compare(number, pivot) <= 0){
                smallerThanPivot.add(number);
            }else {
                biggerThanPivot.add(number);
            }
        }
        return new PairOfLists<>(smallerThanPivot, biggerThanPivot);
    }

    //Return lists can be E or any super class.
    public static <E extends Comparable<? super E>> void copyPartition(List<E> src, E pivot, List<? super E> trg1, List<? super E> trg2){
        Iterator<E> it = src.iterator();
        while (it.hasNext()){
            E number = it.next();
            if ((number.compareTo(pivot)) <= 0){
                trg1.add(number);
            }else {
                trg2.add(number);
            }
        }
    }

    public static <E> void copyPartition(List<E> src, E pivot, Comparator<E> comp,List<? super E> trg1, List<? super E> trg2){
        Iterator<E> it = src.iterator();
        while (it.hasNext()){
            E number = it.next();
            if ((comp.compare(number, pivot)) <= 0){
                trg1.add(number);
            }else {
                trg2.add(number);
            }
        }
    }
}