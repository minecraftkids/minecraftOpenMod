Table of Contents
=================

  * [Install and start the modified Minecraft client](#install-and-start-the-modified-minecraft-client)
  * [Commands that execute actions only once](#commands-that-execute-actions-only-once)
    * ["NameTags" in source code editor](#nametags-in-source-code-editor)
  * [Commands that performs actions in each update tick](#commands-that-performs-actions-in-each-update-tick)

# Install and start the modified Minecraft client
* Install [Forge](http://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.10.2.html) for Minecraft version 1.10.2
* Download minecraftOpenModInit.zip on the [release page](https://github.com/minecraftkids/minecraftOpenMod/releases) and copy it to the Mincraft mods folder. On windows: %appData%/minecraft/mods
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/modFolderExplor.JPG)
* Start Minecraft client and select Forge profile. Make sure that minecraftOpenModInit is installed:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/InitModVerify.JPG)
* Restart the Minecraft client and notice that a new profile: "mcOpenMod" was created
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/verifyModCreated.JPG)
* Optionally if you plan to write custom commands in Java, install the latest version of [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html); click on "Edit Profile" button for "mcOpenMod" and make sure to point the Executable to the installed JDK javaw(.exe):
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcModProfile.JPG)
* start the game with the profile: "mcOpenMod"

# Commands that execute actions only once
## "NameTags" in source code editor
* If Minecraft client is running, use Esc key to pause the game:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcPaulsed.jpg)
* Download sourceEditor.zip on the [release page](../releases)
* Unzip the content and open the mod/index.html file in any browser. You will see the Brockly UI:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blockClean.JPG)
* Drag the following highlighted blocks onto the canvas:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyNT_init.JPG)![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyExecuteOnce.JPG)![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyIf.JPG)![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyNT_Lists.JPG)![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyNT_math.JPG)![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyNT_setSize.JPG)

* The completed "NameTags" command is:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyNameTags.JPG)
* The command contains two methods:
    * The "Create the command" method creates the command with name: "NameTags". It also bind the command to short cut key: "G"
    * The "execute once" defines the actions of the command. It set the size of name label above players. If there is an argument passed to the command, it will be used as the size of label, otherwise the default sized of 2 will be used
* Now to install the command, click on the "Install command" button:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blocklyInstallCmd.JPG)
* Switch to the Minecraft client and notice the background chat message:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcCommandLoaded.JPG)
* To run the command, type "/.NameTags" on the chat line. You have to be in multi-player world to see the name label of other players. Try switch between "/.NameTags 1" and "/.NameTags 2" to see the difference
* Congratulation you completed your first command!

# Commands that performs actions in each update tick 

The previous command executes a single action once. A more complex example would be to continuously perform actions and check on status until the command is stopped or a certain goal is achieved. Minecraft's game loop normally runs at a fixed rate of 20 ticks per second. The following highlighted blocks can be used to insert additional actions to change game status or UI rendering:  
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/blockyTickOverrides.JPG)

The key to these blocks is that their actions will be executed many times per second. All of them return a Boolean value. A false value means the command actions will continue to be invoked in the following tick. A true value signal the goal of this command is achieved and it will stop the command. Please take a look at the xml sources in [Blockly Demo](https://github.com/minecraftkids/minecraftOpenMod/tree/master/src/main/blockly/demo) for the following example commands with shortcut keys:

    * 'B': Fullbright
    * 'C': Sneak
    * 'F': Flight
    * 'H': BaseFinder
    * 'I': Tracer
    * 'J': AutoSprint
    * 'K': ArmorStatus
    * 'L': NoFall
    * 'M': AntiAFK
    * 'N': Criticals
    * 'P': ChestESP
    * 'R': KillAura
    * 'U': Freecam
    * 'V': ProphuntEsp
    * 'X': Xray
    * 'Y': AutoBow
    * 'Z': AntiKB

To load an xml source, please use "Choose File" button on the Blockly UI:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/editorChooseFile.JPG)

