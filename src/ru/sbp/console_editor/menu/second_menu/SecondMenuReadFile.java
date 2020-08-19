package ru.sbp.console_editor.menu.second_menu;

import ru.sbp.console_editor.file.FileUtils;
import ru.sbp.console_editor.menu.Menu;

public class SecondMenuReadFile implements Menu {
    @Override
    public Menu handleInput(String value) {
        FileUtils.readFile();
        //FileUtils.fileReader(SecondMenu.selectedFile);
        return new SecondMenu();
    }

    @Override
    public void drawMenu() {
        System.out.printf("Содержимое файла:%s%n", SecondMenu.selectedFile);
    }
}
