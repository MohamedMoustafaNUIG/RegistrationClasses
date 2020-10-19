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
public class Course {
    private String course_name;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private DateTime start_date;
    private DateTime end_date; 
    
    public Course(String course_name, DateTime start_date, DateTime end_date){
        this.course_name = course_name;
        this.modules = new ArrayList<Module>();
        this.students = new ArrayList<Student>();
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
    @Override
    public int hashCode(){
        return this.course_name==null? 0:this.course_name.hashCode();
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o){return true;}
        if(o == null || getClass()!= o.getClass()) {return false;}
        
        Course temp = (Course) o;
        
        return (this.course_name).equals(temp.getCourse_name());
    }
    
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public DateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(DateTime start_date) {
        this.start_date = start_date;
    }

    public DateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(DateTime end_date) {
        this.end_date = end_date;
    }
    
    //Added utility methods
    public void addStudent(Student s){
        if(!this.students.contains(s)){
            this.students.add(s);
            s.setCourse(this);
        }
    }
    public void removeStudent(Student s){
        if(this.students.contains(s)){
            this.students.remove(s);
            s.setCourse(null);
        }
    }
    public void printStudents(){
        String buff = "Students in course "+ this.course_name+":\n";
        for(Student s:this.students){
            buff+=s.getName()+"\n";
        }
        System.out.println(buff);
    }
    
    public void addModule(Module m){
        if(!this.modules.contains(m)){
            this.modules.add(m);
            m.addCourse(this);
        }
    }
    public void removeModule(Module m){
        if(this.modules.contains(m)){
            this.modules.remove(m);
            m.removeCourse(this);
        }
    }
    public void printModules(){
        String buff = "Modules in course "+ this.course_name+":\n";
        for(Module m:this.modules){
            buff+=m.getModule_name()+"\n";
        }
        System.out.println(buff);
    }
    
    @Override
    public String toString(){
        String temp="Course "+this.course_name;
        temp+="\nModules: ";
        for(Module m:this.modules){
            temp+=m.getModule_name();
            temp+=", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        temp+="\nStudents: ";
        for(Student s:this.students){
            temp+=s.getName();
            temp+=", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        return temp;
    }
}