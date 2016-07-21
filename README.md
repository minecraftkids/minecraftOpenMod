# minecraftOpenMod

A modified Minecraft client that exposes a clean and simple interface to literally everyone. For someone without any programming experience, the goal is to teach Minecraft modding with visual programming tool from Google (Blockly) to quickly experience the joy of coding. For experienced Java developers, it removes the need of decompiling, deobfuscating, and studying Minecraft code. By using simple interfaces and referencing sample command implementations, one can start modding right away.

Table of Contents
=================

  * [minecraftOpenMod](#minecraftopenmod)
  * [Installation](#installation)
  * [Using the modified Minecraft client](#using-the-modified-minecraft-client)
  * [To learn how to develop a custom command](#to-learn-how-to-develop-a-custom-command)
    * [With Blockly](#with-blockly)
    * [With Java](#with-java)
  * [Contributing](#contributing)

# Installation
* Install [Forge](http://files.minecraftforge.net/) for the desired Minecraft version
* Download minecraftOpenModInit.zip on the [release page](https://github.com/minecraftkids/minecraftOpenMod/releases) and copy it to the Mincraft mods folder. On windows: %appData%/minecraft/mods
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/modFolderExplor.JPG)
* Start Minecraft client and select Forge profile. Make sure that minecraftOpenModInit is installed:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/InitModVerify.JPG)
* Restart the Minecraft client and notice that a new profile: "mcOpenMod" was created
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/verifyModCreated.JPG)
* Optionally if you plan to write custom commands in Java, install the latest version of [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html); click on "Edit Profile" button for "mcOpenMod" and make sure to point the Executable to the installed JDK javaw(.exe):
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcModProfile.JPG)
* start the game with the profile: "mcOpenMod"

# Using the modified Minecraft client
* Type "/." and then the "Tab" key to see a list of existing commands:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcCommands.JPG)
Each command can be used to enable certain feature or perform a task. The command names that end with "(?)" are associated with a short cut key. When not in chat line, type the short cut key will start/stop the corresponding command. Within the chat line, typing command name preceded by "/." will start/stop the command. The MC client title bar should show current running commands as shown in the screenshot for the "Fullbright" command

* Type "/-" in chat allows a command to receive additional inputs. For example, "/.attack" in chat will lists five closest living entities on the chat window. You can chose the one by typing in chat "/-" follow by a number between 1 and 5. Once selected the player will attack the entity until it was killed. "/-stop" is a special input that stop all running commands

* The following are the list of commands that are associated with shotcut keys. Please see the tutorial sections on how to develop each one of them in Blockly or Java:

    * 'B': Fullbright
    * 'C': Sneak
    * 'F': Flight
    * 'G': NameTags
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

# To learn how to develop a custom command

## With Blockly
Please see [Blockly tutorial](https://github.com/minecraftkids/minecraftOpenMod/blob/master/doc/tutorial/md/blocklyTutorial.md).

## With Java
Please see [Java tutorial](https://github.com/minecraftkids/minecraftOpenMod/blob/master/doc/tutorial/md/javaTutorial.md). 

# Contributing
Please help us improve by submitting [issues](https://github.com/minecraftkids/minecraftOpenMod/issues) or open [pull request](https://github.com/minecraftkids/minecraftOpenMod/pulls).

