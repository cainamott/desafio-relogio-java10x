package github.cainamott.desafiorelogio.entity.enums;

public enum TipoVidro {
    MINERAL,
    SAPPHIRE,
    ACRYLIC;

    public static TipoVidro fromApi(String value){
        if(value == null || value.isBlank()) return null;
        else{
            return switch (value) {
                case("mineral") -> MINERAL;
                case("sapphire") -> SAPPHIRE;
                case("acrylic") -> ACRYLIC;
                default -> throw new IllegalArgumentException("Tipo de vidro não é válido");
            };
        }
    }

    public String toApi(){
        return switch (this) {
            case MINERAL -> "mineral";
            case SAPPHIRE-> "sapphire";
            case ACRYLIC -> "acrylic";
        };
    }
}
