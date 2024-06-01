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
import com.mycompany.materiapoo_proyectofinal.DAOS.DAOSNotaFinanza;
import java.awt.Color;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignB;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.materialdesign2.MaterialDesignD;
import org.kordamp.ikonli.swing.FontIcon;
import com.mycompany.materiapoo_proyectofinal.DAOS.DAOSNotaPersonal;
import com.mycompany.materiapoo_proyectofinal.DAOS.DAOSNotaSalud;
import com.mycompany.materiapoo_proyectofinal.DAOS.DAOSNotaTrabajo;
import com.mycompany.materiapoo_proyectofinal.DAOS.DAOSNotaVarios;
import com.mycompany.materiapoo_proyectofinal.DAOS.DAOSPrincipal;
import com.mycompany.materiapoo_proyectofinal.DAOS.DAOSRegistro;
import com.mycompany.materiapoo_proyectofinal.clases.NotaAcademica;
import com.mycompany.materiapoo_proyectofinal.clases.NotaFinanza;
import com.mycompany.materiapoo_proyectofinal.clases.NotaPersonal;
import com.mycompany.materiapoo_proyectofinal.clases.NotaSalud;
import com.mycompany.materiapoo_proyectofinal.clases.NotaTrabajo;
import com.mycompany.materiapoo_proyectofinal.clases.NotaVarios;
import com.mycompany.materiapoo_proyectofinal.clases.Persona;
import com.mycompany.materiapoo_proyectofinal.clases.Principal;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignM;

/**
 *
 * @author USUARIO
 */
public class FrmPrincipal extends javax.swing.JFrame {

    FontIcon iconePersonal = new FontIcon();
    FontIcon iconeTrabajo = new FontIcon();
    FontIcon iconeEstudio = new FontIcon();
    FontIcon iconeFinanzas = new FontIcon();
    FontIcon iconeVarios = new FontIcon();
    FontIcon iconeSalud = new FontIcon();

    FontIcon iconeSincronizar = new FontIcon();

    FontIcon iconeGuardar = new FontIcon();
//    FontIcon iconeActualizar = new FontIcon();
//    FontIcon iconeEliminar = new FontIcon();
    
    DAOSPrincipal daos = new DAOSPrincipal();

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        cargarBoxPersonal();
        cargarBoxPersonas();
        cargarBoxTrabajo();
        cargarBoxAcademico();
        cargarBoxSalud();
        cargarBoxFinanzas();
        cargarBoxVarios();

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
        this.lblListaDeCompras.setIcon(iconeVarios);

        iconeSalud.setIkon(MaterialDesignA.ACCOUNT_HEART_OUTLINE);
        iconeSalud.setIconSize(30);
        iconeSalud.setIconColor(Color.decode("#000000"));
        this.lblSalud.setIcon(iconeSalud);

        //icono Guardar 
        iconeGuardar.setIkon(MaterialDesignC.CONTENT_SAVE);
        iconeGuardar.setIconSize(30);
        iconeGuardar.setIconColor(Color.decode("#000000"));
        this.lblGuardar.setIcon(iconeGuardar);
//
//        //icono Actualizar
//        iconeActualizar.setIkon(MaterialDesignU.UBISOFT);
//        iconeActualizar.setIconSize(30);
//        iconeActualizar.setIconColor(Color.decode("#000000"));
//        this.lblActualizar.setIcon(iconeActualizar);

//        //icono Actualizar
//        iconeEliminar.setIkon(MaterialDesignD.DELETE);
//        iconeEliminar.setIconSize(30);
//        iconeEliminar.setIconColor(Color.decode("#000000"));
//        this.lblEliminar.setIcon(iconeEliminar);

        iconeSincronizar.setIkon(MaterialDesignM.MONITOR_CELLPHONE);
        iconeSincronizar.setIconSize(30);
        iconeSincronizar.setIconColor(Color.decode("#000000"));
        this.lblSincronizar.setIcon(iconeSincronizar);
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
        jSalud = new javax.swing.JPanel();
        lblListaDeCompras = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jVarios = new javax.swing.JPanel();
        lblSalud = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lblImgLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboSalud = new javax.swing.JComboBox<>();
        jComboPersonal = new javax.swing.JComboBox<>();
        jComboFinanzas = new javax.swing.JComboBox<>();
        jComboVarios = new javax.swing.JComboBox<>();
        jComboPersona = new javax.swing.JComboBox<>();
        jComboAcademico = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPExportPdf = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPGuardar = new javax.swing.JPanel();
        lblGuardar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblSincronizar = new javax.swing.JLabel();
        jComboPersonal1 = new javax.swing.JComboBox<>();

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

