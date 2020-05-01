package ir.alirezaiyan.main.utils

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/2/2020 1:09 AM.
 */
@set:BindingAdapter("visibleOrGone")
var View.visibleOrGone
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }