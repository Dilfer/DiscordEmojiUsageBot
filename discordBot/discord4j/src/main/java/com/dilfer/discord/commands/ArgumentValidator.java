package com.dilfer.discord.commands;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ArgumentValidator
{
    static List<String> getArguments(ServerCommand command, String message) throws InvalidArgumentsException
    {
        String messageWithoutCommand = message.replace(command.getCommandString(), "");
        List<String> suppliedArguments = Arrays
                .stream(messageWithoutCommand.split(" "))
                .filter(string -> string.length() > 0)
                .collect(Collectors.toList());
        if (command.getArguments().size() != suppliedArguments.size())
        {
            throw new InvalidArgumentsException(String.format("Incorrect arguments supplied. \n\t\tExample=%s\n\t\tExpected=%s\n\t\tActual=%s", command.getHelpCommandExample(), command.getArguments(), suppliedArguments));
        }
        else
        {
            return suppliedArguments;
        }
    }
}
