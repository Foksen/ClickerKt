package com.example.clickerkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clickerkt.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.tvClicker.text = counter.toString()
        binding.btnClicker.setOnClickListener { _ ->        // неиспользуемый аргумент обычно обозначают подчёркиванием
            ++counter;
            binding.tvClicker.text = counter.toString()
        }      // лямбда(анонимная)-функция. Если лямбда одна, можно без круглых скобок

        return binding.root
    }
}