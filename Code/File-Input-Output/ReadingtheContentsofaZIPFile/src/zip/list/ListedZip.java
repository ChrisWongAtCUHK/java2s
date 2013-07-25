package zip.list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import pattern.ArgPattern;
public class ListedZip {
	private ZipFile zf;
	private String pattern;
	
	// Constructor
	public ListedZip(String zipName){
		try {
			this.zf = new ZipFile(zipName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	// Get the content of the zip
	public ArrayList<ZipEntry> list(){
		Enumeration<?> entries = this.zf.entries();
		ArrayList<ZipEntry> list = new ArrayList<ZipEntry>();
		
		while (entries.hasMoreElements()) {
			ZipEntry ze = (ZipEntry) entries.nextElement();
			list.add(ze);
		}
		
		return list;
	}
	
	// Get the content of the zip with specific pattern
	public ArrayList<ZipEntry> list(String pattern){
		String regex = ArgPattern.toRegex(pattern);
		
		Enumeration<?> entries = this.zf.entries();
		ArrayList<ZipEntry> list = new ArrayList<ZipEntry>();
		
		while (entries.hasMoreElements()) {
			ZipEntry ze = (ZipEntry) entries.nextElement();
			if((ze.getName() != "") && ze.getName().matches(regex)){
				list.add(ze);
			}
		}
		
		return list;
	}
}
