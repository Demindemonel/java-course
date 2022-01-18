package io.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileOrFolderHandler {
    private static List<Integer> filenameLength = new ArrayList<>();
    private static List<Integer> filesInFolder = new ArrayList<>();
    private static int totalNumberOfFolders;
    private static int totalNumberOfFiles;
    private static int numberOfFoldersInParentDirectory;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void processingAFileOrFolder(String[] args) {
        if (args.length <= 0) {
            throw new NullPointerException();
        }
        File fileOrFolder = new File(args[0]);
        if (fileOrFolder.isDirectory()) {
            printFolder(fileOrFolder);
        } else {
            readFile(fileOrFolder);
        }
    }

    private static void readFile(File file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            StringBuilder stringBuffer = new StringBuilder();
            String line;
            int filesInFolderCounter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                if (stringBuffer.toString().equals("    |")) {
                    filesInFolder.add(filesInFolderCounter);
                    filesInFolderCounter = 0;
                    stringBuffer.delete(0, stringBuffer.length());
                    continue;
                }
                if (stringBuffer.toString().startsWith("    |-----")) {
                    totalNumberOfFolders++;
                } else if (stringBuffer.toString().startsWith("    |       ") || stringBuffer.toString().startsWith("            ")) {
                    totalNumberOfFiles++;
                    filenameLength.add(stringBuffer.toString().length());
                    filesInFolderCounter++;
                } else {
                    totalNumberOfFolders++;
                    filesInFolder.add(filesInFolderCounter);
                }
                stringBuffer.delete(0, stringBuffer.length());
            }
            filesInFolder.add(filesInFolderCounter);
            System.out.println(totalNumberOfFolders);
            System.out.println(totalNumberOfFiles);
            System.out.println(filenameLength.stream().mapToInt(value -> value).average().getAsDouble());
            System.out.println(filesInFolder.stream().mapToInt(value -> value).average().getAsDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFolder(File folder) {
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory()) {
                numberOfFoldersInParentDirectory++;
            }
        }
        stringBuilder.append(folder.getName()).append("\n");
        getDirsAndFiles(folder, true);
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
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
                    if (isInParentFolder) {
                        numberOfFoldersInParentDirectory--;
                    }
                    getDirsAndFiles(file.listFiles()[i], false);
                } else {
                    if (numberOfFoldersInParentDirectory == 0) {
                        stringBuilder.append("            ");
                    } else {
                        stringBuilder.append("    |       ");
                    }
                    stringBuilder.append(file.listFiles()[i].getName()).append("\n");
                }
            }
        }
    }
}
