package com.example.clickerkt

import android.graphics.Color
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

        with(binding) {     // Чтобы каждый раз не писать binding, можно использовать конструкцию с with (умный компилятор поймёт куда вставлять)

            tvClicker.text = counter.toString()         // без with пришлость бы писать binding.tvClicker
            layout.setBackgroundColor(Color.parseColor(BackgroundColor.RED.color))

            btnClicker.setOnClickListener { _ ->        // неиспользуемый аргумент обычно обозначают подчёркиванием
                ++counter;
                tvClicker.text = counter.toString()
                layout.setBackgroundColor(
                    Color.parseColor(
                        when (counter % 3) {
                            0 -> BackgroundColor.RED.color
                            1 -> BackgroundColor.GREEN.color
                            2 -> BackgroundColor.BLUE.color
                            else -> null
                        }
                    )
                )
            }      // лямбда(анонимная)-функция. Если лямбда одна, можно без круглых скобок

        }

        return binding.root
    }
}

enum class BackgroundColor(val color: String) {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF")
}