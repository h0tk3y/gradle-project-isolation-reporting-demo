// The following invocations all lead to project isolation problems:

gradle.rootProject.buildDir

gradle.rootProject { buildDir }

gradle.allprojects { buildDir }

gradle.beforeProject { buildDir }

gradle.afterProject { buildDir }

gradle.parent?.rootProject?.buildDir

gradle.projectsEvaluated { rootProject.buildDir }