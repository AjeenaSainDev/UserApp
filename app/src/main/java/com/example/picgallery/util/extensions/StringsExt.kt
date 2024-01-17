

import kotlinx.coroutines.delay
import java.util.*

/**
 * This is the String extension function which we are using in multiple classes.
 * Extension Functions in Kotlin follows Decorator Pattern, it allows to extend the class or interface, without
 * making changes to the real class.
 */
fun String.capitalizeFirstLetter(): String {
    return replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(
            Locale.getDefault()
        ) else it.toString()
    }
}

 suspend fun String.countVowels(): Int{
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
     delay(5000L)
    return count {it in vowels}
}
fun String.countVowelLteers():Int{
    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    return count{it in vowels}
}
