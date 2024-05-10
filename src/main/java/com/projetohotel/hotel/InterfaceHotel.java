package com.projetohotel.hotel;

import java.util.List;

public interface InterfaceHotel {
    // funções para o funcionario
    public void adicionarFuncionario(Funcionarios funcionario);
    List<Funcionarios> listarTodosFuncionarios();
    Funcionarios encontrarFuncionarioPorId(int id_funcionario);

    //funções para o cliente
    public void adicionarCliente(Clientes cliente);
    public void removerCliente(int id_cliente);
    List<Clientes> listarTodosClientes();
    Clientes encontrarClientePorId(int id_cliente);
    
    //funções para os quartos
    public void adicionarQuarto(Quartos quarto);
    public void removerQuarto(int numeroQuarto);
    List<Quartos> listarTodosQuartos();
    Quartos encontrarQuarto(int numeroQuarto);

    // funções para os serviços
    List<Servicos> escolherServico();
}
