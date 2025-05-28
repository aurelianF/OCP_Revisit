/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package OCP_Revisit.IO_Java8.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author aureianF
 */
public class ByteBasedFileCopy {
    public static void fileCopy(File in, File out) throws IOException {
        try (InputStream inS = new FileInputStream(in);
                OutputStream outS = new FileOutputStream(out)) {
            int b;
            while ((b = inS.read()) != -1) {
                System.out.printf("Byte is: %x\n", b);
                outS.write(b);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception caught");
        }
    }

    public static void main(String[] args) throws IOException {

        String inPath = "IO_Java8/filecopy/papa.txt";
        String outPath = "IO_Java8/filecopy/papa_out2.txt";

        fileCopy(new File(inPath),
                new File(outPath));
    }

}
