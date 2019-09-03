package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int consoleId);

    List<Console> getAllConsoles();

    List<Console> getConsolesByManufacturer();

    void updateConsole(Console console);

    void deleteConsole(int consoleId);
}
