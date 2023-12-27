package com.example.homework1android2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework1android2.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!
    private val carAdapter = CarsAdapter(this::onClick)

    private fun onClick(car: Car) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectRecycleView()
    }

    private fun connectRecycleView() {
        binding.rvSecondFragment.adapter = carAdapter
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