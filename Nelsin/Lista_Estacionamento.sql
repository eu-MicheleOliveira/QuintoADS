


create database Estacionamento;
use Estacionamento;
-- -----------------------------------------------------
-- Table Cliente
-- -----------------------------------------------------
CREATE TABLE Cliente
 (
  cpf INT NOT NULL,
  nome VARCHAR(60) NOT NULL,
  dt_nasc DATE NOT NULL,
  PRIMARY KEY (cpf))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Modelo
-- -----------------------------------------------------
CREATE TABLE Modelo 
(
  codMod INT NOT NULL,
  Desc_2 VARCHAR(40) NOT NULL,
  PRIMARY KEY (codMod))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Veiculo
-- -----------------------------------------------------
CREATE TABLE Veiculo (
  placa VARCHAR(8) NOT NULL,
  cor VARCHAR(20) NOT NULL,
  Cliente_cpf INT NOT NULL,
  Modelo_codMod INT NOT NULL,
  PRIMARY KEY (placa, Cliente_cpf, Modelo_codMod),
  INDEX fk_Veiculo_Cliente_idx(Cliente_cpf),
  INDEX fk_Veiculo_Modelo1_idx(Modelo_codMod),
  CONSTRAINT fk_Veiculo_Cliente
    FOREIGN KEY (Cliente_cpf)
    REFERENCES Cliente(cpf)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Veiculo_Modelo1
    FOREIGN KEY (Modelo_codMod)
    REFERENCES Modelo(codMod)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Patio
-- -----------------------------------------------------
CREATE TABLE Patio (
  num INT NOT NULL,
  ender VARCHAR(40) NOT NULL,
  capacidade INT NOT NULL,
  PRIMARY KEY (num))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Estaciona
-- -----------------------------------------------------
CREATE TABLE Estaciona (
  cod INT NOT NULL,
  dt_entrada Date NOT NULL,
  dt_saida Date(10) NOT NULL,
  hr_entrada hour(10) NOT NULL,
  hr_saida hour(10) NOT NULL,
  Patio_num INT NOT NULL,
  Veiculo_placa VARCHAR(8) NOT NULL,
  PRIMARY KEY (cod, Patio_num, Veiculo_placa,),
  INDEX fk_Estaciona_Patio1_idx(Patio_num),
  INDEX fk_Estaciona_Veiculo1_idx(Veiculo_placa),
  CONSTRAINT fk_Estaciona_Patio1
    FOREIGN KEY (Patio_num)
    REFERENCES Patio(num)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Estaciona_Veiculo1
    FOREIGN KEY (Veiculo_placa)
    REFERENCES Veiculo(placa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


