package com.example.homework1android2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework1android2.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!
    private val carAdapter = CarsAdapter(this::onClick)

    private fun onClick(car: Car) = with(binding) {
        HandOver.setData(car)
        findNavController().navigate(R.id.action_firstFragment_to_detailFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectRecyclerView()
    }

    private fun connectRecyclerView() {
        binding.rvFirstFragment.adapter = carAdapter
        carAdapter.setCarsList(
            mutableListOf(
                Car(R.drawable.bmw, "Bmw", 4),
                Car(R.drawable.cls, "Mers", 4),
                Car(R.drawable.audi, "Audi", 4),
                Car(R.drawable.bugati, "Bugati", 4),
                Car(R.drawable.lamborgini, "Lamborgini", 4),
                Car(R.drawable.supreme, "Supreme", 4),
            )
        )
    }
}