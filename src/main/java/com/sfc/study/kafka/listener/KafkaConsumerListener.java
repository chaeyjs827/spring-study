//package com.sfc.study.kafka.listener;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaConsumerListener {
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaConsumerListener(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @KafkaListener(topics = "test-topic", groupId = "test-group")
//    public void listen(String message, Acknowledgment acknowledgment) {
//        System.out.println("Received message: " + message);
//        try {
//            processMessage(message);
//            acknowledgment.acknowledge();
//        } catch (Exception e) {
//            proccessFailedMessage(message);
//            // 실패 시에도 오프셋을 커밋하여 중복 처리를 방지
//            acknowledgment.acknowledge();
//        }
//
//
//    }
//
//    private void processMessage(String message) {
//        // 실제 메시지 처리 로직 구현
//        System.out.println("Processing message: " + message);
//    }
//
//    private void proccessFailedMessage(String message) {
//        // 메세지 처리 실패 시 dead letter queue로 전송
//        // KafkaConfig에서 DLQ를 전역으로 설정할 수 있다. (프로젝트 정책에 따라 선택)
//        kafkaTemplate.send("dead-letter-topic", message);
//    }
//}
