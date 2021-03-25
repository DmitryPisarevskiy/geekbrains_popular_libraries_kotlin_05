package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepoView: MvpView {
    fun setName(name: String)
    fun setUrl(url: String)
    fun setForks(forks: Int)
    fun setLanguage(language: String)
    fun setWatchers(watchers: Int)
}