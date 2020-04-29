package ir.alirezaiyan.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.alirezaiyan.main.databinding.MainActivityBinding

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/29/2020 10:40 PM.
 */
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}