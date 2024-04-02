## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `libs`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in `{subproject}\build\classes\java\main` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Managing `DrawingPanel` Source

The `DrawingPanel` class, used for graphical operations, is archived in the `cs141/Archive/graphics` directory. The compiled class is included in a JAR file located in the `lib` directory. If you need to modify the `DrawingPanel` class:

1. Navigate to `cs141/Archive/graphics`.
2. Make the necessary changes to `DrawingPanel.java`.
3. Recompile the class: `javac DrawingPanel.java`.
4. Update the JAR file in `lib`: `jar cvf ../lib/DrawingPanel.jar graphics/`.
5. Ensure the updated JAR file is referenced in your project settings.

**PLEASE NOTE**
`DrawingPanel.jar` exists in the following locations:
- `cs141\CodeStepByStep\libs`
- `cs141\ExampleCodeByWeek\libs`

Should `DrawingPanel.jar` require any modifications, all locations listed above must receive the new version of the file. To check compatibility, please test the programs listed below.

`DrawingPanel.jar` is used by the following programs:
- `cs141\CodeStepByStep\src\SmallProblems1B__1_8\DrawCar.java`
- `cs141\ExampleCodeByWeek\src\week2\Drawing.java`

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
