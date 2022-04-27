class Chat (
    val id:Int,
    val person1:Int,
    val person2:Int,
){
    var messages = mutableListOf<Message>()
    private var messageIdGen=0
    fun messageIdGenerator():Int{
        messageIdGen+=1
        return messageIdGen-1
    }

    override fun toString(): String {
        return "Chat(id=$id, person1=$person1, person2=$person2, messages=${messages.last()}, messageIdGen=$messageIdGen)"
    }



}