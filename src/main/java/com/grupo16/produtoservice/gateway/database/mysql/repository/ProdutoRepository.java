package com.grupo16.produtoservice.gateway.database.mysql.repository;

import com.grupo16.produtoservice.gateway.database.mysql.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/02/2024
 * Project Name: produto-service
 */

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
