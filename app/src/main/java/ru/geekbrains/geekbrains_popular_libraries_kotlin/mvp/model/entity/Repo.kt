package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repo(
    @Expose val name: String,
    @Expose val url: String,
    @Expose val language: String,
    @Expose val forks: Int,
    @Expose val watchers: Int,
) : Parcelable