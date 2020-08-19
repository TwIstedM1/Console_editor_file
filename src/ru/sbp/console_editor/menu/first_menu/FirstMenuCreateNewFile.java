package ru.sbp.console_editor.menu.first_menu;

import ru.sbp.console_editor.file.FileUtils;
import ru.sbp.console_editor.menu.Menu;
import ru.sbp.console_editor.menu.second_menu.SecondMenu;

import java.io.IOException;

public class FirstMenuCreateNewFile implements Menu {
    @Override
    public Menu handleInput(String nameFile) {
        FileUtils file = new FileUtils();
        try {
            file.createFile(nameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл успешно создан.");
        return new SecondMenu();
    }

    @Override
    public void drawMenu() {
        System.out.println("Введите имя файла:");
    }
}
