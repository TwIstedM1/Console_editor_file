package ru.sbp.console_editor.menu.second_menu;

import ru.sbp.console_editor.menu.Menu;
import ru.sbp.console_editor.menu.first_menu.FirstMenu;

import java.io.File;

public class SecondMenu implements Menu {
    public static File selectedFile;

    public void drawMenu() {
        System.out.println(
                "Выберете пункт меню:" + "\n"
                        + "1. Изменить имя файла"+ "\n"
                        + "2. Изменить содержимое файла" + "\n"
                        + "3. Показать содержимое файла" + "\n"
                        + "4. Назад" + "\n"
        );
    }

    public Menu handleInput(String value) {
        switch (value) {
            case "1":
                return new SecondMenuRenameFIle();
            case "2":
                return new SecondMenuChangeFile();
            case "3":
                return new SecondMenuReadFile();
            case "4":
                return new FirstMenu();
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
    }
}
