package ChainingHashTable_5_1;

public class Main {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        Student jaime = new Student(1, "Jaime", "King");
        Student matt = new Student(2, "Matt", "Cai");
        Student meg = new Student(11, "Meg", "LeDon");
        Student reuben = new Student(5, "Reuben", "Black");

        hashTable.add(jaime);
        hashTable.add(matt);
        hashTable.add(new Student(3, "Ali", "Bee"));
        hashTable.add(new Student(4, "Jimbo", "Jones"));
        hashTable.add(reuben);
        hashTable.add(new Student(6, "Jerry", "Mouse"));
        hashTable.add(new Student(7, "Tilly", "Horse"));
        hashTable.add(new Student(8, "Ciri", "Cat"));
        hashTable.add(new Student(9, "Lady", "Wan"));
        hashTable.add(new Student(10, "Mike", "Flemming"));

        System.out.println(hashTable);

        System.out.println("Jaime in table? " + hashTable.contains(jaime));
        System.out.println("Meg in table? " + hashTable.contains(meg));

        System.out.println("Remove: " + matt + " " + hashTable.remove(matt));
        System.out.println("Remove: " + meg + " " + hashTable.remove(meg));
        System.out.println("Remove: " + reuben + " " + hashTable.remove(reuben));

        System.out.println("Matt in table? " + hashTable.contains(matt));

        System.out.println(hashTable);





    }

}
