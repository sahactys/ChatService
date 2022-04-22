class Person(
    val login:String,
    val password:String
){
    fun registration(person: Person) {
        while (true) {
            val currentPersons = ChatService.getPersonsCopy()
            val loginAnsw = currentPersons.indexOfFirst { it.login == person.login }
            if (loginAnsw != -1) println("Логин занят, введите другой")
            else break
        }
        persons.add(person)
    }




}