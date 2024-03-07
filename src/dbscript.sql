CREATE TABLE  IF NOT EXISTS instituto(
	id serial primary key,
	nome varchar(100) not null unique
);

CREATE TYPE public.enum_periodo AS ENUM ('Vespertino', 'Integral', 'Noturno');

CREATE TYPE public.enum_campus AS ENUM ('Itajubá', 'Itabira');
CREATE TABLE  IF NOT EXISTS curso(
	id serial primary key,
	codigo varchar(5) not null unique,
	nome varchar(100) not null unique,
	periodo enum_periodo
);

CREATE TABLE IF NOT EXISTS coordenador_estagio (
	id serial primary key,
	nome varchar(100) not null unique,
	cpf varchar(11) unique,
	rg varchar(10) unique,
	campus enum_campus,
	email varchar(50),
	telefone varchar(15),
	instituto_id int,
	senha varchar(100)
);


CREATE TABLE IF NOT EXISTS endereco (
	id serial primary key,
	logradouro varchar(100) not null,
	numero int not null,
	complento varchar(100),
	apartamento varchar(10),
	cidade varchar(100),
	cep varchar(10)
);

CREATE TABLE IF NOT EXISTS empresa (
	id serial primary key,
	razao_social varchar(100),
	endereco_id int,
	atividade_principal varchar(100),
	tipo_empresa varchar(100),
	CONSTRAINT endereco_empresa_fk FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);


CREATE TABLE IF NOT EXISTS professor (
	id serial primary key,
	nome varchar(100) not null,
	endereco_id int,
	cpf varchar(11) unique,
	rg varchar(10) unique,
	campus enum_campus,
	email varchar(50),
	telefone varchar(15),
	instituto_id int not null
);




CREATE TABLE IF NOT EXISTS aluno (
 	matricula varchar(10) primary key,
	nome varchar(100) not null,
	endereco_id int,
	cpf varchar(11) unique,
	rg varchar(10) unique,
	curso varchar(50),
	campus enum_campus,
	email varchar(50),
	telefone varchar(15),
	professor_orientador_id int,
	CONSTRAINT professor_aluno_fk FOREIGN KEY (professor_orientador_id) REFERENCES professor(id)
);



CREATE TABLE IF NOT EXISTS info_estagio (
	id serial primary key,
	empresa_id int not null,
	aluno_matricula varchar(15) not null,
	professor_id int not null,
	semestre int,
	carga_exigida int,
	data_inicio date,
	data_prevista_termino date,
	nome_orientador_empresa varchar(100),
	formacao_orientador varchar(100),
	cargo_orientador varchar(100),
	email_orientador varchar(100),
	telefone_orientador varchar(20),
	local_estagio varchar(100),
	dias_trabalho_semanal int,
	carga_diaria int,
	projeto_relacionado varchar(200),
	tipo_bolsa varchar(100),
	valor_bolsa numeric,
	descricao_atividade text,
	definicao_cronograma text,
	descricao_resultados text,
	descricao_meios_disponbilizados text,
	descricao_disciplinas_requeridas text,
	CONSTRAINT info_estagio_aluno_fk FOREIGN KEY (aluno_matricula) REFERENCES aluno(matricula),
	CONSTRAINT info_estagio_professor_fk FOREIGN KEY (professor_id) REFERENCES professor(id),
	CONSTRAINT info_estagio_empresa_fk FOREIGN KEY (empresa_id) REFERENCES empresa(id)
);