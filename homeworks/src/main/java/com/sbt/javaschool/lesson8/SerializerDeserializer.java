package com.sbt.javaschool.lesson8;

import java.io.*;
import java.util.List;

public class SerializerDeserializer {


    void serialize(String filename, Object obj, Integer listSize) throws IOException {
        if (obj instanceof List) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
                objectOutputStream.writeObject(((List) obj).subList(0, listSize));
            }
        } else {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
                objectOutputStream.writeObject(obj);
            }
        }

    }

    Object deserialize(String filename) throws IOException, ClassNotFoundException {

        if (!new File(filename).exists()) {
            return null;
        } else {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
                return in.readObject();
            }
        }
    }


}
