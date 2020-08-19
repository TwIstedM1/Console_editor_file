package ru.sbp.console_editor.menu.second_menu;

import ru.sbp.console_editor.file.FileUtils;
import ru.sbp.console_editor.menu.Menu;

public class SecondMenuChangeFile implements Menu {
    @Override
    public Menu handleInput(String content) {
        FileUtils.contentChange(content);
        System.out.println("Наполнение файла изменено.");
        return new SecondMenu();
    }

    @Override
    public void drawMenu() {
        System.out.println("Введите наполнение файла:");
    }
}
