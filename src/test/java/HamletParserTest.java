import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        // Given
        HamletParser hamletParser = new HamletParser();
        String expected = hamletParser.getHamletData().replaceAll("Hamlet","Leon");
        // When
        String actual = hamletParser.changeOneWord("(Hamlet)","Leon",hamletParser.getHamletData());
        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        // Given
        HamletParser hamletParser = new HamletParser();
        String expected = hamletParser.getHamletData().replaceAll("Hamlet","Leon");
        expected = expected.replaceAll("Horatio", "Tariq");

        String actual = hamletParser.changeOneWord("(Hamlet)","Leon",hamletParser.getHamletData());
        actual = hamletParser.changeOneWord("(Horatio)","Tariq",actual);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testFindHoratio() {
        HamletParser hamletParser = new HamletParser();
        hamletParser.findHoratio(hamletParser.getHamletData());

        StringBuilder actual = hamletParser.findHoratio(hamletText);
        StringBuilder expected = new StringBuilder("");

        int index = hamletText.indexOf("Horatio");
        expected.append("Horatio found at " + index + "\n");
        while (index >= 0) {
            index = hamletText.indexOf("Horatio", index + 1);
            if(index == -1){ break;}
            expected.append("Horatio found at " + index  + "\n");
        }
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet() {
        HamletParser hamletParser = new HamletParser();
        hamletParser.findHoratio(hamletParser.getHamletData());

        StringBuilder actual = hamletParser.findHamlet(hamletText);
        StringBuilder expected = new StringBuilder("");

        int index = hamletText.indexOf("Hamlet");
        expected.append("Hamlet found at " + index + "\n");
        while (index >= 0) {
            index = hamletText.indexOf("Hamlet", index + 1);
            if(index == -1){ break;}
            expected.append("Hamlet found at " + index  + "\n");
        }
        Assert.assertEquals(expected,actual);
    }

}