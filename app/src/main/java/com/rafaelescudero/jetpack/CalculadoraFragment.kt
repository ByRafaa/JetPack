package com.rafaelescudero.jetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_calculadora.*
import kotlinx.android.synthetic.main.fragment_dividir.*
import kotlinx.android.synthetic.main.fragment_restar.*
import kotlinx.android.synthetic.main.fragment_sumar.*

class CalculadoraFragment : Fragment(),View.OnClickListener {

    var navController : NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculadora, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.calcular).setOnClickListener(this)
    }

    override fun onClick(v: View?) {



        if (primerNum.text.isEmpty() || segundoNum.text.isEmpty()){

            Toast.makeText(context,"No pueden haber campos vacíos",Toast.LENGTH_LONG).show()

        } else {

            var num1 = primerNum.text.toString()
            var num2 = segundoNum.text.toString()

            var number1 = num1.toDouble()
            var number2 = num2.toDouble()

            var result:Double

            when (v!!.id){

                R.id.calcular ->{

                    if (sumBut.isChecked){

                        val bundle = Bundle()

                        result = number1+number2

                        bundle.putDouble("resultado",result)

                        navController!!.navigate(R.id.fromCalcToSum,bundle)

                    }

                    if (restBut.isChecked){

                        val bundle = Bundle()

                        result = number1-number2

                        bundle.putDouble("resultado",result)

                        navController!!.navigate(R.id.fromCalcToRest,bundle)

                    }

                    if (divBut.isChecked){

                        if (number2 == 0.0){

                            Toast.makeText(context,"No se puede dividir un número entre 0",Toast.LENGTH_LONG).show()

                        } else {

                            val bundle = Bundle()

                            result = number1/number2

                            bundle.putDouble("resultado",result)

                            navController!!.navigate(R.id.fromCalcToDiv,bundle)

                        }

                    }

                }

            }
        }

    }

}