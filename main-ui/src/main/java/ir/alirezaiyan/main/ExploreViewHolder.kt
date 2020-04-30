package ir.alirezaiyan.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.alirezaiyan.main.model.VenueUiModel

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 3:28 PM.
 */
class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val itemIcon: ImageView = itemView.findViewById(R.id.itemIcon)
    private val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
    private val itemCategory: TextView = itemView.findViewById(R.id.itemCategory)
    private val itemAddress: TextView = itemView.findViewById(R.id.itemAddress)
    fun bind(it: VenueUiModel) {
        itemTitle.text = it.title
        if (it.photoUrl.isNotEmpty())
            Picasso.get().load(it.photoUrl).into(itemIcon)
        itemCategory.text = it.formattedPhone
        itemAddress.text = it.formattedAddress
    }
}