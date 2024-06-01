
package cadUser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.sql.*;

public class cadastro extends WindowAdapter implements ActionListener, FocusListener{
    private Frame janela;
    private Panel painelEndereco,painelBotoes;
    private Label lCodigo, lNome, lEndereco, lFone, lCelular,lSexo, lemail, lcep, lcpf, ldata;
    private TextField tCodigo, tNome, tEndereco, tFone, tCelular, temail, tcep, tcpf, tdata;
    private Button bNovo, bSalva,bConsulta,bAltera,bExclui;
    private MenuBar mb;
    private Menu m1;
    private MenuItem mi11, mi12;
    private CheckboxGroup cbgSexo;
    private Checkbox masculino, feminino;
    private Vector vContatos;
    private int posicao;
    public cadastro(){
        vContatos=new Vector();
        janela = new Frame();
        janela.setTitle("Cadastro");
        janela.setSize(370,600);
        janela.setBackground(new Color(160,160,160));
        janela.setLayout(null);
        janela.addWindowListener(this);

// Cria o painel Endereço
        painelEndereco = new Panel();
        painelEndereco.setBackground(new Color(128,128,128));
        painelEndereco.setLayout(null);
// Cria o painel Botões
        painelBotoes = new Panel();
        painelBotoes.setBackground(new Color(64,128,128));
        painelBotoes.setLayout(null);

// Cria menu para a janela
        mb = new MenuBar();
        m1 = new Menu("Opções");
        mi11 = new MenuItem("Cadastro");
        mi12 = new MenuItem("Sair");
        m1.add(mi11);
        m1.addSeparator();
        m1.add(mi12);
        mb.add(m1);
        mi11.addActionListener(this);
        mi12.addActionListener(this);

// Cria Rótulos(Label) do painel Endereço

        lCodigo = new Label("Codigo:");
        lNome = new Label("Nome:");
        lEndereco = new Label("Endereco:");
        lFone = new Label("Fone:");
        lCelular = new Label("Celular:");
        lSexo = new Label("Sexo:");
        lemail = new Label("Email");
        lcep = new Label("CEP:");
        lcpf = new Label("CPF:");
        ldata = new Label("Data de nascimento:");
//Cria os campos de texto (TextField) do painel Endereço
        tCodigo = new TextField(10);
        tCodigo.addFocusListener(this);
        tCodigo.setEnabled(false);
        tNome = new TextField(45);
        tNome.addFocusListener(this);
        tNome.setEnabled(false);
        tEndereco = new TextField(60);
        tEndereco.setEnabled(false);
        tFone = new TextField(8);
        tFone.setEnabled(false);
        tCelular = new TextField(9);
        tCelular.setEnabled(false);
        temail = new TextField(50);
        temail.setEnabled(false);
        tcep = new TextField(10);
        tcep.setEnabled(false);
        tcpf = new TextField(11);
        tcpf.setEnabled(false);
        tdata = new TextField(10);
        tdata.setEnabled(false);

// Posiciona e define tamanhos para
// Rótulos e campos de texto do painel Endereço
        lCodigo.setBounds(10,15,50,13);
        tCodigo.setBounds(70,12,50,19);
        lNome.setBounds(10,37,50,13);
        tNome.setBounds(70,34,240,19);
        lEndereco.setBounds(10,59,60,13);
        tEndereco.setBounds(70,56,270,19);
        lFone.setBounds(10,83,60,13);
        tFone.setBounds(70,80,86,19);
        lCelular.setBounds(180,83,50,13);
        tCelular.setBounds(240,80,80,19);
        lSexo.setBounds(10,105,30,13);
        lemail.setBounds(10, 130, 30, 13);
        temail.setBounds(70, 130, 150, 19);
        lcep.setBounds(10, 155,30,13);
        tcep.setBounds(70, 155,100,19);
        lcpf.setBounds(10, 180, 30, 13 );
        tcpf.setBounds(70,180,100,19);
        ldata.setBounds(10,205,30,13);
        tdata.setBounds(70,205,100,19);

// Cria Checkboxes para sexo no painel Endereço
        cbgSexo = new CheckboxGroup();
        masculino = new Checkbox("Masculino",false,cbgSexo);
        masculino.setEnabled(false);
        feminino = new Checkbox("Feminino",false,cbgSexo);
        feminino.setEnabled(false);
// Posiciona e define tamanhos para
// Checkbox do painel Endereço
        masculino.setBounds(70,102,90,19);
        feminino.setBounds(160,102,90,19);
// Adiciona Labels e campos de texto ao painel Endereco
        painelEndereco.add(lCodigo);
        painelEndereco.add(tCodigo);
        painelEndereco.add(lNome);
        painelEndereco.add(tNome);
        painelEndereco.add(lEndereco);
        painelEndereco.add(tEndereco);
        painelEndereco.add(lFone);
        painelEndereco.add(tFone);
        painelEndereco.add(lCelular);
        painelEndereco.add(tCelular);
        painelEndereco.add(lSexo);
        painelEndereco.add(masculino);
        painelEndereco.add(feminino);
        painelEndereco.add(lemail);
        painelEndereco.add(temail);
        painelEndereco.add(lcep);
        painelEndereco.add(tcep);
        painelEndereco.add(lcpf);
        painelEndereco.add(tcpf);
        painelEndereco.add(ldata);
        painelEndereco.add(tdata);
        bNovo = new Button("Novo/Limpar");
// Define um Listener(escutador) para cada botao
        bNovo.addActionListener(this);
        bSalva = new Button("Salva");
        bSalva.addActionListener(this);
        bConsulta = new Button("Consulta");
        bConsulta.addActionListener(this);
        bAltera=new Button("Altera");
        bAltera.addActionListener(this);
        bExclui=new Button("Exclui");
        bExclui.addActionListener(this);

// Define o gerenciador de layout para o painel botões
        painelBotoes.setLayout(new FlowLayout());
// Adiciona botões ao painel botões
        painelBotoes.add(bNovo);
        painelBotoes.add(bSalva);
        painelBotoes.add(bConsulta);
        painelBotoes.add(bAltera);
        painelBotoes.add(bExclui);
        
// Adiciona os paineis e o menu à janela Agenda
        janela.add(painelEndereco);
        janela.add(painelBotoes);
        janela.setMenuBar(mb);
    }
//METODOS ACESSORES (Permitem adicionar valores para os campos)
    public void setCodigo(String codigo){
        tCodigo.setText(codigo);
    }
    public void setNome(String nome){
        tNome.setText(nome);
    }
    public void setEndereco(String endereco){
        tEndereco.setText(endereco);
    }
    public void setFone(String fone){
        tFone.setText(fone);
    }
    public void setCelular(String celular){
        tCelular.setText(celular);
    }
    public void setSexo(String sexo) {
        if (sexo != null) {
            if (sexo.equals("F")) feminino.setState(true);
            else if (sexo.equals("M")) masculino.setState(true);
        }
    }
    public void setEmail (String email){
        temail.setText(email);
    }
    public void setCEP(String cep){
        tcep.setText(cep);
    }
    public void setCPF(String cpf){
        tcpf.setText(cpf);
    }
    public void setData(String data){
        tdata.setText(data);
    }
    public void setMenuBar(MenuBar mb) {
        janela.setMenuBar(mb);
    }

//METODOS MUTADORES (Permitem receber o conteúdo dos campos)

