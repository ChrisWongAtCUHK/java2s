import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// http://www.vogella.com/articles/JavaRegularExpressions/article.html
public class RegExpExample {
	public static final String EXAMPLE_TEST = "This is my small example "
		      + "string which I'm going to " + "use for pattern matching.";
  public static void main(String args[]) {
	  System.out.println(EXAMPLE_TEST.matches("\\w.*"));
	    String[] splitString = (EXAMPLE_TEST.split("\\s+"));
	    System.out.println(splitString.length);// Should be 14
	    for (String string : splitString) {
	      System.out.println(string);
	    }
	    // Replace all whitespace with tabs
	    System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
  }
}