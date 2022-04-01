package ru.molinov.viewpagerdesign.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.molinov.viewpagerdesign.databinding.FragmentSecondBinding
import ru.molinov.viewpagerdesign.model.Data

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val data = Data()
    private val adapter: SecondClassesAdapter by lazy { SecondClassesAdapter(data.dataClasses) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val linearLayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recycler.adapter = adapter
            recycler.layoutManager = linearLayoutManager
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
