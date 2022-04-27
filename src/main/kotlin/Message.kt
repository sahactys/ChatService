class Message(
    val id:Int,
    val from:Int,
    val to:Int,
    var message: String,
    var reading:Boolean=false
){
    override fun toString(): String {
        return "Message(id=$id, from=$from, to=$to, message='$message', reading=$reading)"
    }


}