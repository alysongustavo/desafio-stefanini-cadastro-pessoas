package br.com.alyson.desafiostefanini.repository;

import br.com.alyson.desafiostefanini.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
