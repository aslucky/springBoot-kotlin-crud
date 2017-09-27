package com.example.demo

import org.springframework.web.bind.annotation.*

@RestController
class controllerTopic(val topicService: TopicService) {

    @RequestMapping(value = "/",method = arrayOf(RequestMethod.GET))
    fun index():String = "hi there"

    @RequestMapping(value = "/topics",method = arrayOf(RequestMethod.GET))
    fun getAllTopic(): procResp{
        var resp = procResp(0,"success")
        resp.data = topicService.getAll()
        return resp
    }

    @RequestMapping(value = "topics/{id}",method = arrayOf(RequestMethod.GET))
    fun getTopic(@PathVariable id: String) : procResp
    {
        var resp = procResp(0,"success")
        resp.data = topicService.getTopic(id)
        return resp
    }

    @RequestMapping(value = "topics",method = arrayOf(RequestMethod.POST))
    fun addTopic(@RequestBody topic:Topic):procResp{
        var resp = procResp(if (topicService.addTopic(topic)) 0 else -1,"success")
        return resp
    }

    @RequestMapping(value = "topics/{id}",method = arrayOf(RequestMethod.PUT))
    fun updateTopic(@RequestBody topic:Topic, @PathVariable id:String):procResp{
        val ret = topicService.updateTopic(id, topic)
        var resp = procResp(ret,if (ret != 0) "error" else "success")
        return resp
    }

    @RequestMapping(value = "topics/{id}",method = arrayOf(RequestMethod.DELETE))
    fun deleteTopic(@PathVariable id: String) : procResp{
        val ret = if (topicService.deleteTopic(id)) 0 else -1
        var resp = procResp(ret ,if (ret != 0) "error" else "success")
        return resp
    }

}