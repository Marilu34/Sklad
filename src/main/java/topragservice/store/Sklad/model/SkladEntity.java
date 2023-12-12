package topragservice.store.Sklad.model;

import lombok.Getter;
import lombok.Setter;
import topragservice.store.Sklad.properties.StringListConverter;

import javax.persistence.*;
import java.util.List;


/**
 * Сущность, представляющая склад.
 */
@Entity
@Table(name = "warehouse")
@Getter
@Setter
public class SkladEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "point_name")
    private String pointName;

    @Column(name = "point_address")
    private String pointAddress;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column
    @Convert(converter = StringListConverter.class)
    private List<String> urlImages;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "big_cell")
    private Integer bigCell;

    @Column(name = "medium_cell")
    private Integer mediumCell;

    @Column(name = "small_cell")
    private Integer smallCell;

    @Transient
    private Integer countFreeCell;
}
