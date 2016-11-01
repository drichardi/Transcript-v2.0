import java.util.*; //importing all utilities

class Transcript
{
  Student student; //variable for when making a new student
  School school; //variable for when making a new school

  public Transcript( Student student, School school) //constructor
  {
    this.student = student; //assigning varibles that can be any type
    this.school = school; //assigning varibles that can be any type
  }

  public void printTranscript() //new method that prints your transcript
  {

    System.out.println("\nInitializing Transcript....\n\n\n"); //printing line
    System.out.println(student.address); //printing address of student
    System.out.println(student.name); //printing name of student
    System.out.println(student.phoneNumber); //printing phone number of student
    System.out.println(student.dob); //printing date of birth of student
    System.out.println(student.guardian); //printing gaurdians name
    System.out.println("\n"); //new line
    System.out.println(school.name); //printing school's name
    System.out.println(school.address); //printing school's address
    System.out.println(school.phoneNumber); //printing school's phone number
    System.out.println(school.email); //printing school's email
    System.out.println("\n"); // new line

    int year = 9; //in grade nine
    for(HashMap<Course, Character> years : student.grades) //running through each set of variables in hashmap
    {
      System.out.println("--------------------Grade-" + year + "-----------------" ); // inserting int year into string
      System.out.println("--------Class----------------Credits--Grade--"); //printing string
      for(Course course : years.keySet()) //running through course in years
      {
        if(course.name.length() < 8) // if course name is greater than 8
        {
          System.out.println("\t"+course.name + "\t\t\t" + //printing out on next lines that will make a table like output
                             course.credits + "\t" + //prints out name, number of credits, and what year you took the class
                             years.get(course));
        }
        else if(course.name.length() > 15) //if course name is less than 15, setting parameters
        {
          System.out.println("\t"+course.name + "\t" +//printing out on next lines that will make a table like output
                             course.credits + "\t" + //prints out name, number of credits, and what year you took the clas
                             years.get(course));
        }

        else { //printing out the rest of the courses in grade 9
          System.out.println("\t"+course.name + "\t\t" + //printing out on next lines that will make a table like output
                             course.credits + "\t" +  //prints out name, number of credits, and what year you took the clas
                             years.get(course));
        }
      }
      year++; // adding one to years to repeat process
  }
  System.out.println("Calculated GPA over 4 years: "+ String.format("%.01f", student.calculateGPA())); //calculating gpa
}
  public static void main(String[] args)
  {
    School kennett = new School("Kennett High School", "409 Eagles' Way, North Conway, NH", "603-356-4343", "info@khs.com");
    //creating a new school and assigning it vairables
    Student dmr84 = new Student("Dan Richardi", "123 You Wish, North Conway, NH", "555-555-5555", "01/29/1984", "Gandalf");
    //creating anew student and assigning it variables

    ArrayList<Course> freshmanCourses = new ArrayList<Course>(); //array for freshman courses
    freshmanCourses.add(new Course("English 9", 1.0f)); //english class with 1 credit
    freshmanCourses.add(new Course("Algebra 1", 1.0f)); //algebra 1 class with 1 credit
    freshmanCourses.add(new Course("Biology w/lab", 1.0f)); //bio class worth 1 credit
    freshmanCourses.add(new Course("American History", 1.0f)); //american history class worth 1 credit
    freshmanCourses.add(new Course("Drawing", 1.0f)); //drawing class worth 1 credit
    freshmanCourses.add(new Course("Martial Arts 1", 0.5f)); //martial arts 1 class worth .5 credits
    freshmanCourses.add(new Course("MS Office", 0.5f)); //MS office class worth .5 credits

    ArrayList<Course> sophomoreCourses = new ArrayList<Course>(); //array for sophomore classes
    sophomoreCourses.add(new Course("English 10", 1.0f));
    sophomoreCourses.add(new Course("Algebra II", 1.0f));
    sophomoreCourses.add(new Course("Chemistry w/lab", 1.0f));
    sophomoreCourses.add(new Course("World History", 1.0f));
    sophomoreCourses.add(new Course("Latin I", 1.0f));
    sophomoreCourses.add(new Course("Martial Arts II", 0.5f));
    sophomoreCourses.add(new Course("Piano", 0.5f));

    ArrayList<Course> juniorCourses = new ArrayList<Course>(); //array for junior courses
    juniorCourses.add(new Course("English 11", 1.0f));
    juniorCourses.add(new Course("Algebra II", 1.0f));
    juniorCourses.add(new Course("Marine Biology w/lab", 1.0f));
    juniorCourses.add(new Course("American Government", 0.5f));
    juniorCourses.add(new Course("Economics", 0.5f));
    juniorCourses.add(new Course("Latin II", 1.0f));
    juniorCourses.add(new Course("Web Design", 1.0f));

    ArrayList<Course> seniorCourses = new ArrayList<Course>(); //array for senior course
    seniorCourses.add(new Course("English 12", 1.0f));
    seniorCourses.add(new Course("Calculus", 1.0f));
    seniorCourses.add(new Course("Physics w/lab", 1.0f));
    seniorCourses.add(new Course("Photography", 0.5f));
    seniorCourses.add(new Course("Yearbook", 0.5f));
    seniorCourses.add(new Course("Driver's Education", 0.5f));
    seniorCourses.add(new Course("Studio Art", 1.0f));
    seniorCourses.add(new Course("Piano", 0.5f));


    dmr84.freshmanYear = dmr84.assignGrades(freshmanCourses); //assigning those arrays to to dmr84 and making them new variables
    dmr84.sophomoreYear = dmr84.assignGrades(sophomoreCourses);//assigning those arrays to to dmr84 and making them new variables
    dmr84.juniorYear = dmr84.assignGrades(juniorCourses);//assigning those arrays to to dmr84 and making them new variables
    dmr84.seniorYear = dmr84.assignGrades(seniorCourses);//assigning those arrays to to dmr84 and making them new variables
    dmr84.compileGrades(); //call void function compileGrades on the above classes

    Transcript dmrTrans = new Transcript(dmr84, kennett); //creates new Transcript with the dmr84 and kennett variables
    dmrTrans.printTranscript(); //prints that transcript

  }
}
class School //making new class for when creating a new school
{
  String name; //when makinng new school u have to define the name, address, phoneNumber, and email
  String address;
  String phoneNumber;
  String email;

