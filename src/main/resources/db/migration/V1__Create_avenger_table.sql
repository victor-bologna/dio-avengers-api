CREATE TABLE avenger (
                         id bigserial NOT NULL PRIMARY KEY,
                         nick varchar(36),
                         person varchar(128),
                         description varchar(128),
                         history text
);

ALTER TABLE avenger ADD CONSTRAINT unique_avenger_nick UNIQUE (nick);