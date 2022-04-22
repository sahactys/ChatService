fun main(){
val abc = mutableListOf<Person>()
    val tim=Person("qwe","123")
    abc.add(tim)
    val asd = abc.indexOfFirst {it.login==tim.login }
    println(asd)
}