    public String getCodigo(){
        return tCodigo.getText();
    }
    public String getNome(){
        return tNome.getText();
    }
    public String getEndereco(){
        return tEndereco.getText();
    }
    public String getFone(){
        return tFone.getText();
    }
    public String getCelular(){
        return tCelular.getText();
    }
    public String getSexo() {
        if (masculino.getState() == true) return "Masculino";
        else if (feminino.getState() == true) return "Feminino";
        else return " ";
    }
    public String getEmail(){
        return temail.getText();
    }
    public String getCEP(){
        return tcep.getText();
    }
    public String getCPF(){
        return tcpf.getText();
    }
    public String getData(){
        return tdata.getText();
    }
    public MenuBar getMenuBar() {
        return janela.getMenuBar();
    }
// Método para tornar visíveis os paineis Endereco e Botoes

    public void mostraPainel() {
        painelEndereco.setSize(350,375); // Tamanho do painel
        painelEndereco.setLocation(10,80); // Posição do painel
        painelBotoes.setSize(350,34);
        painelBotoes.setLocation(10,500);
    }

// Método para detectar se determinada estrutura recebeu o foco
    public void focusGained(FocusEvent e){
    }
// Método para detectar se determinada estrutura perdeu o foco
    public void focusLost(FocusEvent e) {

}

// Método para detectar que ações foram executadas

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mi11)) // Se a ação foi clicar em 'Cadastro'
        { // no Menu Agenda
            this.mostraPainel();
            return;
        }
        if (e.getSource().equals(mi12)) // Se a ação foi clicar em 'Sair' no
        {
            System.exit(0);
        }

//Determina a ação correspondente a cada botão quando clicado.

        Button b=(Button)e.getSource();
        if (b==bNovo) this.botaoNovo();
        else if (b==bSalva) this.botaoSalva();
        else if (b==bConsulta) this.botaoConsulta();
        else if (b==bExclui) this.botaoExclui();
        else if (b==bAltera) this.botaoAltera();
    }
//----------------------Seção de acesso oa banco de dados ----------------/

    Connection conecta()
    {
        String url="jdbc:mysql://127.0.0.1:3306/ativ_extensao?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,"root","sucodeuva12");
            return con;
        }
        catch(ClassNotFoundException cnf){
            JOptionPane.showMessageDialog(null, "Houve um erro no DRIVER: classnotfoundexcepition-"+cnf);
            return null;
        }

        catch(SQLException sql){
            JOptionPane.showMessageDialog(null, "Houve um erro de conexão SQL:sqlexception sql-"+sql);
            return null;
        }
    }
