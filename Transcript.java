import java.util.*;


public class Transcript
{
  Student student;
  School school;

  HashMap<Course, Character> freshGrades = new HashMap<Course, Character>();

  public Transcript( Student student, School school, HashMap<Course, Character> freshGrades)
  {
    this.student = student;
    this.school = school;
    this.freshGrades = freshGrades;

  }

  public void printTranscript()
  {
    //TODO

    System.out.println("\nInitializing Transcript....\n\n\n");
    System.out.println(this.student.name);
    System.out.println(this.student.address);
    System.out.println(this.student.phoneNumber);
    System.out.println(this.student.dob);
    System.out.println(this.student.guardian);
    System.out.println("\n\n");
    System.out.println(this.school.name);
    System.out.println(this.school.address);
    System.out.println(this.school.phoneNumber);
    System.out.println(this.school.email);
    System.out.println("\n\n");

    for(Course course : freshGrades.keySet())
    {
      System.out.println(course.name + "\t\t" +
                         course.credits + "\t" +
                         freshGrades.get(course));


    }
  }





  public static void main(String[] args)
  {
    School kennett = new School("Kennett High School", "409 Eagles' Way, North Conway, NH", "603-356-4343", "info@khs.com");
    Student dmr84 = new Student("Dan Richardi", "123 You Wish, North Conway, NH", "555-555-5555", "01/29/1984", "Gandalf");


    ArrayList<Course> freshmanCourses = new ArrayList<Course>();

    freshmanCourses.add(new Course("English 9", 1.0f));
    freshmanCourses.add(new Course("Algebra 1", 1.0f));
    freshmanCourses.add(new Course("Biology w/lab", 1.0f));
    freshmanCourses.add(new Course("American History", 1.0f));
    freshmanCourses.add(new Course("Drawing", 1.0f));
    freshmanCourses.add(new Course("Martial Arts 1", 0.5f));
    freshmanCourses.add(new Course("MS Office", 0.5f));

    dmr84.freshmanYear = dmr84.assignGrades(freshmanCourses);

    Transcript dmrTrans = new Transcript(dmr84, kennett, dmr84.freshmanYear);
    dmrTrans.printTranscript();
  }
}
class School
{
  String name;
  String address;
  String phoneNumber;
  String email;

  public School( String name,
                  String address,
                  String phoneNumber,
                  String email)
  {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

}

class Student
{
  String name;
  String address;
  String phoneNumber;
  String dob;
  String guardian;

  HashMap<Course, Character> freshmanYear;
  HashMap<Course, Character> sophomoreYear;
  HashMap<Course, Character> juniorYear;
  HashMap<Course, Character> seniorYear;

  public Student(String name,
                String address,
                String phoneNumber,
                String dob,
                String guardian)
  {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.guardian = guardian;

        freshmanYear = new HashMap<Course, Character>();
        sophomoreYear = new HashMap<Course, Character>();
        juniorYear = new HashMap<Course, Character>();
        seniorYear = new HashMap<Course, Character>();

  }
  public HashMap<Course, Character> assignGrades(ArrayList<Course> courses)
  {
    Scanner input = new Scanner(System.in);
    Character grade;
    HashMap<Course, Character> finalGrades = new HashMap<Course, Character>();

    for(Course course : courses)
    {
      System.out.print("Final letter grade for " + course.name + ": ");
      grade = input.next().charAt(0);
      finalGrades.put(course, Character.toUpperCase(grade));

    }
    return finalGrades;
  }

  public float calculateGPA()
  {
    //TODO
    return 0;
  }
}

class Course
{
  String name;
  float credits;

  public Course(String name,
                float credits)
  {
    this.name = name;
    this.credits = credits;
  }
}
