/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Chelsea
 */
public class Student {
    private String name;
    private String gender;
    private String email;
    private Course course1;
    private Course course2;
    private Course course3;

    public Student() {
        this.name = null;
        this.gender = null;
        this.email = null;
        this.course1 = new Course();
        this.course2 = new Course();
        this.course3 = new Course();
    }

    public Student(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.course1 = null;
        this.course2 = null;
        this.course3 = null;
    }

    public Student(String name, String gender, String email, Course course1, 
            Course course2, Course course3) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }
    
    public Student(Student student) { 
        this.name = student.name;
        this.gender = student.gender;
        this.email = student.email;
        this.course1 = new Course(student.course1);
        this.course2 = new Course(student.course2);
        this.course3 = new Course(student.course3);
    }
    
    /**
     * Checks how many courses the student has passed
     * @return the number of courses that the student has passed
     */
    public int calcPassedCourseNum() {
        if (course1.isPassed() && !course2.isPassed() && !course3.isPassed())
            return 1;
        else if (course2.isPassed() && !course1.isPassed() && !course3.isPassed())
            return 1;
        else if (course3.isPassed() && !course2.isPassed() && !course1.isPassed())
            return 1;
        else if (course1.isPassed() && course2.isPassed() || course1.isPassed() &&
                course3.isPassed() || course2.isPassed() && course3.isPassed())
            return 2;
        else if (course1.isPassed() && course2.isPassed() && course3.isPassed())
            return 3;
        else
            return 0;
    }
    
    /**
     * Checks how many credits the student gets, the student will get the credit of 
     * a course only if the course is passed
     * @return the number of credits that the student has gotten
     */
    public double calcTotalCredit() {
        if (course1.isPassed())
            return course1.getCredit();
        else if (course2.isPassed())
            return course2.getCredit();
        else if (course3.isPassed())
            return course3.getCredit();
        else if (course1.isPassed() && course2.isPassed())
            return course1.getCredit() + course2.getCredit();
        else if (course1.isPassed() && course3.isPassed())
            return course1.getCredit() + course3.getCredit();
        else if (course2.isPassed() && course3.isPassed())
            return course2.getCredit() + course3.getCredit();
        else if (course1.isPassed() && course2.isPassed() && course3.isPassed())
            return course1.getCredit() + course2.getCredit() + course3.getCredit();
        else
            return 0;
    }
    
    /**
     * Checks if the email is valid based on what the user inputs
     * @param email the input email
     * @return true if the email is valid and false if it's not
     */
    public static boolean isEmailValid(String email) {
    	int dotIdx = email.indexOf(".");
        int atIdx = email.indexOf("@");
        int characterLimit = 320;
        if (email.length() <= characterLimit)
            return true;
        else
            return false;
        String emailCharacters = ".@";
        if (email.contains(emailCharacters)) {
            if (atIdx != 0 && dotIdx != email.length() - 1 && atIdx > dotIdx && 
                    atIdx++ != dotIdx);
                return true;
        }
        return false;
    }
    
    public boolean equals(Student student) {
        return this.name.equals(student.name) && 
                this.gender.equals(student.gender) && 
                this.email.equals(student.email) && 
                this.course1.equals(student.course1) && 
                this.course2.equals(student.course2) && 
                this.course3.equals(student.course3);
    }
    
    @Override
    public String toString() { 
        String str = "";

        str += String.format("%-15s : %s\n", "Name", name); 
        str += String.format("%-15s : %s\n", "Gender", gender);
        str += String.format("%-15s : %s\n", "Email", email);
        str += "\n";
        str += String.format("%-17s %-17s %10s %13s\n", "Course", "Name", "Credit", "Score");
        str += "-------------------------------------------------------------\n";
        str += String.format("%-15s : %-17s %10.1f %13.1f\n", "Course 1", course1.getCourseName(),
                course1.getCredit(), course1.calcFinalScore());
        str += String.format("%-15s : %-17s %10.1f %13.1f\n", "Course 2", course2.getCourseName(),
                course2.getCredit(), course2.calcFinalScore());
        str += String.format("%-15s : %-17s %10.1f %13.1f\n", "Course 3", course3.getCourseName(),
                course3.getCredit(), course3.calcFinalScore());
        str += "\n";
        str += String.format("%-15s : %d\n", "Passed Courses", calcPassedCourseNum());
        str += String.format("%-15s : %.1f\n", "Total Credits", calcTotalCredit());
        
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public Course getCourse2() {
        return course2;
    }

    public void setCourse2(Course course2) {
        this.course2 = course2;
    }

    public Course getCourse3() {
        return course3;
    }

    public void setCourse3(Course course3) {
        this.course3 = course3;
    }
}

