package ru.molinov.viewpagerdesign.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ru.molinov.viewpagerdesign.R
import ru.molinov.viewpagerdesign.databinding.FragmentFirstBinding
import ru.molinov.viewpagerdesign.model.Data

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val data = Data()
    private val classesAdapter: ClassesRVAdapter by lazy { ClassesRVAdapter(data.dataClasses) }
    private val homeworkAdapter: HomeworkRVAdapter by lazy { HomeworkRVAdapter(data.dataHomework) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val layoutManagerClasses =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val layoutManagerHomework =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val divider = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
            ResourcesCompat.getDrawable(resources, R.drawable.recycler_divider, context?.theme)
                ?.let { divider.setDrawable(it) }
            recyclerClasses.adapter = classesAdapter
            recyclerClasses.layoutManager = layoutManagerClasses
            recyclerClasses.addItemDecoration(divider)
            recyclerHomework.adapter = homeworkAdapter
            recyclerHomework.layoutManager = layoutManagerHomework
            recyclerHomework.addItemDecoration(divider)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
