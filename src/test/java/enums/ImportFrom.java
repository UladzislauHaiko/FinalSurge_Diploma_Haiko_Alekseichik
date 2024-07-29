package enums;

import java.util.Arrays;

public enum ImportFrom {
    MY_SWIM_BIKE_RUN("MySwimBikeRun"),
    FLO_TRACK("FloTrack");
    private String name;

    ImportFrom(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ImportFrom getFromName(String name) {
        return Arrays.stream(ImportFrom.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
