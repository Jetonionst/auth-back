CREATE TABLE Transaction
(
    id BIGINT auto_increment,
    transaction_type NVARCHAR(20) NOT NULL,
    client_id NVARCHAR(20) NOT NULL,
    account_id  NVARCHAR(20) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    bank_id LONG NOT NULL
);