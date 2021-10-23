package com.application.moviecatalogue.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tv_show_entity")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    val id: Int?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "release")
    val release: String?,

    @ColumnInfo(name = "score")
    val score: Double?,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "poster")
    val poster: String?,

    @ColumnInfo(name = "backdrop")
    val backdrop: String?,

    @ColumnInfo(name = "isFav")
    var isFav: Boolean = false
) : Parcelable