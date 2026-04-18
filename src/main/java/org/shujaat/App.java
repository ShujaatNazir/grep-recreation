package org.shujaat;

import java.io.File;

public class App {

    public static void main(String[] args) {
        // --> mini tasks , give the root folder , and the keyword , find the keyword in
        // the files , if the file is the directory go isnide the direcotry and do the
        // same

        // first let me try to list all the files of the root folder;

        final String rootFolderPath = "/home/snowblind/vscodeProjects";

        File rootFolder = new File(rootFolderPath);

        // checking if the dir exists or is it vaild
        if (!rootFolder.exists() || !rootFolder.isDirectory()) {
            System.out.println("Either the folder does not exist , or the folder path is invalid");
            return;
        }

        // moved the logic into a function that will cann itself again and again unitl
        // if find the files out

        listAllFiles(rootFolder);
    }

    public static void listAllFiles(File folder) {
        File[] folderEntites = folder.listFiles(); // new nethod listFiles that return array of files and directory
                                                   // directly

        if (folderEntites != null) {
            for (File entity : folderEntites) {

                if (entity.isDirectory()) {
                    System.out.println("Entering Directory : " + entity.getAbsolutePath());
                    listAllFiles(entity);
                } else {
                    System.out.println("File : " + entity.getName());
                }
            }
        }

    }

}
