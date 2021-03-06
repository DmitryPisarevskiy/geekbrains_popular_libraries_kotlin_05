package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.navigation

import com.github.terrakok.cicerone.Screen
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.Repo

interface IScreens {
    fun users(): Screen
    fun user(githubUser: GithubUser): Screen
    fun repo(repo: Repo): Screen
}