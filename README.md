# minecraftOpenMod

A modified Minecraft Java client that exposes a clean and simple interface to programmers. The goal is the to allow Java developers regardless of experience level to quickly start with Minecraft modding.

## Quick start

* Download 1.8.8.mod.zip on the [release page](https://github.com/minecraftkids/minecraftOpenMod/releases)
* Unzip to the Minecraft's versions directory. On Windows OS it is at: %appData%/.minecraft/versions
* Launch Minecraft and create a profile using version 1.8.8.mod, and start the game with the profile.
* Use Ctrl+Down Arrow to bring up Mod UI, use Ctrl+Up Arrow or Esc key to hide UI
* On the Mod UI, click on "Commands" tab, click on "Add" button to add your own custom command class. Once loaded your command will appear as a link in the tab

## To learn how to develop a custom command

Study the existing commands. There are two ways to run a command:
* click on it in the "Commands" tab and input parameters if necessary
* Type in chat: "/.[Command Name]" followed by command arguments. 
If the command need additional input, type in chat: "/-" follows by the input.

Each command is implemented by a class in com.logiccity.minecraft.api.command package. It must implement either [CommandInterface](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/CommandInterface.html) or [ModCommandInterface](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/ModCommandInterface.html). The main interfaces to the game are [GameInfo](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/GameInfo.html) and [GameControl](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/GameControl.html)

For example, "/.attack" in chat will start the command implemented by the Attack class, it lists five closest living entities on the chat window. You can chose the one by typing in chat "/-" follow by a number between 1 and 5. One selected the player will attack the entity until it was killed

## To play with the build-in Mods

Click on a link in the "Buildin Mods" tab in Mod UI. Each Mod name is follow by a shortcut key in braces. A mod can also be toggled on or off by press Ctrl+shortcut key. For example "AutoAttack(k)" can be toggled by Ctrl+k. Current available build-in mods:
* Ctr-B: Fullbright
* Ctr-C: Critical
* Ctr-F: Flight
* Ctr-I: Tracer
* Ctr-J: BaseFinder
* Ctr-K: AutoAttack
* Ctr-L: NoFall
* Ctr-M: AntiAFK
* Ctr-N: NoWeb
* Ctr-P: ChestESP
* Ctr-R: KillAura
* Ctr-S: AutoSprint
* Ctr-U: Freecam
* Ctr-V: InstantBunker
* Ctr-X: Xray
* Ctr-Y: AutoBow
* Ctr-Z: AntiKB
