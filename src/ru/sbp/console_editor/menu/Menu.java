package ru.sbp.console_editor.menu;

public interface Menu {
    Menu handleInput(String value);
    void drawMenu();
}
