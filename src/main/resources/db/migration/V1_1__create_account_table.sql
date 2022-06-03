CREATE TABLE Account
(
    id NVARCHAR(20) NOT NULL,
    account_type NVARCHAR(20) NOT NULL,
    client_id NVARCHAR(20) NOT NULL,
    balance DECIMAL(10,2) NOT NULL,
    withdraw_allowed NVARCHAR(20) NOT NULL,
    bank_id LONG NOT NULL
);