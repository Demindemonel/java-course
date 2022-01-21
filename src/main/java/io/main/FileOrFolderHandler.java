package io.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOrFolderHandler {
    private static List<Integer> filenameLength = new ArrayList<>();
    private static List<Integer> filesInFolder = new ArrayList<>();
    private static int totalNumberOfFolders;
    private static int totalNumberOfFiles;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void readFile(File file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            StringBuilder builder = new StringBuilder();
            String line;
            int lastIndexOfFolder = 0;
            int lastIndexOfFile = 0;
            int filesInFolderCounter = 0;
            boolean isWasInFolder = false;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
                if (builder.toString().contains("|-----")) {
                    if (isWasInFolder && (lastIndexOfFolder <= builder.toString().lastIndexOf("|-----") || lastIndexOfFolder > builder.toString().lastIndexOf("|-----"))) {
                        filesInFolder.add(filesInFolderCounter);
                        filesInFolderCounter = 0;
                    }
                    lastIndexOfFolder = builder.toString().lastIndexOf("|-----");
                    isWasInFolder = true;
                    totalNumberOfFolders++;
                } else if (builder.toString().contains("|     ")) {
                    if (isWasInFolder && lastIndexOfFolder < builder.lastIndexOf("|     ")) {
                        filesInFolderCounter++;
                    }
                    lastIndexOfFile = builder.toString().lastIndexOf("|     ");
                    totalNumberOfFiles++;
                    filenameLength.add(builder.substring(builder.lastIndexOf("|     ") + 6).length());
                }
                builder.delete(0, builder.length());
            }
            if (lastIndexOfFile > lastIndexOfFolder) {
                filesInFolder.add(filesInFolderCounter);
            }
            System.out.println("Всего папок: " + totalNumberOfFolders);
            System.out.println("Всего файлов: " + totalNumberOfFiles);
            System.out.println("Средняя длина имени файла: " + filenameLength.stream().mapToInt(value -> value).average().getAsDouble());
            System.out.println("Среднее количество файлов в папке: " + filesInFolder.stream().mapToInt(value -> value).average().getAsDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFolder(File file, int indent) {
        stringBuilder.append(printIndent(indent, true)).append(file.getName()).append("\n");
        for (File fileOrFolder : file.listFiles()) {
            if (!fileOrFolder.isDirectory()) {
                stringBuilder.append(printIndent(indent + 1, false)).append(fileOrFolder.getName()).append("\n");
            }
        }
        for (File fileOrFolder : file.listFiles()) {
            if (fileOrFolder.isDirectory()) {
                printFolder(fileOrFolder, indent + 1);
            }
        }
        try (PrintStream printStream = new PrintStream(new FileOutputStream("data\\output_file.txt"))) {
            printStream.print(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String printIndent(int indent, boolean isFolder) {
        StringBuilder sb = new StringBuilder();
        String indentString = isFolder ? "-----" : "     ";
        if (indent == 1) {
            sb.append("    |").append(indentString);
        }
        if (indent > 1) {
            sb.append("    |");
            for (int i = indent; i > 1; i--) {
                sb.append("     ");
            }
            sb.append("|").append(indentString);
        }
        return sb.toString();
    }
}
