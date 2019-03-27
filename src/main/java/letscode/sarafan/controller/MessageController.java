package letscode.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Message;
import letscode.sarafan.domain.User;
import letscode.sarafan.domain.Views;
import letscode.sarafan.dto.MessagePageDto;
import letscode.sarafan.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("message")
public class MessageController {
    public static final int MESSAGES_PER_PAGE = 3;

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    /** Получение списка всех сообщений
     *
     * @return
     */
    @GetMapping
    @JsonView(Views.FullMessage.class)
    public MessagePageDto list(
            @AuthenticationPrincipal User user,
            @PageableDefault(size = MESSAGES_PER_PAGE, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return messageService.findForUser(pageable, user);
    }

    /** Получение сообщения по номеру id (пример: http://localhost:8080/message/2)
     *
     * @param message
     * @return
     */
    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }


    /** Добавление нового объекта в коллекцию методом POST
     *
     * @param message
     * @return
     */
    @PostMapping
    public Message create(
            @RequestBody Message message,
            @AuthenticationPrincipal User user
    ) throws IOException {
        return messageService.create(message, user);
    }

    /** Обновление записи по id
     *
     *
     * @param message
     * @return
     */

    @PutMapping("{id}")
    public Message update(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message
    ) throws IOException {
        return messageService.update(messageFromDb, message);
    }

    /** Удаление объекта по id
     *
     * @param message
     */

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageService.delete(message);
    }
}
