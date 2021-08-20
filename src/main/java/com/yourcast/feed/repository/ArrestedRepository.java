package com.yourcast.feed.repository;

import com.yourcast.feed.models.ArrestedAccounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrestedRepository extends JpaRepository<ArrestedAccounts, Long> {
    ArrestedAccounts findByIban(String iban);
}