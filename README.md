## Cross-project model access for Project Isolation

This project demonstrates new problem reporting coverage for cross-project model access 
with project isolation enabled.

The list of "entry point" APIs that need to track cross-project model access is 
available in https://github.com/gradle/gradle/issues/21485.

To produce a problem report for all the newly covered illegal access scenarios, run:

```shell
./gradlew -Dorg.gradle.unsafe.isolated-projects=true
```

Then open the report by the link in the output,

<pre>
* What went wrong:
Configuration cache problems found in this build.

21 problems were found storing the configuration cache, 7 of which seem unique.
...

See the complete report at file:///<b>THE_REPORT_URL_HERE</b>
</pre>

### New covered cases

* [`:get-gradle:illegal-access`](get-gradle/illegal-access/build.gradle.kts)

    Accessing the mutable models of the other project available via `Project.getGradle()`
    is now properly tracked and reported.

    Covered in https://github.com/gradle/gradle/pull/21600


* [`:task-execution-graph`](task-execution-graph/build.gradle.kts)

    Accessing the task graph content that might include the tasks from other projects is reported as
    a project isolation problem. 

    However, checking for the presence of the current project's tasks in the task graph is allowed.

    Covered in https://github.com/gradle/gradle/pull/22445


* [`:task-dependency`](task-dependency/build.gradle.kts)

    Accessing a `Buildable`'s `TaskDependency.getDependencies(...)` is reported as a project isolation problem.

    Covered in https://github.com/gradle/gradle/pull/22433


* [`:inherited-properties:illegal-access`](inherited-properties/illegal-access/build.gradle)

    Dynamic access to properties and methods, as well as static calls to `property(...)`, `hasProperty(...)`, 
    `findProperty(...)` etc. is now reported as a project isolation problem when the property or method is not found
    in the current project's dynamic object.

    Covered in https://github.com/gradle/gradle/pull/21838