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
public class CourseTest {
    private Student s1, s2;
    private Module m1, m2;
    private Course c1, c2;
    
    @Before
    public void setup(){
        s1 = new Student("Mohamed Moustafa", 22, new DateTime("1998-11-21"), 1728);
        
        m1 = new Module("Programming", "CT101");
        
        c1 = new Course("CS&IT", new DateTime("2020-08-01"), new DateTime("2021-05-25"));
    }
    
    @Test
    public void testSetup(){
        String name1 = s1.getName();
        String name2 = m1.getModule_name();
        String name3 = c1.getCourse_name();
        
        assertNotNull(name1);
        assertNotNull(name2);
        assertNotNull(name3);
    }
    
    @Test
    public void testRegistration(){
        c1.addStudent(s1);
        c1.addModule(m1);
        
        Student expS = new Student("Mohamed Moustafa", 22, new DateTime("1998-11-21"), 1728);
        Module expM = new Module("Programming", "CT101");
        
        assertTrue(c1.getStudents().contains(expS));
        assertTrue(c1.getModules().contains(expM));
    }
    
    @Test
    public void testUnregistration(){
        c1.setStudents(new ArrayList<Student>());
        c1.setModules(new ArrayList<Module>());
        
        c1.addStudent(s1);
        c1.addModule(m1);
        
        c1.removeStudent(s1);
        c1.removeModule(m1);
        
        Student notExpS = new Student("Mohamed Moustafa", 22, new DateTime("1998-11-21"), 1728);
        Module notExpM = new Module("Programming", "CT101");
        
       assertFalse(c1.getStudents().contains(notExpS));
       assertFalse(c1.getModules().contains(notExpM));
    }
}