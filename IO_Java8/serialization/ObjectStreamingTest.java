/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package OCP_Revisit.IO_Java8.serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aurelianF
 */
public class ObjectStreamingTest {

    public static void objDeserialize(File file, List<Animal> outputList) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (true) {
                Object obj = inStream.readObject();
                if (obj instanceof Animal) {
                    Animal a = (Animal) obj;
                    outputList.add(a);
                } else {
                    throw new InvalidClassException("Wrong class of the deserialized object");
                }
            }

        } catch (EOFException e) {
            // TODO: handle exception
            System.out.println("EOFException caught");
        }
    }

    public static void objSerializa(List<Animal> list, File file) throws IOException {
        try (ObjectOutputStream oStream = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            for (Animal animal : list) {
                oStream.writeObject(animal);
            }
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        File dataFile = new File("IO_Java8/serialization/animal.data");
        // File dataFile = new File("OCP_Revisit/IO_Java8/serialization/animal.data");
        if (!dataFile.exists()) {
            System.out.println("dataFile does NOT exist");
        }

        List<Animal> myList = new ArrayList<>();
        myList.add(new Animal("Marcel", 3, 'B'));
        myList.add(new Animal("Joiana", 2, 'V'));

        List<Animal> outList = new ArrayList<>();

        objSerializa(myList, dataFile);
        objDeserialize(dataFile, outList);

        System.out.println(myList.equals(outList));

    }
}
