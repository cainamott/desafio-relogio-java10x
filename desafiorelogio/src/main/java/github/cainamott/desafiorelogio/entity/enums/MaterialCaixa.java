package github.cainamott.desafiorelogio.entity.enums;

public enum MaterialCaixa {
    STEEL,
    TITANIUM,
    RESIN,
    BRONZE,
    CERAMIC;

    public static MaterialCaixa fromApi(String value){
        if(value == null || value.isBlank()) return null;
        else{
            return switch (value) {
                case("steel") -> STEEL;
                case("titanium") -> TITANIUM;
                case("resin") -> RESIN;
                case("bronze") -> BRONZE;
                case("ceramic") -> CERAMIC;
                default -> throw new IllegalArgumentException("Material da caixa não é válido");
            };
        }
    }

    public String toApi(){
        return switch (this) {
            case STEEL -> "steel";
            case TITANIUM-> "titanium";
            case RESIN -> "resin";
            case BRONZE-> "bronze";
            case CERAMIC -> "ceramic";
        };
    }
}
