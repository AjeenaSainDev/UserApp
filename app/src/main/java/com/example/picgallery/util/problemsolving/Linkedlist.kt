package com.example.picgallery.util.problemsolving

import java.util.LinkedList

fun main(){
    val linkedlist = Node(1, Node(2, Node(3,Node(4,Node(5)))))
    println(linkedlist)
    println("$linkedlist.next_node")
    linkedlist.reverseListValue()
}

