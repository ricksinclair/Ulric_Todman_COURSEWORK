package com.trilogyed.commentqueueconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.commentqueueconsumer.util.feign.CommentFeignClient;
import com.trilogyed.commentqueueconsumer.util.messages.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {


    @Autowired
    CommentFeignClient client;



    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(Comment msg){

        if(msg.getCommentId()!=0){
            client.updateComment(msg, msg.getCommentId());
        } else{
            client.addComment(msg);
        }





    }

}
