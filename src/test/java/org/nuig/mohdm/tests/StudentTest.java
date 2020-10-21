package org.nuig.mohdm.tests;

import org.nuig.mohdm.classes.Module;
import org.nuig.mohdm.classes.Course;
import org.nuig.mohdm.classes.Student;
import java.util.ArrayList;
import java.util.Collections;
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
public class StudentTest {
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
    public void testUsername(){
        String expected = "Mohamed Moustafa22";
        String retrieved = s1.getUsername();
        assertEquals(expected, retrieved);

        expected = "Jonathen Nicholas24";
        retrieved = s2.getUsername();
        assertEquals(expected, retrieved);    
    }
    
    @Test
    public void testModuleRegistration(){
        s1.setModules(new ArrayList<Module>());
        
        s1.addModule(m1);
        s2.addModule(m2);
        
        Module expM1 = new Module("Programming", "CT101");
        Module expM2 = new Module("Paradigms", "CT201");
        
        assertTrue(s1.getModules().contains(expM1));
        assertTrue(s2.getModules().contains(expM2));
    }
    
    @Test
    public void testModuleRemoval(){
        s1.removeModule(m1);
        s1.removeModule(m2);
        
        assertEquals(s1.getModules().size(), 0);
        assertEquals(s2.getModules().size(), 0);
    }
    
    @Test
    public void testCourseRegistration(){
        s1.setCourse(c1);
        s2.setCourse(c2);
        
        Course expC1 = new Course("CS&IT", new DateTime("2020-08-01"), new DateTime("2021-05-25"));
        Course expC2 = new Course("ECE", new DateTime("2020-08-01"), new DateTime("2021-05-25"));
        
        assertTrue(s1.getCourse().equals(expC1));
        assertTrue(s2.getCourse().equals(expC2));
        
        ArrayList<Module> mods1 = new ArrayList<Module>();
        ArrayList<Module> mods2 = new ArrayList<Module>();
        
        mods1 = s1.getModules();
        mods2 = expC1.getModules();
        
        Collections.sort(mods1);
        Collections.sort(mods2);
        
        assertTrue(mods1.equals(mods2));
        
        mods1 = s2.getModules();
        mods2 = expC2.getModules();
        
        Collections.sort(mods1);
        Collections.sort(mods2);
        
        assertTrue(mods1.equals(mods2));
    }
    
    @Test
    public void testCourseRemoval(){
        s1.setCourse(c1);
        s2.setCourse(c2);
        
        Course expC1 = new Course("BME", new DateTime("2020-08-01"), new DateTime("2021-05-25"));
        Course expC2 = new Course("MED", new DateTime("2020-08-01"), new DateTime("2021-05-25"));
        
        assertFalse(s1.getCourse().equals(expC1));
        assertFalse(s2.getCourse().equals(expC2));
    }
}