plugins {
    java
}

files().buildDependencies.getDependencies(null)
configurations["compileClasspath"].buildDependencies.getDependencies(null)
sourceSets.main.get().output.buildDependencies.getDependencies(null)
sourceSets.main.get().java.buildDependencies.getDependencies(null)

tasks["help"].taskDependencies.getDependencies(null)
artifacts.add("apiElements", File("demo.txt")).buildDependencies.getDependencies(null)
