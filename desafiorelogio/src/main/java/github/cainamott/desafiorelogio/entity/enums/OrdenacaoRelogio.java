package github.cainamott.desafiorelogio.entity.enums;

public enum OrdenacaoRelogio {
    MAIS_RECENTES, PRECO_CRESC, PRECO_DESC, DIAMETRO_CRESC, RESISTENCIA_CRESC;


    public static OrdenacaoRelogio fromApi(String value){
        if(value == null || value.isBlank()) return MAIS_RECENTES;
        else{
            return switch (value) {
                case("newest") -> MAIS_RECENTES;
                case("price_asc") -> PRECO_CRESC;
                case("price_desc") -> PRECO_DESC;
                case("diameter_asc") -> DIAMETRO_CRESC;
                case("wr_asc") -> RESISTENCIA_CRESC;
                default -> throw new IllegalArgumentException("Ordenação Inválida");
            };
        }
    }
}
