package com.example.task_build_time_plugin

import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.api.tasks.TaskState

class BuildTimeListener implements TaskExecutionListener, BuildListener {

    // 用来记录 task 的执行时长信息
    Map<String, TaskTimeInfo> taskTimeMap = new HashMap<>()

    @Override
    void buildStarted(Gradle gradle) {
        //
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
        taskTimeMap.each { k, v -> println "${k}:[${v.total}ms]" }
        println "-----------------------------------------------------------------"
    }

    @Override
    void beforeExecute(Task task) {
        // task开始执行之前搜集task的信息
        TaskTimeInfo timeInfo = new TaskTimeInfo()
        timeInfo.start = System.currentTimeMillis()
        timeInfo.path = task.getPath()
        taskTimeMap.put(task.getPath(), timeInfo)
    }

    @Override
    void afterExecute(Task task, TaskState taskState) {
        // task执行完之后，记录结束时的时间
        TaskTimeInfo timeInfo = taskTimeMap.get(task.getPath())
        timeInfo.end = System.currentTimeMillis()
        // 计算该 task 的执行时长
        timeInfo.total = timeInfo.end - timeInfo.start
    }

    class TaskTimeInfo {
        long total
        String path
        long start
        long end
    }
}