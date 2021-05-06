CREATE DATABASE "FechamentoFolha"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE folha
(
    id serial PRIMARY KEY,
    idcolaborador integer NOT NULL,
    dataemissao date NOT NULL,
    valorhorastrabalhadas decimal NOT NULL,
    valorhorasfaltas decimal NOT NULL,
    valorhorasextras decimal NOT NULL,
    valorreflexodsr decimal NOT NULL,
    valorinss decimal NOT NULL,
    valorimpostoderenda decimal NOT NULL,
    valorplanosaude decimal NOT NULL,
    valorvaletransporte decimal NOT NULL,
    salariobruto decimal NOT NULL,
    salarioliquido decimal NOT NULL,
    valorferias decimal NOT NULL,
    valorinssferias decimal NOT NULL,
    valorimpostoderendaferias decimal NOT NULL,
    feriasliquido decimal NOT NULL
);