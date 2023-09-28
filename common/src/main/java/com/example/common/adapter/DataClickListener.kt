package com.example.common.adapter

interface DataClickListener<T> {
    fun onClick(value: T, position: Int)

}