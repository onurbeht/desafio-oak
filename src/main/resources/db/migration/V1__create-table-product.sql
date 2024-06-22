create table product(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    info TEXT NOT NULL,
    price_in_cents INT NOT NULL,
    available BOOLEAN NOT NULL
);