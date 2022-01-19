package io.main;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        FileOrFolderHandler.printFolder(new File("D:\\epam-demo\\java\\java-course\\target"), 0);
        FileOrFolderHandler.readFile(new File("D:\\epam-demo\\java\\java-course\\data\\output_file.txt"));
    }
}
