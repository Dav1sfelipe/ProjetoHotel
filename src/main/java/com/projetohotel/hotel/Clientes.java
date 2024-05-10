package com.projetohotel.hotel;

import java.util.Scanner;

public class Clientes implements InterfaceHotel {
    private String nome;
    private int cpf;
    private int telefone;

    Scanner leitura = new Scanner(System.in);
    
    public Clientes(String nome, int cpf, int telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    @Override
    public void adicionarCliente(Clientes cliente){
        if (cliente != null){
            String nome = leitura.next();
        }
    }
}
