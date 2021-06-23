package ru.student.data.mapstruct;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.student.data.dto.CategoriesMediaDTO;
import ru.student.data.model.CategoryFile;
import ru.student.data.repo.CategoryFileRepository;

import java.util.List;

/**
 * Маппер для категорий медиа
 */
@Mapper(componentModel="spring")
public abstract class CategoriesMediaMapper {
    @Autowired
    private CategoryFileRepository categoryFileRepository;

    public abstract CategoriesMediaDTO toCategoriesMediaDTo(CategoryFile categoryFile);
    public abstract List<CategoriesMediaDTO> toCategoriesMediaDTos(List<CategoryFile> categoryFile);
    public CategoryFile findCategoryFileById(CategoriesMediaDTO categoriesMediaDTO) {
        if (categoriesMediaDTO != null) {
            int id = categoriesMediaDTO.getCategoryFileId();
            return categoryFileRepository.findById(id).
                    orElseThrow();
        }else return null;
    }
}
