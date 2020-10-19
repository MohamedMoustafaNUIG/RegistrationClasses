package org.nuig.mohdm.tests;

import org.nuig.mohdm.classes.Module;
import org.nuig.mohdm.classes.Course;
import org.nuig.mohdm.classes.Student;
import java.util.ArrayList;
import org.joda.time.DateTime;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 *
 * @author mohdm
 */
public class ModuleTest {
    private Student s1, s2;
    private Module m1, m2;
    private Course c1, c2;
    
    @Before
    public void setup(){
        s1 = new Student("Mohamed Moustafa", 22, new DateTime("1998-11-21"), 1728);
        s2 = new Student("Jonathen Nicholas", 24, new DateTime("1996-11-01"), 1708);
        
        m1 = new Module("Programming", "CT101");
        m2 = new Module("Paradigms", "CT201");
        
        c1 = new Course("CS&IT", new DateTime("2020-08-01"), new DateTime("2021-05-25"));
        c2 = new Course("ECE", new DateTime("2020-08-01"), new DateTime("2021-05-25"));
    }
    
    @Test
    public void testSetup(){
        String name1 = s1.getName();
        String name2 = s2.getName();
           
        String name3 = m1.getModule_name();
        String name4 = m2.getModule_name();
        
        String name5 = c1.getCourse_name();
        String name6 = c2.getCourse_name();
        
        assertNotNull(name1);
        assertNotNull(name2);
        assertNotNull(name3);
        assertNotNull(name4);
        assertNotNull(name5);
        assertNotNull(name6);
    }
    
    @Test
    public void testtRegistration(){
        m1.setStudents(new ArrayList<Student>());
        m1.setCourses(new ArrayList<Course>());
        
        m1.addStudent(s1);
        m1.addCourse(c1);
        
        Student expS = new Student("Mohamed Moustafa", 22, new DateTime("1998-11-21"), 1728);
        Course expC = new Course("CS&IT", new DateTime("2020-08-01"), new DateTime("2021-05-25"));
        
        assertTrue(m1.getStudents().contains(expS));
        assertTrue(m1.getCourses().contains(expC));
    }
    
    @Test
    public void testUnregistration(){
        m1.setStudents(new ArrayList<Student>());
        m1.setCourses(new ArrayList<Course>());
        
        m1.addStudent(s1);
        m1.addCourse(c1);
        
        m1.removeStudent(s1);
        m1.removeCourse(c1);
        
        Student notExpS = new Student("Mohamed Moustafa", 22, new DateTime("1998-11-21"), 1728);
        Course notExpC = new Course("CS&IT", new DateTime("2020-08-01"), new DateTime("2021-05-25"));
        
       assertFalse(m1.getStudents().contains(notExpS));
       assertFalse(m1.getCourses().contains(notExpC));
    }
}