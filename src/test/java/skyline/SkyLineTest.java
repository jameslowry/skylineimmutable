package skyline;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SkyLineTest {


    @Test @Ignore
    public void oneBuilding() {
        assertThat(
                inputSequence("1,11,5"),
                equalTo("1,11,5,0")
        );
    }

    @Test @Ignore
    public void threeBuildings() {
        assertThat(
                inputSequence("1,11,5\n2,6,7\n3,13,9"),
                equalTo("1,11,3,13,9,0")
        );
    }

    @Test @Ignore
    public void eightBuildingsWithGap() {
        assertThat(
                inputSequence("1,11,5\n2,6,7\n3,13,9\n12,7,16\n14,3,25\n19,18,22\n23,13,29\n24,4,28"),
                equalTo("1,11,3,13,9,0,12,7,16,3,19,18,22,3,23,13,29,0")
        );
    }

    private String inputSequence(String input) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out =  new PrintStream(baos);
        InputStream in = new ByteArrayInputStream(input.getBytes());

        new SkyLine().run(in, out);

        return baos.toString();
    }
}
