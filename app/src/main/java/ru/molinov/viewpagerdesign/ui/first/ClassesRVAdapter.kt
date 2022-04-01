package ru.molinov.viewpagerdesign.ui.first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ru.molinov.viewpagerdesign.R
import ru.molinov.viewpagerdesign.databinding.RecyclerClassesItemMainBinding
import ru.molinov.viewpagerdesign.model.Class

class ClassesRVAdapter(private val data: List<Class>) :
    RecyclerView.Adapter<ClassesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerClassesItemMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])
    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val binding: RecyclerClassesItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Class) = with(binding) {
            title.text = data.title
            time.text = data.time
            skype.isVisible = data.skype
            if (data.isElective) {
                itemView.background =
                    ResourcesCompat.getDrawable(itemView.resources, R.drawable.card_gradient, null)
            } else {
                itemView.background =
                    ResourcesCompat.getDrawable(itemView.resources, R.drawable.card_gray, null)
            }
        }
    }
}
