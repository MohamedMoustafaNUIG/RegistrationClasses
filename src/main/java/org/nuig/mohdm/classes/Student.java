package org.nuig.mohdm.classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import org.joda.time.DateTime;
/**
 *
 * @author mohdm
 */
public class Student implements Comparable {
    private String name;
    private int age;
    private DateTime dob;
    private int id;
    private Course course;
    private ArrayList<Module> modules;

    public Student(String name, int age, DateTime dob, int id){
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.id = id;
        this.modules = new ArrayList<Module>();
    }
    
    public Student(String name, int age, DateTime dob, int id, Course course){
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.id = id;
        this.course = course;
        this.modules = this.course.getModules();
    }
    
    @Override
    public int hashCode(){return id;}
    
    @Override
    public boolean equals(Object o){
        if(this == o){return true;}
        if(o == null || getClass()!= o.getClass()) {return false;}
        
        Student temp = (Student) o;
        
        return this.id == temp.getId();
    }
        
    public String getUsername(){
        return (this.name + Integer.toString(this.age));
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DateTime getDob() {
        return dob;
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if(this.course!=null){//If we are removing student from course
            for(Module m:this.course.getModules()){//remove course modules
                if(this.modules.contains(m)){
                    this.removeModule(m);
                }
            }
            //If we are simply removing them from course
            if (course!=null){
                this.course.removeStudent(this);
                this.course = course;
                course.addStudent(this);
            }else{
                this.course.removeStudent(this);
                this.course=course;
            }
        }else{//if we are setting course
            if(course!=null){//make sure new course isnt null
                for(Module m:course.getModules()){//add modules from course
                    if(!this.modules.contains(m)){
                        this.addModule(m);
                    }
                }
                course.addStudent(this);//add student to course if not null
            }
            this.course=course;//whether null or not, set it to student
        }
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    
    //Added utility methods
    public void addModule(Module m){
        if(!this.modules.contains(m)){
            this.modules.add(m);
            m.addStudent(this);
        }   
    }
    
    public void removeModule(Module m){
        if(this.modules.contains(m)){
            this.modules.remove(m);
            m.removeStudent(this);
        }
    }
    
    public void printModules(){
        String buff = "Modules for student "+ this.name+":\n";
        for(Module m:this.modules){
            buff+=m.getModule_name()+"\n";
        }
        System.out.println(buff);
    }
    
    @Override
    public String toString(){
        String temp="Student "+this.name+"\tId: "+this.id+"\tUsername: "+this.getUsername();
        temp+="\nCourse: "+this.course.getCourse_name();
        temp+="\nModules: ";
        for(Module m:this.modules){
            temp+=m.getModule_name();
            temp+=", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        
        return temp;
    }

    @Override
    public int compareTo(Object o) {
        Student temp = (Student) o;
        return this.hashCode() - temp.hashCode();
    }
}