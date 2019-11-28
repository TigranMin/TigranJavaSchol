package com.sbt.javaschool.lesson8;

import java.io.*;

public class SerializerDeserializer {

    void serialize(String filename, Object obj) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(obj);
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
