package com.example.picgallery.util.problemsolving

data class NodeSample<T:Any>(
    var  value:T,
    var next:NodeSample<T>?=null
) {
    override fun toString(): String {
        return if(next !== null ){
            "$value -> ${next.toString()}"
        }
        else{
            //print last value
            "$value"
        }


    }

    fun PrintInReverse(){
        next?.PrintInReverse()

        if(next !== null ){
            print("->")
        }
        print(value.toString())
    }
}