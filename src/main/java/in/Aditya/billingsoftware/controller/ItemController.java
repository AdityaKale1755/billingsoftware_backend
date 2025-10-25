package in.Aditya.billingsoftware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.Aditya.billingsoftware.io.ItemRequest;
import in.Aditya.billingsoftware.io.ItemResponse;
import in.Aditya.billingsoftware.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin/items")//4.48.49
    public ItemResponse addItem(@RequestBody ItemRequest request){
        try {
            return  itemService.add(request);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unable to create User"+e.getMessage());
        }
    }

    @GetMapping("/items")
    public List<ItemResponse> readItems(){
        return itemService.fetchItems();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/admin/items/{itemId}")
    public void removeItem(@PathVariable String itemId){
        try{
            itemService.deleteItem(itemId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
