package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.Repo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.RepoView

class RepoPresenter(val router: Router, val repo: Repo): MvpPresenter<RepoView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setName(repo.name)
        viewState.setLanguage(repo.language)
        viewState.setUrl(repo.url)
        viewState.setForks(repo.forks)
        viewState.setWatchers(repo.watchers)
    }

    fun backPressed():Boolean {
        router.exit()
        return true
    }
}