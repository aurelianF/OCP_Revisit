package OCP_Revisit.IO_Java8;

import java.io.File;

public class BasicIOTest {
    public static void main(String[] args) {

        System.out.println();
        File newFile = new File("IO_Java8/BasicIOTest.java");

        if (newFile.exists()) {
            System.out.println("File exists");
            System.out.println("Absolute path = " + newFile.getAbsolutePath());
            System.out.println("Parent  = " + newFile.getParent());
        } else {
            System.out.println("File does not exist");
        }
    }

}
