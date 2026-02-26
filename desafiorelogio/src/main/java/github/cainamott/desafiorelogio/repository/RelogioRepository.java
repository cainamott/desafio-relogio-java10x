package github.cainamott.desafiorelogio.repository;

import github.cainamott.desafiorelogio.entity.Relogio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RelogioRepository extends JpaRepository<Relogio, UUID> {
}
