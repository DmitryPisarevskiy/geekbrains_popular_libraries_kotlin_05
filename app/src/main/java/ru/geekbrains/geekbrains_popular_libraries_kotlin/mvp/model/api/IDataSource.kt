package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Url
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.Repo

interface IDataSource {

    @GET("users")
    fun getUsers() : Single<List<GithubUser>>

    @GET
    fun getUserRepos(@Url url: String) : Single<List<Repo>>

}