package Tests;


import Logic.Md5;
import static org.junit.Assert.*;

public class Md5Test {

    @org.junit.Test
    public void testMd5(){
        assertNotEquals(Md5.md5("12345"), Md5.md5("123"));
        assertEquals(Md5.md5("12345"), Md5.md5("12345"));
    }
}
