package github.cainamott.desafiorelogio.repository;

import github.cainamott.desafiorelogio.entity.Relogio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RelogioRepository extends JpaRepository<Relogio, UUID> {
}
