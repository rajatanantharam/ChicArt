package io.chicago.data.mappers

import io.chicago.data.entities.ArtWorkUIItem

object ArtWorkMapper {
    fun getArtworkUIItems(artWorks: io.chicago.domain.entities.ArtWorks): List<ArtWorkUIItem> =
        artWorks.data.map {
            ArtWorkUIItem(
                imageUrl = "${artWorks.config.iiif_url}/${it.image_id}/full/843,/0/default.jpg",
                title = it.title
            )
        }
}