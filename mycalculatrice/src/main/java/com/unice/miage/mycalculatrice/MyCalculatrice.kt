package com.unice.miage.mycalculatrice

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MyCalculatrice : AppCompatActivity() {


    private var OPERATION: Char = ' '

    private var valeurUne = Double.NaN
    private var valeurDeux: Double = 0.toDouble()

    private var decimalFormat: DecimalFormat? = null
    private var buttonPoint: Button? = null
    private var buttonUn: Button? = null
    private var buttonDeux: Button? = null
    private var buttonTrois: Button? = null
    private var buttonQuatre: Button? = null
    private var buttonCinq: Button? = null
    private var buttonSix: Button? = null
    private var buttonSept: Button? = null
    private var buttonHuit: Button? = null
    private var buttonNeuf: Button? = null
    private var buttonZero: Button? = null
    private var buttonPlus: Button? = null
    private var buttonFoix: Button? = null
    private var buttonDiviser: Button? = null
    private var buttonMoins: Button? = null
    private var buttonClear: Button? = null
    private var buttonEgale: Button? = null
    private var editText: EditText? = null
    private var infoTextView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        decimalFormat = DecimalFormat("#.##########")

        setContentView(R.layout.activity_my_calculatrice)

        buttonPoint = findViewById(R.id.buttonPoint) as Button
        buttonUn = findViewById(R.id.button1) as Button
        buttonDeux = findViewById(R.id.button2) as Button
        buttonTrois = findViewById(R.id.button3) as Button
        buttonQuatre = findViewById(R.id.button4) as Button
        buttonCinq = findViewById(R.id.button5) as Button
        buttonSix = findViewById(R.id.button6) as Button
        buttonSept = findViewById(R.id.button7) as Button
        buttonHuit = findViewById(R.id.button8) as Button
        buttonNeuf = findViewById(R.id.button9) as Button
        buttonZero = findViewById(R.id.button0) as Button
        buttonPlus = findViewById(R.id.buttonPlus) as Button
        buttonFoix = findViewById(R.id.buttonFoix) as Button
        buttonDiviser = findViewById(R.id.buttonDiviser) as Button
        buttonMoins = findViewById(R.id.buttonMoins) as Button
        buttonClear = findViewById(R.id.buttonClear) as Button
        buttonEgale = findViewById(R.id.buttonEgale) as Button
        editText = findViewById(R.id.editText) as EditText
        infoTextView = findViewById(R.id.infoTextView) as TextView

        buttonPoint!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + ".") // pq on a besoin du toSting() ?
            }
        })

        buttonZero!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + "0") //getTect() et text c'est pareil ??
            }
        })

        buttonUn!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + "1")
            }
        })

        buttonDeux!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + "2")
            }
        })

        buttonTrois!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                //editText!!.setText(editText!!.text + "3")  //Demader à Amosse pq le + ne concatene pas

                editText!!.setText(editText!!.text.toString().plus("3"))  //+  et plus c'est pareil ?
            }
        })

        buttonQuatre!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + "4")
            }
        })

        buttonCinq!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + "5")
            }
        })

        buttonSix!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + "6")
            }
        })

        buttonSept!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + "7")
            }
        })

        buttonHuit!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + "8")
            }
        })

        buttonNeuf!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                editText!!.setText(editText!!.text.toString() + "9")
            }
        })

        buttonPlus!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                calcul()
                OPERATION = ADDITION
                infoTextView!!.setText(decimalFormat!!.format(valeurUne) + "+")
                editText!!.setText(null)
            }
        })

        buttonMoins!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                calcul()
                OPERATION = SOUSTRACTION
                infoTextView!!.setText(decimalFormat!!.format(valeurUne) + "-")
                editText!!.setText(null)
            }
        })

        buttonFoix!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                calcul()
                OPERATION = MULTIPLICATION
                infoTextView!!.setText(decimalFormat!!.format(valeurUne) + "*")
                editText!!.setText(null)
            }
        })

        buttonDiviser!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                calcul()
                OPERATION = DIVISION
                infoTextView!!.setText(decimalFormat!!.format(valeurUne) + "/")
                editText!!.setText(null)
            }
        })

        buttonEgale!!.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")

            override fun onClick(view: View) {
                calcul()
                infoTextView!!.setText(infoTextView!!.getText().toString() +
                        decimalFormat!!.format(valeurDeux) + " = " + decimalFormat!!.format(valeurUne))
                valeurUne = Double.NaN
                OPERATION = '0'
            }
        })

        buttonClear!!.setOnClickListener(object : View.OnClickListener {

            override fun onClick(view: View) {
                if (editText!!.getText().length > 0) {
                    val currentText = editText!!.getText()
                    editText!!.setText(currentText.subSequence(0, currentText.length - 1))
                } else {
                    valeurUne = Double.NaN
                    valeurDeux = Double.NaN
                    editText!!.setText("")
                    infoTextView!!.setText("")
                }
            }
        })
    }

    private fun calcul() {
        if (!((valeurUne).isNaN())) {
            //valeurDeux = (Double)(editText!!.text.toString())
            valeurDeux = (editText!!.text.toString()).toDouble()
            editText!!.setText(null)

            if (OPERATION == ADDITION)
                valeurUne = this.valeurUne + valeurDeux
            else if (OPERATION == SOUSTRACTION)
                valeurUne = this.valeurUne - valeurDeux
            else if (OPERATION == MULTIPLICATION)
                valeurUne = this.valeurUne * valeurDeux
            else if (OPERATION == DIVISION)
                valeurUne = this.valeurUne / valeurDeux
        } else {
            try {
                valeurUne = (editText!!.text.toString()).toDouble()
            } catch (e: Exception) {
            }

        }
    }

    companion object {


        private val ADDITION = '+'
        private val SOUSTRACTION = '-'
        private val MULTIPLICATION = '*'
        private val DIVISION = '/'
    }
}
