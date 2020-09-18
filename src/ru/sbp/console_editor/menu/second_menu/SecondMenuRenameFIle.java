package ru.sbp.console_editor.menu.second_menu;

import ru.sbp.console_editor.file.FileUtils;
import ru.sbp.console_editor.menu.Menu;
import ru.sbp.console_editor.menu.first_menu.FirstMenu;

import java.io.File;

public class SecondMenuRenameFIle implements Menu {
    @Override
    public Menu handleInput(String nameFile) {
        String txtnameFile = FileUtils.txt(nameFile);
        FileUtils.reName(txtnameFile);
        System.out.println("Имя файла изменено");
        return new FirstMenu();
    }

    @Override
    public void drawMenu() {
        System.out.println("Введите имя файла:");
    }
}
