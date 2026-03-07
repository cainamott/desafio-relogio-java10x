package github.cainamott.desafiorelogio.service;

import github.cainamott.desafiorelogio.entity.Relogio;
import github.cainamott.desafiorelogio.entity.enums.MaterialCaixa;
import github.cainamott.desafiorelogio.entity.enums.TipoMovimento;
import github.cainamott.desafiorelogio.entity.enums.TipoVidro;
import org.springframework.data.jpa.domain.Specification;

public class RelogioSpecs {
    private RelogioSpecs() {}

    public static Boolean blank(String term){
        return term == null || term.isBlank();
    }

    public static Specification<Relogio> all(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
    }

    public static Specification<Relogio> search(String term){
        if(blank(term)) return all();
        String like = "%" + term.toLowerCase() + "%";
        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
                criteriaBuilder.like(criteriaBuilder.lower(root.get("marca")), like),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("modelo")), like),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("referencia")), like)
        );
    }

    public static Specification<Relogio> marcaIgual(String marca){
        if(blank(marca)) return all();
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("marca"), marca));
    }

    public static Specification<Relogio> modeloIgual(String modelo){
        if(blank(modelo)) return all();
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("modelo"), modelo));
    }

    public static Specification<Relogio> referenciaIgual(String referencia){
        if(blank(referencia)) return all();
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("marca"), referencia));
    }

    public static Specification<Relogio> tipoMovimento(TipoMovimento movimento){
        if(movimento == null) return all();
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("marca"), movimento));
    }

    public static Specification<Relogio> tipoVidro(TipoVidro vidro){
        if(vidro == null) return all();
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("marca"), vidro));
    }

    public static Specification<Relogio> materialCaixa(MaterialCaixa material){
        if(material == null) return all();
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("marca"), material));
    }

    public static Specification<Relogio> resistenciaAgua(Integer min, Integer max){
        if(min == null && max == null) return all();
        return (root, query, criteriaBuilder) ->
        {
            if (min != null && max != null) return criteriaBuilder.between(root.get("resistenciaAgua"), min, max);
            if(min != null) return criteriaBuilder.greaterThan(root.get("resistenciaAgua"), min);
            return criteriaBuilder.lessThanOrEqualTo(root.get("resistenciaAgua"), max);
        };
    }

    public static Specification<Relogio> precoEntre(Integer min, Integer max){
        if(min == null && max == null) return all();
        return (root, query, criteriaBuilder) ->
        {
            if (min != null && max != null) return criteriaBuilder.between(root.get("precoEmCentavos"), min, max);
            if(min != null) return criteriaBuilder.greaterThan(root.get("precoEmCentavos"), min);
            return criteriaBuilder.lessThanOrEqualTo(root.get("precoEmCentavos"), max);
        };
    }

    public static Specification<Relogio> diametroEntre(Integer min, Integer max){
        if(min == null && max == null) return all();
        return (root, query, criteriaBuilder) ->
        {
            if (min != null && max != null) return criteriaBuilder.between(root.get("diametro"), min, max);
            if(min != null) return criteriaBuilder.greaterThan(root.get("diametro"), min);
            return criteriaBuilder.lessThanOrEqualTo(root.get("diametro"), max);
        };
    }
}
