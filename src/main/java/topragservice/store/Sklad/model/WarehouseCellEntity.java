package topragservice.store.Sklad.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "warehouse_cell")
@Getter
@Setter
public class WarehouseCellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "number")
    private int number;

    @Column(name = "category")
    private String category;

    @Column(name = "area")
    private double area;

    @Column(name = "length")
    private double length;

    @Column(name = "width")
    private double width;

    @Column(name = "height")
    private double height;

    @Column(name = "tier")
    private int tier;

    @Column(name = "price")
    private double price;

    @Column(name = "busy")
    private boolean busy;

    @Column(name = "lock_key")
    private String lockKey;
}
