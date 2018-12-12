  USE `bd_alunos`;

  DROP TABLE IF EXISTS `agendamentoBanca`;
  DROP TABLE IF EXISTS `agendamentoDefesa`;
  DROP TABLE IF EXISTS `projeto`;
  DROP TABLE IF EXISTS `usuarioOrientador`;
  DROP TABLE IF EXISTS `usuario`;
  
  CREATE TABLE `usuario`(
    `codigo` INT(11) NOT NULL AUTO_INCREMENT,
    `cpf` VARCHAR(255) NOT NULL,
    `nome` VARCHAR(255) NOT NULL,
    `prontuario` VARCHAR(255) NOT NULL,
    `senha` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `isProfessor` BOOLEAN NOT NULL,
    `isCoordenador` BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(codigo)
  );

  CREATE TABLE `usuarioOrientador`(
    `usuarioID` INT(11) NOT NULL,
    `orientadorID` INT(11) NOT NULL,
    `orientacaoAceita` BOOLEAN DEFAULT FALSE,
    `conviteProfessor` BOOLEAN DEFAULT FALSE,
    FOREIGN KEY(`usuarioID`) REFERENCES usuario(codigo),
    FOREIGN KEY(`orientadorID`) REFERENCES usuario(codigo)
  );

  CREATE TABLE `projeto` (
    `codigo` INT(11) NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL,
    `parecerProjeto` VARCHAR(255),
    `resultadoQualificacao` VARCHAR(255),
    `projetoEnviadoColegiado` BOOLEAN DEFAULT FALSE,
    `projetoEnviadoColegiadoConcordado` BOOLEAN DEFAULT FALSE,
    `projetoRecebidoAnalise` BOOLEAN DEFAULT FALSE,
    `projetoFinalEnviado` BOOLEAN DEFAULT FALSE,
    `projetoFinalEnviadoOrientador` BOOLEAN DEFAULT FALSE,
    `usuarioID` INT(11) NOT NULL,
    FOREIGN KEY(`usuarioID`) REFERENCES usuario(codigo),
    PRIMARY KEY(`codigo`)
  );

  CREATE TABLE `agendamentoBanca` (
    `codigo` INT(11) NOT NULL AUTO_INCREMENT,
    `dataMarcada` DATE NOT NULL,
    `statusOrientando` BOOLEAN DEFAULT FALSE,
    `statusCoordenador` BOOLEAN DEFAULT FALSE,
    `primeiroMembroID` INT(11) NULL,
    `segundoMembroID` INT(11) NULL,
    `projetoID` INT(11) NOT NULL,
    FOREIGN KEY(`projetoID`) REFERENCES projeto(codigo),
    FOREIGN KEY(`primeiroMembroID`) REFERENCES usuario(codigo),
    FOREIGN KEY(`segundoMembroID`) REFERENCES usuario(codigo),
    PRIMARY KEY(`codigo`)
  );

  CREATE TABLE `agendamentoDefesa` (
    `codigo` INT(11) NOT NULL AUTO_INCREMENT,
    `dataMarcada` DATE NOT NULL,
    `statusAgendamentoOrientando` BOOLEAN DEFAULT FALSE,
    `statusAgendamentoCoordenador` BOOLEAN DEFAULT FALSE,
    `primeiroMembroID` INT(11) NULL,
    `segundoMembroID` INT(11) NULL,
    `resultadoDefesa` VARCHAR(50) NULL,
    `parecerBanca` VARCHAR(50) NULL,
    `consideracoesBanca` VARCHAR(255) NULL, 
    `projetoID` INT(11) NOT NULL,
    FOREIGN KEY(`projetoID`) REFERENCES projeto(codigo),
    FOREIGN KEY(`primeiroMembroID`) REFERENCES usuario(codigo),
    FOREIGN KEY(`segundoMembroID`) REFERENCES usuario(codigo),
    PRIMARY KEY(`codigo`)
  );

INSERT INTO usuario VALUES(NULL, "42530524874", "Bruno", "1620037", "1234", "bruno@gmail.com", true, true);
INSERT INTO usuario VALUES(NULL, "42530523424", "Gustavo", "1620304", "1234", "gustavo@gmail.com", true, false);
INSERT INTO usuario VALUES(NULL, "42530524534", "Tiago", "1620035", "1234", "bolacha@gmail.com", false, false);