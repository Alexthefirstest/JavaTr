package by.javaTr.financeAccounting.controller;

import by.javaTr.financeAccounting.controller.command.Command;

public final class Controller {

    Controller() {
    }

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {

        String commandName;
        Command executionCommand;

        commandName = request.split(" ")[0];
        executionCommand = provider.getCommand(commandName);

        return executionCommand.execute(request);//response
    }

}
