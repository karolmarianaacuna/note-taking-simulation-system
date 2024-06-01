/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.materiapoo_proyectofinal.formularioss;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.materiapoo_proyectofinal.DAOS.DAOSNotaAcademica;
import com.mycompany.materiapoo_proyectofinal.clases.NotaAcademica;
import com.mycompany.materiapoo_proyectofinal.clases.NotaPersonal;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignB;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.materialdesign2.MaterialDesignD;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignU;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author USUARIO
 */
public class FrmAcademico extends javax.swing.JFrame {

    FontIcon iconePersonal = new FontIcon();
    FontIcon iconeTrabajo = new FontIcon();
    FontIcon iconeEstudio = new FontIcon();
    FontIcon iconeFinanzas = new FontIcon();
    FontIcon iconeVarios = new FontIcon();
    FontIcon iconeSalud = new FontIcon();

    FontIcon iconeGuardar = new FontIcon();
    FontIcon iconeActualizar = new FontIcon();
    FontIcon iconeEliminar = new FontIcon();

    DAOSNotaAcademica dAOSNotaAcademica = new DAOSNotaAcademica();

    /**
     * Creates new form FrmAcademico
     */
    public FrmAcademico() {
        initComponents();
        listar();

        try {
            // define la URL de la imagen externa
            URL imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/4/45/Notion_app_logo.png");
            // crea una imagenIcon a partir de la URL
            Image imageIconSpotify = new ImageIcon(imageUrl).getImage().getScaledInstance(60, 60, 0);
            ImageIcon iconoSpo = new ImageIcon(imageIconSpotify);
            // crea un Jlabel y asigna el ImageIcon
            lblImgLogo.setIcon(iconoSpo);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            // define la URL de la imagen externa
            URL imageUrl = new URL("https://cdn-icons-png.flaticon.com/512/2839/2839097.png?ga=GA1.1.67356358.1685806904");
            // crea una imagenIcon a partir de la URL
            Image imageIconSpotify = new ImageIcon(imageUrl).getImage().getScaledInstance(80, 80, 0);
            ImageIcon iconoSpo = new ImageIcon(imageIconSpotify);
            // crea un Jlabel y asigna el ImageIcon
            jLabelIncompleto.setIcon(iconoSpo);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            // define la URL de la imagen externa
            URL imageUrl = new URL("https://cdn-icons-png.flaticon.com/512/1365/1365358.png?ga=GA1.1.67356358.1685806904");
            // crea una imagenIcon a partir de la URL
            Image imageIconSpotify = new ImageIcon(imageUrl).getImage().getScaledInstance(80, 80, 0);
            ImageIcon iconoSpo = new ImageIcon(imageIconSpotify);
            // crea un Jlabel y asigna el ImageIcon
            jLabelsig.setIcon(iconoSpo);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        iconePersonal.setIkon(MaterialDesignA.ACCOUNT_OUTLINE);
        iconePersonal.setIconSize(30);
        iconePersonal.setIconColor(Color.decode("#000000"));
        this.lblPersonal.setIcon(iconePersonal);

        iconeTrabajo.setIkon(MaterialDesignB.BRIEFCASE_ACCOUNT_OUTLINE);
        iconeTrabajo.setIconSize(30);
        iconeTrabajo.setIconColor(Color.decode("#000000"));
        this.lblTrabajo.setIcon(iconeTrabajo);

        iconeEstudio.setIkon(MaterialDesignB.BOOK_EDUCATION);
        iconeEstudio.setIconSize(30);
        iconeEstudio.setIconColor(Color.decode("#000000"));
        this.lblEstudio.setIcon(iconeEstudio);

        iconeFinanzas.setIkon(MaterialDesignF.FINANCE);
        iconeFinanzas.setIconSize(30);
        iconeFinanzas.setIconColor(Color.decode("#000000"));
        this.lblFinazas.setIcon(iconeFinanzas);

        iconeVarios.setIkon(MaterialDesignA.AUTO_FIX);
        iconeVarios.setIconSize(30);
        iconeVarios.setIconColor(Color.decode("#000000"));
        this.lblVarios.setIcon(iconeVarios);

        iconeSalud.setIkon(MaterialDesignA.ACCOUNT_HEART_OUTLINE);
        iconeSalud.setIconSize(30);
        iconeSalud.setIconColor(Color.decode("#000000"));
        this.lblSalud.setIcon(iconeSalud);

        //icono Guardar 
        iconeGuardar.setIkon(MaterialDesignC.CONTENT_SAVE);
        iconeGuardar.setIconSize(30);
        iconeGuardar.setIconColor(Color.decode("#000000"));
        this.lblGuardar.setIcon(iconeGuardar);

        //icono Actualizar
        iconeActualizar.setIkon(MaterialDesignU.UBISOFT);
        iconeActualizar.setIconSize(30);
        iconeActualizar.setIconColor(Color.decode("#000000"));
        this.lblActualizar.setIcon(iconeActualizar);

        //icono Actualizar
        iconeEliminar.setIkon(MaterialDesignD.DELETE);
        iconeEliminar.setIconSize(30);
        iconeEliminar.setIconColor(Color.decode("#000000"));
        this.lblEliminar.setIcon(iconeEliminar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPersonal = new javax.swing.JPanel();
        lblPersonal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTrabajo = new javax.swing.JPanel();
        lblTrabajo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jAcademico = new javax.swing.JPanel();
        lblEstudio = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jFinanzas = new javax.swing.JPanel();
        lblFinazas = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jVarioss = new javax.swing.JPanel();
        lblVarios = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSalud = new javax.swing.JPanel();
        lblSalud = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lblImgLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreNota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jPGuardar = new javax.swing.JPanel();
        lblGuardar = new javax.swing.JLabel();
        jPActualizar = new javax.swing.JPanel();
        lblActualizar = new javax.swing.JLabel();
        jPEliminar = new javax.swing.JPanel();
        lblEliminar = new javax.swing.JLabel();
        jPExportPdf = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelIncompleto = new javax.swing.JLabel();
        jLabelsig = new javax.swing.JLabel();
        txtObjetivosAprendizaje = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtLike = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPersonal.setBackground(new java.awt.Color(255, 255, 255));
        jPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPersonalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPersonalMouseEntered(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel3.setText("Personal");

        jPanel10.setBackground(new java.awt.Color(204, 255, 102));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPersonalLayout = new javax.swing.GroupLayout(jPersonal);
        jPersonal.setLayout(jPersonalLayout);
        jPersonalLayout.setHorizontalGroup(
            jPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPersonalLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(lblPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPersonalLayout.setVerticalGroup(
            jPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPersonalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lblPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTrabajo.setBackground(new java.awt.Color(255, 255, 255));
        jTrabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTrabajoMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel5.setText("Trabajo");

        jPanel11.setBackground(new java.awt.Color(255, 102, 153));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jTrabajoLayout = new javax.swing.GroupLayout(jTrabajo);
        jTrabajo.setLayout(jTrabajoLayout);
        jTrabajoLayout.setHorizontalGroup(
            jTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTrabajoLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTrabajoLayout.setVerticalGroup(
            jTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTrabajoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lblTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jAcademico.setBackground(new java.awt.Color(255, 255, 255));
        jAcademico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAcademicoMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel7.setText("Académico");

        jPanel12.setBackground(new java.awt.Color(102, 255, 204));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jAcademicoLayout = new javax.swing.GroupLayout(jAcademico);
        jAcademico.setLayout(jAcademicoLayout);
        jAcademicoLayout.setHorizontalGroup(
            jAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAcademicoLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        jAcademicoLayout.setVerticalGroup(
            jAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jAcademicoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jFinanzas.setBackground(new java.awt.Color(255, 255, 255));
        jFinanzas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFinanzasMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel9.setText("Finanzas");

        jPanel13.setBackground(new java.awt.Color(204, 102, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFinanzasLayout = new javax.swing.GroupLayout(jFinanzas);
        jFinanzas.setLayout(jFinanzasLayout);
        jFinanzasLayout.setHorizontalGroup(
            jFinanzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFinanzasLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblFinazas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFinanzasLayout.setVerticalGroup(
            jFinanzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFinanzasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jFinanzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFinazas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFinanzasLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jVarioss.setBackground(new java.awt.Color(255, 255, 255));
        jVarioss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jVariossMouseClicked(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel10.setText("varios");

        javax.swing.GroupLayout jVariossLayout = new javax.swing.GroupLayout(jVarioss);
        jVarioss.setLayout(jVariossLayout);
        jVariossLayout.setHorizontalGroup(
            jVariossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jVariossLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblVarios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jVariossLayout.setVerticalGroup(
            jVariossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jVariossLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jVariossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jSalud.setBackground(new java.awt.Color(255, 255, 255));
        jSalud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSaludMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel13.setText("Salud");

        jPanel15.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jSaludLayout = new javax.swing.GroupLayout(jSalud);
        jSalud.setLayout(jSaludLayout);
        jSaludLayout.setHorizontalGroup(
            jSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSaludLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jSaludLayout.setVerticalGroup(
            jSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSaludLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jSaludLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        lblImgLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImgLogoMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gotham Black", 0, 24)); // NOI18N
        jLabel1.setText("NOTION");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jAcademico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jFinanzas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSalud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jVarioss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(jPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jVarioss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 255, 204));

        jLabel2.setFont(new java.awt.Font("Gotham Black", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOTAS ACADEMICAS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel4.setText("Nombre Nota: ");

        jLabel6.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel6.setText("Fecha de creacion:");

        jPanel4.setBackground(new java.awt.Color(102, 255, 204));

        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Lista De Notas");

        jLabel11.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel11.setText("Escribe tu nota:");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jPGuardar.setBackground(new java.awt.Color(255, 255, 255));
        jPGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPGuardarMouseExited(evt);
            }
        });

        lblGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPGuardarLayout = new javax.swing.GroupLayout(jPGuardar);
        jPGuardar.setLayout(jPGuardarLayout);
        jPGuardarLayout.setHorizontalGroup(
            jPGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        jPGuardarLayout.setVerticalGroup(
            jPGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPActualizar.setBackground(new java.awt.Color(255, 255, 255));
        jPActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPActualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPActualizarMouseExited(evt);
            }
        });

        lblActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPActualizarLayout = new javax.swing.GroupLayout(jPActualizar);
        jPActualizar.setLayout(jPActualizarLayout);
        jPActualizarLayout.setHorizontalGroup(
            jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        jPActualizarLayout.setVerticalGroup(
            jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jPEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPEliminarMouseExited(evt);
            }
        });

        lblEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPEliminarLayout = new javax.swing.GroupLayout(jPEliminar);
        jPEliminar.setLayout(jPEliminarLayout);
        jPEliminarLayout.setHorizontalGroup(
            jPEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        jPEliminarLayout.setVerticalGroup(
            jPEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPExportPdf.setBackground(new java.awt.Color(204, 255, 255));
        jPExportPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPExportPdfMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("EXPORTAR PDF");

        javax.swing.GroupLayout jPExportPdfLayout = new javax.swing.GroupLayout(jPExportPdf);
        jPExportPdf.setLayout(jPExportPdfLayout);
        jPExportPdfLayout.setHorizontalGroup(
            jPExportPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPExportPdfLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPExportPdfLayout.setVerticalGroup(
            jPExportPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPExportPdfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel14.setText("Objetivos de Aprendizaje:");

        jLabel18.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Incompleto ");

        jLabel19.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Significativo");

        txtLike.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLikeKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel15.setText("BUSCAR:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNombreNota, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(34, 34, 34)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDescripcion))
                                    .addComponent(jPExportPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtObjetivosAprendizaje, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabelsig, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelIncompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jPGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLike, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLike, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreNota, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObjetivosAprendizaje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIncompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelsig, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jPExportPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPersonalMouseClicked
        FrmPersonal frmPersonal = new FrmPersonal();
        frmPersonal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPersonalMouseClicked

    private void jPersonalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPersonalMouseEntered
        //        jPersonal.setBackground(Color.decode("#05F283"));
    }//GEN-LAST:event_jPersonalMouseEntered

    private void jTrabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTrabajoMouseClicked
        FrmTrabajo frmTrabajo = new FrmTrabajo();
        frmTrabajo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTrabajoMouseClicked

    private void jAcademicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAcademicoMouseClicked
        FrmAcademico frmAcademico = new FrmAcademico();
        frmAcademico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jAcademicoMouseClicked

    private void jFinanzasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFinanzasMouseClicked
        FrmFinanzas frmFinanzas = new FrmFinanzas();
        frmFinanzas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jFinanzasMouseClicked

    private void jVariossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVariossMouseClicked

        FrmVarios frmVarios = new FrmVarios();
        frmVarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jVariossMouseClicked

    private void jSaludMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSaludMouseClicked
        FrmsSalud frmsSalud = new FrmsSalud();
        frmsSalud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jSaludMouseClicked

    private void lblImgLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImgLogoMouseClicked
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblImgLogoMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void jPGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPGuardarMouseClicked
//       

        NotaAcademica notaAcademica = new NotaAcademica(txtObjetivosAprendizaje.getText(), txtNombreNota.getText(), jDateChooser1.getDate(), txtDescripcion.getText());

        if (dAOSNotaAcademica.agregar(notaAcademica)) {

            System.out.println("entro al dao agregar ");
            listar();
            limpiar();
            JOptionPane.showMessageDialog(jPanel1, " Guardado!!! ", "Exito", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(jPanel1, "Oops!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jPGuardarMouseClicked

    private void jPGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPGuardarMouseEntered
        jPGuardar.setBackground(Color.decode("#BDE038"));
        iconeGuardar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_jPGuardarMouseEntered

    private void jPGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPGuardarMouseExited
        jPGuardar.setBackground(Color.decode("#ffffff"));
        iconeGuardar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_jPGuardarMouseExited

    private void jPActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPActualizarMouseClicked
//        // BOTON DE ACTUALIZAR

        DefaultListModel<NotaAcademica> listModel = (DefaultListModel<NotaAcademica>) jList2.getModel();
//        indice seleccionado(posicion)

        int indiceSeleccionado = jList2.getSelectedIndex();

        if (indiceSeleccionado != -1) {

            NotaAcademica Selecionado = listModel.getElementAt(indiceSeleccionado);
            NotaAcademica actualizado = new NotaAcademica(txtObjetivosAprendizaje.getText(), Selecionado.getIdNota(), txtNombreNota.getText(), jDateChooser1.getDate(), txtDescripcion.getText());
            if (dAOSNotaAcademica.actualizar(actualizado)) {

                listar();
                limpiar();

                JOptionPane.showMessageDialog(jPanel1, "Actulizado!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Oops!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        }


    }//GEN-LAST:event_jPActualizarMouseClicked

    private void jPActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPActualizarMouseEntered
        jPActualizar.setBackground(Color.decode("#00CCC0"));
        iconeActualizar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_jPActualizarMouseEntered

    private void jPActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPActualizarMouseExited
        jPActualizar.setBackground(Color.decode("#ffffff"));
        iconeActualizar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_jPActualizarMouseExited

    private void jPEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPEliminarMouseClicked
        // BOTON ELIMINAR

        DefaultListModel<NotaAcademica> listModel = (DefaultListModel<NotaAcademica>) jList2.getModel();
        //        indice seleccionado(posicion)

        int indiceSeleccionado = jList2.getSelectedIndex();

        if (indiceSeleccionado != -1) {

            NotaAcademica Selecionado = listModel.getElementAt(indiceSeleccionado);
            if (dAOSNotaAcademica.eliminar(Selecionado)) {

                listar();
                limpiar();

                JOptionPane.showMessageDialog(jPanel1, "Eliminado!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Oops!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_jPEliminarMouseClicked

    private void jPEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPEliminarMouseEntered
        jPEliminar.setBackground(Color.red);
        iconeEliminar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_jPEliminarMouseEntered

    private void jPEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPEliminarMouseExited
        jPEliminar.setBackground(Color.decode("#ffffff"));
        iconeEliminar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_jPEliminarMouseExited

    private void jPExportPdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPExportPdfMouseClicked
        Document documento = new Document();

        try {
//            String ruta = System.getProperty("user.home");
//
//            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/USUARIO/Downloads/Reporte_prueba.pdf"));//ruta, la cual se guardara el pdf
//            documento.open();

            String ruta = "D:\\USUARIO\\Documents\\NetBeansProjects\\materiaPOO_ProyectoFinal\\PDF"; // Ruta base
            String nombreArchivo = "Reporte_NotasAcademicas.pdf"; // Nombre del archivo

// Ruta completa del archivo
            String rutaCompleta = ruta + "\\" + nombreArchivo;

// Resto de tu código...
            PdfWriter.getInstance(documento, new FileOutputStream(rutaCompleta));
            documento.open();

            PdfPTable tabla = new PdfPTable(5);
            //titulos de las tablass
            tabla.addCell("ID");
            tabla.addCell("titulo");
            tabla.addCell("fecha");
            tabla.addCell("descripcion");
            tabla.addCell("Objetivo Academico");

            try {
                //ruta para la bd
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "user_Java1", "1287");
                PreparedStatement pst = cn.prepareStatement("select * from notasacademicas");
                //url user clave

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());

                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Podras encontrar el reporte creado en la carpeta donde tienes el proyecto, ve a buscarlo :)");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

            System.out.println("No se pudo. Se produjo la siguiente excepción:");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jPExportPdfMouseClicked

    private void txtLikeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLikeKeyTyped
        listarLike("%" + txtLike.getText() + "%");
    }//GEN-LAST:event_txtLikeKeyTyped

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged

        DefaultListModel<NotaAcademica> listModel = (DefaultListModel<NotaAcademica>) jList2.getModel();
        // Obtén el índice del elemento seleccionado en la lista
        int indiceSeleccionado = jList2.getSelectedIndex();

        // Verifica si se ha seleccionado un elemento (el índice no es -1)
        if (indiceSeleccionado != -1) {
            // Obtén el objeto Usuario seleccionado
            NotaAcademica Selecionado = listModel.getElementAt(indiceSeleccionado);
            txtNombreNota.setText(Selecionado.getTituloNota());
            txtDescripcion.setText(Selecionado.getDescripcion());
            txtObjetivosAprendizaje.setText(Selecionado.getObjetivosAprendizaje());
            jDateChooser1.setDate(Selecionado.getFechaCreacion());

        }
    }//GEN-LAST:event_jList2ValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAcademico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jAcademico;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jFinanzas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelIncompleto;
    private javax.swing.JLabel jLabelsig;
    private javax.swing.JList<NotaAcademica> jList2;
    private javax.swing.JPanel jPActualizar;
    private javax.swing.JPanel jPEliminar;
    private javax.swing.JPanel jPExportPdf;
    private javax.swing.JPanel jPGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPersonal;
    private javax.swing.JPanel jSalud;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jTrabajo;
    private javax.swing.JPanel jVarioss;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblEstudio;
    private javax.swing.JLabel lblFinazas;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblImgLogo;
    private javax.swing.JLabel lblPersonal;
    private javax.swing.JLabel lblSalud;
    private javax.swing.JLabel lblTrabajo;
    private javax.swing.JLabel lblVarios;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtLike;
    private javax.swing.JTextField txtNombreNota;
    private javax.swing.JTextField txtObjetivosAprendizaje;
    // End of variables declaration//GEN-END:variables

    private void listar() {

        DefaultListModel<NotaAcademica> listModel = new DefaultListModel<>();
        List<NotaAcademica> NotaAcademicas = dAOSNotaAcademica.cosultar();

        for (NotaAcademica NotaAcademica : NotaAcademicas) {
            listModel.addElement(NotaAcademica);

        }
        jList2.setModel(listModel);
    }

    private void limpiar() {

        txtNombreNota.setText("");
        txtObjetivosAprendizaje.setText("");
        txtDescripcion.setText("");
        jDateChooser1.setDate(null);
    }

    private void listarLike(String string) {

        DefaultListModel<NotaAcademica> listModel = new DefaultListModel<>();
        List<NotaAcademica> NotaAcademicas = dAOSNotaAcademica.findOneLike(string);

        for (NotaAcademica NotaAcademica : NotaAcademicas) {
            listModel.addElement(NotaAcademica);

        }
        jList2.setModel(listModel);
    }
}
