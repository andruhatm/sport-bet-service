package ru.student.data.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="categories_file")
public class CategoryFile {

  /**
   * айди файла
   */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_file_id", unique = true, nullable = false)
    private Integer categoryFileId;

  /**
   * имя файла
   */
    @Column(name="categories_file_name", nullable = false)
    private String categoryFileName;

  /**
   *  лист медиа
   */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriesFile")
    private List<Media> media;

    public void setMedia(List<Media> media) {
        this.media = media;
        for (Media md : media) {
            md.setCategoriesFile(this);
        }
    }
}
