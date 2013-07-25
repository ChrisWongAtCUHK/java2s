package pattern;

public class ArgPattern {
	static final CharSequence target1 = ".", replacement1 = "\\.", target2  = "*", replacement2 = ".*";
	
	// Transform the argument pattern to regular expression, e.g. *.txt to .*\.txt
	public static String toRegex(String pattern){
		// Replacement for regular expression
		pattern = pattern.replace(target1, replacement1);
        pattern = pattern.replace(target2, replacement2);
        
        return pattern;
	}
}
