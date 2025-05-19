package br.com.payments.adapters.output.db.jpa;

import br.com.payments.adapters.output.db.jpa.entities.PersonEntity;
import br.com.payments.core.domain.vo.PersonTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findAllByType(PersonTypeEnum typeEnum);

    Optional<PersonEntity> findByDocument(String number);

    Optional<PersonEntity> findByEmail(String address);

}
