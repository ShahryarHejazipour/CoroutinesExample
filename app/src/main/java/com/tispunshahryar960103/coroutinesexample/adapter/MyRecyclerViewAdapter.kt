package com.tispunshahryar960103.coroutinesexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.coroutinesexample.R
import com.tispunshahryar960103.coroutinesexample.databinding.ListItemBinding
import com.tispunshahryar960103.coroutinesexample.model.Subscriber

class MyRecyclerViewAdapter(private val clickListener: (Subscriber) -> Unit):
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    private val subscribersList = ArrayList<Subscriber>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(subscribersList[position], clickListener)
    }

    fun setList(subscribers: List<Subscriber>) {
        subscribersList.clear()
        subscribersList.addAll(subscribers)

    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }











    class MyViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit) {
            binding.nameTextView.text = subscriber.name
            binding.emailTextView.text = subscriber.email
            binding.listItemLayout.setOnClickListener {
                clickListener(subscriber)
            }
        }

    }

}