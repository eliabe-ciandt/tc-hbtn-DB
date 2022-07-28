-- TABLE
CREATE TABLE Aluno (id  integer, email varchar(255), matricula varchar(255), nascimento date, nomeCompleto varchar(255), primary key (id));
CREATE TABLE Alunos_Cursos (curso_id bigint not null, aluno_id bigint not null, primary key (curso_id, aluno_id));
CREATE TABLE Curso (id bigint not null, nome varchar(255), sigla varchar(255), professor_id bigint, primary key (id));
CREATE TABLE hibernate_sequence (next_val bigint);
CREATE TABLE MaterialCurso (id  integer, url varchar(255), curso_id bigint not null, primary key (id), unique (curso_id));
CREATE TABLE Professor (id bigint not null, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id));
CREATE TABLE Telefone (id bigint not null, DDD varchar(255), numero varchar(255), aluno_id bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
