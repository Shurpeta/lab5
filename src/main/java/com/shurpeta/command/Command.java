package com.shurpeta.command;

public interface Command {
    void execute(String details);
    String getDescription();
}