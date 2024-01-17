package com.example.picgallery.util.problemsolving

import android.content.Intent

fun main(){
    //let
    //usualy using for check null and it will return last line of statement
    var number:Int ? = null
    var i = 0
    val x= number?.let {
        val number2 = it+1
        number2

    }?: 6

    //also


  fun  getSquare() = (i*i).also {
      i++
  }

   //apply modify objects, lot of changes with properties

   val intent=Intent().apply {
       putExtra("jj","kk")
   }


}