Java Vindinium Starter Pack 
================

This repository contains a starter pack for Vindinium, an Artificial Intelligence programming challenge. If Java is your weapon of choice, feel free to use it as you see fit. 

More about Vindinium itself: http://vindinium.org/

Starter packs for other languages: http://vindinium.org/starters

# Building
The project is configured to be build using **Gradle** and you are encouraged to use it (it's great!), but you can use any build system. If you decide to not use Gradle you have to provide 3 libraries:

* com.squareup.okhttp:okhttp:2.0.0
* com.squareup.mimecraft:mimecraft:1.1.1
* com.google.code.gson:gson:2.2.4

(Gradle will download those automatically)

### Intellij IDEA
If you are using Intellij Idea, you can just File -> Open -> build.gradle file. 

# Usage
Class **ExampleBot** contains standard main() function and usage example. The code itself should be self explanatory in the most part. 

Model package contains objects reflecting the structure of Vindinium API responses. Only additional logic is a translation of board markup to **Tile** objects. Tiles are described by TileCategory and who integer.  **Tile.who** describes who is the owner of the mine OR in case of a hero - who he is.

### Building and running from command line

To build it:
`gradlew build`

To run it:
`gradlew run`
