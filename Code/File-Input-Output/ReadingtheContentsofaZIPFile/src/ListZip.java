import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ListZip {
	public static void main(String args[]) {
		if(args.length < 1){
			System.out.println("Usage: " + System.getProperty("sun.java.command") + " zipFile");
			return;
		}
		try {
			ZipFile zf = new ZipFile(args[0]);
			Enumeration<?> entries = zf.entries();

			while (entries.hasMoreElements()) {
				ZipEntry ze = (ZipEntry) entries.nextElement();
				System.out.println(ze.getName());

				long size = ze.getSize();
				if (size > 0) {
					System.out.println("Length is " + size);

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
