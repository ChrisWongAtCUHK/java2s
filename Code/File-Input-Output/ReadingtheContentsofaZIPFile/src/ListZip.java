import zip.list.ListedZip;
import java.util.ArrayList;
import java.util.zip.ZipEntry;

// List the content of zip file
public class ListZip {
	public static void main(String args[]) {
		String filename = "";
		String pattern = "*";
		
		if(args.length == 2){
			filename = args[0];
			pattern = args[1];
		} else if(args.length == 1){
			filename = args[0];
		} else {
			System.out.println("Usage: java -jar " + System.getProperty("sun.java.command") + " zipFile [pattern]");
			return;
		}
		
		ListedZip listedZip = new ListedZip(args[0]);
		ArrayList<ZipEntry> zeList = listedZip.list(pattern);
		
		for(ZipEntry ze: zeList){
			System.out.println(ze.getName());
		}
		
	}
}
