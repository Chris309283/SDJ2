package model;

public class Student
{
  private String name;
  private int studentNumber;

  public Student(String name, int studentNumber)
  {
    this.name = name;
    this.studentNumber = studentNumber;
  }

  public Student(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getStudentNumber()
  {
    return studentNumber;
  }

  public void setStudentNumber(int studentNumber)
  {
    this.studentNumber = studentNumber;
  }

  @Override public String toString()
  {
    return "Student{" + "name='" + name + '\'' + ", studentNumber="
        + studentNumber + '}';
  }
}
