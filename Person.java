

public class Person {
    int age;
    String name;

    public Person(int Age, String Name){
      age = Age;
      name = Name;
    }
    public static void main(String[] args) {

        Teacher dan = new Teacher(32, "Dan Richardi");
        dan.department = "CTC";
        dan.setYears(2);

        Teacher bob = new Teacher(32, "Bob Bobby", 5, "Math");
        bob.setYears(10);

        Student joe = new Student(16, "Joe Moe");
        joe.yearOfGrad = 2018;
        joe.gpa = 3.5f;

        System.out.println(joe.name + " is graduating in " + joe.yearOfGrad + " and has " + dan.name + " as a teacher");
        System.out.println(bob.name + " is " + bob.age + " years old, and has been teaching for " + bob.getYears() + " years in the " + bob.department + " Department.");


    }
}

class Teacher extends Person {
    String department;
    private int years;

    public Teacher(int Age, String Name){
      super(Age, Name);
    }
    public Teacher(int Age, String Name, int Years, String Dept){
      super(Age, Name);
      years = Years;
      department = Dept;
    }
    public int getYears(){
      return years;
    }
    public void setYears(int Years){
      years = Years;
    }


}

class Student extends Person {
    int yearOfGrad;
    float gpa;

    public Student(int Age, String Name){
      super(Age, Name);
    }

}
