package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.lang.Cow;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class StudentTest
{

  @Test
  void studentNamedPatIsNamedPat() {
    String name = "Pat";
    var pat = createStudentNamed(name);
    assertThat(pat.getName(), equalTo(name));
  }

  private static Student createStudentNamed(String name) {
    return new Student(name, new ArrayList<>(), 0.0, "Doesn't matter");
  }

  @Test
  void allStudentsSayThisClassIsTooMuchWork() {
    Student student = createStudentNamed("Name");
    assertThat(student.says(), equalTo("This class is too much work"));
  }

  @Test
  @Disabled
  void daveStudentSaysWhatIsExpected() {
    // Arrange (Given)
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Algorithm");
    classes.add("Operating Systems");
    classes.add("Java");
    Student dave = new Student("Dave", classes, 3.64, "male");

    // Act (When)
    String daveString = dave.toString();

    // Assert (Then)
    assertThat(daveString, equalTo("Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating Systems, and Java. He says \"This class is too much work\""));
  }

  @Test
  void nullNameThrowsNullPointerException() {
    assertThrows(NullPointerException.class, () -> new Student(null, null, 3.45, null));
  }

  @Test
  void nullClassesThrowsNullPointerException() {
    assertThrows(NullPointerException.class, () -> new Student("Name", null, 3.45, null));
  }

  @Test
  void nullGenderThrowsNullPointerException() {
    assertThrows(NullPointerException.class, () -> new Student("Name", new ArrayList<>(), 3.45, null));
  }

  @Test
  void studentCanTakeZeroClasses() {
    Student kendra = new Student("Kendra", new ArrayList<>(), 2.1, "female");
    String kendraString = kendra.toString();
    assertThat(kendraString, containsString("is taking 0 classes"));
  }

  @Test
  void studentCanTakeOnceClass() {
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Java");
    Student kendra = new Student("Kendra", classes, 2.1, "female");

    String kendraString = kendra.toString();

    assertThat(kendraString, containsString("is taking 1 class"));
  }

}
