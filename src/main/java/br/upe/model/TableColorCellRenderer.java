package br.upe.model;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TableColorCellRenderer implements TableCellRenderer {
    private static final TableCellRenderer RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column==3){
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate dataAtual = LocalDate.now();
            LocalDate dataPrazo = (LocalDate) table.getModel().getValueAt(row, column);

            Color cor = null;
            if (dataAtual.isAfter(dataPrazo)){
                cor = Color.RED;
            }
            else {
                cor = Color.BLACK;
            }
            c.setForeground(cor);
        }
        return c;
    }
}
