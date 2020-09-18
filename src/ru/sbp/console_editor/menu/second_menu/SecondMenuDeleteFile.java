package ru.sbp.console_editor.menu.second_menu;

import ru.sbp.console_editor.file.FileUtils;
import ru.sbp.console_editor.menu.Menu;
import ru.sbp.console_editor.menu.first_menu.FirstMenu;

public class SecondMenuDeleteFile implements Menu {

    @Override
    public Menu handleInput(String value) {
        FileUtils.deleteFile(SecondMenu.selectedFile);
        return new FirstMenu();
    }

    @Override
    public void drawMenu() {
        System.out.println("Файл удален.");
    }
}
