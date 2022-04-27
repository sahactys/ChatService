import org.junit.Assert.*
import org.junit.Test

class ChatServiceTest {

    @Test
    fun createPersonTrue() {
        ChatService.clear()
        val result = ChatService.createPerson("login")
        assertTrue(result)
    }

    @Test
    fun createPersonFalse() {
        ChatService.clear()
        ChatService.createPerson("login")
        val result = ChatService.createPerson("login")
        assertFalse(result)
    }


    @Test
    fun createChatTrue() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        val result = ChatService.createChat(0,"")
        assertTrue(result)
    }

    @Test
    fun createChatFalse() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        val result = ChatService.createChat(0,"")
        assertFalse(result)
    }

    @Test
    fun deleteChatTrue() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        val result = ChatService.deleteChat(0)
        assertTrue(result)
    }

    @Test
    fun deleteChatFalse() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        val result = ChatService.deleteChat(3)
        assertFalse(result)
    }

    @Test
    fun sendMessageTrue() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        val result = ChatService.sendMessage(0,"")
        assertTrue(result)
    }

    @Test
    fun sendMessageFalse() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        val result = ChatService.sendMessage(1,"")
        assertFalse(result)
    }

    @Test
    fun updateMessageTrue() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        ChatService.sendMessage(0,"")
        val result = ChatService.updateMessage(0,"abc",0)
        assertTrue(result)
    }

    @Test
    fun updateMessageFalse() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        ChatService.sendMessage(0,"")
        val result = ChatService.updateMessage(0,"abc",3)
        assertFalse(result)
    }

    @Test
    fun deleteMessageTrue() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        ChatService.sendMessage(0,"")
        val result = ChatService.deleteMessage(0,0)
        assertTrue(result)
    }

    @Test
    fun deleteMessageFalse() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        ChatService.sendMessage(0,"")
        val result = ChatService.deleteMessage(3,1)
        assertFalse(result)
    }

    @Test
    fun getUnreadChatsCount() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        ChatService.sendMessage(0,"")
        ChatService.changeCurrentPerson(1)
        val result = ChatService.getUnreadChatsCount()
        assertEquals(1,result)

    }

    @Test
    fun getMessagesInChatTrue() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        ChatService.sendMessage(0,"")
        ChatService.changeCurrentPerson(0)
        val result = ChatService.getMessagesInChat(1,0,3)
        assertTrue(result)
    }

    @Test
    fun getMessagesInChatFalse() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        ChatService.createChat(0,"")
        ChatService.sendMessage(0,"")
        ChatService.changeCurrentPerson(0)
        val result = ChatService.getMessagesInChat(0,0,3)
        assertFalse(result)
    }

    @Test
    fun changeCurrentPersonTrue() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        val result = ChatService.changeCurrentPerson(0)
        assertTrue(result)
    }

    @Test
    fun changeCurrentPersonFalse() {
        ChatService.clear()
        ChatService.createPerson("login1")
        ChatService.createPerson("login2")
        val result = ChatService.changeCurrentPerson(3)
        assertFalse(result)
    }
}