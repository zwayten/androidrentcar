package com.example.exam
const val PICTURE="PICTURE"
const val NAME="NAME"

const val DISPO="DISPO"
const val PRIX="PRIX"
data class Champion(
    val champPic:Int,
    val Nom:String,
    val dispo:String,
    val prix:Int
){
}