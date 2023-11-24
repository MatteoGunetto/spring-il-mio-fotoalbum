package org.project.java.fotoAlbum.api;

import java.util.List;
import java.util.Optional;

import org.project.java.fotoAlbum.api.dto.MessageDto;
import org.project.java.fotoAlbum.db.foto.Message;
import org.project.java.fotoAlbum.db.serv.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/messages")
public class MessageRestController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> fetchAllMessages(){
        List<Message> messages = messageService.findAll();
        return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
    }

    @GetMapping("/filter/{filter}")
    public ResponseEntity<List<Message>> fetchFilteredMessages(@PathVariable String filter){
        List<Message> messages = messageService.findByEmail(filter);
        return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> saveMessage(@RequestBody MessageDto messageDto){
        Message message = new Message(messageDto);
        message = messageService.save(message);

        return new ResponseEntity<>(message.getId(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> fetchMessage(@PathVariable int id){
        Optional<Message> messageOpt = messageService.findById(id);

        if(messageOpt.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(messageOpt.get(), HttpStatus.OK);
        }
    }

}