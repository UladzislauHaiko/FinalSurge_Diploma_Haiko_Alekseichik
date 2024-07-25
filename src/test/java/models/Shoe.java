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
    @EqualsAndHashCode.Include
    private String shoeCost;
    @EqualsAndHashCode.Include
    private String datePurchased;
    @EqualsAndHashCode.Include
    private String shoeSize;
    private String startingDistance;
    private String alertDistance;
    private String notes;
}
