package com.example.beratbadan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beratbadan.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = ArrayList<data>()
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        var adapter = RecyclerViewAdapter(data)


        with(binding){
            hitung.setOnClickListener {
                Toast.makeText(this@MainActivity, "ok", Toast.LENGTH_SHORT).show()
                var nama = Namafield.text
                var group1 = groupid.checkedRadioButtonId
                val radioButton: RadioButton = findViewById(group1)
                val value = radioButton.text
                var berat = 0.0
                var tinggi = fieldtinggi.text
                if(perempuan.isChecked) {
                     berat = (Integer.parseInt(tinggi.toString()) - 100) * 0.85
                }
                else{
                    berat =  (Integer.parseInt(tinggi.toString()) - 100) * 0.9
                }
                data.add(data(name = nama.toString(), gender = value.toString(), height = Integer.parseInt(tinggi.toString()), weight = berat.toInt()))
             adapter = RecyclerViewAdapter(data)
                binding.recyclerview.adapter =  adapter
                adapter.setOnItemClickListener(object : RecyclerViewAdapter.OnItemClickListener{
                    override fun onItemClick(position: Int) {
                        Toast.makeText(this@MainActivity, "ok", Toast.LENGTH_SHORT).show()
                    }
                })
            }
    }

    }

}