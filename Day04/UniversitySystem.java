package com.bridgelabz;

interface Graded {
    void assignGrade(Enrollment enrollment, String grade);
}

class Course {
    private String courseCode;
    private String courseName;
    private int credits;

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName;
    }
}

abstract class Student {
    protected String studentId;
    protected String name;
    protected double totalGradePoints = 0.0;
    protected int totalCredits = 0;
    private double gpa;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public abstract void enroll(Course course);

    protected void updateGPA(double gradePoints, int credits) {
        totalGradePoints += gradePoints;
        totalCredits += credits;
        gpa = totalGradePoints / totalCredits;
    }

    public double getGPA() {
        return gpa;
    }

    public void viewTranscript() {
        System.out.println("Transcript for " + name + " (ID: " + studentId + ")");
        System.out.println("GPA: " + gpa);
    }
}

class Undergraduate extends Student {
    private String elective;

    public Undergraduate(String studentId, String name) {
        super(studentId, name);
    }

    public Undergraduate(String studentId, String name, String elective) {
        super(studentId, name);
        this.elective = elective;
    }

    @Override
    public void enroll(Course course) {
        System.out.println(name + " enrolled in " + course);
    }
}

class Postgraduate extends Student {
    public Postgraduate(String studentId, String name) {
        super(studentId, name);
    }

    @Override
    public void enroll(Course course) {
        System.out.println(name + " (Postgrad) enrolled in " + course);
    }
}

class Enrollment {
    private Student student;
    private Course course;
    private String grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}

class Faculty implements Graded {
    private String facultyId;
    private String name;

    public Faculty(String facultyId, String name) {
        this.facultyId = facultyId;
        this.name = name;
    }

    @Override
    public void assignGrade(Enrollment enrollment, String grade) {
        enrollment.setGrade(grade);

        double gradePoints = calculateGradePoints(grade);
        Student student = enrollment.getStudent();
        student.updateGPA(gradePoints, enrollment.getCourse().getCredits());

        System.out.println("Faculty " + name + " assigned grade " + grade +" to " + student.name + " for course " + enrollment.getCourse());
    }

    private double calculateGradePoints(String grade) {
        switch (grade) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            case "Pass": return 4.0;
            case "Fail": return 0.0;
            default: return 0.0;
        }
    }
}

public class UniversitySystem {
    public static void main(String[] args) {

        Course c1 = new Course("CS101", "Intro to Programming", 3);
        Course c2 = new Course("MATH201", "Discrete Math", 4);
        Undergraduate ug = new Undergraduate("U001", "Alice", "Photography");
        Postgraduate pg = new Postgraduate("P001", "Bob");

        ug.enroll(c1);
        pg.enroll(c2);

        Faculty profSmith = new Faculty("F001", "Prof. Smith");

        Enrollment e1 = new Enrollment(ug, c1);
        Enrollment e2 = new Enrollment(pg, c2);

        profSmith.assignGrade(e1, "A");
        profSmith.assignGrade(e2, "Pass");

        ug.viewTranscript();
        pg.viewTranscript();

    }
}
