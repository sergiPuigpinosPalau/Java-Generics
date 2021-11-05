import java.util.Comparator;

public class EmployeeComparator<E extends Employee> implements Comparator<E> {
    @Override
    public int compare(E emp1, E emp2) {
        if (emp1.getDNI().compareTo(emp2.getDNI()) == 0 || emp1.getAL() == emp2.getAL()){
            return 0;
        } else if (emp1.getAL() > emp2.getAL()){
            return 1;
        }else {
            return -1;
        }
    }
}
