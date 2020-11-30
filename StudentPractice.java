/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 * Class of a student, basic OOP exercise
 * @author Chelsea
 */
public class Student {
    private String name;
    private String id;
    private int age;
    private String gender;
    private String email; // name@vaniercollege.qc.ca
    private static int nextId = 1; // one copy of the value (the next student's Id)
    private final static String SCHOOL_NAME = "Vanier College";
    
    public Student(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = null;
        this.email = null;
    }
    
    public Student(String name, int age, String gender) {
        this.name = name;
        this.id = String.format("%06d", nextId++); //000001 --> the "06" will make it have 6 zeros before
        this.age = age;
        this.gender = gender;
        this.email = email;
    } 
    
    public Student() {
        this.name = null;
        this.id = null;
        this.age = 0;
        this.gender = null;
        this.email = null;
    }
    
    @Override
    public String toString() { // non-static method --> belongs to the object
        String str = "";
        
        str += String.format("Student from %s\n", SCHOOL_NAME); // static variable
        str += String.format("%10s : %s\n", "Name", name);
        str += String.format("%10s : %s\n", "ID", id);
        str += String.format("%10s : %s\n", "Age", age);
        str += String.format("%10s : %s\n", "Gender", gender);
        str += String.format("%10s : %s\n", "Email", email);
        
        return str;
    }
    /**
     * to generate an email for a student
     */
    public void generateEmail() { // you don't need a parameter because name is a data member
        email = String.format("%s@vaniercollege.qc.ca", name);
    }
    
    public static boolean isNameValid(String name) { // static method --> belongs to the class
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '-' &&  c != '\'')
                return false;
        }
        return true;
    }
    
    public boolean equals(Student student) { //temporary solution for programming 1
        return this.name.equals(student.name) && 
                this.id.equals(student.id) &&
                this.age == (student.age) && 
                this.gender.equals(student.gender) &&
                this.email.equals(student.email);
    }
    
    public Student(Student student) { // copy constructor
        this.name = student.name;
        this.id = student.id;
        this.age = student.age;
        this.gender = student.gender;
        this.email = student.email;
    }
    
    // getter and setter 
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (isNameValid(name)) {
            this.name = name;
            this.email = String.format("%s@vaniercollege.qc.ca", name); 
        }
        else 
            System.out.println("Sorry, the new name is invalid...Request denied");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email = generateEmail(name);
    }

    public void setEmail(String email) {
        this.email = email;
        int atIdx = email.indexOf('@');
        name = email.substring(0, atIdx);
    }
}
