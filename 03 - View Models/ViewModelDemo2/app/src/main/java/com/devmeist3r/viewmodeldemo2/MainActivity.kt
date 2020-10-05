package com.devmeist3r.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devmeist3r.viewmodeldemo2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Criar o bind
    private lateinit var binding: ActivityMainBinding
    // Criar a viewModel
    private lateinit var viewModel: MainActivityViewModel
    // Criar modelFactory
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // remover o setContentView()
        // setContentView(R.layout.activity_main)

        // criar o binding de DataBidndingUtil
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //Iniciar o valor do viewlModelFactory
        viewModelFactory = MainActivityViewModelFactory(0)
        // associar ao viewModelProvider
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        viewModel.totalData.observe(this, Observer {
            binding.resultTextView.text = it.toString()
        })

               // adicionar funçao do click para um botao
        binding.insertButton.setOnClickListener {
            if (binding.inputEditText.text.toString() != "") {
                viewModel.setTotal(binding.inputEditText.text.toString().toInt())
                binding.inputEditText.setText("")
            } else {
                Toast.makeText(this, "Informe um valor", Toast.LENGTH_LONG).show()
            }

        }
    }
}