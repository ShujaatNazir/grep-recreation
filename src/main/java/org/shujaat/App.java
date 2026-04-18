package org.shujaat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static boolean isPresent = false;

    public static void main(String[] args) {

        // i learned how to read from a file;
        // i learned how to list all the files in the directory
        // now combining these two i will try to make a word finder that looks into all
        // the subfolder folders of parentfolder and serachs for the result;

        ArrayList<File> filesList = new ArrayList<>();
        final String ROOT_FOLDER_PATH = "/home/snowblind/vscodeProjects";
        final String KEYWORD = "labubu";
        File rootFolder = new File(ROOT_FOLDER_PATH);

        if (!rootFolder.exists() || !rootFolder.isDirectory()) {
            System.out.println("invalid path");
        }

        ArrayList<File> allDirFiles = getAllFiles(rootFolder, filesList);
        readFiles(allDirFiles, KEYWORD);
    }

    public static ArrayList<File> getAllFiles(File folder, ArrayList<File> list) {

        File[] folderEntities = folder.listFiles();

        if (folderEntities != null) {

            for (File entity : folderEntities) {
                if (entity.isDirectory()) {

                    getAllFiles(entity, list);
                } else {

                    list.add(entity);
                }
            }
        }

        return list;
    }

    public static void readFiles(ArrayList<File> files, String keyword) {

    }
}
