package com.example.demo

import org.springframework.stereotype.Service

@Service
class TopicService {
    private var topics = mutableListOf(
            Topic("spring", "spring framework", "spring description"),
            Topic("java", "java framework", "java description"),
            Topic("java script", "java script framework", "java script description")
    )

    fun getAll() = topics

    fun getTopic(id: String) = topics.filter({ it -> it.id == id }).firstOrNull()

    // return Boolean. true success otherwise failed
    fun addTopic(topic: Topic) = topics.add(topic)

    fun updateTopic(id: String, topic: Topic):Int {
        var list = topics.filter({ it -> it.id == id }).firstOrNull()
        if (list == null)
            return -1
        else
            topics.set(topics.indexOf(list), topic)
        return 0
    }

    //true : success otherwise false
    fun deleteTopic(id: String): Boolean{
        val ret = topics.removeIf({ it -> it.id.equals(id) })
        return ret
    }
}