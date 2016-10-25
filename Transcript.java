import java.util.*;

public class Transcript
{
  Student student;
  School school;

  ArrayList<HashMap<Course, Character>> grades = new ArrayList<HashMap<Course, Character>>();

  public Transcript( Student student, School school, ArrayList<HashMap<Course, Character>> grades)
  {
    this.student = student;
    this.school = school;
    this.grades = grades;
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
    System.out.println("\n");
    System.out.println(this.school.name);
    System.out.println(this.school.address);
    System.out.println(this.school.phoneNumber);
    System.out.println(this.school.email);
    System.out.println("\n");

    for(HashMap<Course, Character> years : grades)
    {
      System.out.println("--------Class--------Credits----Grade--");
      for(Course course : years.keySet())
      {
        System.out.println(course.name + "\t\t" +
                           course.credits + "\t" +
                           years.get(course));
      }
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

    ArrayList<Course> sophomoreCourses = new ArrayList<Course>();
    sophomoreCourses.add(new Course("English 10", 1.0f));
    sophomoreCourses.add(new Course("Algebra II", 1.0f));
    sophomoreCourses.add(new Course("Chemistry w/lab", 1.0f));
    sophomoreCourses.add(new Course("World History", 1.0f));
    sophomoreCourses.add(new Course("Latin I", 1.0f));
    sophomoreCourses.add(new Course("Martial Arts II", 0.5f));
    sophomoreCourses.add(new Course("Piano", 0.5f));

    ArrayList<Course> juniorCourses = new ArrayList<Course>();
    juniorCourses.add(new Course("English 11", 1.0f));
    juniorCourses.add(new Course("Algebra II", 1.0f));
    juniorCourses.add(new Course("Marine Biology w/lab", 1.0f));
    juniorCourses.add(new Course("American Government", 0.5f));
    juniorCourses.add(new Course("Economics", 0.5f));
    juniorCourses.add(new Course("Latin II", 1.0f));
    juniorCourses.add(new Course("Web Design", 1.0f));

    ArrayList<Course> seniorCourses = new ArrayList<Course>();
    seniorCourses.add(new Course("English 12", 1.0f));
    seniorCourses.add(new Course("Calculus", 1.0f));
    seniorCourses.add(new Course("Physics w/lab", 1.0f));
    seniorCourses.add(new Course("Photography", 0.5f));
    seniorCourses.add(new Course("Yearbook", 0.5f));
    seniorCourses.add(new Course("Driver's Education", 0.5f));
    seniorCourses.add(new Course("Studio Art", 1.0f));
    seniorCourses.add(new Course("Piano", 0.5f));

    //Refactor in future to loop
    dmr84.freshmanYear = dmr84.assignGrades(freshmanCourses);
    dmr84.sophomoreYear = dmr84.assignGrades(sophomoreCourses);
    dmr84.juniorYear = dmr84.assignGrades(juniorCourses);
    dmr84.seniorYear = dmr84.assignGrades(seniorCourses);
    dmr84.compileGrades();

    Transcript dmrTrans = new Transcript(dmr84, kennett, dmr84.grades);
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
  ArrayList<HashMap<Course, Character>> grades;

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
        grades = new ArrayList<HashMap<Course, Character>>();
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
  public void compileGrades()
  {
    grades.addAll(Arrays.asList(freshmanYear, sophomoreYear, juniorYear, seniorYear));
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
