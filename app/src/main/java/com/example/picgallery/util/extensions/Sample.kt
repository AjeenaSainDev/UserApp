package com.example.picgallery.util.extensions

import coil.map.Mapper
import com.example.picgallery.util.problemsolving.Student
import countVowels
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    val input = "Hello Dear"

    val student =Student("aju",9)
    student.apply {
        name = "rahul"
    }.also { println() }

    println(oddNumbersinReverse(arrayOf(1,2,8,4,9,3,7,11,33)))
showSquareofnumbers()

}
fun <T,R> highOrderFunction(numbers:List<T>,mapper: (T)->R):List<R>{
    return  numbers.map{mapper(it)}
}
fun String.countVowelLteers():Int{
    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    return count{it in vowels}
}
fun showSquareofnumbers(){
    val numbers = listOf(1,2,3)
    //val sqaur = numbers.map { it * it }
    val square = highOrderFunction(numbers){it * it }
    println(square)
}
fun sampleWhen(input:String){
    when (input) {
      //  is Int -> println("It's a String")
        //is Double -> println("It's an Int")
        else -> println("It's something else")
    }
}

fun GuGuideide(){
    println("hello")
    Teach()
    println("end")
}

inline fun Teach(){
    println("teach")
}

val modeOperation = {a:Int -> a%2 != 0}
val oddNumbersinReverse : (Array<Int>) -> Unit ={it
    var  oddnumbers : Array<Int>
     oddnumbers = it.filter{ modeOperation(it)}.toTypedArray()
    oddnumbers.reversed().forEach { println(it) }
    print(oddnumbers)
}