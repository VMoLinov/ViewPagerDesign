package ru.molinov.viewpagerdesign.ui.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ru.molinov.viewpagerdesign.R
import ru.molinov.viewpagerdesign.databinding.RecyclerClassesItemSecondBinding
import ru.molinov.viewpagerdesign.model.Class

class SecondClassesAdapter(private val data: List<Class>) :
    RecyclerView.Adapter<SecondClassesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerClassesItemSecondBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])
    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val binding: RecyclerClassesItemSecondBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Class) {
            val resources = binding.card.resources
            binding.history.text = data.title
            binding.skype.isVisible = data.skype
            if (data.skype) {
                binding.timeIndicator.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_time,
                        null
                    )
                )
                binding.timeIndicator.background = null
            } else {
                binding.timeIndicator.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        binding.timeIndicator.resources,
                        R.drawable.ic_time_now,
                        null
                    )
                )
                binding.timeIndicator.background = ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_time_background,
                    null
                )
            }
        }
    }
}
