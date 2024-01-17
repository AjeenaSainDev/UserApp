package com.example.picgallery.util.problemsolving

data class Node<T:Any>(
    var value:T,
    var next_node:Node<T>?=null
) {
    override fun toString(): String {
        return if(next_node !== null){
            "$value -> ${next_node.toString()}"
        }
        else{
            "$value"
        }
    }

    fun reverseListValue(){
        //print("$next_node \n")
          next_node?.reverseListValue()

        if (next_node !== null){
            print(" -> ")
        }
        print(value.toString())
    }
}