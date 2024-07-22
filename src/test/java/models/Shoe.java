package models;

import enums.ShoeBrand;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Shoe {
    @EqualsAndHashCode.Include
    private String shoeName;
    private ShoeBrand shoeBrand;
    private String shoeModel;
    private String shoeCost;
    private String datePurchased;
    private String shoeSize;
    private String startingDistance;
    private String alertDistance;
    private String notes;
}
