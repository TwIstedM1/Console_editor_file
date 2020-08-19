package ru.sbp.console_editor.menu;

import ru.sbp.console_editor.menu.first_menu.*;

public class Launcher {
    public void start()  {
        Menu m = new FirstMenu();
        String select;
        while(m != null) {
            m.drawMenu();
            select = InputProcessing.enterValueMenu();
            m = m.handleInput(select);
        }
    }
}
