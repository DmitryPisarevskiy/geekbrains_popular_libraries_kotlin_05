package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.Repo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.IGithubUsersRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.list.IRepoListPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.UserView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.list.RepoItemView

class UserPresenter(
        val uiScheduler: Scheduler,
        val usersRepo: IGithubUsersRepo,
        val router: Router,
        val user: GithubUser
) : MvpPresenter<UserView>() {

    class RepoListPresenter : IRepoListPresenter {
        val repos = mutableListOf<Repo>()
        override var itemClickListener: ((RepoItemView) -> Unit)? = null

        override fun getCount() = repos.size

        override fun bindView(view: RepoItemView) {
            val repo = repos[view.pos]
            view.setRepoName(repo.name)
        }
    }

    val repoListPresenter = RepoListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setLogin(user.login)
        usersRepo.getUserRepos(user.reposUrl)
        .observeOn(uiScheduler)
        .subscribe({ repos ->
            repoListPresenter.repos.clear()
            repoListPresenter.repos.addAll(repos)
            viewState.updateList()
        }, {
            println("Error: ${it.message}")
        })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
