package in.Aditya.billingsoftware.implementation;

import in.Aditya.billingsoftware.Entity.categoryEntity;
import in.Aditya.billingsoftware.io.categoryRequest;
import in.Aditya.billingsoftware.io.categoryResponse;
import in.Aditya.billingsoftware.repository.ItemRepository;
import in.Aditya.billingsoftware.repository.categoryRepository;
import in.Aditya.billingsoftware.service.categoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class categoryServiceImpl implements categoryService {

    private final categoryRepository categoryrepository;

    private final ItemRepository itemRepository;
    @Override
    public categoryResponse addCategory(categoryRequest request) {

        categoryEntity newCategory=convertToEntity(request);
        newCategory=categoryrepository.save(newCategory);
        return convertToResponse(newCategory);
    }

    @Override
    public List<categoryResponse> read() {
        return categoryrepository.findAll()
                .stream()
                .map(categoryEntity -> convertToResponse(categoryEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId) {
       categoryEntity existing = categoryrepository.findByCategoryId(categoryId)
                .orElseThrow(()->new RuntimeException("Category Not Found :"+categoryId));

       categoryrepository.delete(existing);
    }

//    @Override
//    public void deleteCategory(String categoryId) {
//        categoryEntity existingCategory = categoryrepository.findByCategoryId(categoryId)
//                .orElseThrow(() -> new RuntimeException("Category not found: " + categoryId));
//
//        categoryrepository.delete(existingCategory);
//    }


    private categoryResponse convertToResponse(categoryEntity newCategory) {
        Integer itemsCount=itemRepository.countByCategory_Id(newCategory.getId());
       return categoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor())
                .imageUrl(newCategory.getImageUrl())
               .createdAt(newCategory.getCreatedAt())
               .updateAt(newCategory.getUpdateAt())
               .items(itemsCount)
               .build();

    }

    private categoryEntity convertToEntity(categoryRequest request) {
        return categoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }
}
