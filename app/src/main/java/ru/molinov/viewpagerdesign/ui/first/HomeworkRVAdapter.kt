package ru.molinov.viewpagerdesign.ui.first

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.molinov.viewpagerdesign.R
import ru.molinov.viewpagerdesign.databinding.RecyclerHomeworkItemBinding
import ru.molinov.viewpagerdesign.model.Homework

class HomeworkRVAdapter(private val data: List<Homework>) :
    RecyclerView.Adapter<HomeworkRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerHomeworkItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])
    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val binding: RecyclerHomeworkItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun bind(data: Homework) = with(binding) {
            title.text = data.title
            daysLeft.text = data.daysLeft.toString()
            description.text = data.description
            when {
                data.daysLeft <= 3 -> daysLeft.setTextColor(android.R.color.holo_red_dark)
                else -> daysLeft.setTextColor(R.color.gray_text)
            }
            daysLeft.text = "${data.daysLeft} days left"
        }
    }
}