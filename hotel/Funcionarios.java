package projetohotel.hotel;

public class Funcionarios implements InterfaceHotel{
        private String nome_funcionario;
        private String cargo;
        
        public Funcionarios(String nome_funcionario, String cargo){
            this.nome_funcionario = nome;
            this.cargo = cargo;
        }
    // getters
        public String getNome(){
            return nome;
        }
        
        public String getCargo(){
            return cargo;
        }
        
    //set para editar dados
        public void setNome(String nome){
            this.nome = nome;
        }
    
        public void setCargo(String cargo){
            this.cargo = cargo;
        }
    //funções da interface
        public static Funcionarios adicionarFuncionario() {
            Scanner leitura = new Scanner(System.in);
    
            System.out.println("Digite o nome do funcionario: ");
            String nome = leitura.nextLine();
            
            System.out.println("Digite o cargo do funcionario: ");
            String cargo = leitura.nextInt();
       
            return new Funcionarios(nome, cargo); 
        }
        
        @Override
        public void incluirFuncionario(Funcionarios funcionario) {
            String sql = "INSERT INTO funcionarios (nome_funcionario, cargo) VALUES (?, ?)";
            
            try (Connection conexao = DatabaseConnection.getConnection();
                 PreparedStatement statement = conexao.prepareStatement(sql)) {
        
                statement.setString(1, funcionario.getNome());
                statement.setInt(2, funcionario.getCargo());
        
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Funcionario cadastrado com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar o funcionario.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        @Override
        public Lista<Funcionarios> listarTodosFuncionarios() {
            Lista<Funcionarios> listaFuncioanrios = new Arraylist<>();
            String sql = "SELECT * FROM funcionarios";
    
            try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
    
                while (resultSet.next()) {
                    Funcionarios funcionario = new funcionarios(
                    resultSet.getString("nome_funcionario"),
                    resultSet.getInt("cargo")
                );
                listaFuncioanrios.add(funcionarios); 
                }
            }catch (SQLException e) {
                e.printStackTrace();
            } return listaFuncioanrios;
        }
        
        @Override
        public  Funcionarios encontrarFuncionarioPorId(int id_funcionario) {
            Funcionarios funcionario = null;
            String sql = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
            
            try (Connection conexao = DatabaseConnection.getConnection();
                 PreparedStatement statement = conexao.prepareStatement(sql)) {
                
                statement.setInt(1, id_funcionario);
                ResultSet resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    funcionario = new Funcionarios(
                        resultSet.getString("nome_funcionario"),
                        resultSet.getInt("cargo")
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            return funcionarios;
        }
    
        @Override
        public void removerFuncionario(Funcionarios funcionario) {
        String sql = "DELETE FROM funcionarios WHERE id_funcionario = ? AND nome_funcionario = ? AND cargo = ?";
        
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
    
                statement.setString(1, funcionario.getNome());
                statement.setInt(2, funcionario.getCargo());
        
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionario removido com sucesso!");
            } else {
                System.out.println("Falha ao remover o Funcionario ou Funcionario não encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao tentar remover Funcionario: ");
            e.printStackTrace();
        }
    }
}
