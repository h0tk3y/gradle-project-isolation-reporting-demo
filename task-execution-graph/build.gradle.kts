// The TaskExecutionGraph APIs will report project isolation problems 
// on an attempt to access the task graph content:

plugins { 
    java
}

gradle.taskGraph.whenReady {
    hasTask(":foo")
    allTasks.firstOrNull()?.let { 
        getDependencies(it)
    }

    // However, one is allowed to check if the tasks from the current
    // project are present in the task graph, so these calls do not
    // lead to problems:
    hasTask(tasks["help"])
    hasTask(":task-execution-graph:help")
}