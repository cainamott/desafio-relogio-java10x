package github.cainamott.desafiorelogio.entity.enums;

public enum TipoMovimento {
    QUARTZ,
    AUTOMATIC,
    MANUAL;

    public static TipoMovimento fromApi(String value){
        if(value == null || value.isBlank()) return null;
        else{
            return switch (value) {
                case("quartz") -> QUARTZ;
                case("automatic") -> AUTOMATIC;
                case("manual") -> MANUAL;
                default -> throw new IllegalArgumentException("Tipo de movimento não é válido");
            };
        }
    }

    public String toApi(){
        return switch (this) {
            case QUARTZ -> "quartz";
            case AUTOMATIC-> "automatic";
            case MANUAL -> "manual";
        };
    }

}
