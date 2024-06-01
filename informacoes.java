package cadUser;

public class informacoes{

    private String codigo;

    private String nome;

    private String endereco;

    private String fone;

    private String celular;

    private String sexo;

    private String email;

    private String cep;

    private String cpf;

    private String datanasc;

    public informacoes(

            String codigo,

            String nome,

            String endereco,

            String fone,

            String celular,

            String sexo,

            String obs,

            String email,

            String cep,

            String cpf,

            String datanasc
            )

    {

        this.codigo=codigo;

        this.nome = nome;

        this.endereco = endereco;

        this.fone = fone;

        this.celular = celular;

        this.sexo=sexo;

        this.email=email;

        this.cep=cep;

        this.cpf = cpf;

        this.datanasc = datanasc;

    }

    public String getCodigo(){

        return this.codigo;}

    public String getNome(){

        return this.nome;}

    public String getEndereco(){

        return this.endereco;}

    public String getFone(){

        return this.fone;}

    public String getCelular(){

        return this.celular;}

    public String getSexo(){

        return this.sexo;}

    public String getEmail() {
        return this.email;
    }

    public String getCep() {
        return this.cep;
    }

    public String getCpf(){
        return this.cpf;
    }
    public String getData(){
        return this.datanasc;
    }

}