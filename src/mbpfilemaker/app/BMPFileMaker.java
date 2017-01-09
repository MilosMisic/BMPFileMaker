package mbpfilemaker.app;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import javax.swing.*;
import javax.swing.event.*;

public class BMPFileMaker extends javax.swing.JFrame {

    private StringBuilder builder;
    private JFileChooser fileChooser;
    private String outDirectory;
    private File bmpFile;
    private byte[] result;

    int width;
    int height;
    int vertRes;
    int horisRes;
    int pixelDataSize;

    public BMPFileMaker() {
        initComponents();
        this.setLocationRelativeTo(null);
        BMPNameLabel.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                BMPNameLabel.setToolTipText(bmpFile.getPath());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                BMPNameLabel.setToolTipText(bmpFile.getPath());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browseButton = new javax.swing.JButton();
        makeButton = new javax.swing.JButton();
        outFileNameLabel = new javax.swing.JTextField();
        outFileButton = new javax.swing.JButton();
        BMPNameLabel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        resLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bppLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fileSizeLabel = new javax.swing.JLabel();
        succesfulLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BMPFileMaker");
        setResizable(false);

        browseButton.setText("BMP File");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        makeButton.setText("Make");
        makeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeButtonActionPerformed(evt);
            }
        });

        outFileButton.setText("Text File");
        outFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outFileButtonActionPerformed(evt);
            }
        });

        BMPNameLabel.setEditable(false);

        jLabel1.setText("Resolution:");

        jLabel3.setText("BPP:");

        jLabel2.setText("File size:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(outFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BMPNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                            .addComponent(outFileNameLabel))
                        .addGap(18, 18, 18)
                        .addComponent(makeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bppLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileSizeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(succesfulLabel)
                        .addGap(141, 141, 141)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(browseButton)
                            .addComponent(BMPNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outFileButton)
                            .addComponent(outFileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(makeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(resLabel)
                    .addComponent(bppLabel)
                    .addComponent(jLabel2)
                    .addComponent(fileSizeLabel)
                    .addComponent(succesfulLabel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        fileChooser = new JFileChooser();
        builder = new StringBuilder();
        fileChooser.setDialogTitle("Select BMP File");
        switch (fileChooser.showOpenDialog(this)) {
            case JFileChooser.APPROVE_OPTION:
                bmpFile = fileChooser.getSelectedFile();
                String extension = ".bmp";
                if (!bmpFile.getName().substring(bmpFile.getName().length() - 4).equalsIgnoreCase(extension)) {
                    JOptionPane.showMessageDialog(this, "File must be BMP type file!");
                    browseButtonActionPerformed(null);
                    bmpFile = null;
                }
                Path path = Paths.get("");
                if (bmpFile != null) {
                    path = Paths.get(bmpFile.getAbsolutePath());
                }

                try {
                    byte[] data = Files.readAllBytes(path);

                    width = read4Bytes(data, 18);
                    height = read4Bytes(data, 22);
                    vertRes = read4Bytes(data, 38);
                    horisRes = read4Bytes(data, 42);
                    pixelDataSize = read4Bytes(data, 34);

                    int bpp = read2Bytes(data, 28);
                    int start = read4Bytes(data, 10);
                    int fileSize = read4Bytes(data, 2);

                    result = new byte[data.length - data[10]];

                    int length = 0;
                    for (int i = start; i < data.length; i++) {
                        result[length++] = data[i];
                    }

                    BMPNameLabel.setText(bmpFile.getAbsolutePath());
                    resLabel.setText(width + "x" + height);
                    bppLabel.setText(String.valueOf(bpp));
                    fileSizeLabel.setText(String.valueOf(fileSize) + " bytes");
                    succesfulLabel.setText("");
                    data = null;
                } catch (IOException ex) {
                }

                break;
            case JFileChooser.CANCEL_OPTION:
                bmpFile = null;
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void makeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeButtonActionPerformed
        succesfulLabel.setText("");
        String fileName = outFileNameLabel.getText();
        if (fileName.contains(".")) {
            fileName = fileName.substring(0, fileName.indexOf("."));
        }
        String newOutDirectory = outDirectory;
        newOutDirectory = newOutDirectory + File.separator + fileName + ".txt";

        int length = 0;
        for (int i = 0; i < result.length; i++) {
            if (length == 16) {
                builder.append("\r\n");
                length = 0;
            }
            builder.append("0x").append(String.format("%02X", result[i])).append(", ");
            length++;
        }
        builder = builder.deleteCharAt(builder.length() - 2);
        System.out.println(builder.toString());
        if (new File(newOutDirectory).exists()) {
            switch (JOptionPane.showConfirmDialog(this, "File already exits    \n Do you want to overwrite it?")) {
                case JOptionPane.YES_OPTION:
                    writeToFile(newOutDirectory, builder.toString());
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
            }
        } else {
            writeToFile(newOutDirectory, builder.toString());
        }

    }//GEN-LAST:event_makeButtonActionPerformed
    private void writeToFile(String dir, String text) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dir));
            out.write(text);
            out.close();
            builder.delete(0, builder.length());
            if (new File(dir).exists()) {
                succesfulLabel.setText("Successful!");
            }
            dir = null;
        } catch (IOException e) {
            System.out.println("Exception ");
        }
    }
    private void outFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outFileButtonActionPerformed
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        switch (fileChooser.showSaveDialog(this)) {
            case JFileChooser.APPROVE_OPTION:
                outDirectory = fileChooser.getSelectedFile().getPath();
                outFileNameLabel.setToolTipText(outDirectory);
                break;
        }
    }//GEN-LAST:event_outFileButtonActionPerformed
    public int read4Bytes(byte[] array, int firstIndex) {
        byte[] data = new byte[]{array[firstIndex], array[firstIndex + 1], array[firstIndex + 2], array[firstIndex + 3]};
        ByteBuffer byteBuffer = ByteBuffer.wrap(data);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getInt();
    }

    public int read2Bytes(byte[] array, int firstIndex) {
        return (((int) array[firstIndex]) & 0xFF) + ((((int) array[firstIndex + 1])) << 8);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BMPFileMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new BMPFileMaker().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BMPNameLabel;
    private javax.swing.JLabel bppLabel;
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel fileSizeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton makeButton;
    private javax.swing.JButton outFileButton;
    private javax.swing.JTextField outFileNameLabel;
    private javax.swing.JLabel resLabel;
    private javax.swing.JLabel succesfulLabel;
    // End of variables declaration//GEN-END:variables
}
//					double rowSize = Math.floor((bpp * width + 31) / 32) * 4;
//					double pixelArraySize = rowSize * Math.abs(height);
