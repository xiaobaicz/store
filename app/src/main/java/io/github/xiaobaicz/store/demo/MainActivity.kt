package io.github.xiaobaicz.store.demo

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import io.github.xiaobaicz.store.demo.databinding.ActivityMainBinding
import io.github.xiaobaicz.store.demo.store.Local
import io.github.xiaobaicz.store.store

class MainActivity : FragmentActivity() {
    private val bind by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val local: Local = store()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        bind.lifecycleOwner = this
        bind.local = local
    }
}