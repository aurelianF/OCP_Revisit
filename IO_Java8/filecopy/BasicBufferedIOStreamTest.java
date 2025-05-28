package OCP_Revisit.IO_Java8.filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BasicBufferedIOStreamTest {
    public static void bufferedByteCopy(File in, File out) throws IOException {
        try (OutputStream oStream = new BufferedOutputStream(new FileOutputStream(in));
                InputStream inStream = new BufferedInputStream(new FileInputStream(out))) {
            byte[] inArr = new byte[512];
            int nrBytesRead = 0;

            while ((nrBytesRead = inStream.read(inArr)) != -1) {
                oStream.write(inArr, 0, nrBytesRead);

            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception caught");
        }
    }

    public static void main(String[] args) throws IOException /* throws FileNotFoundException */ {
        String inPath = "IO_Java8/filecopy/papa.txt";
        String outPath = "IO_Java8/filecopy/papa_out.txt";

        File outFile = new File(outPath);
        File inFile = new File(inPath);

        bufferedByteCopy(inFile, outFile);

    }
}
