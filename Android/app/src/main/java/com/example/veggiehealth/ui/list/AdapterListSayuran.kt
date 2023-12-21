package com.example.veggiehealth.ui.list
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.veggiehealth.data.remote.response.VegetablesItem
import com.example.veggiehealth.databinding.VeggieListItemBinding
import com.example.veggiehealth.ui.detail.DetailActivity

class AdapterListSayuran : PagingDataAdapter<VegetablesItem, AdapterListSayuran.MyViewHolder>(DIFF_CALLBACK) {
    inner class MyViewHolder(internal val binding: VeggieListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(vegetables : VegetablesItem) {
            Glide.with(binding.root.context)
                .load(vegetables.image)
                .into(binding.image)
            binding.namaSayuran.text = vegetables.name
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val vegetables = getItem(position)
        holder.bind(vegetables!!)

        holder.itemView.setOnClickListener {
            val optionsCompat: ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    holder.itemView.context as Activity,
                    Pair(holder.binding.image,"photo"),
                    Pair(holder.binding.namaSayuran,"name")
                )
            val moveDetailSayuran = Intent(holder.itemView.context, DetailActivity::class.java)
            moveDetailSayuran.putExtra(DetailActivity.EXTRA_DETAIL, vegetables.id.toString())
            holder.itemView.context.startActivity(moveDetailSayuran, optionsCompat.toBundle())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = VeggieListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MyViewHolder(binding)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<VegetablesItem>(){
            override fun areItemsTheSame(oldItem: VegetablesItem, newItem: VegetablesItem): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(
                oldItem: VegetablesItem,
                newItem: VegetablesItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
