package com.Portfolio.MyPortfolio.repositories;

import com.Portfolio.MyPortfolio.entities.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
}
