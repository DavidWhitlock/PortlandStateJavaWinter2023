package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.lang.Human;

import java.util.ArrayList;
                                                                                    
/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {

  static final String MISSING_ARGUMENTS = "Missing command line arguments. To run this program, please provide the following in order: name, gender, GPA, and one or more classes.";
  static final String UNKNOWN_GENDER = "The gender is invalid. The second argument is gender. To run this program, please provide the following in order: name, gender, GPA, and a class/classes.";
  private final ArrayList<String> classes;

  /**
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The student's name                                                      
   * @param classes                                                                 
   *        The names of the classes the student is taking.  A student              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The student's grade point average                                       
   * @param gender                                                                  
   *        The student's gender ("male", "female", or "other", case insensitive)
   */                                                                               
  public Student(String name, ArrayList<String> classes, double gpa, String gender) {
    super(name);

    validateNotNull(name);
    validateNotNull(classes);
    validateNotNull(gender);

    this.classes = classes;

  }

  private static void validateNotNull(Object object) {
    if (object == null) {
      throw new NullPointerException();
    }
  }

  /**                                                                               
   * All students say "This class is too much work"
   */
  @Override
  public String says() {                                                            
    return "This class is too much work";
  }
                                                                                    
  /**                                                                               
   * Returns a <code>String</code> that describes this                              
   * <code>Student</code>.                                                          
   */                                                                               
  public String toString() {
    int numberOfClasses = getNumberOfClasses();
    return "is taking " + numberOfClasses + " classes";
  }

  private int getNumberOfClasses() {
    return classes.size();
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the student to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println(MISSING_ARGUMENTS);
      return;
    }

    String gender = args[1];

    if (!genderIsKnown(gender)) {
      System.err.println(UNKNOWN_GENDER);
    }


  }

  private static boolean genderIsKnown(String gender) {
    return false;
  }
}