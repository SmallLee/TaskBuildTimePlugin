package com.module.task_build_time_plugin

import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.api.tasks.TaskState

class BuildTimeListener implements TaskExecutionListener, BuildListener {

    Map<String, TaskTimeInfo> taskTimeMap = new HashMap<>()

    @Override
    void buildStarted(Gradle gradle) {

    }

    @Override
    void beforeSettings(Settings settings) {
        super.beforeSettings(settings)
    }

    @Override
    void settingsEvaluated(Settings settings) {

    }

    @Override
    void projectsLoaded(Gradle gradle) {

    }

    @Override
    void projectsEvaluated(Gradle gradle) {

    }

    @Override
    void buildFinished(BuildResult buildResult) {
        println "-------build finished, now println all task execution time-------"
        taskTimeMap.sort { a, b ->
            b.value.total <=> a.value.total
        }.each { k, v -> println "Task ${k} take [${v.total}ms]" }
        println "-----------------------------------------------------------------"
    }

    @Override
    void beforeExecute(Task task) {
        TaskTimeInfo timeInfo = new TaskTimeInfo()
        timeInfo.start = System.currentTimeMillis()
        timeInfo.path = task.getPath()
        taskTimeMap.put(task.getPath(), timeInfo)
    }

    @Override
    void afterExecute(Task task, TaskState taskState) {
        TaskTimeInfo timeInfo = taskTimeMap.get(task.getPath())
        timeInfo.end = System.currentTimeMillis()
        timeInfo.total = timeInfo.end - timeInfo.start
    }

    class TaskTimeInfo {
        long total
        String path
        long start
        long end
    }
}