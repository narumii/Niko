> Java version: AdoptJDK 11 openJ9
---

### Niko is a small crash client base for retarded(german) people who steal other people's code.

---

### Features
- LazyLoading for crashers
- Simple CommandAPI
- Simple ExploitAPI
- Shitty GuiInGameHook
- Discord RPC

---

### Running client through intellij idea
- Main: `Start`
- JVM args: `-Djava.library.path=$ProjectFileDir$/natives/`
- Working directory: `$ProjectFileDir$/work`

> Clean `target` before running

> Some thins can be fucked due to minecraft working dir (for example resourcepack button crashers the game xd)


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

#### Preview

![](https://i.imgur.com/ZlXz3yL.png)
![](https://i.imgur.com/89hJYV7.png)
![](https://i.imgur.com/gPkWI1l.png)
