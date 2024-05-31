package pokerlator;

import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;


public class pokerLatorView extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
    ImageIcon pokerIcon = new ImageIcon("src/images/mano.png");

    public pokerLatorView() {
        initComponents();
        init();

        for (int i = 0; i < 80 * 300; i++) {
            System.out.println("\b");
        }

        System.out.println(Functions.ANSI_YELLOW_BLACK + "Pokerlator v1.2024 (By Santiago Torres P.)");
        
        jLabelPokerIcon.setIcon(pokerIcon);
        jLabelPokerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jLabelPokerIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir");
        btnAbrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar Como");
        btnGuardarC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        btnCompilar.setText("Compilar");
        btnCompilar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jtpCode);

        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ){
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        }
    );
    jScrollPane3.setViewportView(tblTokens);

    jLabelPokerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelPokerIcon.setToolTipText("Documentación");
    jLabelPokerIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelPokerIcon.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelPokerIconMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
    rootPanel.setLayout(rootPanelLayout);
    rootPanelLayout.setHorizontalGroup(
        rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(rootPanelLayout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane2)
                .addComponent(jScrollPane1)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                    .addComponent(btnNuevo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnAbrir)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnGuardar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnGuardarC)
                    .addGap(44, 44, 44)
                    .addComponent(btnCompilar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnEjecutar)))
            .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rootPanelLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPokerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(164, 164, 164))))
    );
    rootPanelLayout.setVerticalGroup(
        rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(rootPanelLayout.createSequentialGroup()
            .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelPokerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(rootPanelLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo)
                        .addComponent(btnAbrir)
                        .addComponent(btnGuardar)
                        .addComponent(btnGuardarC)
                        .addComponent(btnCompilar)
                        .addComponent(btnEjecutar))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(rootPanelLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addContainerGap(19, Short.MAX_VALUE))
    );

    jLabelPokerIcon.getAccessibleContext().setAccessibleParent(this);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        title = "Pokerlator";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".poker");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"corazones", "diamantes", "treboles", "picas"}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

        private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
            directorio.New();
            clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed

        if (getTitle().contains("*") || getTitle().equals(title)) {
            directorio.Save();
        }

        compile();
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);
                executeCode(blocksOfCode, 1);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void jLabelPokerIconMouseClicked(java.awt.event.MouseEvent evt) {

        try {
            Desktop .getDesktop().browse(new URI("https://github.com/sanTorres770/compilador-Pokerlator/blob/master/README.md"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private void executeCode(ArrayList<String> blocksOfCode, int repeats) {

    }

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexer;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexer.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void lexicalAnalysis() {
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {

        SyntaxPokerlator gramatica = new SyntaxPokerlator(tokens, errors);

        /* Deshabilitar mensajes y validaciones */
        gramatica.disableMessages();
        gramatica.disableValidations();

        /* Eliminación de errores */
        gramatica.delete(new String[]{"ERROR", "ERROR_1", "ERROR_2", "ERROR_3"}, 14);

        /* Agrupacion de cartas */
        gramatica.group("CARTA", "(DIAMANTES | CORAZONES | TREBOLES | PICAS)", true);


        /* Agrupación de valores */
        gramatica.group("VALOR", "(NUMERO | TEXTO | CARTA | BOOLEANO | NADA)", true);

        /* Comparacion texto*/
        gramatica.group("COMPARACION_TEXTO", "(OP_LOGICO)? IDENTIFICADOR NUMERAL COMPARAR PARENTESIS_A VALOR PARENTESIS_C", true);
        gramatica.group("COMPARACION_TEXTO", "(OP_LOGICO)? IDENTIFICADOR NUMERAL PARENTESIS_A VALOR PARENTESIS_C", true,
                150, "× Error sintáctico {}: falta llamar la palabra reservada 'comparar' [#, %]");

        /* Arreglo de cartas y agrupacion como valor*/

        gramatica.group("ARREGLO_CARTAS", "MANO CORCHETE_A (VALOR)+ CORCHETE_C", true);
        gramatica.group("ARREGLO_CARTAS", "CORCHETE_A (VALOR)+ CORCHETE_C", true,
                350, "× Error sintáctico {}: falta la declaracion en la mano de cartas [#, %]");
        gramatica.group("ARREGLO_CARTAS", "MANO (VALOR)+ CORCHETE_C", true,
                351, "× Error sintáctico {}: falta el corchete que abre en la mano de cartas [#, %]");
        gramatica.group("ARREGLO_CARTAS", "MANO CORCHETE_A (VALOR)+", true,
                352, "× Error sintáctico {}: falta el corchete que cierra en la mano de cartas [#, %]");
        gramatica.group("ARREGLO_CARTAS", "MANO CORCHETE_A CORCHETE_C", true,
                353, "× Error sintáctico {}: la mano de cartas está vacía [#, %]");
        gramatica.group("ARREGLO_CARTAS", "MANO CORCHETE_A (VALOR)+ (ERROR_4)? CORCHETE_C", true,
                354, "× Error sintáctico {}: la mano contiene un valor de carta no válido [#, %]");

        gramatica.group("VALOR", "ARREGLO_CARTAS", true);


        /* Declaración de variables */
        gramatica.group("VARIABLE", "(TIPO_CARTA | TIPO_DATO) IDENTIFICADOR ASIGNACION VALOR", true, identProd);

        gramatica.group("VARIABLE", "TIPO_CARTA ASIGNACION VALOR", true,
                1, " × Error sintáctico {}: falta el identificador en la declaración de variable [#, %]");

        gramatica.finalLineColumn();

        gramatica.group("VARIABLE", "(TIPO_CARTA | TIPO_DATO) IDENTIFICADOR ASIGNACION", true,
                2, " × Error sintáctico {}: falta el valor en la declaración de variable [#, %]");

        gramatica.group("VARIABLE", "(TIPO_CARTA | TIPO_DATO) IDENTIFICADOR VALOR", true,
                3, " × Error sintáctico {}: falta el operador de asignación en la declaración de variable [#, %]", 2);

        gramatica.initialLineColumn();

        gramatica.group("VARIABLE", "IDENTIFICADOR ASIGNACION VALOR", true,
                4, " × Error sintáctico {}: falta el tipo de dato en la declaración de variable [#, %]");

        gramatica.group("VARIABLE", "(TIPO_CARTA | TIPO_DATO) IDENTIFICADOR ASIGNACION ERROR_4", true,
                400, " × Error sintáctico {}: el valor de la carta esta mal definido [#, %]");

        /* Eliminación de tipos de datos y operadores de asignación */
        gramatica.delete("(TIPO_CARTA | TIPO_DATO)",
                5, " × Error sintáctico {}: el tipo de dato no está en la declaración de la variable [#, %]");
        gramatica.delete("ASIGNACION",
                6, " × Error sintáctico {}: el operador de asignación no está en la declaración de una variable [#, %]");

        /*definición de parámetros y retorno de función */

        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

        gramatica.group("RETORNAR", "RETORNO ASIGNACION_RETORNO VALOR");
        gramatica.group("RETORNAR", "ASIGNACION_RETORNO VALOR",
                963," × Error sintáctico {}: falta la sentencia 'retorno' al retornar el valor en la función [#, %]");
        gramatica.group("RETORNAR", "RETORNO VALOR",
                964," × Error sintáctico {}: falta el operador de asignación de retorno en la función [#, %]");
        gramatica.group("RETORNAR", "RETORNO ASIGNACION_RETORNO",
                965," × Error sintáctico {}: falta el valor de retorno en la función [#, %]");


        /* Agrupación de funciones */
        gramatica.group("FUNCION_LAMBDA", "PARENTESIS_A (VALOR | PARAMETROS)? PARENTESIS_C ASIGNACION_LAMBDA", true);

        gramatica.group("FUNCION_RESERVADA", "(MOVIMIENTO | REPARTIR | REPETIR | DETENER | IMPRIMIR) PARENTESIS_A (VALOR | PARAMETROS | FUNCION_LAMBDA) PARENTESIS_C", true);
        gramatica.group("FUNCION_RESERVADA", "(MOVIMIENTO | REPARTIR | REPETIR | DETENER | IMPRIMIR) PARENTESIS_A PARENTESIS_C", true);

        gramatica.group("FUNCION_NORMAL", "PROCESO IDENTIFICADOR PARENTESIS_A (VALOR | PARAMETROS | FUNCION_LAMBDA) PARENTESIS_C", true);
        gramatica.group("FUNCION_NORMAL", "PROCESO IDENTIFICADOR PARENTESIS_A PARENTESIS_C", true);

        gramatica.group("FUNCION_NORMAL", "PROCESO IDENTIFICADOR (VALOR | PARAMETROS | FUNCION_LAMBDA) PARENTESIS_C", true,
                7, " × Error sintáctico {}: falta el paréntesis que abre en la función [#, %]");
        gramatica.group("FUNCION_NORMAL", "PROCESO IDENTIFICADOR PARENTESIS_C", true,
                77, " × Error sintáctico {}: falta el paréntesis que abre en la función [#, %]");


        gramatica.group("FUNCION_RESERVADA", "(MOVIMIENTO | REPARTIR | REPETIR | DETENER | IMPRIMIR) (VALOR | PARAMETROS | FUNCION_LAMBDA) PARENTESIS_C", true,
                78, " × Error sintáctico {}: falta el paréntesis que abre en la función [#, %]");
        gramatica.group("FUNCION_LAMBDA", "(VALOR | PARAMETROS)? PARENTESIS_C ASIGNACION_LAMBDA", true,
                79, " × Error sintáctico {}: falta el paréntesis que abre en la función [#, %]");

        gramatica.finalLineColumn();


        gramatica.group("FUNCION_NORMAL", "PROCESO IDENTIFICADOR PARENTESIS_A (VALOR | PARAMETROS | FUNCION_LAMBDA)", true,
                850, " × Error sintáctico {}: falta el paréntesis que cierra en la función [#, %]");
        gramatica.group("FUNCION_NORMAL", "PROCESO IDENTIFICADOR PARENTESIS_A", true,
                851, " × Error sintáctico {}: falta el paréntesis que cierra en la función [#, %]");

        gramatica.group("FUNCION_RESERVADA", "(MOVIMIENTO | REPARTIR | REPETIR | DETENER | IMPRIMIR) PARENTESIS_A (VALOR | PARAMETROS | FUNCION_LAMBDA)", true,
                852, " × Error sintáctico {}: falta el paréntesis que cierra en la función [#, %]");
        gramatica.group("FUNCION_RESERVADA", "(MOVIMIENTO | REPARTIR | REPETIR | DETENER | IMPRIMIR) PARENTESIS_A", true,
                853, " × Error sintáctico {}: falta el paréntesis que cierra en la función [#, %]");

        gramatica.group("FUNCION_LAMBDA", "PARENTESIS_A (VALOR | PARAMETROS)? ASIGNACION_LAMBDA", true,
                854, " × Error sintáctico {}: falta el paréntesis que cierra en la función [#, %]");

        gramatica.initialLineColumn();


        // eliminacion de funciones mal declaradas //
        gramatica.delete(new String[]{"MOVIMIENTO", "REPARTIR", "REPETIR", "DETENER", "IMPRIMIR", "PROCESO"},
                91, " × Error sintáctico {}: funcion mal declarada [#, %]");

       // Expresiones lógicas //
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EXP_LOGICA", "(EXP_LOGICA | FUNCION_RESERVADA | FUNCION_NORMAL) (OP_LOGICO (EXP_LOGICA | FUNCION_RESERVADA | FUNCION_NORMAL))+");
            gramatica.group("EXP_LOGICA", "PARENTESIS_A (EXP_LOGICA | FUNCION_RESERVADA | FUNCION_NORMAL) PARENTESIS_C", true);
        });

        // Eliminación de operadores lógicos //
        gramatica.delete("OP_LOGICO",
                10, " × Error sintáctico {}: El operador lógico no está contenido en una expresión [#, %]");

        // Agrupación de expresiones lógicas como valores y parámetros //
        gramatica.group("VALOR", "EXP_LOGICA", true);
        gramatica.group("VALOR", "COMPARACION_TEXTO", true);
        gramatica.group("VALOR", "IDENTIFICADOR", true);
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

        // Agrupación de estructuras de control //
        gramatica.group("EST_CONTROL", "(REPETIR | ESTRUCTURA_SI)", true);
        gramatica.group("EST_CONTROL_COMPLETA", "EST_CONTROL (VALOR | PARAMETROS)", true);
        gramatica.group("EST_CONTROL_COMPLETA", "EST_CONTROL PARENTESIS_A PARENTESIS_C", true);
        gramatica.group("EST_CONTROL_COMPLETA", "EST_CONTROL PARENTESIS_A (VALOR | PARAMETROS) PARENTESIS_C", true);
        gramatica.group("EST_CONTROL_COMPLETA", "EST_CONTROL (VALOR | PARAMETROS) PARENTESIS_C", true,
                11, " × Error sintáctico {}: falta el paréntesis que abre en la estructura [#, %]");
        gramatica.group("EST_CONTROL_COMPLETA", "EST_CONTROL PARENTESIS_C", true,
                12, " × Error sintáctico {}: falta el paréntesis que abre en la estructura [#, %]");
        gramatica.finalLineColumn();
        gramatica.group("EST_CONTROL_COMPLETA", "EST_CONTROL PARENTESIS_A (VALOR | PARAMETROS)", true,
                13, " × Error sintáctico {}: falta el paréntesis que cierra en la estructura [#, %]");
        gramatica.group("EST_CONTROL_COMPLETA", "EST_CONTROL PARENTESIS_A", true,
                14, " × Error sintáctico {}: falta el paréntesis que cierra en la estructura [#, %]");

        gramatica.initialLineColumn();

        // Eliminación de estructuras de control mal declaradas //
        gramatica.delete("EST_CONTROL",
                15, " × Error sintáctico {}: La estructura de control no está declarada correctamente [#, %]");

        // Eliminación de paréntesis //
        gramatica.delete(new String[]{"PARENTESIS_A", "PARENTESIS_C"},
                16, " × Error sintáctico {}: El paréntesis [] no está contenido en una agrupación [#, %]");

        // Eliminación de valores //
        gramatica.delete("VALOR",
                17, " × Error sintáctico {}: El valor no está contenido en una función o estructura de control [#, %]");

        gramatica.finalLineColumn();

        // Verificación de punto y coma al final de la sentencia //
        // Identificadores
        gramatica.group("VARIABLE_PC", "VARIABLE PUNTO_COMA", true);
        gramatica.group("VARIABLE_PC", "VARIABLE", true,
                18, " × Error sintáctico {}: falta el punto y coma al final de la declaración de variable [#, %]");

        gramatica.initialLineColumn();

        // Eliminación de punto y coma //
        gramatica.delete("PUNTO_COMA",
                20, " × Error sintáctico {}: el punto y coma no está al final de la declaración de una variable [#, %]");



      // Agrupación de bloques //
        gramatica.group("BLOQUE_CODIGO", "(VARIABLE_PC | FUNCION_NORMAL | FUNCION_RESERVADA)+");
      // Estructuras de control completas //
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EST_CONTROL_CON_LLAVES", "EST_CONTROL_COMPLETA LLAVE_A BLOQUE_CODIGO LLAVE_C", true);
            gramatica.group("FUNCION_NORMAL_CON_LLAVES", "BLOQUE_CODIGO LLAVE_A BLOQUE_CODIGO RETORNAR LLAVE_C", true);
            gramatica.group("FUNCION_RESERVADA_CON_LLAVES", "BLOQUE_CODIGO LLAVE_A BLOQUE_CODIGO RETORNAR LLAVE_C", true);
            gramatica.group("FUNCION_RESERVADA_CON_LLAVES", "BLOQUE_CODIGO LLAVE_A RETORNAR LLAVE_C", true);
            gramatica.group("BLOQUE_CODIGO", "(BLOQUE_CODIGO | EST_CONTROL_CON_LLAVES | FUNCION_NORMAL_CON_LLAVES | FUNCION_RESERVADA_CON_LLAVES)+");
        });

        // Estructuras de control incompletas //
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.initialLineColumn();

            gramatica.group("EST_CONTROL_CON_LLAVES", "EST_CONTROL_COMPLETA (BLOQUE_CODIGO)? RETORNAR LLAVE_C", true,
                    21, " × Error sintáctico {}: falta la llave que abre en la estructura de control [#, %]");

            gramatica.group("FUNCION_NORMAL_CON_LLAVES", "BLOQUE_CODIGO LLAVE_A RETORNAR LLAVE_C", true,
                    209, " × Error sintáctico {}: falta sentencias en la función normal [#, %]");

            gramatica.group("FUNCION_NORMAL_CON_LLAVES", "BLOQUE_CODIGO LLAVE_A BLOQUE_CODIGO LLAVE_C", true,
                    298, " × Error sintáctico {}: falta retorno en la función normal [#, %]");

            gramatica.group("FUNCION_NORMAL_CON_LLAVES", "BLOQUE_CODIGO BLOQUE_CODIGO RETORNAR LLAVE_C", true,
                    210, " × Error sintáctico {}: falta la llave que abre en la función [#, %]");

            gramatica.group("FUNCION_RESERVADA_CON_LLAVES", "BLOQUE_CODIGO BLOQUE_CODIGO RETORNAR LLAVE_C", true,
                    325, " × Error sintáctico {}: falta la llave que abre en la función [#, %]");

            gramatica.group("FUNCION_RESERVADA_CON_LLAVES", "BLOQUE_CODIGO RETORNAR LLAVE_C", true,
                    335, " × Error sintáctico {}: falta la llave que abre en la función [#, %]");

            gramatica.group("FUNCION_RESERVADA_CON_LLAVES", "BLOQUE_CODIGO LLAVE_A BLOQUE_CODIGO LLAVE_C", true,
                    336, " × Error sintáctico {}: falta retorno en la función reservada con bloque de código [#, %]");

            gramatica.finalLineColumn();

            gramatica.group("EST_CONTROL_CON_LLAVES", "EST_CONTROL_COMPLETA LLAVE_A BLOQUE_CODIGO RETORNAR",
                    22, " × Error sintáctico {}: falta la llave que cierra en la estructura de control [#, %]");

            gramatica.group("FUNCION_NORMAL_CON_LLAVES", "BLOQUE_CODIGO LLAVE_A BLOQUE_CODIGO RETORNAR", true,
                    217, " × Error sintáctico {}: falta la llave que cierra en la función [#, %]");

            gramatica.group("FUNCION_RESERVADA_CON_LLAVES", "BLOQUE_CODIGO LLAVE_A BLOQUE_CODIGO RETORNAR", true,
                    328, " × Error sintáctico {}: falta la llave que cierra en la función [#, %]");

            gramatica.group("FUNCION_RESERVADA_CON_LLAVES", "BLOQUE_CODIGO LLAVE_A RETORNAR", true,
                    329, " × Error sintáctico {}: falta la llave que cierra en la función [#, %]");
        });

        // agrupacion codigo completo//

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("CODIGO_COMPLETO", "INICIO (BLOQUE_CODIGO)+ FINAL", true);
        });


        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.initialLineColumn();

            gramatica.group("CODIGO_COMPLETO", "INICIO (BLOQUE_CODIGO)+", true,
                    300, " × Error sintáctico {}: falta declarar el FINAL [#, %]");

            gramatica.group("CODIGO_COMPLETO", "(BLOQUE_CODIGO)+ FINAL", true,
                    301, " × Error sintáctico {}: falta declarar el INICIO [#, %]");

            gramatica.group("CODIGO_COMPLETO", "(BLOQUE_CODIGO)+", true,
                    302, " × Error sintáctico {}: falta declarar el INICIO y el FINAL [#, %]");

            gramatica.group("CODIGO_COMPLETO", "INICIO FINAL", true,
                    301, " × Error sintáctico {}: código sin sentencias [#, %]");
        });



        // Eliminación de llaves //
        gramatica.delete(new String[]{"LLAVE_A", "LLAVE_C"},
                546, " × Error sintáctico {}: la llave no está contenida en una agrupación [#, %]");

        // Eliminación de retorno mal declarado //
        gramatica.delete("RETORNAR",
                567, " × Error sintáctico {}: el retorno no pertenece a ninguna función [#, %]");

        // Eliminación de bloques de codigo //
        gramatica.delete("BLOQUE_CODIGO",
                568, " × Error sintáctico {}: bloque de código está fuera de las sentencias Inicio y Final[#, %]");

        // Eliminación de Inicio y final //
        gramatica.delete(new String[]{"INICIO", "FINAL"},
                569, " × Error sintáctico {}: el inicio o el final no pertenecen a ningún bloque de código [#, %]");

        /* Mostrar gramáticas */
        gramatica.show();
    }

    private void semanticAnalysis() {

        HashMap<String, String> identDataType = new HashMap<>();
        identDataType.put("diamantes", "DIAMANTES");
        identDataType.put("corazones", "CORAZONES");
        identDataType.put("treboles", "TREBOLES");
        identDataType.put("picas", "PICAS");
        identDataType.put("numero", "NUMERO");
        identDataType.put("texto", "TEXTO");
        identDataType.put("bool", "BOOLEANO");
        for (Production id : identProd) {
            if (!identDataType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1))) {
                errors.add(new ErrorLSSL(1, " × Error semántico {}: valor no compatible con el tipo de dato [#, %]. Se esperaba un " + identDataType.get(id.lexemeRank(0)), id, true));
            }
            if (id.lexicalCompRank(-1).equals("COLOR") && !id.lexemeRank(-1).matches("#[0-9a-fA-F]+")) {
                errors.add(new ErrorLSSL(2, " × Error lógico {}: el color no es un número hexadecimal [#, %]", id, false));
            }
            identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
        }

    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {

        if (!errors.isEmpty()) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {

            try {

                UIManager.setLookAndFeel(new FlatIntelliJLaf());

                new pokerLatorView().setVisible(true);

            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(pokerLatorView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabelPokerIcon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables

}
