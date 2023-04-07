package com.marco.springcloud.msvc.users.msvcusers.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marco.springcloud.msvc.users.msvcusers.model.dto.UserDTO;
import com.marco.springcloud.msvc.users.msvcusers.model.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ProduceProduct
{
    private String kafkaTopic;
    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;


    public ProduceProduct( @Value( "${kafka.topic.create.product}" ) final  String kafkaTopic,
                        final KafkaTemplate<String, String> kafkaTemplate,
                        final ObjectMapper objectMapper)
    {
        this.kafkaTopic = kafkaTopic;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }


    public String sendMessage( final Product product)
          throws JsonProcessingException
    {
        String userMessage = objectMapper.writeValueAsString(product);
        kafkaTemplate.send(kafkaTopic, userMessage);

        log.info("create product produced {}", product);

        return "message sent";
    }
}
