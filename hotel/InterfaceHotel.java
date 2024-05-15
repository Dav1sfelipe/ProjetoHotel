package projetohotel.hotel;

import java.util.List;

public interface InterfaceHotel {
    // funções para o funcionario
    public void removerFuncionario();
    public void adicionarFuncionario(Funcionarios funcionario);
    Lista<Funcionarios> listarTodosFuncionarios();
    Funcionarios encontrarFuncionarioPorId(int id_funcionario);

    //funções para o cliente
    public void adicionarCliente(Clientes cliente);
    public void removerCliente();
    Lista<Clientes> listarTodosClientes();
    Clientes encontrarClientePorId(int id_cliente);
    
    //funções para os quartos
    public void adicionarQuarto(Quartos quarto);
    Lista<Quartos> listarTodosQuartos();
    Quartos encontrarQuarto(int numeroQuarto);

    // funções para os serviços PRECISAMOS VER COMO FAZER
    public void limpezaFeita();
    public void servicoDeQuartoFeita();
}