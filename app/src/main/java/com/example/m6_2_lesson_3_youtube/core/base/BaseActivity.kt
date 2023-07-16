package com.example.m6_2_lesson_3_youtube.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding, VM: BaseViewModel>: AppCompatActivity() {

    private lateinit var binding: VB
    abstract var viewModel: VM
    protected  abstract fun inflateVB(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateVB()
        setContentView(binding.root)

        checkInternet()
        initViewModel()
        initView()
        initListener()
    }

    open fun initView() {}

    open fun initViewModel() {}

    open fun initListener() {}

    open fun checkInternet() {}
}