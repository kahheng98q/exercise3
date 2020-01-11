package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit  var age:Spinner
    lateinit  var gender:RadioGroup
    lateinit  var smoker: CheckBox
    lateinit  var calButton: Button
    lateinit  var reButton: Button
    lateinit  var total: TextView
    var price=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        age = findViewById(R.id.spinnerAge)
        gender = findViewById(R.id.radioGroupGender)
        smoker = findViewById(R.id.checkBoxSmoker)
        calButton = findViewById(R.id.buttonCalculate)
        reButton = findViewById(R.id.buttonReset)
        total=findViewById(R.id.textViewPremium)
//        gender.setOnCheckedChangeListener(
//            RadioGroup.OnCheckedChangeListener { group, checkedId ->
//                val radio: RadioButton = findViewById(checkedId)
//                Toast.makeText(applicationContext," On checked change : ${radio.text}",
//                    Toast.LENGTH_SHORT).show()
//            })


        calButton.setOnClickListener {
            // Get the checked radio button id from radio group
            var id: Int = gender.checkedRadioButtonId

            // Get the instance of radio button using id
            val radio: RadioButton = findViewById(id)
//            Toast.makeText(applicationContext,age.selectedItemPosition.toString(),
//                    Toast.LENGTH_SHORT).show()
            if(age.selectedItemPosition==0){
                total.text="Insurance Premium:RM60"
            }else if(age.selectedItemPosition==1){
                price=70
                if(radio.text.toString().equals("Male")){
                    price=price+50
                }
                if(smoker.isChecked){
                    price=price+100
                }
                total.setText("Insurance Premium:RM"+price)

            }else if(age.selectedItemPosition==2){
                price=90
                if(radio.text.toString().equals("Male")){
                    price=price+100
                }
                if(smoker.isChecked){
                    price=price+150
                }
                total.setText("Insurance Premium:RM"+price)
            }else if(age.selectedItemPosition==3){
                price=120
                if(radio.text.toString().equals("Male")){
                    price=price+150
                }
                if(smoker.isChecked){
                    price=price+200
                }
                total.setText("Insurance Premium:RM"+price)
            }else if(age.selectedItemPosition==4){
                price=150
                if(radio.text.toString().equals("Male")){
                    price=price+200
                }
                if(smoker.isChecked){
                    price=price+250
                }
                total.setText("Insurance Premium:RM"+price)
            }else{
                price=150
                if(radio.text.toString().equals("Male")){
                    price=price+200
                }
                if(smoker.isChecked){
                    price=price+300
                }
                total.setText("Insurance Premium:RM"+price)
            }
//
//
        }

        reButton.setOnClickListener {
            total.text="Insurance Premium:"
            age.setSelection(0)
            gender.clearCheck()
            smoker.isChecked=false

        }
    }
}
