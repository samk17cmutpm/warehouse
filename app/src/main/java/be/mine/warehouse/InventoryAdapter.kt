package be.mine.warehouse

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by sam_nguyen on 1/4/18.
 */
class InventoryAdapter constructor(val inventoryItems: ArrayList<InventoryItem>) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context: Context = parent.context
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val contactView: View = inflater.inflate(R.layout.inventory_item, parent, false)
        val viewHolder: InventoryAdapter.ViewHolder = InventoryAdapter.ViewHolder(contactView)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return inventoryItems.size
    }


    class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}