  public School( String name, //constructor for school class
                  String address, //define name, address, phoneNumber, and email
                  String phoneNumber,
                  String email)
  {
    this.name = name; //recalls the information from when you made the school variable and assigns it to the correct variable
    this.address = address; //kennett.address = 409 Eagles Way, North Conway, NH
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

}

class Student //custom class that has different variables than school, used when creating a new student
{
  String name; //define name
  String address; //define address
  String phoneNumber; //define phoneNumber
  String dob; //defines dob
  String guardian; //define gaurdian

  HashMap<Course, Character> freshmanYear; //creates new hashmaps for each year
  HashMap<Course, Character> sophomoreYear;
  HashMap<Course, Character> juniorYear;
  HashMap<Course, Character> seniorYear;
  ArrayList<HashMap<Course, Character>> grades; //uses previous arrays to define hashmaps

  public Student(String name, //custom constructor for new students
                String address,
                String phoneNumber,
                String dob,
                String guardian)
  {
        this.name = name; //creates new student by using whatever the input is
        this.address = address; //dmr84.address = 123 You Wish, North Conway, NH
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.guardian = guardian;

        freshmanYear = new HashMap<Course, Character>(); //imports previous arrays into seperate hashmaps
        sophomoreYear = new HashMap<Course, Character>(); //sophomoreYear is now a hashmap that we previously created
        juniorYear = new HashMap<Course, Character>(); //juniorYear variable defined as previously created hashmap
        seniorYear = new HashMap<Course, Character>();
        grades = new ArrayList<HashMap<Course, Character>>(); //takes previously compiled hashmaps, and puts them into an array titled grades
  }
  public HashMap<Course, Character> assignGrades(ArrayList<Course> courses) //new public class that will let you assign each class a letter grade
  {
    Scanner input = new Scanner(System.in); //allowing for user input
    Character grade; //defining what the input is
    HashMap<Course, Character> finalGrades = new HashMap<Course, Character>(); //using the hashmap to make sure each grade you input gets assigned to a class

    for(Course course : courses) //going through every course in the courses you put in hashmaps
    {
      System.out.print("Final letter grade for " + course.name + ": "); //takes name of course and puts it in a string
      grade = input.next().charAt(0); //takes the next thing you input and assigns it to variable
      finalGrades.put(course, Character.toUpperCase(grade)); //adds to array finalGrades in upper case

    }
    return finalGrades; //returns array finalGrades
  }

  public float calculateGPA() //public that calculates GPA using grades you entered
  {
    float total = 0.0f; //new varaible that equals 0
    int courseCount = 0; //new int that also equals 0

    //Simple GPA Calculation - A = 4, B = 3, C = 2, D = 1, F = 0
    for (HashMap<Course, Character> gradeYear : grades) //goes through every grade in gradeYear
    {
      for (Course course : gradeYear.keySet()) //goes through every course in gradeYear
      {
        switch(gradeYear.get(course)) //switch statement for gradeYear courses
        {
          case 'A': //if grade is a
            total += 4.0f; //add 4 to total
            courseCount++; //add 1 to course count
            break;
          case 'B': //if grade is b
            total += 3.0f; //add 3 to total
            courseCount++;  // add 1 to course count
            break;
          case 'C': //if grade is c
            total += 2.0f; //add 2 to total
            courseCount++; //add 1 to course count
            break;
          case 'D': //if grade is d
            total += 1.0f; //add 1 to total
            courseCount++; //add 1 to course count
          default: //if grade is f
            courseCount++; //add 1 to course count
            break;

        }
      }
    }

    return total/courseCount; //returns the total divided by course count
  }
  public void compileGrades() //compileGrades method
  {
    grades.addAll(Arrays.asList(freshmanYear, sophomoreYear, juniorYear, seniorYear)); //adds all grades together as one array
  }
}

class Course //custom class for when adding course afterwards
{
  String name; //naming class
  float credits; //giving it a amount of credits

  public Course(String name, //custom constructor for Course class
                float credits)
  {
    this.name = name; //taking name of class and assigning it to name variable
    this.credits = credits; //taking number of credits and assigning it to credits variable
  }
}
