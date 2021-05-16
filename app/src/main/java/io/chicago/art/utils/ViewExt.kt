package io.chicago.art.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


@BindingAdapter("imageUrl")
fun ImageView.loadImage(imageUrl: String?) {
    if (imageUrl?.isNotEmpty() == true) {
        val requestCreator = Picasso.get()
                .load(imageUrl)
            .fit()
            .centerCrop()
        requestCreator
                .into(this)
    }
}