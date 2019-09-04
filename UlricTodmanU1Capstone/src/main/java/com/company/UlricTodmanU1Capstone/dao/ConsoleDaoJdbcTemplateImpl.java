package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.Console;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao{
    @Override
    public Console addConsole(Console console) {
        return null;
    }

    @Override
    public Console getConsole(int consoleId) {
        return null;
    }

    @Override
    public List<Console> getAllConsoles() {
        return null;
    }

    @Override
    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return null;
    }

    @Override
    public void updateConsole(Console console) {

    }

    @Override
    public void deleteConsole(int consoleId) {

    }
}
