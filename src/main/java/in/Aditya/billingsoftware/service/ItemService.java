package in.Aditya.billingsoftware.service;

import in.Aditya.billingsoftware.io.ItemRequest;
import in.Aditya.billingsoftware.io.ItemResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    //used when image handling is done" ItemResponse add(ItemRequest request, MultipartFile file);

    ItemResponse add(ItemRequest request);

    List<ItemResponse>fetchItems();

    void deleteItem(String itemId);
}
