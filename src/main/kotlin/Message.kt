class Message {
    fun getMessageByKey(key: String): String {
        return messageCodeList[key] ?: "WRONG_KEY"
    }
}