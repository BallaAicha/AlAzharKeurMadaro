package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<Paiement, Long> {
}
