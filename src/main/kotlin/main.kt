fun main() {
    ChatService.createPerson("Иван")
    ChatService.createPerson("Сергей")
    ChatService.createChat(0,"first")
    ChatService.sendMessage(0,"dva")
    ChatService.changeCurrentPerson(0)
    println(ChatService.getUnreadChatsCount())
    ChatService.getMessagesInChat(1,0,55)
    println(ChatService.getUnreadChatsCount())

}