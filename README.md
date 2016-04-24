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
* Download 1.8.8.mod.zip on the [release page](https://github.com/minecraftkids/minecraftOpenMod/releases)
* Unzip to the Minecraft's versions directory. On Windows OS it is at: %appData%/.minecraft/versions
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcInstall.JPG)
* Optionally install the latest version of [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). This is only required for if you plan to write custom commands in Java 
* Launch Minecraft and create a profile using version 1.8.8.mod. If you want to develop Java commands, please make sure to point the Java Executable to the installed JDK javaw(.exe):
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcModProfile.JPG)
* start the game with the profile:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcLaunchMod.JPG)

# Using the modified Minecraft client
* Type "/." and then the "Tab" key to see a list of all sample commands:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcCommands.JPG)
A command is to performance a task for the player. For example type "/.buildMaze 5 5 1" in the chat will build a random maze with supplied dimension.
* Type "//" and then the "Tab" key to see a list of all sample mods:
![](https://raw.githubusercontent.com/minecraftkids/minecraftOpenMod/master/doc/tutorial/mcMods.JPG)
Each Mod name is follow by a shortcut key in braces. A mod can also be toggled on or off by press Ctrl+shortcut key. A mod is to change the capability/state of the player. For example the "//xray(X)" will allow users to see through blocks. You can type "//xray" in chat or use Ctrl-x to enable or disable it. To change the short-cut key "x", after entered "//xray(X)" on chat line, type Ctrl-[new key]. The current list of mods:
    * Ctr-1: NoWeb
    * Ctr-B: Fullbright
    * Ctr-F: Flight
    * Ctr-G: NameTags
    * Ctr-H: AntiMac
    * Ctr-I: Tracer
    * Ctr-J: BaseFinder
    * Ctr-K: AutoAttack
    * Ctr-L: NoFall
    * Ctr-LSHIFT: Sneak
    * Ctr-M: AntiAFK
    * Ctr-N: Critical
    * Ctr-P: ChestESP
    * Ctr-R: KillAura
    * Ctr-S: AutoSprint
    * Ctr-U: Freecam
    * Ctr-V: ProphuntEspMod
    * Ctr-X: Xray
    * Ctr-Y: AutoBow
    * Ctr-Z: AntiKB

* Type "/-" in chat allows a command to receive additional inputs. For example, "/.attack" in chat will lists five closest living entities on the chat window. You can chose the one by typing in chat "/-" follow by a number between 1 and 5. Once selected the player will attack the entity until it was killed

# To learn how to develop a custom command

## With Blockly
Please see [Blockly tutorial](https://github.com/minecraftkids/minecraftOpenMod/blob/master/doc/tutorial/md/blocklyTutorial.md).

## With Java
Please see [Java tutorial](https://github.com/minecraftkids/minecraftOpenMod/blob/master/doc/tutorial/md/javaTutorial.md). 

# Contributing
Please help us improve by submitting [issues](https://github.com/minecraftkids/minecraftOpenMod/issues) or open [pull request](https://github.com/minecraftkids/minecraftOpenMod/pulls).