//Método do botão Salva
    public void botaoSalva()
    {
        tCodigo.setEnabled(true);
        Connection con=conecta();
        try {

            Statement st=con.createStatement();
            int resultado=st.executeUpdate("insert into cadastro (nome, endereco, fone, celular, sexo, email, cep, cpf, datanasc) values('"+getNome()+"','"+getEndereco()+"','"+getFone()+"','"+getCelular()+"','"+getSexo()+"','"+getEmail()+"','"+getCEP()+"','"+getCPF()+",'"+getData()+"'')");

//fechar cnx
            st.close();
            con.close();

            JOptionPane.showMessageDialog(null,"Registro Salvo");
            this.limpaDados();
        }
        catch(SQLException sql){

            JOptionPane.showMessageDialog(null,"Registro não foi Salvo :(");
        }
    }

//Método do botão Exclui.
    void botaoExclui() {
        Connection con=conecta();
        con=conecta();
        try{

            String cod=getCodigo();
            Statement st=con.createStatement();
            int resultado=st.executeUpdate("Delete from cadastro where codigo='"+cod+"';");
            con.close();
            this.limpaDados();
            tCodigo.requestFocus();
            JOptionPane.showMessageDialog(null,"Registro Excluido");

        }

        catch(SQLException sql)
        {
            JOptionPane.showMessageDialog(null,"Não foi possível excluir o registro.");

        }
    }

//Método do botão Novo

    void botaoNovo() {

        this.limpaDados();
        bNovo.setEnabled(true);
        bSalva.setEnabled(true);
        bConsulta.setEnabled(true);
        bExclui.setEnabled(true);
        bAltera.setEnabled(true);
        tCodigo.setEnabled(false);
        tNome.setEnabled(true);
        tEndereco.setEnabled(true);
        tFone.setEnabled(true);
        tCelular.setEnabled(true);
        masculino.setEnabled(true);
        feminino.setEnabled(true);
        tNome.requestFocus();
        temail.setEnabled(true);
        tcep.setEnabled(true);
        tcpf.setEnabled(true);
        tdata.setEnabled(true);


    }


//Método do botão Consulta

    void botaoConsulta()
    {

        Connection con=conecta();
        con=conecta();
        try

        {
            String cod=getCodigo();
            String nome=getNome();
            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery("Select * from cadastro where Nome like '%"+nome+"%';");

            while(rs.next())
            {

                this.setCodigo(rs.getString(1));
                this.setNome(rs.getString(2));
                this.setEndereco(rs.getString(3));
                this.setFone(rs.getString(4));
                this.setCelular(rs.getString(5));
                this.setSexo(rs.getString(6));
                this.setEmail(rs.getString(7));
                this.setCEP(rs.getString(8));
                this.setCPF(rs.getString(9));
                this.setData(rs.getString(10));

                JOptionPane.showMessageDialog(null,"Registro encontrado");
            }

            con.close();
        }

        catch(SQLException sql)
        {
            JOptionPane.showMessageDialog(null,"Registro não encontrado");
        }

    }

//Código do botão Altera.

    void botaoAltera()
    {
        Connection con=conecta();
        try
        {

            try (Statement st = con.createStatement()) {

                int resultado=st.executeUpdate("Update cadastro set nome='"+getNome()+"',endereco='"+getEndereco()+"',fone='"+getFone()+"',celular='"+getCelular()+"',sexo='"+getSexo()+"',obs='"+getEmail()+"','"+getCEP()+"','"+getCPF()+"','"+getData()+"'where codigo='"+getCodigo()+"';");

            }

            con.close();
            JOptionPane.showMessageDialog(null,"Registro Alterado");
            this.limpaDados();
            tNome.requestFocus();
            bSalva.setEnabled(false);
        }

        catch(SQLException sql)
        {
            JOptionPane.showMessageDialog(null,"Não foi possível alterar o registro.");
        }
    }

//Método para limpar o conteúdo do campos
    public void limpaDados() {
        this.setCodigo(""); 
        this.setNome("");
        this.setEndereco("");
        this.setFone("");
        this.setCelular("");
    }

//Obtem os dados do objeto contato e mostra-os nos seus respectivos
//componentes visuais.
    public void obterDadosContatos(int pos) {

//cria um objeto para receber o conteudo na posicao do vetor
        informacoes cadastroAtual=(informacoes)vContatos.elementAt(pos);

//Utiliza o metodo getCodigo do objeto e devolve para o método setCodigo do componente
        this.setCodigo(cadastroAtual.getCodigo());
        this.setNome(cadastroAtual.getNome());
        this.setEndereco(cadastroAtual.getEndereco());
        this.setFone(cadastroAtual.getFone());
        this.setCelular(cadastroAtual.getCelular());
        this.setSexo(cadastroAtual.getSexo());
        this.setEmail(cadastroAtual.getEmail());
        this.setCEP(cadastroAtual.getCep());
        this.setCPF(cadastroAtual.getCpf());
        this.setData(cadastroAtual.getData());
    }

// fechar da janela Agenda

    public void windowClosing(WindowEvent e) {
        System.exit(0);

    }
// Cria método para tornar a janela Agenda visível
    public void mostraAgenda(){
        janela.setVisible(true);
    }
    public static void main(String[] args) {
        cadastro agenda = new cadastro();
        agenda.mostraAgenda();
    }}