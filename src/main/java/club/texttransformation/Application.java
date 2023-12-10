package club.texttransformation;

import club.texttransformation.transform.NoopTransformer;
import club.texttransformation.transform.TextTransformer;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Application extends JFrame {

  private JTextArea sourceTextArea = new JTextArea();
  private JTextArea transformedTextArea = new JTextArea();
  private JComboBox<TextTransformer> transformers = new JComboBox<>(
      new TextTransformer[]{
          // ADD Transformers to this array.
          new NoopTransformer()
      }
  );

  Application() {
    super("Text Transformation");
    transformers.setRenderer(new TransformerRenderer());
    sourceTextArea.getDocument().addDocumentListener(
        new DocumentListener() {
          @Override
          public void insertUpdate(DocumentEvent e) {
            applyTransformation();
          }

          @Override
          public void removeUpdate(DocumentEvent e) {
            applyTransformation();
          }

          @Override
          public void changedUpdate(DocumentEvent e) {
            applyTransformation();
          }
        }
    );

    JPanel transformersPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    transformersPanel.add(new JLabel("Transformation"));
    transformersPanel.add(transformers);

    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(
        createTextPanel("Source text", sourceTextArea),
        BorderLayout.LINE_START
    );
    contentPane.add(
        transformersPanel,
        BorderLayout.PAGE_START
    );
    contentPane.add(
        createTextPanel("Transformed text", transformedTextArea),
        BorderLayout.LINE_END
    );
    pack();
  }

  private void applyTransformation() {
    Object selectedItem = transformers.getSelectedItem();

    if (selectedItem instanceof TextTransformer transformer) {
      String transformedText = transformer.transform(sourceTextArea.getText());
      transformedTextArea.setText(transformedText);
    }
  }

  private static void runGuiApplication() {
    Application applicationFrame = new Application();
    applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    applicationFrame.setLocationRelativeTo(null);
    applicationFrame.setVisible(true);
  }

  private static JPanel createTextPanel(String title, JTextArea textArea) {
    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(400, 400));
    panel.setLayout(new BorderLayout());
    JLabel labelTitle = new JLabel(title);
    labelTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
    panel.add(labelTitle, BorderLayout.NORTH);

    JScrollPane scroll = new JScrollPane(
        textArea,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
    );
    panel.add(scroll, BorderLayout.CENTER);

    return panel;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> runGuiApplication());
  }
}
