package club.texttransformation;

import club.texttransformation.transform.TextTransformer;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class TransformerRenderer extends JLabel implements ListCellRenderer<TextTransformer> {

  @Override
  public Component getListCellRendererComponent(JList<? extends TextTransformer> list,
      TextTransformer value, int index, boolean isSelected, boolean cellHasFocus) {

    if (isSelected) {
      setBackground(list.getSelectionBackground());
      setForeground(list.getSelectionForeground());
    } else {
      setBackground(list.getBackground());
      setForeground(list.getForeground());
    }

    setFont(list.getFont());
    setText(value.getName());

    return this;
  }
}
