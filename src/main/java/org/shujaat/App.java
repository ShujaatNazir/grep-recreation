package org.shujaat;

import java.io.File;
import java.io.IOException;
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

        if (args.length < 2) {
            System.out.println("Usage : findword <path> <keyword>");
            return;
        }
        final String ROOT_FOLDER_PATH = args[0];
        final String KEYWORD = args[1];

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

        if (!files.isEmpty()) {
            for (File file : files) {
                int lineNumber = 0;

                try (Scanner scanner = new Scanner(file)) {

                    while (scanner.hasNext()) {
                        lineNumber++;
                        String line = scanner.nextLine();

                        if (line.toLowerCase().contains(keyword.toLowerCase())) {

                            System.out.println("your word " + keyword + " was found in file : " + file.getAbsolutePath()
                                    + " at line number " + lineNumber);
                            System.out.println("---------------------------------------------------");
                            return;
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!isPresent) {
            System.out.println("your word not found in the directory");
        }
    }
}
