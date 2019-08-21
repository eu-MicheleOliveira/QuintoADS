DROP DATABASE IF EXISTS `autoescola`;
CREATE DATABASE IF NOT EXISTS `autoescola`;
USE `autoescola`;

CREATE TABLE IF NOT EXISTS `endereco` (
  `cod_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `cep` varchar(10) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `cidade` varchar(40) DEFAULT NULL,
  `bairo` varchar(40) DEFAULT NULL,
  `logradouro` varchar(100) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cod_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `aluno` (
  `cod_aluno` int(11) NOT NULL AUTO_INCREMENT,
  `nome_aluno` varchar(40) DEFAULT NULL,
  `rg` varchar(15) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `datanasc` date DEFAULT NULL,
  `nome_pai` varchar(40) DEFAULT NULL,
  `nome_mae` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `categoria` varchar(2) DEFAULT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  `fk_endereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_aluno`),
  KEY `fk_endereco` (`fk_endereco`),
  CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`fk_endereco`) REFERENCES `endereco` (`cod_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `autoescola` (
  `cod_auto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `nomeFantasia` varchar(50) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `proprietario` varchar(50) DEFAULT NULL,
  `cnpj` varchar(18) DEFAULT NULL,
  `dataAbertura` date DEFAULT NULL,
  `inscricaoEstadual` varchar(20) DEFAULT NULL,
  `fk_endereco` int(11) NOT NULL,
  PRIMARY KEY (`cod_auto`),
  KEY `fk_endereco` (`fk_endereco`),
  CONSTRAINT `autoescola_ibfk_1` FOREIGN KEY (`fk_endereco`) REFERENCES `endereco` (`cod_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `conta` (
  `cod_conta` int(11) NOT NULL AUTO_INCREMENT,
  `codBanco` varchar(10) DEFAULT NULL,
  `agencia` varchar(10) DEFAULT NULL,
  `numConta` varchar(20) DEFAULT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `fk_auto` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_conta`),
  KEY `fk_auto` (`fk_auto`),
  CONSTRAINT `conta_ibfk_1` FOREIGN KEY (`fk_auto`) REFERENCES `autoescola` (`cod_auto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `funcionario` (
  `cod_func` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) DEFAULT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `CNH` varchar(20) DEFAULT NULL,
  `nome_pai` varchar(40) DEFAULT NULL,
  `nome_mae` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `data_contratacao` datetime DEFAULT NULL,
  `fk_endereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_func`),
  KEY `fk_endereco` (`fk_endereco`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`fk_endereco`) REFERENCES `endereco` (`cod_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `despesas` (
  `cod_despesa` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(10) DEFAULT NULL,
  `descricao` varchar(40) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `fundo` varchar(10) DEFAULT NULL,
  `data_despesa` datetime DEFAULT NULL,
  `fk_func` int(11) NOT NULL,
  `fk_conta` int(11) NOT NULL,
  PRIMARY KEY (`cod_despesa`),
  KEY `fk_func` (`fk_func`),
  KEY `fk_conta` (`fk_conta`),
  CONSTRAINT `despesas_ibfk_1` FOREIGN KEY (`fk_func`) REFERENCES `funcionario` (`cod_func`),
  CONSTRAINT `despesas_ibfk_2` FOREIGN KEY (`fk_conta`) REFERENCES `conta` (`cod_conta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `login` (
  `usuario` varchar(10) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `fk_autoescola` INT NOT NULL,
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`fk_autoescola`) REFERENCES `autoescola` (`cod_auto`),
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `movimentacao` (
  `cod_movimentacao` int(11) NOT NULL,
  `operacao` varchar(10) DEFAULT NULL,
  `valor` varchar(10) DEFAULT NULL,
  `numero_documento` varchar(20) DEFAULT NULL,
  `dtOperacao` datetime DEFAULT NULL,
  `fk_conta` int(11) NOT NULL,
  PRIMARY KEY (`cod_movimentacao`),
  KEY `fk_conta` (`fk_conta`),
  CONSTRAINT `movimentacao_ibfk_1` FOREIGN KEY (`fk_conta`) REFERENCES `conta` (`cod_conta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `receitas` (
  `cod_receita` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(40) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `data_receita` datetime DEFAULT NULL,
  `fk_aluno` int(11) NOT NULL,
  `fk_conta` int(11) NOT NULL,
  PRIMARY KEY (`cod_receita`),
  KEY `fk_aluno` (`fk_aluno`),
  KEY `fk_conta` (`fk_conta`),
  CONSTRAINT `receitas_ibfk_1` FOREIGN KEY (`fk_aluno`) REFERENCES `aluno` (`cod_aluno`),
  CONSTRAINT `receitas_ibfk_2` FOREIGN KEY (`fk_conta`) REFERENCES `conta` (`cod_conta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `veiculo` (
  `cod_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(15) DEFAULT NULL,
  `ano` varchar(4) DEFAULT NULL,
  `cor` varchar(10) DEFAULT NULL,
  `combustivel` varchar(15) DEFAULT NULL,
  `fk_auto` int(11) NOT NULL,
  PRIMARY KEY (`cod_veiculo`),
  KEY `fk_auto` (`fk_auto`),
  CONSTRAINT `veiculo_ibfk_1` FOREIGN KEY (`fk_auto`) REFERENCES `autoescola` (`cod_auto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;