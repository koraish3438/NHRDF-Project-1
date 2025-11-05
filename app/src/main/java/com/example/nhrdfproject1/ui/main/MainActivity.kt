package com.example.nhrdfproject1.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nhrdfproject1.R
import com.example.nhrdfproject1.databinding.ActivityMainBinding
import com.example.nhrdfproject1.ui.adapter.ProductAdapter
import com.example.nhrdfproject1.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productViewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        productAdapter = ProductAdapter(emptyList())
        binding.recyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        productViewModel.products.observe(this) { products ->
            products?.let { productAdapter.updateProducts(it) }
        }

        binding.refreshBtn.setOnClickListener { productViewModel.refreshProducts() }
    }
}