package ru.sbp.console_editor.file;

import ru.sbp.console_editor.menu.second_menu.SecondMenu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class FileUtils {
    public static final String directoryPath = "E:\\Java_Ilyha\\Console_editor_file\\src\\ru\\sbp\\console_editor\\file\\box_file\\";

    public boolean createFile(String nameFile) throws IOException {
        if (!nameFile.contains(".txt")) nameFile = String.format("%s.txt", nameFile);
        File dir = new File(directoryPath+nameFile);
        return dir.createNewFile();
    }

    public static File[] catalogFile() {//вернуть массив с файлами
        File directory = new File(directoryPath);
        if (directory.isDirectory()) System.out.println(Arrays.toString(directory.listFiles()));
        return new File[0];
    }
    public File selectedFile (int num) {
        File directory = new File(directoryPath);
        File[] file = new File[directoryPath.length()];
        if (directory.isDirectory()) {
            file = directory.listFiles();
        }
        return Objects.requireNonNull(file)[num];
    }
    public static void fileReader (File file) {
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
    public static void reName(String nameFile) {
        File newName = new File(FileUtils.directoryPath+nameFile);
        if(SecondMenu.selectedFile.renameTo(newName)){
            System.out.println("Имя изменено");
        }else{
            System.out.println("Имя не изменено");
        }
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
    public static void readFile() {
        StringBuilder sb = new StringBuilder(SecondMenu.selectedFile);
        String result = sb.toString();
        System.out.println(result);
    }
}
