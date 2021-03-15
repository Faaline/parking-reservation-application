package sn.fatou.dakparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.fatou.dakparking.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
