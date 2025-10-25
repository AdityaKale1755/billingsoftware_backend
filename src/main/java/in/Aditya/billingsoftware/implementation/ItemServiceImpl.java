package in.Aditya.billingsoftware.implementation;

import in.Aditya.billingsoftware.Entity.ItemEntity;
import in.Aditya.billingsoftware.Entity.categoryEntity;
import in.Aditya.billingsoftware.io.ItemRequest;
import in.Aditya.billingsoftware.io.ItemResponse;
import in.Aditya.billingsoftware.repository.ItemRepository;
import in.Aditya.billingsoftware.repository.categoryRepository;
import in.Aditya.billingsoftware.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final categoryRepository categoryRepository;

    @Override
    public ItemResponse add(ItemRequest request) {
        // used when img handling is done String imgUrl=fileUploadService.uploadFile(file);
        String imgUrl="";
        ItemEntity newItem=covertToEntity(request);
        categoryEntity existingCategory= categoryRepository.findByCategoryId(request.getCategoryId())
                .orElseThrow(()->new RuntimeException("Category Not Found"+request.getCategoryId()));

        newItem.setCategory(existingCategory);
        newItem.setImgUrl(imgUrl);
        newItem=itemRepository.save(newItem);
        return convertTOResponse(newItem);
    }

    private ItemResponse convertTOResponse(ItemEntity newItem) {
        return ItemResponse.builder()
                .itemId(newItem.getItemId())
                .name(newItem.getName())
                .description(newItem.getDescription())
                .price(newItem.getPrice())
                .imgUrl(newItem.getImgUrl())
                .categoryName(newItem.getCategory().getName())
                .categoryId(newItem.getCategory().getCategoryId())
                .createdAt(newItem.getCreatedAt())
                .updateAt(newItem.getUpdateAt())
                .build();
    }

    private ItemEntity covertToEntity(ItemRequest request) {
        return ItemEntity.builder()
                .itemId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

    @Override
    public List<ItemResponse> fetchItems() {
       return itemRepository.findAll()
                .stream()
                .map(itemEntity -> convertTOResponse(itemEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteItem(String itemId) {
        ItemEntity existingItem=itemRepository.findByItemId(itemId)
                .orElseThrow(()->new RuntimeException("Item Not Found"+itemId));

//        boolean isFileDelete=fileUploadService.deleteFile(existingItem.getImgUrl());
//        if (isFileDelete){
//            itemRepository.delete(existingItem);
//        }else {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"unable to Delete");
//        }

        itemRepository.delete(existingItem);
    }
}
