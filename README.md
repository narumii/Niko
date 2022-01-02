### Skidders
- PhecdaClient (Vexio(Naski, Hapix, Ayarume), Out)
- AvarionCient (Szymeko, Noxerek)
- Str0ng/StormClient (str0ngsz)
- SweetClient (BlackCrack, AvarionTeam)
- Ayakashi (Noxerek, FixMem)
- Heaven (Noxerek)
- And probably more

> All of these clients are trash

---

> Java version: AdoptJDK 8
---

### Niko is a small crash client base for retarded(german) people who steal other people's code.

---

### Features
- LazyLoading for crashers
- Simple CommandAPI
- Simple ExploitAPI
- Shitty GuiInGameHook
- Discord RPC
- Updated Log4J

---

### Running client through intellij idea
- Main: `Start`
- JVM args: `-Djava.library.path=$ProjectFileDir$/natives/`
- Working directory: `$ProjectFileDir$/work`

> Clean `target` before running

> Some things can be fucked due to minecraft working dir (for example resourcepack button crashes the game xd)


![](https://i.imgur.com/1ttvVCZ.png)

--- 

### Building
- Terminal -> `mvn clean install` in working dir (dir with fucking pom.xml lol)
- Jar file output:  `target/NikoClient-1.0-SNAPSHOT.jar`
- Move `NikoClient-1.0-SNAPSHOT.jar` to `versions/NikoClient`
- Rename it to `NikoClient.jar`
- Copy folder `NikoClient` to `.minecraft/versions`

> JSON File: `versions/NikoClient/NikoClient.json`

> Please add libraries to json file (don't create fat jar, we don't want jar that have 40mb size xd)

---

### Credits
- MetaClient (mori0) `Json NBT(extra) from MetaClient, sorry but i don't give you other json nbt ¯\_(ツ)_/¯`
---

#### Preview

![](https://i.imgur.com/ZlXz3yL.png)
![](https://i.imgur.com/89hJYV7.png)
![](https://i.imgur.com/gPkWI1l.png)
