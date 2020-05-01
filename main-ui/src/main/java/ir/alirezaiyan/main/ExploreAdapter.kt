package ir.alirezaiyan.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.main.utils.ItemClick

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 3:27 PM.
 */
class ExploreAdapter(private val listener: ItemClick<VenueUiModel>) :
    RecyclerView.Adapter<ExploreViewHolder>() {

    private var items = mutableListOf<VenueUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ExploreViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_explore, parent, false)
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener.click(item) }
    }

    fun update(it: List<VenueUiModel>) {
        items.addAll(it)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }
}