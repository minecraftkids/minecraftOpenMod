Table of Contents
=================

      * [Install and start the modified Minecraft client](#install-and-start-the-modified-minecraft-client)
      * [Setup IDE](#setup-ide)
      * [Create and install your own command](#create-and-install-your-own-command)
      * [Command super classes CustomCommandBase vs <code>CustomModCommandBase</code> ](#command-super-classes-customcommandbase-vs-custommodcommandbase)

### Install and start the modified Minecraft client
* Download 1.8.8.mod.zip on the [release page](https://github.com/minecraftkids/minecraftOpenMod/releases)
* Unzip to the Minecraft's versions directory. On Windows OS it is at: %appData%/.minecraft/versions
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcInstall.JPG)
* Optionally install the latest version of [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). This is only required for if you plan to write custom commands in Java 
* Launch Minecraft and create a profile using version 1.8.8.mod. If you want to develop Java commands, please make sure to point the Java Executable to the installed JDK javaw(.exe):
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcModProfile.JPG)
* start the game with the profile:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcLaunchMod.JPG)

### Setup IDE
You can use any Java IDE for this project. There is no third party dependencies out side of JRE. 
If you are interested in using the popular [Eclipse](https://eclipse.org/)/[Gradle](http://gradle.org/) setup:
* [Install Gradle Plugin](https://github.com/eclipse/buildship/blob/master/docs/user/Installation.md)
* Clone the [current repo](https://github.com/minecraftkids/minecraftOpenMod)
* Import the cloned repo as a Gradle project

### Create and install your own command
* If Minecraft client is running, use Esc key to pause the game:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcPaulsed.jpg)
* As an example, open the Jump.java class in com.logiccity.minecraft.api.command package. Change `super("jump");` to `super("jumpOnce");` and save the file
* Download sourceEditor.zip on the [release page](../releases)
* Unzip the content and open the mod/index.html file in any browser. Click on the "Choose File" button:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/editorChooseFile.JPG)
* Browse to load the Jump.java file. Click on the "Install command" button:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/editorInstallJavaCmd.JPG)
* Switch to the Minecraft client and notice the background chat message:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcCommandLoaded.JPG)
* To run the command, type "/.jumpOnce" on the chat line:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcCmdInput.JPG)
* You can use "/" and up arrow to repeat the command several times. You will notice each time you run the command, the player jumps once. 
* Congratulation you completed your first command!

### Command super classes `CustomCommandBase` vs `CustomModCommandBase`

The "jumpOnce" command extends from class `CustomCommandBase`, it executes a single action once. A more complex example would be to perform actions and check on status until a certain goal is achieved. Minecraft's game loop normally runs at a fixed rate of 20 ticks per second. There are special threads to handle game status update, and UI rendering. To perform action in those threads, a command needs extend from `CustomModCommandBase` and override the methods:
* `boolean doInUpdateTicThread()`
* `boolean doInRenderTicThread()`

These methods will be executed many times per second. Both of them return a Boolean value. A false value means the command actions will continue to be invoked in the following tick. A true value signal the goal of this command is achieved and it will stop the command. There are many sample commands in the com.logiccity.minecraft.api.command package. Along with super classes, all commands must implement either [CommandInterface](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/CommandInterface.html) or [ModCommandInterface](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/ModCommandInterface.html). The main interfaces to Minecraft code are [GameInfo](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/GameInfo.html) and [GameControl](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/GameControl.html)

