package locadoraveiculos;
import java.util.ArrayList;

// classe que guarda os dados em array

public class LocadoraDados {
    
    
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();  //armazena os clientes cadastrados
    private static ArrayList<LocacaoVeiculo> listaLocacoes = new ArrayList<LocacaoVeiculo>(); //armazena as locações registradas
    private static ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>(); //armazena os veículos cadastrados
    

    
    public static long setIdAuto(){ // gerador de ID
        int index = listaClientes.size()-1;
        
        if(index < 0){
            return 1;
        }
            return listaClientes.get(index).getID()+1;  
       
    }
    
    public static void cadastraCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    
    public static void alteraCliente(int indice, Cliente cliente){
        listaClientes.set(indice, cliente);
    }
    
    public static void removeCliente(int indice){
        listaClientes.remove(indice);
    }
    
    public static ArrayList<Cliente> getClientes(){
        return listaClientes;
    }
    

    public static boolean verificaExclusaoCliente(int id){// exclusão do cliente com base no cod do veiculo 
        boolean podeExcluir = true;
        
        for(int i = 0; i < listaLocacoes.size(); i++){
           
            if(listaLocacoes.get(i).getCliente().getID() == id){
                
                podeExcluir = false;
                
            }
        }
        
        return podeExcluir;
    }
    
    //Fim dos metodos de cadastro do cliente
    

    //Metodos de locação
    
    public static void cadastraLocacao(LocacaoVeiculo locacaoVeiculo){
        System.out.println("CÓDIGO:" + locacaoVeiculo.getVeiculo().getCodigoAuto());
        verificarDisponibilidadeVeiculo(locacaoVeiculo.getVeiculo().getCodigoAuto());
        listaLocacoes.add(locacaoVeiculo);
        alinharDados();
    }
    
    public static void alteraLocacao(int indice, LocacaoVeiculo locacao){
        verificarDisponibilidadeVeiculo(locacao.getVeiculo().getCodigoAuto());
        listaLocacoes.set(indice, locacao);
        alinharDados();
        
    }
    
    public static void removeLocacao(int indice){// exclui locação apartir do indice 
        listaLocacoes.remove(indice);
        alinharDados();
    }
    
    public static void baixarLocacao(int indice){
        if(indice == -1){
            throw new IllegalArgumentException ("Indice não localizado!");
        }else if(listaLocacoes.get(indice).getStatus().equals("RECEBIDO")){
            throw new IllegalArgumentException ("Essa locação já se encontra baixada");
        }else{
        listaLocacoes.get(indice).setStatus("RECEBIDO");
        alinharDados();
        }
    }
    
    private static void verificarDisponibilidadeVeiculo(long codVeiculo){
        if(listaVeiculos.get(localizaVeiculoPorCodigo(codVeiculo)).isDisponivel() == false){
            throw new IllegalArgumentException("No momento este veículo não está disponívelpara locação");
        }
    }
    
    public static ArrayList<LocacaoVeiculo> getLocacao(){
        return listaLocacoes;
    }
    
    //FIM Metodos da locação
    
    
    // metodos dos veiculos 
    
    public static void cadastraVeiculo(Veiculo veiculo){// cadastra um novo veiculo 
        veiculo.setCodigoAuto(String.valueOf(setCodigoAutomatico()));
        listaVeiculos.add(veiculo);
        alinharDados();
    }
    
    public static int localizaVeiculoPorCodigo(long cod){// busca por meio  do cod do veiculo
        int index = -1;
        for(int i=0; i < listaVeiculos.size(); i++){
            if(listaVeiculos.get(i).getCodigoAuto() == cod){
                index = i;
            }
        }
        return index;
    }
    
    public static boolean verificaExclusaoVeiculo(long cod){// verifica se o veiculo pode ser excluido a partir do cod
        boolean podeExcluir = true;
        
        for(int i = 0; i < listaLocacoes.size(); i++){
           
            if(listaLocacoes.get(i).getVeiculo().getCodigoAuto() == cod){
                
                podeExcluir = false;
               
            }
        }
        return podeExcluir;
    }
    
    public static ArrayList<Veiculo> getVeiculos(){// array com veiculos cadastrados 
        return listaVeiculos;
    }
    
    public static void removeVeiculo(int indice){// remove o veiculo a partir do indice 
        
        long cod =  listaVeiculos.get(indice).getCodigoAuto();
        System.out.println("Delete o veidulo cod: " + cod);
        if(verificaExclusaoVeiculo(cod) == true){
        
        listaVeiculos.remove(localizaVeiculoPorCodigo(listaVeiculos.get(indice).getCodigoAuto()));
        
        }else{
            throw new IllegalArgumentException("Desculpe, esse veículo não pode ser deletado, pois evistem locações vinculadas a ele");
        } 
    }
    
    public static void removeVeiculoPorCod(int cod){// remove o veiculo a partir do cod
        
        if(verificaExclusaoVeiculo(cod)){
            listaVeiculos.remove(localizaVeiculoPorCodigo(cod));            
        }else{
            throw new IllegalArgumentException("Desculpe, esse veiculo não pode ser removido, pois existem locações vinculadas a ele");
        }
    }
    
    
    public static void alteraVeiculo(int indice, Veiculo veiculo){// obj veiculo deve ter os parametros configurados (setados)
        listaVeiculos.set(indice, veiculo);
        alinharDados();
    }
    
    public static long setCodigoAutomatico(){// retorna o cod gerado para o veiculo 
        int index = listaVeiculos.size()-1;
        
        if(index < 0){
            return 1;
        }
            return listaVeiculos.get(index).getCodigoAuto()+1;  
    }
    
    public static void baixaVeiculo(int cod){ //Torna veiculo indisponivel quando locado
        
        listaVeiculos.get(localizaVeiculoPorCodigo(cod)).setDisponivel(false);
        
    }
    //Fim dos metodos dos veiculos
    

    private static void alinharDados(){// metodo para configuração dos status 
        long atualizarCod;
        int indiceDoVeiculo;
        
        for(int j = 0; j < listaVeiculos.size(); j++){
            listaVeiculos.get(j).setDisponivel(true);
        }
        
        for(int i = 0; i < listaLocacoes.size(); i++){
            
            if(listaLocacoes.get(i).getStatus().equals("LOCADO")){
                atualizarCod = listaLocacoes.get(i).getVeiculo().getCodigoAuto();
                indiceDoVeiculo = localizaVeiculoPorCodigo(atualizarCod);
                listaVeiculos.get(indiceDoVeiculo).setDisponivel(false);
            }
        }
    }
}
