package org.shujaat;

import java.io.File;

public class App {
    public static void main(String[] args) {
        // --> mini tasks , give the root folder , and the keyword , find the keyword in
        // the files , if the file is the directory go isnide the direcotry and do the
        // same

        // first let me try to list all the files of the root folder;

        final String rootFolderPath = "/home/snowblind/vscodeProjects";

        File folder = new File(rootFolderPath);

        // checking if the dir exists or is it vaild
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Either the folder does not exist , or the folder path is invalid");
            return;
        }

        String[] dirEntities = folder.list();

        // now the problem if the dirEntites is a file just stop and print the name , if
        // the dirEntity is a direcotry , keep going insider unit the files is found and
        // return the file

        for (String entity : dirEntities) {

            // trying to check if the entity is a file or folder
            File entityToRead = new File(folder, entity);

            if (entityToRead.isDirectory()) {

                File newEntityFiles = new File(entity);
                String[] newEntityFilesList = newEntityFiles.list();

                if (newEntityFilesList != null) {
                    for (String newFiles : newEntityFilesList) {
                        System.out.println(newFiles);
                    }
                }

            } else {
                System.out.println(entity);
            }

            // if have ran into a problem , the infinite subfolder -- i learned about the
            // recursion and new method called .listFiles() which gives file objects
            // directly

        }

    }

}
