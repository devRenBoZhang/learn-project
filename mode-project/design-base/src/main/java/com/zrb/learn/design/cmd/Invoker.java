package com.zrb.learn.design.cmd;

public class Invoker {
    private Command command;


    public void execute() {
        command.invoke(null);
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
