CREATE TABLE arrested_accounts
(
    iban VARCHAR(34),
    active BOOLEAN DEFAULT true,
    created_at TIMESTAMP not null DEFAULT now(),
    updated_at TIMESTAMP not null DEFAULT now(),
    primary key (iban)
);
