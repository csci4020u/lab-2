import org.junit.*;
import static org.junit.Assert.*;
import java.util.regex.*;

public class TestRE {
    static String goodMatch1 = "import java.util.*;";
    static String goodMatch2 = "import java.util.List;";
    static String goodMatch3 = "import static java.lang.System.out;";
    static String goodMatch4 = "   import static java.lang.System.out;   ";

    static String badMatch1 = "import java;";
    static String badMatch2 = "import .*;";
    static String badMatch3 = "import java.util.List";
    static String badMatch4 = "import java.util. List;";

    @Test
    public void TestMatch() {
        Pattern pat = Main.importPattern;
        assertTrue("goodMatch1", Main.isValidString(pat, goodMatch1));
        assertTrue("goodMatch2", Main.isValidString(pat, goodMatch2));
        assertTrue("goodMatch3", Main.isValidString(pat, goodMatch3));
        assertTrue("goodMatch4", Main.isValidString(pat, goodMatch4));

        assertTrue("badMatch1", !Main.isValidString(pat, badMatch1));
        assertTrue("badMatch2", !Main.isValidString(pat, badMatch2));
        assertTrue("badMatch3", !Main.isValidString(pat, badMatch3));
        assertTrue("badMatch4", !Main.isValidString(pat, badMatch4));
    }

    static String goodSearch1 = "class X {";
    static String goodSearch2 = "public class X";
    static String goodSearch3 = "public static class X { }";

    static String badSearch1 = "Class X";
    static String badSearch2 = "hello world";

    @Test
    public void TestSearch() {
        Pattern pat = Main.classDeclPattern;

        assertTrue("goodSearch1", Main.contains(pat, goodSearch1));
        assertTrue("goodSearch2", Main.contains(pat, goodSearch2));
        assertTrue("goodSearch3", Main.contains(pat, goodSearch3));

        assertTrue("badSearch1", !Main.contains(pat, badSearch1));
        assertTrue("badSearch2", !Main.contains(pat, badSearch2));
    }

    static String line1 = "String name = person.getName();";
    static String line2 = "total.add(num.getValue())";
    static String line3 = "a.add(1) + b.subtract(a.multiply(3))";

    @Test
    public void TestExtract() {
        String[][] results;
        Pattern pat = Main.invokePattern;

        results = Main.findMatches(pat, line1);
        assertSame(results, new String[][] {
            new String[]{"person", "getName"}
        });

        results = Main.findMatches(pat, line2);
        assertSame(results, new String[][] {
            new String[]{"total", "add"},
            new String[]{"num", "getValue"}
        });

        results = Main.findMatches(pat, line3);
        assertSame(results, new String[][] {
            new String[]{"a", "add"},
            new String[]{"b", "subtract"},
            new String[]{"a", "multiply"}
        });
    }

    public static void assertSame(String[][] x, String[][] y) throws AssertionError {
        if(x == null && y != null) fail();
        if(x != null && y == null) fail();

        assertEquals(x.length, y.length);
        for(int i=0; i < x.length; i++) {
            assertArrayEquals(x[i], y[i]);
        }
    }
}
