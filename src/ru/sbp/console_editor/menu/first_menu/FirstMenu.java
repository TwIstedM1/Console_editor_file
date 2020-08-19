package ru.sbp.console_editor.menu.first_menu;

import ru.sbp.console_editor.menu.Menu;

public class FirstMenu implements Menu {
    public void drawMenu() {
        System.out.println(
                "Выберете пункт меню:" + "\n"
                        + "1. Посмотреть список файлов"
                        + "\n" + "2. Создать файл" + "\n"
                        + "q. Выход" + "\n");
    }

    public Menu handleInput (String value) {
        switch (value){
            case "1":
                return new FirstMenuFileList();
            case "2":
                return new FirstMenuCreateNewFile();
            case "q":
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
    return null;
    }
}
