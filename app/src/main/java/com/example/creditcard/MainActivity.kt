package com.example.creditcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var crednum: EditText
    private lateinit var tve:EditText
    private lateinit var weli:EditText
    private lateinit var cvv:EditText
    private lateinit var button: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name=findViewById(R.id.name)
        crednum=findViewById(R.id.creditnum)
        tve=findViewById(R.id.tve)
        weli=findViewById(R.id.weli)
        cvv=findViewById(R.id.cvv)
        button=findViewById(R.id.button)
        button.setOnClickListener {
            if (!crednum.text.toString().isDigitsOnly() || crednum.text.toString().length!=16 || crednum.text.toString() == ""){
                Toast.makeText(this, "გთხოვთ, სწორად შეიყვანოთ ბარათის ნომერი", Toast.LENGTH_SHORT).show()
            } else  if (name.text.toString().length<8 || name.text.toString() == "" || !(name.text.toString().contains(" "))) {
                Toast.makeText(this, "გთხოვთ,სწორად შეიყვანოთ ბარათის სახელი", Toast.LENGTH_SHORT).show()
            } else if (!tve.text.toString().isDigitsOnly() || tve.text.toString().length!=2 || tve.text.toString().toInt() >12 || tve.text.toString() == "") {
                Toast.makeText(this, "გთხოვთ, სწორად შეიყვანოთ თვე", Toast.LENGTH_SHORT).show()
                }else if (!weli.text.toString().isDigitsOnly() || weli.text.toString().length!=4 || name.text.toString() == "") {
                Toast.makeText(this, "გთხოვთ, სწორად შეიყვანოთ წელი", Toast.LENGTH_SHORT).show()
                } else if ((weli.text.toString().toInt()==2022 && tve.text.toString().toInt()<11) || weli.text.toString().toInt()<2022) {
                Toast.makeText(this, "თქვენი საკრედიტო ბარათი ვადაგასულია", Toast.LENGTH_SHORT).show()
                } else if (!cvv.text.toString().isDigitsOnly() || cvv.text.toString().length!=3 || cvv.text.toString()=="") {
                Toast.makeText(this, "გთხოვთ, სწორად შეიყვანოთ CVV კოდი", Toast.LENGTH_SHORT).show()
                } else {
                Toast.makeText(this, "ოპერაცია წარმატებით შესრულდა, slayyyyyyyyyy!", Toast.LENGTH_SHORT).show()
                }
        }
    }
}