package com.module.task_build_time_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class TaskBuildTimePlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
        target.gradle.addListener(new BuildTimeListener())
    }
}