package com.example.resume.ui.projects

import androidx.lifecycle.ViewModel

class ProjectsViewModel : ViewModel() {

    val resume = Project("Resume", "https://github.com/Kavertx/ResumeApp/")
    private val notes = Project("Notes", "https://github.com/Kavertx/NotesApp/")
    private val calculator = Project("Calculator", "https://github.com/Kavertx/Calculator/")

    val androidProjectsList = arrayOf(resume, notes, calculator)
    val webProjectsList = arrayOf<Project>()
    val desktopProjectsList = arrayOf<Project>()


}


class Project(val Name: String, val URL: String)


