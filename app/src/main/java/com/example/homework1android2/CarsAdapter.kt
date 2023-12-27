package com.example.homework1android2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1android2.databinding.ItemCarBinding

class CarsAdapter(private val onItemClick: (cars: Car) -> Unit) :
    RecyclerView.Adapter<CarsAdapter.CarViewHolder>() {

    private var cars = mutableListOf<Car>()

    fun setCarsList(car: MutableList<Car>) {
        cars = car
        notifyDataSetChanged()
    }

    inner class CarViewHolder(private val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(cars[adapterPosition])
            }
        }

        fun onBind(car: Car) = with(binding) {
            ivRamka.setImageResource(car.carImage)
            tvNameCar.text = car.name
            tvWheel.text = car.wheel.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.onBind(cars[position])
    }

    override fun getItemCount(): Int = cars.size
}