# minecraftOpenMod

A modified Minecraft Java client that exposes a clean and simple interface to programmers. The goal is the to allow Java developers regardless of experience level to quickly start with Minecraft modding.

## Quick start

* [Download the latest release](https://github.com/minecraftkids/minecraftOpenMod/files/100358/1.8.8.mod.zip)
* Unzip to the Minecraft's versions directory. On Windows OS it is at: %appData%/.minecraft/versions
* Launch Minecraft and create a profile using version 1.8.8.mod, and start the game with the profile.
* Use Ctrl+Down Arrow to bring up Mod UI, use Ctrl+Up Arrow or Esc key to hide UI
* On the Mod UI, click on "Commands" tab, click on "Add" button to add your own custom command class. Once loaded your command will appear as a link in the tab

## To play with the build in Mods

Click on a link in the "Buildin Mods" tab in Mod UI. Each Mod name is follow by a shortcut key in braces. A mod can also be toggled on or off by press Ctrl+shortcut key. For example "AutoAttack(k)" can be toggled by Ctrl+k.

## To learn how to develop a custom command

Study the existing commands, to run a command click on it in the "Commands" tab or type in chat: "/.[Command Name]" followed by command arguments. Each command is implemented by a class in com.logiccity.minecraft.api.command package

Each custom command must implement either [CommandInterface](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/CommandInterface.html) or [ModCommandInterface](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/ModCommandInterface.html). The main interfaces to the game are [GameInfo](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/GameInfo.html) and [GameControl](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/GameControl.html)