package StudentMap_5_2;

public class Student {

    private int id;
    private String name;
    private String birthDate;

    public Student(int id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        return this.id * this.name.charAt(0);
    }

    @Override
    public String toString() {
        return "Student #: " + id + "\nName: " + name + "\nBirthdate: " + birthDate + "\n\n";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
