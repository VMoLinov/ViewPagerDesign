package ru.molinov.viewpagerdesign.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.molinov.viewpagerdesign.R
import ru.molinov.viewpagerdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFragment.newInstance())
            .commit()
    }
}
