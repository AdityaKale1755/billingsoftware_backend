package in.Aditya.billingsoftware.service;

import in.Aditya.billingsoftware.Entity.categoryEntity;
import in.Aditya.billingsoftware.io.categoryRequest;
import in.Aditya.billingsoftware.io.categoryResponse;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

public interface categoryService {

    categoryResponse addCategory(categoryRequest request);

    List<categoryResponse> read();

//    void deleteCategory(String categoryId);
    void delete(String categoryId);
}
