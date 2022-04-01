package ru.molinov.viewpagerdesign.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.molinov.viewpagerdesign.R

@Parcelize
data class Data(
    val dataClasses: List<Class> = listClasses(),
    val dataHomework: List<Homework> = listHomework()
) : Parcelable

@Parcelize
data class Class(
    val title: String,
    val time: String,
    val teacher: String,
    val skype: Boolean,
    val isElective: Boolean
) : Parcelable

@Parcelize
data class Homework(
    val title: String,
    val titleIcon: Int,
    val daysLeft: Int,
    val description: String,
    val icons: Int
) : Parcelable

fun listClasses(): List<Class> {
    return listOf(
        Class("History", "8:00 - 8:45", "Mrs Thomas", true, isElective = false),
        Class("Literature", "9:00 - 9:45", "Mrs Barros", false, isElective = false),
        Class("Physical Education", "10:00 - 11:35", "Mr Barros", false, isElective = true),
        Class("Physics", "12:00 - 12:45", "Mrs Williams", true, isElective = false),
        Class("Economics", "13:00 - 13:45", "Mr Guriev", true, isElective = false),
        Class("Mathematics", "14:00 - 14:45", "Mrs White", false, isElective = false),
        Class("Psychology", "13:00 - 14:35", "Mr Madness", true, isElective = true)
    )
}

fun listHomework(): List<Homework> {
    return listOf(
        Homework("Literature", R.drawable.thailand_flag, 2, descriptions[1], 2),
        Homework("Physics", R.drawable.turkey_flag, 5, descriptions[2], 2),
        Homework("History", R.drawable.turkey_flag, 6, descriptions[1], 1),
        Homework("Economics", R.drawable.turkey_flag, 7, descriptions[1], 3),
        Homework("Mathematics", R.drawable.turkey_flag, 8, descriptions[1], 0)
    )
}

private val descriptions = listOf(
    "Read scenes 1.1-1.12 of The Master and Margarita",
    "Learn Newton's laws of motion",
    "Intensive preparation for The Junior World Championship in Los Angeles"
)
