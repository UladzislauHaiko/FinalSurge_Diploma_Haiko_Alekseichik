package enums;

import java.util.Arrays;

public enum ShoeBrand {
    ADIDAS("adidas"),
    ALTRA("Altra"),
    ASICS("ASICS"),
    AVIA("Avia"),
    BROOKS("Brooks"),
    HOKA_ONE_ONE("Hoka One One"),
    INOV_8("Inov-8"),
    K_SWISS("K-SWISS"),
    MERELL("Merell"),
    MIZUNO("Mizuno"),
    MONTRAIL("Montrail"),
    NEW_BALANCE("New Balance"),
    NEWTON_RUNNING("Newton Running"),
    NIKE("Nike"),
    NOBULL("NOBULL"),
    ON("On"),
    PEARL_IZUMI("Pearl Izumi"),
    PUMA("Puma"),
    REEBOK("Reebok"),
    RYKA("Ryka"),
    SALOMON("Salomon"),
    SAUCONY("Saucony"),
    SCOTT("SCOTT"),
    SKECHERS("Skechers"),
    SKORA("SKORA"),
    SPIRA("Spira"),
    UK_GEAR("UK Gear"),
    UNDER_ARMOUR("Under Armour"),
    VIBRAM_FIVE_FINGERS("Vibram FiveFingers"),
    VIVOBAREFOOT("VIVOBAREFOOT"),
    ZOOT("Zoot");

    private String name;

    ShoeBrand(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ShoeBrand getFromName(String name) {
        return Arrays.stream(ShoeBrand.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
