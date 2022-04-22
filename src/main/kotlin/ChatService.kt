import java.util.function.Predicate

//fun <T>check(
//    list: MutableList<T>,predicate: Predicate<T>
//):Boolean{
//
//}
//
//class Same{
//    operator fun invoke(value:String,value2: String):Boolean{
//        return value==value2
//    }
//}


object ChatService {
    private val persons = mutableListOf<Person>()
    private var currentPerson: Person
        get() {
            TODO()
        }
        set(value) {}


    fun getPersonsCopy():List<Person>{
        return persons.toList()
    }
    fun 
}