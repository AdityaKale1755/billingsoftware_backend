package in.Aditya.billingsoftware.controller;

import in.Aditya.billingsoftware.io.categoryRequest;
import in.Aditya.billingsoftware.io.categoryResponse;
import in.Aditya.billingsoftware.service.categoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@CrossOrigin("*")
@RestController
//@RequestMapping("/categories")
@RequiredArgsConstructor
public class categoryController {
    private final categoryService categoryservice;

    @PostMapping("/admin/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public categoryResponse addCategory(@RequestBody categoryRequest request) {
        return categoryservice.addCategory(request);
    }


    @GetMapping("/categories")
    public List<categoryResponse> fetchCategories() {
        return categoryservice.read();
    }

//    @DeleteMapping("/{categoryId}")
//    public void remove(@PathVariable String categoryId) {
//        try {
//            categoryservice.deleteCategory(categoryId);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
//        }
//    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public void remove(@PathVariable String categoryId){
        try {
            categoryservice.delete(categoryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
}
