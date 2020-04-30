package ir.alirezaiyan.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.alirezaiyan.main.model.VenueUiModel

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 3:27 PM.
 */
class ExploreAdapter : RecyclerView.Adapter<ExploreViewHolder>() {

    private var items = mutableListOf<VenueUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ExploreViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_expore, parent, false)
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun update(it: List<VenueUiModel>) {
        items.addAll(it)
        notifyDataSetChanged()
    }
}