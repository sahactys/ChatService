import java.awt.Choice

object ChatService {
    val persons = mutableListOf<Person>()
    val chats = mutableListOf<Chat>()
    private var personIdCount = 0
    private var chatIdCount = 0
    private var currentPersonId = 0

    private fun idCreate(choice: Int): Int {
        return when (choice) {
            0 -> {
                personIdCount += 1
                personIdCount - 1
            }
            1 -> {
                chatIdCount += 1
                chatIdCount - 1
            }
            else -> error("Ошибка выбора режима работы idCreate")
        }
    }

    private fun chatSearch(toId: Int): Int {
        return chats.indexOfFirst {
            it.person1 == currentPersonId &&
                    it.person2 == toId ||
                    it.person1 == toId &&
                    it.person2 == currentPersonId
        }
    }

    fun createPerson(login: String): Boolean {
        return if (persons.indexOfFirst { it.login == login } == -1) {
            val id = idCreate(0)
            persons.add(Person(id, login))
            currentPersonId = id
            true
        } else {
            println("Пользователь с таким логином уже существет")
            false
        }

    }

    fun createChat(toId: Int, text: String): Boolean {
        return if (chatSearch(toId) == -1) {
            val id = idCreate(1)
            chats.add(Chat(id, currentPersonId, toId))
            sendMessage(toId, text)
            true
        } else {
            println("Такой чат уже существует")
            false
        }
    }

    fun deleteChat(id: Int): Boolean {
        return if (chats.indexOfFirst { it.id == id } != -1) {
            chats.removeAt(chats.indexOfFirst { it.id == id })
            true
        } else{
            println("Чат не найден")
            false
        }
    }

    fun personChats(): List<Chat> {
        return chats.filter { it.person1 == currentPersonId || it.person2 == currentPersonId }
    }

    fun sendMessage(toId: Int, text: String): Boolean {
        return if (chatSearch(toId) != -1) {
            val id = chats[chatSearch(toId)].messageIdGenerator()
            chats[chatSearch(toId)].messages.add(Message(id, from = currentPersonId, to = toId, message = text))
            true
        } else {
            println("Чат не найден")
            false
        }
    }

    fun updateMessage(toId: Int, text: String, messageId: Int): Boolean {
        return if (chatSearch(toId) != -1) {
            if (chats[chatSearch(toId)].messages.indexOfFirst { it.id == messageId }!=-1){
                chats[chatSearch(toId)].messages[chats[chatSearch(toId)].messages.indexOfFirst { it.id == messageId }] = Message(messageId,
                    currentPersonId, toId, text)
                true
            } else {
                println("Сообщение не найдено")
                false
            }
        } else{
            println("Чат не найден")
            false
        }
    }

    fun deleteMessage(toId: Int,messageId: Int):Boolean{
        return if (chatSearch(toId) != -1) {
            return if (chats[chatSearch(toId)].messages.indexOfFirst { it.id == messageId }!=-1){
                chats[chatSearch(toId)].messages.removeAt(chats[chatSearch(toId)].messages.indexOfFirst { it.id == messageId })
                true
            } else {
                println("Сообщение не найдено")
                false
            }
        }else {
            println("Чат не найден")
            false
        }
    }

    fun getUnreadChatsCount():Int{
        return personChats().filter { it.messages.find { !it.reading }!=null }.size
        }




}