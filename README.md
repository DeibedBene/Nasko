# Nasko Discord Bot

## Project Overview
Nasko is a Discord bot developed in Kotlin designed to enhance the user experience on Discord servers with various interactive features.

## Features
- Responds to user commands
- Manages server roles and permissions
- Provides informative responses and help commands

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/DeibedBene/Nasko.git
   cd Nasko
   ```
2. Ensure you have [Kotlin](https://kotlinlang.org/) installed.
3. Add your Discord bot token in the `config.properties` file.
4. Build the project:
   ```bash
   ./gradlew build
   ```
5. Run the bot:
   ```bash
   java -jar build/libs/Nasko.jar
   ```

## Usage
- Use the prefix `!` for commands. For example, `!help` will provide a list of available commands.
- Ensure your bot has the necessary permissions on the server to function correctly.

## Contributing
Feel free to open issues or submit pull requests to improve the bot! 

## License
This project is licensed under the MIT License.