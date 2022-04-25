fun main() {
    ChatService.createPerson("Иван")
    ChatService.createPerson("Сергей")
    ChatService.createPerson("Дмитрий")
    ChatService.createChat(0,"aaa")
    ChatService.sendMessage(0,"bbb")
    ChatService.createChat(1,"aaa")
    ChatService.updateMessage(0,"ccc",1)
    ChatService.deleteMessage(5,1)
    println(ChatService.personChats().map { it.messages })
    println(ChatService.getUnreadChatsCount())

}