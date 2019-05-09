package ChainingHashTable_5_1;

public class Student {

    private int id;
    private String fName, lName;

    public Student(int id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    @Override
    public int hashCode() {
        return this.id * this.fName.charAt(0) * this.lName.charAt(0);
    }

    @Override
    public String toString() {
        return "id= " + id + " - " + fName + " " + lName;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }
}
