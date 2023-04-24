package br.upe.model;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TableColorCellRenderer implements TableCellRenderer {
    private static final TableCellRenderer RENDERER = new DefaultTableCellRenderer();
    private static final List<Color> COLOR_LIST = new ArrayList<Color>();

    static {
        COLOR_LIST.add(new Color(204, 255, 204)); // verde claro
        COLOR_LIST.add(new Color(255, 255, 153)); // amarelo
        COLOR_LIST.add(new Color(255, 204, 153)); // laranja
        COLOR_LIST.add(new Color(255, 153, 153)); // vermelho
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == 3) {
            LocalDate dataAtual = LocalDate.now();
            LocalDate dataPrazo = (LocalDate) value;
            long diasRestantes = dataAtual.until(dataPrazo).getDays();

            if (diasRestantes > 7) {
                c.setBackground(COLOR_LIST.get(0)); // verde claro mais de 7 dias
            } else if (diasRestantes > 3) {
                c.setBackground(COLOR_LIST.get(1)); // amarelo 7 a 3 dias antes
            } else if (diasRestantes > 1) {
                c.setBackground(COLOR_LIST.get(2)); // laranja de 3 a 1 dia antes
            } else {
                c.setBackground(COLOR_LIST.get(3)); // vermelho menos de um dia ou vencido
            }
        } else {
            c.setBackground(Color.WHITE); // cor padrão das células que não representam o prazo
        }
        return c;
    }
}
