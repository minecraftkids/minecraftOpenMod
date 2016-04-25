Table of Contents
=================

  * [Install and start the modified Minecraft client](#install-and-start-the-modified-minecraft-client)
  * [Create a simple command in source code editor](#create-a-simple-command-in-source-code-editor)
  * [A more complex command that performs actions in each update tick](#a-more-complex-command-that-performs-actions-in-each-update-tick)

# Install and start the modified Minecraft client
* Download 1.8.8.mod.zip on the [release page](https://github.com/minecraftkids/minecraftOpenMod/releases)
* Unzip to the Minecraft's versions directory. On Windows OS it is at: %appData%/.minecraft/versions
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcInstall.JPG)
* Optionally install the latest version of [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). This is only required for if you plan to write custom commands in Java 
* Launch Minecraft and create a profile using version 1.8.8.mod. If you want to develop Java commands, please make sure to point the Java Executable to the installed JDK javaw(.exe):
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcModProfile.JPG)
* start the game with the profile:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcLaunchMod.JPG)

# Create a simple command in source code editor
* If Minecraft client is running, use Esc key to pause the game:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcPaulsed.jpg)
* Download sourceEditor.zip on the [release page](../releases)
* Unzip the content and open the mod/index.html file in any browser. You will see the Brockly UI:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blockClean.JPG)
* Drag the following five elements onto the canvas:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyInitializeCmd.JPG)![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyExecuteOnce.JPG)![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyTextString.JPG)![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyEmptyList.JPG)![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyJumpOnce.JPG)
* Construct the following Blockly logic on the canvas:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/jumpOnceComplete.JPG)
* The complete command contains two blocks, first one initialize the command name to "jumpOnce" and set the argument lengths to an empty list which means the command has no argument
* Now to install the command, click on the "Install command" button:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyInstallCmd.JPG)
* Switch to the Minecraft client and notice the background chat message:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcCommandLoaded.JPG)
* To run the command, type "/.jumpOnce" on the chat line:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcCmdInput.JPG)
* You can use "/" and up arrow to repeat the command several times. You will notice each time you run the command, the player jumps once. 
* Congratulation you completed your first command!

# A more complex command that performs actions in each update tick 

The previous command executes a single action once. A more complex example would be to perform actions and check on status until a certain goal is achieved. Minecraft's game loop normally runs at a fixed rate of 20 ticks per second. The "Override"->"do in each update tick" and "Override"->"do in each render tick" blocks can be used to insert additional actions to change game status or UI rendering:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blockyTickOverrides.JPG)

The key to these two blocks is that their actions will be executed many times per second. Both of them return a Boolean value. A false value means the command actions will continue to be invoked in the following tick. A true value signal the goal of this command is achieved and it will stop the command. As an example of using the "do in each render tick" block, the following command will cause the player to go forward until it is blocked:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/goFwd.JPG)

