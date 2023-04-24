package br.upe.ui;

import br.upe.controller.TarefaControlador;
import br.upe.model.TableColorCellRenderer;
import br.upe.model.Tarefa;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class TelaPrincipal {
    private JPanel pnlMain;
    private JTextField txtDescricaoTarefa;
    private JButton btnAdicionarTarefa;
    private JPanel pnlAdicionar;
    private JTable tblTarefas;
    private TableColorCellRenderer tblRenderer;
    private JCheckBox chkExibirFinalizadas;
    private JTextField txtDataFinalizacao;

    private List<Tarefa> tarefas;

    private TarefaControlador controlador;

    public TelaPrincipal() {
        super();
        tarefas = new ArrayList<>();
        btnAdicionarTarefa.addActionListener(e -> {
            adicionarTarefa(txtDescricaoTarefa.getText(), txtDataFinalizacao.getText());
            txtDescricaoTarefa.setText("");
            txtDataFinalizacao.setText("");
        });
        chkExibirFinalizadas.addActionListener(e -> {
            boolean selecionado = ((JCheckBox) e.getSource()).isSelected();
            controlador.exibirFinalizadas(selecionado);
        });

        txtDescricaoTarefa.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtDescricaoTarefa.getText().equals("descrição da tarefa a ser feita")){
                    txtDescricaoTarefa.setText("");
                }
                txtDescricaoTarefa.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtDescricaoTarefa.getText().equals("")){
                    txtDescricaoTarefa.setText("descrição da tarefa a ser feita");
                    txtDescricaoTarefa.setForeground(new Color(137,132,131));
                }
            }
        });

        txtDataFinalizacao.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtDataFinalizacao.getText().equals("data no formato dia/mês/ano")){
                    txtDataFinalizacao.setText("");
                }
                txtDataFinalizacao.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtDataFinalizacao.getText().equals("")){
                    txtDataFinalizacao.setText("data no formato dia/mês/ano");
                    txtDataFinalizacao.setForeground(new Color(137,132,131));
                }
            }
        });
    }
    private void adicionarTarefa(String texto, String prazo) {
        Tarefa tarefa = new Tarefa(texto, prazo, tarefas.size());
        controlador.adicionarTarefaAtiva(tarefa);
        tblTarefas.revalidate();
        tblTarefas.repaint();
    }
    public JPanel getPnlMain() {
        return this.pnlMain;
    }

    private void createUIComponents() {
        controlador = new TarefaControlador();
        tblTarefas = new JTable(controlador.getTarefaTableModel());
        tblRenderer = new TableColorCellRenderer();

        tblTarefas.getColumnModel().getColumn(0).setMaxWidth(20);
        tblTarefas.setDefaultRenderer(Object.class, tblRenderer);
    }
}
