package io.chicago.data.entities

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class ArtWorkUIItem(val imageUrl: String, val title: String): Parcelable