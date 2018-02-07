/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_master;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Batoul
 */
public class FileOperations {

    public static void readFromFile(List list) {
        File file = new File("./src/dictionary_master/classes.txt");
        Scanner readfile = null;
        try {
            readfile = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (readfile.hasNext()) {
            String str = readfile.nextLine();
            list.add(str);
        }
        readfile.close();
    }

    public static boolean searchFile(String s) {
        List<String> searchList = new ArrayList();
        readFromFile(searchList);
        for (String temp : searchList) {
            if (temp.equals(s)) {
                System.out.println("class name exists");
                return true;

            }
        }
        return false;
    }

    public static void writeToFile(String s) {
        FileWriter classesFile = null;
        try {
            classesFile = new FileWriter("./src/dictionary_master/classes.txt", true);
        } catch (IOException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bf = new BufferedWriter(classesFile);
        PrintWriter pw = new PrintWriter(bf);
        pw.println(s);
        pw.close();
    }

    public static void createFile(ArrayList<MyField> attributes, String filename) throws FileNotFoundException {
        //FileWriter classFile = null;
        String path = "./src/dictionary_master/fileFolder/" + filename + ".txt";
        PrintWriter pw = new PrintWriter(path);
        for (MyField f : attributes) {
            pw.print(f.attType + " ");
            pw.println(f.attName);

        }
        pw.close();
    }

    public static void readCreatedFile(String filename, List list) {
        String path = "./src/dictionary_master/fileFolder/" + filename + ".txt";
        File file = new File(path);
        Scanner readfile = null;
        try {
            readfile = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (readfile.hasNext()) {
            String str = readfile.nextLine();
            list.add(str);
        }
        readfile.close();
    }

}
