package carhiring.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Model.java
 *
 * @version 1.0
 * <p>
 * It is the Model (part of MVC).
 * All of the models will be inherited
 * from here and will be used in controllers.
 */
public abstract class Model {

    /**
     * Default Constructor.
     */
    public Model() {

    }

    /**
     * To initialise the data of the model.
     */
    public abstract void initData();

    /**
     * It will save the serialized data into
     * the file.
     *
     * @param filename on which data will be written.
     * @param data     to be saved
     * @throws IOException if any IO issue occur.
     */
    public void saveData(String filename, List<? extends Serializable> data) throws IOException {

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(data);
        objectOutputStream.close();

    }

    /**
     * It will read the serialized data from the
     * file and return it in list.
     *
     * @param filename from data will be read
     * @return list of data
     * @throws IOException            if any IO issue occur
     * @throws ClassNotFoundException if data is different.
     */
    public List<? extends Serializable> readData(String filename) throws IOException, ClassNotFoundException {

        List<? extends Serializable> data = null;
        File file = new File(filename);
        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            data = (List<? extends Serializable>) objectInputStream.readObject();
            objectInputStream.close();
        }
        if (data == null) {
            data = new ArrayList<>();
        }
        return data;

    }

}
