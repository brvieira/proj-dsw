  DROP TABLE IF EXISTS `agendamentoBanca`;
  DROP TABLE IF EXISTS `projeto`;
  DROP TABLE IF EXISTS `projetoStatus`;
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
    `conviteProfessor` BOOLEAN DEFAULT FALSE
    FOREIGN KEY(`usuarioID`) REFERENCES usuario(codigo),
    FOREIGN KEY(`orientadorID`) REFERENCES usuario(codigo)
  );
  
  CREATE TABLE `projetoStatus` (
    `codigo` INT(11) NOT NULL AUTO_INCREMENT,
    `descricao` VARCHAR(255) NOT NULL,
    PRIMARY KEY(`codigo`)
  );

  CREATE TABLE `projeto` (
    `codigo` INT(11) NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL,
    `parecerProjeto` VARCHAR(255),
    `resultadoQualificacao` VARCHAR(255),
    `projetoStatusID` INT(11) NOT NULL,
    `usuarioID` INT(11) NOT NULL,
    FOREIGN KEY(`projetoStatusID`) REFERENCES projetoStatus(codigo),
    FOREIGN KEY(`usuarioID`) REFERENCES usuario(codigo),
    PRIMARY KEY(`codigo`)
  );

  CREATE TABLE `agendamentoBanca` (
    `codigo` INT(11) NOT NULL AUTO_INCREMENT,
    `dataMarcada` DATE NOT NULL,
    `statusOrientando` BOOLEAN DEFAULT FALSE,
    `statusCoordenador` BOOLEAN DEFAULT FALSE,
    `primeiroMembroID` INT(11) NOT NULL,
    `segundoMembroID` INT(11) NOT NULL,
    `projetoID` INT(11) NOT NULL,
    FOREIGN KEY(`projetoID`) REFERENCES projeto(codigo),
    FOREIGN KEY(`primeiroMembroID`) REFERENCES usuario(codigo),
    FOREIGN KEY(`segundoMembroID`) REFERENCES usuario(codigo),
    PRIMARY KEY(`codigo`)
  );

INSERT INTO usuario VALUES(NULL, "42530524874", "Bruno Vieira", "a1620037", "1234", "bruno@gmail.com", true, true);
INSERT INTO usuario VALUES(NULL, "42530523424", "Gustavo", "a1620033", "1234", "gustavo@gmail.com", true, false);
INSERT INTO usuario VALUES(NULL, "42530524534", "Tiago", "a1620035", "1234", "bolacha@gmail.com", false, false);