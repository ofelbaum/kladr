package com.app.dao.impl;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;

import java.io.*;

/**
 * User: admin
 * Date: 14.10.11 21:03
 */
public class DBRead {
    public static void main(String[] args) throws IOException, DBFException {
        long start  = System.currentTimeMillis();
        InputStream inputStream = new FileInputStream("D:\\java\\gitrepo\\ws\\kladr\\KLADR.DBF");

        DBFReader reader = new DBFReader(inputStream);
        reader.setCharactersetName("Cp866");

        int numberOfFields = reader.getFieldCount();
        for (int i = 0; i < numberOfFields; i++) {
            DBFField field = reader.getField(i);
            System.out.print(field.getName());
            System.out.print("\t");
        }

//        System.out.println("");
//        int c = 0;
        Object[] rowObjects;
        while ((rowObjects = reader.nextRecord()) != null) {
//            System.out.print(c++);
            System.out.print("\t");
            for (int i = 0; i < rowObjects.length; i++) {
                String rowObject = (String) rowObjects[i];
                System.out.print(rowObject);
                System.out.print("\t");
            }
            System.out.println("");
        }
        inputStream.close();

        long stop  = System.currentTimeMillis();
        System.out.println("Takes time: " + (stop - start)/1000 + " sec");
    }
}
