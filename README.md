# Discord Emoji Usage Bot

The intent of this repo is to capture all usages of custom discord guild emojis and add reporting to see how often they
are used. 

## Modules
This repo is multi-facted and contains many different Gradle modules for different purposes.

### [aws](./aws/README.md)
The `aws` module includes all of the Lambda functions which will be interacting with EC2 and invoked via API Gateway

### [discordBot](./discordBot/README.md)
The `discordBot` module provides a [Discord4J](https://github.com/Discord4J/Discord4J) implementation of a discord bot.

### [serverController](./http-api/README.md)
The `serverController` module is the pre-generated SDK from APIGateway
