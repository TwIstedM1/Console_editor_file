package ru.sbp.console_editor.file;

import ru.sbp.console_editor.menu.second_menu.SecondMenu;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class FileUtils {
    public static final String directoryPath = "E:\\Java_Ilyha\\Console_editor_file\\src\\ru\\sbp\\console_editor\\file\\box_file\\";

    public boolean createFile(String nameFile) throws IOException {
        txt(nameFile);
        File dir = new File(directoryPath+nameFile);
        return dir.createNewFile();
    }
    public static File[] catalogFile() {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            return directory.listFiles();
        } else return new IOException;
    }

    public static void printCatalogFile() {
       File directory = new File(directoryPath);
       if (directory.isDirectory()) {
           int i = 0;
           for (File item: directory.listFiles()) {
               System.out.println(i + ". " + item.getName());
               i++;
           }
       }
    }

    public File selectedFile (int num) {
        return Objects.requireNonNull(SecondMenu.catalogFile)[num];
    }

    public static void fileReader (File file) {//прочесть содержимое файла
        try(FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);) {
            int i = 1;
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
                i++;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static boolean reName(String nameFile) throws IllegalStateException {
        File newName = new File(FileUtils.directoryPath+nameFile);
        if(SecondMenu.selectedFile.renameTo(newName)) return true;
        else return false; //throw new IllegalStateException("Unexpected nameFile: " + nameFile);
    }
    public static void contentChange (String content) {//наполнение файла
        try (FileWriter writer = new FileWriter(SecondMenu.selectedFile, false)) {
            String text = content;
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static String txt(String nameFile) {
        if (!nameFile.contains(".txt")) nameFile = String.format("%s.txt", nameFile);
        return nameFile;
    }
}