        jSalud.setBackground(new java.awt.Color(255, 255, 255));

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
        jLabel10.setText("Varios");

        javax.swing.GroupLayout jSaludLayout = new javax.swing.GroupLayout(jSalud);
        jSalud.setLayout(jSaludLayout);
        jSaludLayout.setHorizontalGroup(
            jSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSaludLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblListaDeCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jSaludLayout.setVerticalGroup(
            jSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jSaludLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblListaDeCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jVarios.setBackground(new java.awt.Color(255, 255, 255));
        jVarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jVariosMouseClicked(evt);
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

        javax.swing.GroupLayout jVariosLayout = new javax.swing.GroupLayout(jVarios);
        jVarios.setLayout(jVariosLayout);
        jVariosLayout.setHorizontalGroup(
            jVariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jVariosLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jVariosLayout.setVerticalGroup(
            jVariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jVariosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jVariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jVariosLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Gotham Black", 0, 24)); // NOI18N
        jLabel1.setText("NOTION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jAcademico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jFinanzas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jVarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSalud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(36, 36, 36)
                .addComponent(jPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jVarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Gotham Black", 0, 24)); // NOI18N
        jLabel2.setText("PERSONA:");

        jLabel4.setFont(new java.awt.Font("Gotham Black", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("NOTAS:");

        jLabel6.setFont(new java.awt.Font("Gotham Black", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("BLOCK PRINCIPAL DE NOTAS ");

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPExportPdf.setBackground(new java.awt.Color(204, 255, 255));
        jPExportPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPExportPdfMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Gotham Black", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("EXPORTAR PDF");

        javax.swing.GroupLayout jPExportPdfLayout = new javax.swing.GroupLayout(jPExportPdf);
        jPExportPdf.setLayout(jPExportPdfLayout);
        jPExportPdfLayout.setHorizontalGroup(
            jPExportPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPExportPdfLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPExportPdfLayout.setVerticalGroup(
            jPExportPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPExportPdfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPGuardarLayout = new javax.swing.GroupLayout(jPGuardar);
        jPGuardar.setLayout(jPGuardarLayout);
        jPGuardarLayout.setHorizontalGroup(
            jPGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGuardarLayout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(lblGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPGuardarLayout.setVerticalGroup(
            jPGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGuardarLayout.createSequentialGroup()
                .addComponent(lblGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        lblSincronizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSincronizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblSincronizar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jComboPersonal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboAcademico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboPersonal1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jComboSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboVarios, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPExportPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboSalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboPersonal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboVarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPExportPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void jPersonalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPersonalMouseEntered
//        jPersonal.setBackground(Color.decode("#05F283"));
    }//GEN-LAST:event_jPersonalMouseEntered

    private void jPGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPGuardarMouseClicked
        // GUARDAR INFORMACION
        
        NotaSalud notaSalud = (NotaSalud) jComboSalud.getSelectedItem();
        NotaAcademica notaAcademica = (NotaAcademica) jComboAcademico.getSelectedItem();
        NotaFinanza notaFinanza = (NotaFinanza) jComboFinanzas.getSelectedItem();
        NotaPersonal notaPersonal = (NotaPersonal) jComboPersonal.getSelectedItem();
        NotaTrabajo notaTrabajo = (NotaTrabajo) jComboPersonal1.getSelectedItem();
        NotaVarios notaVarios = (NotaVarios) jComboVarios.getSelectedItem();
        Persona persona = (Persona) jComboPersona.getSelectedItem();
        
        
        Principal principal = new Principal(notaAcademica, notaPersonal, notaTrabajo, notaSalud, notaVarios, notaFinanza, persona);

        if (daos.agregar(principal)) {
            
           
            listar();
//            limpiar();
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

    private void jPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPersonalMouseClicked
        FrmPersonal frmPersonal = new FrmPersonal();
        frmPersonal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPersonalMouseClicked

    private void jPExportPdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPExportPdfMouseClicked
                Document documento = new Document();

        try {
//            String ruta = System.getProperty("user.home");
//
//            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/USUARIO/Downloads/Reporte_prueba.pdf"));//ruta, la cual se guardara el pdf
//            documento.open();

            String ruta = "D:\\USUARIO\\Documents\\NetBeansProjects\\materiaPOO_ProyectoFinal\\PDF"; // Ruta base
            String nombreArchivo = "Reporte_NotasPrincipal.pdf"; // Nombre del archivo

// Ruta completa del archivo
            String rutaCompleta = ruta + "\\" + nombreArchivo;

// Resto de tu código...
            PdfWriter.getInstance(documento, new FileOutputStream(rutaCompleta));
            documento.open();

            PdfPTable tabla = new PdfPTable(7);
            //titulos de las tablass
            tabla.addCell("id nota trabajo");
            tabla.addCell("titulo");
            tabla.addCell("fecha");
            tabla.addCell("descripcion");
            tabla.addCell("recordatorios");
            tabla.addCell("descripcion");
            tabla.addCell("recordatorios");

            try {
                //ruta para la bd
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "user_Java1", "1287");
                PreparedStatement pst = cn.prepareStatement("select * from notas");
                //url user clave

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));

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

    private void jVariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVariosMouseClicked
        FrmsSalud frmsSalud = new FrmsSalud();
        frmsSalud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jVariosMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        FrmSincronizar frmSincronizar = new FrmSincronizar();
        frmSincronizar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGuardarMouseClicked

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jAcademico;
    private javax.swing.JComboBox<NotaAcademica> jComboAcademico;
    private javax.swing.JComboBox<NotaFinanza> jComboFinanzas;
    private javax.swing.JComboBox<Persona> jComboPersona;
    private javax.swing.JComboBox<NotaPersonal> jComboPersonal;
    private javax.swing.JComboBox<NotaTrabajo> jComboPersonal1;
    private javax.swing.JComboBox<NotaSalud> jComboSalud;
    private javax.swing.JComboBox<NotaVarios> jComboVarios;
    private javax.swing.JPanel jFinanzas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<Principal> jList1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jTrabajo;
    private javax.swing.JPanel jVarios;
    private javax.swing.JLabel lblEstudio;
    private javax.swing.JLabel lblFinazas;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblImgLogo;
    private javax.swing.JLabel lblListaDeCompras;
    private javax.swing.JLabel lblPersonal;
    private javax.swing.JLabel lblSalud;
    private javax.swing.JLabel lblSincronizar;
    private javax.swing.JLabel lblTrabajo;
    // End of variables declaration//GEN-END:variables

    private void cargarBoxPersonal() {

        DAOSNotaPersonal dAOSNotaPersonal = new DAOSNotaPersonal();
        List<NotaPersonal> notaPersonals = dAOSNotaPersonal.cosultar();

        for (NotaPersonal notaPersonal : notaPersonals) {

            jComboPersonal.addItem(notaPersonal);

        }

    }

    private void cargarBoxPersonas() {

        DAOSRegistro dAOSRegistro = new DAOSRegistro();
        List<Persona> personas = dAOSRegistro.cosultar();

        for (Persona persona : personas) {

            jComboPersona.addItem(persona);

        }

    }

    private void cargarBoxTrabajo() {

        DAOSNotaTrabajo dAOSNotaTrabajo = new DAOSNotaTrabajo();
        List<NotaTrabajo> notaTrabajos = dAOSNotaTrabajo.cosultar();

        for (NotaTrabajo NotaTrabajo : notaTrabajos) {

            jComboPersonal1.addItem(NotaTrabajo);

        }
    }

    private void cargarBoxAcademico() {

        DAOSNotaAcademica DAOSNotaAcademica = new DAOSNotaAcademica();
        List<NotaAcademica> NotaAcademicas = DAOSNotaAcademica.cosultar();

        for (NotaAcademica NotaAcademica : NotaAcademicas) {

            jComboAcademico.addItem(NotaAcademica);

        }
    }

    private void cargarBoxSalud() {

        DAOSNotaSalud DAOSNotaSalud = new DAOSNotaSalud();
        List<NotaSalud> NotaSaluds = DAOSNotaSalud.cosultar();

        for (NotaSalud NotaSalud : NotaSaluds) {

            jComboSalud.addItem(NotaSalud);

        }
    }

    private void cargarBoxFinanzas() {
        DAOSNotaFinanza DAOSNotaFinanza = new DAOSNotaFinanza();
        List<NotaFinanza> NotaFinanzas = DAOSNotaFinanza.cosultar();

        for (NotaFinanza NotaFinanza : NotaFinanzas) {

            jComboFinanzas.addItem(NotaFinanza);

        }
    }

    private void cargarBoxVarios() {

        DAOSNotaVarios DAOSNotaVarios = new DAOSNotaVarios();
        List<NotaVarios> NotaVarios = DAOSNotaVarios.cosultar();

        for (NotaVarios NotaVario : NotaVarios) {

            jComboVarios.addItem(NotaVario);

        }
    }

    private void listar() {
        
        DefaultListModel<Principal> listModel = new DefaultListModel<>();
        List<Principal> Principales = daos.cosultar();

        for (Principal Principal : Principales) {

            listModel.addElement(Principal);

        }

        jList1.setModel(listModel);
        
        
        
    }

    private void limpiar() {
        
    }
}
