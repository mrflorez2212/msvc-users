package com.marco.springcloud.msvc.users.msvcusers.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marco.springcloud.msvc.users.msvcusers.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Component

public class ProduceUser
{

    private String kafkaTopic;
    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;


    public ProduceUser( @Value( "${kafka.topic.create.user}" ) final  String kafkaTopic,
                        final KafkaTemplate<String, String> kafkaTemplate,
                        final ObjectMapper objectMapper)
    {
        this.kafkaTopic = kafkaTopic;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }


    public String sendMessage( final UserDTO userDTO)
          throws JsonProcessingException
    {
        String userMessage = objectMapper.writeValueAsString(userDTO);
        kafkaTemplate.send(kafkaTopic, userMessage);

        log.info("create user produced {}", userDTO);

        return "message sent";
    }

}
