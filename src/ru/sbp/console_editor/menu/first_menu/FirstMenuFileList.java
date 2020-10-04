package ru.sbp.console_editor.menu.first_menu;

import ru.sbp.console_editor.file.*;
import ru.sbp.console_editor.menu.Menu;
import ru.sbp.console_editor.menu.second_menu.SecondMenu;

import java.io.File;

import static ru.sbp.console_editor.menu.second_menu.SecondMenu.selectedFile;

public class FirstMenuFileList implements Menu {
    @Override
    public Menu handleInput(String number) {
        int num = Integer.parseInt(number);
        FileUtils file = new FileUtils();
        selectedFile = file.selectedFile(num);
        System.out.printf("Выбран: %s\n", selectedFile);
        return new SecondMenu();
    }
    @Override
    public void drawMenu() {
        System.out.println("Список файлов:");
        File directory = new File(FileUtils.directoryPath());
        if (directory.isDirectory()) {
            int i = 0;
            for (File item: FileUtils.catalogFile()) {//File item: catalogFile()directory.listFiles()
                System.out.println(i + ". " + item.getName());
                i++;
            }
        }
        System.out.println("Выберите файл:");
    }
}
