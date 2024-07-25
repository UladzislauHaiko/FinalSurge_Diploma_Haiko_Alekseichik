package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Runs {
    private String date;
    private String time;
    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private String description;
    private boolean showPlannedDistance;
    private String plannedDistance;
    private String plannedDuration;
    private String distance;
    private String duration;
    @EqualsAndHashCode.Include
    private String howIFelt;
    @EqualsAndHashCode.Include
    private String perceivedEffort;
    @EqualsAndHashCode.Include
    private String minimumHeartRate;
    @EqualsAndHashCode.Include
    private String averageHeartRate;
    @EqualsAndHashCode.Include
    private String maximumHeartRate;
    private String shoe;
}
