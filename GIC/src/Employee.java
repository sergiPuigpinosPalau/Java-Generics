public class Employee implements Comparable<Employee>{
    private final String name;
    private final String DNI;
    private final int AL;

    public Employee (String name, String DNI, int AL){
        this.name = name;
        this.DNI = DNI;
        this.AL = AL;
    }

    public String getName(){
        return this.name;
    }

    public String getDNI(){
        return this.DNI;
    }

    public int getAL(){
        return this.AL;
    }

    public int compareTo(Employee employee){
        if (this.getDNI().compareTo(employee.getDNI()) == 0 || this.getAL() == employee.getAL()){
            return 0;
        } else if (this.getAL() > employee.getAL()){
            return 1;
        }else {
            return -1;
        }
    }

}
