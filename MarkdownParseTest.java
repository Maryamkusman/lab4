import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testTestfile() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"),MarkdownParse.getLinks(contents));
    }
    @Test
    public void testImagemd() throws IOException {
        Path fileName = Path.of("image.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(),MarkdownParse.getLinks(contents));
    }
    @Test
    public void testInvalidlink() throws IOException {
        Path fileName = Path.of("invalidlink.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(),MarkdownParse.getLinks(contents));
    }
    @Test
    public void testWhatever() throws IOException {
        Path fileName = Path.of("whatever.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("abc.com"),MarkdownParse.getLinks(contents));
    }

}