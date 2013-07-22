import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ReadZip {
	public static void main(String args[]) {
		if(args.length < 1){
			System.out.println("Usage: " + System.getProperty("sun.java.command") + " zipFile");
			return;
		}
		try {
			ZipFile zf = new ZipFile(args[0]);
			Enumeration<?> entries = zf.entries();

			 BufferedReader input = new BufferedReader(new
			 InputStreamReader(System.in));
			while (entries.hasMoreElements()) {
				ZipEntry ze = (ZipEntry) entries.nextElement();
				System.out.println(ze.getName());
				String inputLine = input.readLine();
				if (inputLine.equalsIgnoreCase("yes")) {
					long size = ze.getSize();
					if (size > 0) {
						System.out.println("Length is " + size);

						BufferedReader br = new BufferedReader(
								new InputStreamReader(zf.getInputStream(ze)));
						String line;
						while ((line = br.readLine()) != null) {
							System.out.println(line);
						}
						br.close();

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}