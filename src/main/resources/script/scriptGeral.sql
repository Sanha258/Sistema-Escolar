SET SQL_SAFE_UPDATES = 0;
SET GLOBAL log_bin_trust_function_creators = 1;
DROP DATABASE IF EXISTS DBSistemaEscolar;
CREATE DATABASE DBSistemaEscolar;
USE DBSistemaEscolar;


-- Tabela Professores
CREATE TABLE Professor (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Especializacao VARCHAR(100) NOT NULL,
    Endereco VARCHAR(255) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Telefone VARCHAR(20) NOT NULL
);
 
-- Tabela Disciplinas
CREATE TABLE Disciplina (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NomeDisciplina VARCHAR(100) NOT NULL,
    Descricao TEXT NOT NULL,
    ProfessorResponsavel INT NOT NULL,
    FOREIGN KEY (ProfessorResponsavel) REFERENCES Professor(ID)
);
 
-- Tabela Turmas
CREATE TABLE Turma (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NomeTurma VARCHAR(100) NOT NULL,
    AnoSerie VARCHAR(20) NOT NULL,
    ProfessorResponsavel INT NOT NULL,
    FOREIGN KEY (ProfessorResponsavel) REFERENCES Professor(ID)
);

-- Tabela Alunos
CREATE TABLE Aluno (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    DataNascimento DATE NOT NULL,
    Genero VARCHAR(10) NOT NULL,
    Endereco VARCHAR(255) NOT NULL,
    Turma INT NOT NULL,
    Email VARCHAR(100) NOT NULL, 
    TelefoneResponsavel VARCHAR(20) NOT NULL,
	CONSTRAINT Turma FOREIGN KEY (Turma) REFERENCES Turma(ID)
);
 
 
-- Tabela Notas
CREATE TABLE avaliacao (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDAluno INT NOT NULL,
    IDDisciplina INT NOT NULL,
    Nota DECIMAL(5,2) NOT NULL,
    DataNota DATE NOT NULL,
    FOREIGN KEY (IDAluno) REFERENCES Aluno(ID),
    FOREIGN KEY (IDDisciplina) REFERENCES Disciplina(ID)
);
 
-- Tabela Presencas
CREATE TABLE Presenca (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDAluno INT NOT NULL,
    IDTurma INT NOT NULL,
    DataPresenca DATE NOT NULL,
    Presenca ENUM('presente', 'ausente') NOT NULL,
    FOREIGN KEY (IDAluno) REFERENCES Aluno(ID),
    FOREIGN KEY (IDTurma) REFERENCES Turma(ID)
);

-- Inserts para a tabela Alunos
-- Inserir um aluno

-- Inserts para a tabela Professores
INSERT INTO Professor (Nome, Especializacao, Endereco, Email, Telefone) VALUES
    ('Ana Pereira', 'Matemática', 'Rua da Escola, 10', 'ana@example.com', '(11) 1234-5678'),
    ('Carlos Ferreira', 'Português', 'Avenida Central, 20', 'carlos@example.com', '(11) 2345-6789'),
    ('Mariana Oliveira', 'Ciências', 'Praça da Educação, 30', 'mariana@example.com', '(11) 3456-7890');
 
-- Inserts para a tabela Disciplinas
INSERT INTO Disciplina (NomeDisciplina, Descricao, ProfessorResponsavel) VALUES
    ('Matemática', 'Estudo dos números e suas operações.', 1),
    ('Português', 'Estudo da língua portuguesa.', 2),
    ('Ciências', 'Estudo dos fenômenos naturais.', 3);
 
-- Inserts para a tabela Turmas
INSERT INTO Turma (NomeTurma, AnoSerie, ProfessorResponsavel) VALUES
    ('8º ano A', '8º ano',  1),
    ('9º ano B', '9º ano', 2),
    ('7º ano C', '7º ano', 3);
    
    INSERT INTO Aluno (Nome, DataNascimento, Genero, Endereco, Turma, Email, TelefoneResponsavel) VALUES
 ('arthur', '2004-08-15', 'Masculino', 'Rua das Flores, 128', 2, 'furry.silva@email.com', '(99) 9899-9999'),
 ('vilmar', '2004-03-22', 'Masculino', 'Avenida dos Girassóis, 556', 2, 'vilmar.souza@email.com', '(88) 8788-8888'),
 ('Jonatan de souza', '2004-03-22', 'Masculino', 'Avenida dos Girassóis, 856', 2, 'jonatan.souza@email.com', '(48) 8828-8888');

 
-- Inserts para a tabela avaliacao
INSERT INTO avaliacao (IDAluno, IDDisciplina, Nota, DataNota) VALUES
    (1, 1, 8.5, '2024-05-10'),
    (1, 2, 7.9, '2024-05-12'),
    (2, 1, 9.2, '2024-05-11'),
    (2, 2, 8.0, '2024-05-13'),
    (3, 3, 8.7, '2024-05-14');
 
-- Inserts para a tabela Presencas
INSERT INTO Presenca (IDAluno, IDTurma, DataPresenca, Presenca) VALUES
    (1, 1, '2024-05-10', 'presente'),
    (1, 1, '2024-05-11', 'ausente'),
    (2, 2, '2024-05-12', 'presente'),
    (2, 2, '2024-05-13', 'presente'),
    (3, 3, '2024-05-14', 'presente');
 
 
 
select * from turma;
 
select *
from
	turma
    inner join aluno on