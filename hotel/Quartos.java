package projetohotel.hotel;

public class Quartos implements InterfaceHotel{
    private String tipo_quarto;
    private String status_quarto;
    
    public Quartos(String tipo_quarto, String status_quarto){
        this.tipo_quarto = tipo;
        this.status_quarto = status;
    }
    // getters
    public String getTipo(){
        return tipo;
    }
    
    public int getStatus(){
        return status;
    }
    
    //set para editar dados
    public void setTipo(String tipo){
        this.tipo_quarto = tipo;
    }

    public void setStatus(String status){
        this.status_quarto = status;
    }

    public static Quartos tipoDoQuarto() {
        
    }
    
}
