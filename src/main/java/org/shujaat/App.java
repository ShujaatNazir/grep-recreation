package org.shujaat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    static boolean isPresent = false;

    public static void main(String[] args) {

        // i learned how to read from a file;
        // i learned how to list all the files in the directory
        // now combining these two i will try to make a word finder that looks into all
        // the subfolder folders of parentfolder and serachs for the result;

        final String ROOT_FOLDER_PATH = "/home/snowblind/vscodeProjects";
        final String KEYWORD = "imposter";
        File rootFolder = new File(ROOT_FOLDER_PATH);

        if (!rootFolder.exists() || !rootFolder.isDirectory()) {
            System.out.println("invalid path");
        }

        findKeyword(rootFolder, KEYWORD);

        if (isPresent) {

            System.out.println("your word was found");
        } else {
            System.out.println("your word was not found");
        }
    }

    public static void findKeyword(File folder, String keyword) {

        File[] folderEntites = folder.listFiles();

        if (folderEntites != null) {
            for (File entity : folderEntites) {

                if (entity.isDirectory()) {
                    if (!isPresent) {
                        findKeyword(entity, keyword);
                    }
                } else {
                    try (Scanner scanner = new Scanner(entity)) {
                        while (scanner.hasNext()) {
                            String word = scanner.next();

                            if (word.equalsIgnoreCase(keyword)) {
                                isPresent = true;
                                break;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
