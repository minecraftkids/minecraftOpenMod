# minecraftOpenMod

A modified Minecraft Java client that exposes a clean and simple interface to literally everyone. For someone without any programming experience, the goal is to teach Minecraft modding with visual programming tool from Google (Blockly) to quickly experience the joy of coding. For experienced Java developers, it removes the need of decompiling, deobfuscating, and studying Minecraft code. By studying two interfaces and sample command implementations, one can start modding right away.

## Quick start

* Download 1.8.8.mod.zip on the [release page](../../releases)
* Unzip to the Minecraft's versions directory. On Windows OS it is at: %appData%/.minecraft/versions
* Launch Minecraft and create a profile using version 1.8.8.mod, and start the game with the profile.
* Type "/." and then the "Tab" key to see a list of all sample commands. A command is to performance a task for the player. For example type "/.buildMaze 5 5 1" in the chat will build a random maze with supplied dimension.
* Type "//" and then the "Tab" key to see a list of all sample mods. Each Mod name is follow by a shortcut key in braces. A mod can also be toggled on or off by press Ctrl+shortcut key. A mod is to change the capability/state of the player. For example the "//xray(X)" will allow users to see through blocks. You can type "//xray" in chat or use Ctrl-x to enable or disable it. To change the short-cut key "x", after entered "//xray(X)" on chat line, type Ctrl-[new key].
* Type "/-" in chat allows a command to receive additional inputs. For example, "/.attack" in chat will lists five closest living entities on the chat window. You can chose the one by typing in chat "/-" follow by a number between 1 and 5. Once selected the player will attack the entity until it was killed

## To learn how to develop a custom command

### With Blockly
Please see [Blockly tutorial](../../wiki/Blockly-Tutorial).

### With Java
Please see [Java tutorial](../../wiki/Java-Tutorial). 

#### Java Quick Start
Study the existing sample commands. Each command is implemented by a class in com.logiccity.minecraft.api.command package. It must implement either [CommandInterface](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/CommandInterface.html) or [ModCommandInterface](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/ModCommandInterface.html). The main interfaces to Minecraft code are [GameInfo](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/GameInfo.html) and [GameControl](http://minecraftkids.github.io/minecraftOpenMod/com/logiccity/minecraft/api/GameControl.html)

After implementing your own command, please see [Java tutorial](wiki/Java-Tutorial) to load it into the game. 


## To play with the build-in Mods

* Ctr-B: Fullbright
* Ctr-C: Critical
* Ctr-F: Flight
* Ctr-G: NameTags
* Ctr-H: AntiMac
* Ctr-I: Tracer
* Ctr-J: BaseFinder
* Ctr-K: AutoAttack
* Ctr-L: NoFall
* Ctr-LSHIFT: Sneak
* Ctr-M: AntiAFK
* Ctr-N: NoWeb
* Ctr-P: ChestESP
* Ctr-R: KillAura
* Ctr-S: AutoSprint
* Ctr-U: Freecam
* Ctr-V: ProphuntEspMod
* Ctr-X: Xray
* Ctr-Y: AutoBow
* Ctr-Z: AntiKB