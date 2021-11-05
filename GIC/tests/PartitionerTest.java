import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class PartitionerTest {

    @Test
    void partitionIntTest() {
        List<Integer> list = new ArrayList<>(List.of(9, 89, 1, 50, 6, 77, 999, 2, 68, 9999));
        PairOfListsInt testResult = Partitioner.partitionInt(list, 50);
        //Result Checker
        List<Integer> resultSmall = Arrays.asList(9,1,50,6,2);
        List<Integer> resultBig = Arrays.asList(89,77,999,68,9999);
        assertEquals(resultSmall, testResult.getSmallerThanPivotArray());
        assertEquals(resultBig, testResult.getBiggerThanPivotArray());
    }

    @Test
     void testFloats() {
        //Create comparator
        FloatComparator comp = new FloatComparator();
        //Create source list
        List<Float> list = new ArrayList<>(List.of(15.55f, 7.25f, 60.55f, 50.99f, 77.2f, 99.3f, 2.3f, 100.1f, 69.9f, 33.3f));
        //Create pivot
        float pivot = 50.0f;
        //Create solutions
        List<Float> resultSmall = Arrays.asList(15.55f,7.25f,2.3f,33.3f);
        List<Float> resultBig = Arrays.asList(60.55f,50.99f,77.2f,99.3f,100.1f,69.9f);
        PairOfLists<Float> results = new PairOfLists<>(resultSmall, resultBig);
        //Copy lists
        List<Float> trg1 = new ArrayList<>();
        List<Float> trg2 = new ArrayList<>();
        PairOfLists<Float> trgs = new PairOfLists<>(trg1, trg2);
        //Tests
        tests(list, pivot, comp, results, trgs);
    }

    @Test
    void testEmployees() {
        //Create comparator
        EmployeeComparator<Employee> empComp = new EmployeeComparator<>();
        //Create source list
        Engineer engi1 = new Engineer("Jordi", "90737011X", 1);
        Mechanic mech2 = new Mechanic("Pepe", "49820569Q", 4);
        Engineer engi3 = new Engineer("Sergi", "49259953W", 6);
        Mechanic mech4 = new Mechanic("Pablo", "02270954A", 8);
        List<Employee> list = new ArrayList<>(List.of(engi1, mech2, engi3, mech4));
        //Pivot
        Engineer pivot = new Engineer("Oriol", "60386159G", 5);
        //Create solutions
        List<Employee> resultSmall = new ArrayList<>(List.of(engi1, mech2));
        List<Employee> resultBig = new ArrayList<>(List.of(engi3, mech4));
        PairOfLists<Employee> results = new PairOfLists<>(resultSmall, resultBig);
        //Copy lists
        List<Employee> trg1 = new ArrayList<>();
        List<Employee> trg2 = new ArrayList<>();
        PairOfLists<Employee> trgs = new PairOfLists<>(trg1, trg2);
        //Tests
        tests(list, pivot, empComp, results, trgs);
    }

    @Test
    void testEngineers() {
        //Create comparator
        EmployeeComparator<Engineer> empComp = new EmployeeComparator<>();
        //Create source list
        Engineer engi1 = new Engineer("Jordi", "90737011X", 1);
        Engineer engi2 = new Engineer("Pepe", "49820569Q", 4);
        Engineer engi3 = new Engineer("Sergi", "49259953W", 6);
        Engineer engi4 = new Engineer("Pablo", "02270954A", 8);
        List<Engineer> list = new ArrayList<>(List.of(engi1, engi2, engi3, engi4));
        //Pivot
        Engineer pivot = new Engineer("Oriol", "60386159G", 5);
        //Create solutions
        List<Engineer> resultSmall = new ArrayList<>(List.of(engi1, engi2));
        List<Engineer> resultBig = new ArrayList<>(List.of(engi3, engi4));
        PairOfLists<Engineer> results = new PairOfLists<>(resultSmall, resultBig);
        //Copy lists
        List<Employee> trg1 = new ArrayList<>();
        List<Employee> trg2 = new ArrayList<>();
        PairOfLists<Employee> trgs = new PairOfLists<>(trg1, trg2);
        //Tests
        tests(list, pivot, empComp, results, trgs);
    }

    //Specify that E extends from Comparable. If not compiler will tell you that E  needs to be from Comparable<E>
    <E extends Comparable<? super E>>void tests(List<E> list, E pivot, Comparator<E> comp, PairOfLists<E> results, PairOfLists<? super E> trgs){
        comparablePartition(list,pivot,results);
        comparatorPartition(list, pivot, comp, results);
        comparableCopyPartition(list,pivot,results, trgs);
        comparatorCopyPartition(list, pivot, comp, results, trgs);
    }

    <E extends Comparable<? super E>>void comparablePartition(List<E> list, E pivot, PairOfLists<E> results){
        PairOfLists<E> testResult = Partitioner.partition(list,pivot);
        System.out.println("comparablePartition");
        resultChecker(testResult, results);
    }

    <E>void comparatorPartition(List<E> list, E pivot, Comparator<E> comp, PairOfLists<E> results){
        PairOfLists<E> testResult = Partitioner.partition(list, pivot, comp);
        System.out.println("comparatorPartition");
        resultChecker(testResult, results);
    }

    <E extends Comparable<? super E>>void comparableCopyPartition(List<E> list, E pivot, PairOfLists<E> results, PairOfLists<? super E> trgs){
        //Create variables
        List<? super E> trg1 = trgs.getSmallerThanPivotArray();
        List<? super E> trg2 = trgs.getBiggerThanPivotArray();
        trg1.clear();
        trg2.clear();
        //Tests
        Partitioner.copyPartition(list, pivot, trg1, trg2);
        System.out.println("comparableCopyPartition");
        resultChecker(trgs, results);
    }

    <E>void comparatorCopyPartition(List<E> list, E pivot, Comparator<E> comp, PairOfLists<E> results, PairOfLists<? super E> trgs){
        //Create variables
        List<? super E> trg1 = trgs.getSmallerThanPivotArray();
        List<? super E> trg2 = trgs.getBiggerThanPivotArray();
        trg1.clear();
        trg2.clear();
        //Tests
        Partitioner.copyPartition(list, pivot, comp,trg1, trg2);
        System.out.println("comparatorCopyPartition");
        resultChecker(trgs, results);
    }

    <E> void resultChecker(PairOfLists<? super E> testResult, PairOfLists<E> results) {
        assertEquals(results.getSmallerThanPivotArray(), testResult.getSmallerThanPivotArray());
        assertEquals(results.getBiggerThanPivotArray(), testResult.getBiggerThanPivotArray());
        System.out.println("[Small] Test: " + testResult.getSmallerThanPivotArray() + " Solution: " + results.getSmallerThanPivotArray());
        System.out.println("[Big] Test: " + testResult.getBiggerThanPivotArray() + " Solution: " + results.getBiggerThanPivotArray());
    }
}