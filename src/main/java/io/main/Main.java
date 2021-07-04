package io.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    private static int numberOfFoldersInParentDirectory;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        File fileOrFolder = new File(args[0]);
        for (File file : fileOrFolder.listFiles()) {
            if (file.isDirectory()) numberOfFoldersInParentDirectory++;
        }
        stringBuilder.append(fileOrFolder.getName() + "\n");
        getDirsAndFiles(fileOrFolder, true);
        try (PrintStream printStream = new PrintStream(new FileOutputStream("data\\output_file.txt"))) {
            printStream.print(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getDirsAndFiles(File file, boolean isInParentFolder) {
        if (file.listFiles() != null) {
            for (int i = 0; i < file.listFiles().length; i++) {
                if (file.listFiles()[i].isDirectory()) {
                    stringBuilder.append("    |-----" + file.listFiles()[i].getName() + "\n");
                    if (isInParentFolder) numberOfFoldersInParentDirectory--;
                    getDirsAndFiles(file.listFiles()[i], false);
                } else {
                    if (numberOfFoldersInParentDirectory == 0) {
                        stringBuilder.append("            " + file.listFiles()[i].getName() + "\n");
                    } else {
                        stringBuilder.append("    |       " + file.listFiles()[i].getName() + "\n");
                    }
                }
            }
        }
    }
}
