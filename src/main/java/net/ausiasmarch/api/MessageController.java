/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.ausiasmarch.entity.MessageEntity;
import net.ausiasmarch.service.implementation.specific.MessageService;
import net.ausiasmarch.service.implementation.specific.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/messages")
public class MessageController {
    
   @Autowired
    MessageService oMessageService;
    UserService oUserService;
    @Autowired
    private SimpMessageSendingOperations simpMessagingTemplate;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> useSimpleRest(@RequestBody  Map<String, String> message){
        if(message.containsKey("body")){
        	//if the toId is present the message will be sent privately else broadcast it to all users
            if(message.containsKey("to_id") && message.get("to_id")!=null && !message.get("to_id").equals("")){
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/"+message.get(""),message);
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/"+message.get("from_id"),message);
                System.out.println("Por rest");
            }else{
                this.simpMessagingTemplate.convertAndSend("/socket-publisher",message);
            }
            return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    
    @MessageMapping("/send/message")
    public Map<String,String> useSocketCommunication(@Payload String body) throws InterruptedException{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> messageConverted = null;
        MessageEntity oMessageEntity = new MessageEntity();
        try {
            messageConverted = mapper.readValue(body, Map.class);
        } catch (IOException e) {
            messageConverted = null;
        }
        if(messageConverted!=null){
            if(messageConverted.containsKey("to") && messageConverted.get("to")!=null && !messageConverted.get("to").equals("")){
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/"+messageConverted.get("to"),messageConverted);
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/"+messageConverted.get("from"),body);
                Integer to_id = Integer.parseInt(messageConverted.get("to"));
                Integer from_id = Integer.parseInt(messageConverted.get("from"));
                String message = messageConverted.get("body");
                Date now =new java.sql.Date(new java.util.Date().getTime());
                oMessageService.send(to_id,from_id,message,now);
                //oMessageEntity = oMessageService.getMessage(to_id,from_id,message,now);
            }else{
                this.simpMessagingTemplate.convertAndSend("/socket-publisher",messageConverted);
            }
        }
        simulatedDelay();
        return messageConverted;
        //return new ResponseEntity<>(messageConverted, HttpStatus.OK);
    }
   
    private void simulatedDelay() throws InterruptedException {
    Thread.sleep(3000);
    }
    
     @GetMapping("/getpagechat/{page}/{rpp}/{to_id}/{from_id}")
    public ResponseEntity<List<MessageEntity>> getPageChat(
          @PathVariable(value = "page") int page,
          @PathVariable(value = "rpp") int rpp,
          @PathVariable(value = "to_id") int to_id,
          @PathVariable(value = "from_id") int from_id) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp, Sort.by(Sort.Order.desc("date")));
        return new ResponseEntity<>(oMessageService.getPageChat(oPageable, to_id, from_id), HttpStatus.OK);
    }
    
       /*
    @GetMapping("/{id}")
    public ResponseEntity<MessageEntity> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>((MessageEntity) oMessageService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<MessageEntity>> get() {
        return new ResponseEntity<>(oMessageService.getall(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(oMessageService.count(), HttpStatus.OK);
    }

    @GetMapping("/getpage/{page}/{rpp}")
    public ResponseEntity<Page<MessageEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(oMessageService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(oMessageService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<MessageEntity> create(@RequestBody GenericEntityInterface oMessageEntity) {
        return new ResponseEntity<>((MessageEntity) oMessageService.create(oMessageEntity), HttpStatus.OK);
    }

    @PutMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<MessageEntity> update(@RequestBody GenericEntityInterface oMessageEntity) {
        return new ResponseEntity<>((MessageEntity) oMessageService.update(oMessageEntity), HttpStatus.OK);
    }
 
 */

}
