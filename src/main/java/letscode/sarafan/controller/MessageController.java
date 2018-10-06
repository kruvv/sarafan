package letscode.sarafan.controller;


import letscode.sarafan.exeptions.NotFoundExeption;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {

    private int counter = 4;

    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("text", "First_message");}});
        add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Two_message");}});
        add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Three_message");}});
    }};

    /** Получение списка всех сообщений
     *
     * @return
     */
    @GetMapping
    public List<Map<String, String>> list() {
        return messages;
    }

    /** Получение сообщения по номеру id (пример: http://localhost:8080/message/2)
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getMessage(id);
    }

    private Map<String, String> getMessage(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundExeption::new);
    }

    /** Добавление нового объекта в коллекцию методом POST
     *
     * @param message
     * @return
     */
    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));
        messages.add(message);
        return message;
    }

    /** Обновление записи по id
     *
     * @param id
     * @param message
     * @return
     */
    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDB = getMessage(id);

        messageFromDB.putAll(message); //Может перезаписать id
        messageFromDB.put("id", id); // Восстанавливаем id  на всякий пожарный

        return messageFromDB;
    }

    /** Удаление объекта по id
     *
     * @param id
     */

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> message = getMessage(id);
        messages.remove(message);

    }
}
