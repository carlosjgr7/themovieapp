package com.example.themovieapp.data.local.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.themovieapp.data.network.response.Movies
import com.example.themovieapp.data.network.response.Results

@Entity
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("adult") val adult: Boolean? = null,
    @ColumnInfo("backdrop_path") val backdropPath: String? = null,
    @ColumnInfo("original_language") val originalLanguage: String? = null,
    @ColumnInfo("original_title") val originalTitle: String? = null,
    @ColumnInfo("overview") val overview: String? = null,
    @ColumnInfo("popularity") val popularity: Double? = null,
    @ColumnInfo("poster_path") val posterPath: String? = null,
    @ColumnInfo("release_date") val releaseDate: String? = null,
    @ColumnInfo("title") val title: String? = null,
    @ColumnInfo("video") val video: Boolean? = null,
    @ColumnInfo("vote_average") val voteAverage: Double? = null,
    @ColumnInfo("vote_count") val voteCount: Int? = null,
    @ColumnInfo("movie_type") var movietype:String =""
)

fun List<MovieEntity>.toMovieList():Movies{
    val movieList = Movies()
    this.forEach {
        movieList.results.add(
            Results(
                it.adult,
                it.backdropPath,
                it.id,
                it.originalLanguage,
                it.originalTitle,
                it.overview,
                it.popularity,
                it.posterPath,
                it.releaseDate,
                it.title,
                it.video,
                it.voteAverage,
                it.voteCount,
            )
        )
    }
    return movieList
}

