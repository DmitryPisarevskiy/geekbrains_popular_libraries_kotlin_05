package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.FragmentRepoBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.Repo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.RepoPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.RepoView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.BackButtonListener

private const val REPO = "repo"

class RepoFragment : MvpAppCompatFragment(), RepoView, BackButtonListener {

    companion object {
        fun newInstance(repo: Repo) = RepoFragment().apply {
            arguments = Bundle().apply {
                putParcelable(REPO, repo)
            }
        }
    }

    val presenter: RepoPresenter by moxyPresenter {
        val repo = arguments?.getParcelable<Repo>(REPO) as Repo
        RepoPresenter(App.instance.router, repo)
    }

    private var vb: FragmentRepoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRepoBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = presenter.backPressed()

    override fun setName(name: String) {
        vb?.tvRepoName?.text = "repository: $name"
    }

    override fun setUrl(url: String) {
        vb?.tvRepoUrlText?.text = url
    }

    override fun setForks(forks: Int) {
        vb?.tvRepoForksText?.text = forks.toString()
    }

    override fun setLanguage(language: String) {
        vb?.tvRepuLanguageText?.text = language
    }

    override fun setWatchers(watchers: Int) {
        vb?.tvRepoWatchersText?.text = watchers.toString()
    }
}