package ir.alirezaiyan.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ir.alirezaiyan.data.model.VenueUiModel
import ir.alirezaiyan.main.utils.ItemClick

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 3:27 PM.
 */
private val DIFF_CALLBACK: DiffUtil.ItemCallback<VenueUiModel> =
    object : DiffUtil.ItemCallback<VenueUiModel>() {
        override fun areItemsTheSame(
            oldItem: VenueUiModel,
            newItem: VenueUiModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: VenueUiModel,
            newItem: VenueUiModel
        ): Boolean {
            return compare(oldItem, newItem)
        }

        private fun compare(
            item1: VenueUiModel,
            item2: VenueUiModel
        ): Boolean {
            return item1.id == item2.id
        }
    }

class ExploreAdapter(private val listener: ItemClick<VenueUiModel>) :
    ListAdapter<VenueUiModel, ExploreViewHolder>(DIFF_CALLBACK) {


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
        items.clear()
        items.addAll(it)
        notifyDataSetChanged()
    }

}