package com.azimzada.bedenkutleindeksi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azimzada.bedenkutleindeksi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.weighttNum.minValue = 10
        binding.weighttNum.maxValue = 300

        binding.heightNum.minValue = 10
        binding.heightNum.maxValue = 300


        binding.weighttNum.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }

        binding.heightNum.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }


    }

    fun calculateBMI() {

        val height = binding.heightNum.value
        val toDoubleHeight = height.toDouble() / 100

        val weight = binding.weighttNum.value

        val bmi = weight.toDouble() / (toDoubleHeight * toDoubleHeight)

        binding.tvResult.text = String.format(":  %.2f", bmi)

        binding.helthyTV.text = String.format("Məlumat %s", healityMessage(bmi))

    }

    fun healityMessage(bmi: Double): String {

        if (bmi < 18.5) {
            return " Boy uzunluğunuza görə bədən çəkiniz normalın altındadır və bu mövzuda daha çox məlumat əldə etmək üçün dietoloqa müraciət etməyinizi tövsiyə edirik."
        }
        if (bmi < 24.9) {
            return " Boy uzunluğunuza görə bədən çəkiniz \"normal\"–dır. Sağlam və balanslı qidalanaraq, həmçinin nizamlı fiziki fəaliyyət edərək bu çəkinizi qorumağa çalışın."
        }
        if (bmi < 29.9) {
            return " Boy uzunluğunuza görə bədən çəkiniz \"normaldan çoxdur\". Bu mövzuda daha çox məlumat əldə etmək üçün dietoloqa müraciət etməyinizi tövsiyə edirik."
        }
        if (bmi < 30.0)
            return " Boy uzunluğunuza görə bədən çəkiniz normalın çox üstündədir və \"Piylənmə\" dərəcəsinə girir. Köklük, ürək-damar xəstəlikləri, diabet, hipertoniya v.s. xroniki xəstəliklər üçün risk faktorudur. Həkim / dietoloq nəzarətində arıqlayaraq normal çəkinizi əldə etməyiniz sağlamlığınız baxımından çox əhəmiyyətlidir. "
        return "\"Obez\""
    }
}