package ru.sbp.console_editor.file;

import ru.sbp.console_editor.menu.second_menu.SecondMenu;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class FileUtils {

    //public static final String directoryPath = "E:\\Java_Ilyha\\Console_editor_file\\src\\ru\\sbp\\console_editor\\file\\box_file\\";

    public static String directoryPath() {
        return new File("src\\ru\\sbp\\console_editor\\file\\box_file\\").getAbsolutePath();
    }

    public boolean createFile(String nameFile) throws IOException {
        File dir = new File(directoryPath(), txt(nameFile));
        return dir.createNewFile();
    }

    public static File[] catalogFile() {
            File directory = new File(directoryPath());
        if (directory.isDirectory()) {
            return directory.listFiles();
        } else return new File[0];
    }

    public File selectedFile (int num) {
        return Objects.requireNonNull(catalogFile())[num];
    }

    public static void fileReader (File file) {
        StringBuilder sb = new StringBuilder();
        try(FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);) {
            while (scan.hasNextLine()) {
                sb.append(scan.nextLine());
                sb.append("\n");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(sb);
    }

    public static boolean reName(String nameFile) {
        File newName = new File(directoryPath()+nameFile);
        return SecondMenu.selectedFile.renameTo(newName);
    }

    public static void contentChange (String content) {
        try (FileWriter writer = new FileWriter(SecondMenu.selectedFile, false)) {
            writer.write(content);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String txt(String nameFile) {
        if (!nameFile.contains(".txt")) nameFile = String.format("%s.txt", nameFile);
        return nameFile;
    }

    public static boolean deleteFile (File file) {
        return file.delete();
    }
}
