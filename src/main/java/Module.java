/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author mohdm
 */
public class Module {
    private String module_name;
    private String id; 
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    
    public Module(String module_name, String id){
        this.module_name = module_name;
        this.id = id;
        this.students = new ArrayList<Student>(); 
        this.courses = new ArrayList<Course>();
    }
    
    @Override
    public int hashCode(){
        return this.id!= null? this.id.hashCode():0;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o){return true;}
        if(o == null || getClass()!= o.getClass()) {return false;}
        
        Module temp = (Module) o;
        
        return (this.id).equals(temp.getId());
    }
    
    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
    //Added utility methods
    public void addStudent(Student s){
        if(!this.students.contains(s)){
            this.students.add(s);
            s.addModule(this);
        }
    }
    public void removeStudent(Student s){
        if(this.students.contains(s)){
            this.students.remove(s);
            s.removeModule(this);
        }
    }
    public void printStudents(){
        String buff = "Students in module "+ this.module_name+":\n";
        for(Student s:this.students){
            buff+=s.getName()+"\n";
        }
        System.out.println(buff);
    }
    
    public void addCourse(Course c){
        if(!this.courses.contains(c)){
            this.courses.add(c);
            c.addModule(this);
        }
    }
    
    public void removeCourse(Course c){
        if(this.courses.contains(c)){
            this.courses.remove(c);
            c.removeModule(this);
        }
    }
    public void printCourses(){
        String buff = "Courses with module "+ this.module_name+":\n";
        for(Course c:this.courses){
            buff+=c.getCourse_name()+"\n";
        }
        System.out.println(buff);
    }
    
    @Override
    public String toString(){
        String temp="Module "+this.module_name+"\tId: "+this.id;
        temp+="\nCourses: ";
        for(Course c:this.courses){
            temp+=c.getCourse_name();
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