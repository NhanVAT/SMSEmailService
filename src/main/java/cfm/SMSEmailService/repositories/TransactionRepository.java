package cfm.SMSEmailService.repositories;

import cfm.SMSEmailService.entities.AppTransaction;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<AppTransaction, Long> {

  Optional<AppTransaction> findById(Long id);
}
