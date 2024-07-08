//package com.sfc.study.kafka;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import com.sfc.study.kafka.service.KafkaProducerService;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.header.internals.RecordHeaders;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.util.concurrent.ListenableFuture;
//
//@ExtendWith(MockitoExtension.class)
//public class KafkaProducerFailTest {
//
//    @Mock
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    @InjectMocks
//    private KafkaProducerService kafkaProducerService;
//
//    @Captor
//    private ArgumentCaptor<ProducerRecord<String, String>> recordCaptor;
//
//    @Test
//    public void testSendMessage() {
//        // Arrange
//        String topic = "test-topic";
//        String message = "test-message";
//
//        // Act
//        kafkaProducerService.sendMessage(topic, message);
//
//        // Assert
//        verify(kafkaTemplate, times(1)).send(recordCaptor.capture());
//
//        ProducerRecord<String, String> capturedRecord = recordCaptor.getValue();
//        assertEquals(topic, capturedRecord.topic());
//        assertEquals(message, capturedRecord.value());
//    }
//}
