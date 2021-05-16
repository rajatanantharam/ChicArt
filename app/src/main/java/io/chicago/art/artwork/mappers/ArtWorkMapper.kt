package io.chicago.art.artwork.mappers

import io.chicago.art.artwork.dto.api.ArtWorks
import io.chicago.art.artwork.dto.ui.ArtWorkUIItem

object ArtWorkMapper {

    fun getArtworkUIItems(artWorks: ArtWorks): List<ArtWorkUIItem> =
        artWorks.data.map {
            ArtWorkUIItem(
                imageUrl = "${artWorks.config.iiif_url}/${it.image_id}/full/843,/0/default.jpg",
                title = it.title
            )
        }
}