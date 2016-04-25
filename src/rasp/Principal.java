/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rasp;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.JThermometer;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author vbarrera
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    JFreeChart Grafica;
    JFreeChart Grafica1;
    JThermometer termometro = new JThermometer();
    JThermometer termometro1 = new JThermometer();
    DialPlot dialPlot = new DialPlot();
    DialPlot dialPlot1 = new DialPlot();
    DefaultValueDataset Datos = new DefaultValueDataset();
    DefaultValueDataset Datos1 = new DefaultValueDataset();
    ThermometerPlot plot = new ThermometerPlot(Datos);
    ThermometerPlot plot1 = new ThermometerPlot(Datos1);
    PrintWriter out;
    
    BufferedReader in;
    ServerSocket server;
    Socket socket;
    int n1 = 0;
    int n2 = 0;

    /////////
    final XYSeries Seriept1 = new XYSeries("V Proceso");
    final XYSeries Seriept2 = new XYSeries("Promedio");
    final XYSeries Seriept3 = new XYSeries("Set Point");
    final XYSeriesCollection Colecciont = new XYSeriesCollection();
    /////////////////
    final XYSeries Seriepn1 = new XYSeries("V Proceso");
    final XYSeries Seriepn2 = new XYSeries("Promedio");
    final XYSeries Seriepn3 = new XYSeries("Set Point");
    final XYSeriesCollection Coleccionn = new XYSeriesCollection();

    // final XYSeriesCollection Coleccionp2 = new XYSeriesCollection();
    JFreeChart Graficap1;
    JFreeChart Graficap2;
    // Graficas g;

    public Principal() {
        initComponents();
        // g=new Graficas(panelG1);
        setLocationRelativeTo(this);
        setVisible(true);
        setResizable(false);
        Grafica = new JFreeChart("Temp", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
        plot.setUnits(ThermometerPlot.UNITS_CELCIUS);
        plot.setThermometerStroke(new BasicStroke(2.0F));
        ChartPanel chartPanel = new ChartPanel(Grafica);
        panelGrafica.setLayout(new BorderLayout());
        panelGrafica.add(chartPanel);
        setTitle(".:Proyecto de grado:.");
        Grafica1 = new JFreeChart("Temp", JFreeChart.DEFAULT_TITLE_FONT, plot1, false);
        plot1.setUnits(ThermometerPlot.UNITS_CELCIUS);
        plot1.setThermometerStroke(new BasicStroke(2.0F));
        ChartPanel chartPanel1 = new ChartPanel(Grafica1);
        panelGrafica2.setLayout(new BorderLayout());
        panelGrafica2.add(chartPanel1);
        monitor();
        Graficap1 = ChartFactory.createXYLineChart("Temperatura Vs. Tiempo \n",
                "Tiempo", "Temperatura", Colecciont,
                PlotOrientation.VERTICAL, true, true, false);

        panelG1.setLayout(
                new BorderLayout());
        ChartPanel Panelt = new ChartPanel(Graficap1);
        panelG1.add(Panelt);
        /////////////////
        Graficap2 = ChartFactory.createXYLineChart("Temperatura Vs. Tiempo \n",
                "Tiempo", "Temperatura", Coleccionn,
                PlotOrientation.VERTICAL, true, true, false);

        panelG2.setLayout(
                new BorderLayout());
        ChartPanel Paneln = new ChartPanel(Graficap2);
        panelG2.add(Paneln);
    }

    public void mostrar() {
        JOptionPane.showMessageDialog(null, "Inicio Mostrar");
        new Thread(new Runnable() {

            @Override
            public void run() {

                final GpioController gpio = GpioFactory.getInstance();
                final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02,
                        PinPullResistance.PULL_DOWN);

                while (true) {
                    try {
                        Thread.sleep(500);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });//.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tem1 = new javax.swing.JPanel();
        panelGrafica = new javax.swing.JPanel();
        tempBaja1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        monitor1 = new javax.swing.JButton();
        tempAlta1 = new javax.swing.JTextField();
        setPoint1 = new javax.swing.JTextField();
        panelG1 = new javax.swing.JPanel();
        tem3 = new javax.swing.JPanel();
        panelGrafica2 = new javax.swing.JPanel();
        tempBaja2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        monitor2 = new javax.swing.JButton();
        tempAlta2 = new javax.swing.JTextField();
        setPoint2 = new javax.swing.JTextField();
        panelG2 = new javax.swing.JPanel();
        botonConectar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        alertaTemBaja = new javax.swing.JLabel();
        alertaTemAlta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGrafica.setPreferredSize(new java.awt.Dimension(400, 296));

        javax.swing.GroupLayout panelGraficaLayout = new javax.swing.GroupLayout(panelGrafica);
        panelGrafica.setLayout(panelGraficaLayout);
        panelGraficaLayout.setHorizontalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelGraficaLayout.setVerticalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        tempBaja1.setText("10");

        jLabel5.setText("Temp. Alta");

        jLabel6.setText("Set Point");

        jLabel7.setText("Temp. Baja");

        monitor1.setText("Actualizar");
        monitor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitor1ActionPerformed(evt);
            }
        });

        tempAlta1.setText("80");

        setPoint1.setText("50");

        javax.swing.GroupLayout panelG1Layout = new javax.swing.GroupLayout(panelG1);
        panelG1.setLayout(panelG1Layout);
        panelG1Layout.setHorizontalGroup(
            panelG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelG1Layout.setVerticalGroup(
            panelG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tem1Layout = new javax.swing.GroupLayout(tem1);
        tem1.setLayout(tem1Layout);
        tem1Layout.setHorizontalGroup(
            tem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tem1Layout.createSequentialGroup()
                .addComponent(panelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(tempAlta1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(setPoint1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tempBaja1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(monitor1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(tem1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelG1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tem1Layout.setVerticalGroup(
            tem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tem1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelG1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tem1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tempAlta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(setPoint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(tempBaja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monitor1)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tem1Layout.createSequentialGroup()
                        .addComponent(panelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        jTabbedPane1.addTab("Temperatura 1", tem1);

        panelGrafica2.setPreferredSize(new java.awt.Dimension(400, 296));

        javax.swing.GroupLayout panelGrafica2Layout = new javax.swing.GroupLayout(panelGrafica2);
        panelGrafica2.setLayout(panelGrafica2Layout);
        panelGrafica2Layout.setHorizontalGroup(
            panelGrafica2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelGrafica2Layout.setVerticalGroup(
            panelGrafica2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        tempBaja2.setText("10");

        jLabel11.setText("Temp. Alta");

        jLabel12.setText("Set Point");

        jLabel13.setText("Temp. Baja");

        monitor2.setText("Actualizar");
        monitor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitor2ActionPerformed(evt);
            }
        });

        tempAlta2.setText("80");

        setPoint2.setText("50");

        javax.swing.GroupLayout panelG2Layout = new javax.swing.GroupLayout(panelG2);
        panelG2.setLayout(panelG2Layout);
        panelG2Layout.setHorizontalGroup(
            panelG2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelG2Layout.setVerticalGroup(
            panelG2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tem3Layout = new javax.swing.GroupLayout(tem3);
        tem3.setLayout(tem3Layout);
        tem3Layout.setHorizontalGroup(
            tem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tem3Layout.createSequentialGroup()
                .addComponent(panelGrafica2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addComponent(tempAlta2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(setPoint2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tempBaja2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(monitor2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(tem3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelG2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tem3Layout.setVerticalGroup(
            tem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tem3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelG2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tem3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tempAlta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addComponent(setPoint2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6)
                        .addComponent(tempBaja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monitor2)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tem3Layout.createSequentialGroup()
                        .addComponent(panelGrafica2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        jTabbedPane1.addTab("Temperatura 2", tem3);

        botonConectar.setText("Conectar");
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });

        jLabel1.setText("Alertas:");

        alertaTemBaja.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        alertaTemBaja.setOpaque(true);

        alertaTemAlta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        alertaTemAlta.setOpaque(true);

        jLabel2.setText("Temp Baja");

        jLabel3.setText("Temp Alta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(botonConectar)
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(alertaTemBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alertaTemAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(208, 208, 208))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(alertaTemBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alertaTemAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarActionPerformed
        plot.setSubrangeInfo(ThermometerPlot.NORMAL, Double.parseDouble(tempBaja1.getText().toString()), Double.parseDouble(setPoint1.getText().toString()), 0.0, 150.0);
        plot.setSubrangePaint(0, new GradientPaint(1.0f, 2.0f, Color.BLUE, 3.0f, 4.0f, Color.BLUE));
        plot.setSubrangeInfo(ThermometerPlot.WARNING, Double.parseDouble(setPoint1.getText().toString()), Double.parseDouble(tempAlta1.getText().toString()), 0.0, 150.0);
        plot.setSubrangePaint(1, new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.green));
        plot.setSubrangeInfo(ThermometerPlot.CRITICAL, Double.parseDouble(tempAlta1.getText().toString()), 150.0, 0.0, 150.0);
        plot.setSubrangePaint(2, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.red));
        plot.setThermometerStroke(new BasicStroke(2.0f));
        plot.setThermometerPaint(Color.BLACK);
        /////////////
        plot1.setSubrangeInfo(ThermometerPlot.NORMAL, Double.parseDouble(tempBaja2.getText().toString()), Double.parseDouble(setPoint2.getText().toString()), 0.0, 150.0);
        plot1.setSubrangePaint(0, new GradientPaint(1.0f, 2.0f, Color.BLUE, 3.0f, 4.0f, Color.BLUE));
        plot1.setSubrangeInfo(ThermometerPlot.WARNING, Double.parseDouble(setPoint2.getText().toString()), Double.parseDouble(tempAlta2.getText().toString()), 0.0, 150.0);
        plot1.setSubrangePaint(1, new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.green));
        plot1.setSubrangeInfo(ThermometerPlot.CRITICAL, Double.parseDouble(tempAlta2.getText().toString()), 150.0, 0.0, 150.0);
        plot1.setSubrangePaint(2, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.red));
        plot1.setThermometerStroke(new BasicStroke(2.0f));
        plot1.setThermometerPaint(Color.BLACK);
        ///////////////////////
        Seriept1.add(
                0, 0);
        Seriept2.add(
                0, 0);
        Seriept3.add(
                0, 0);
        Colecciont.addSeries(Seriept1);
        Colecciont.addSeries(Seriept2);
        Colecciont.addSeries(Seriept3);
        ///////////////////////////////////////////////////////
         Seriepn1.add(
                0, 0);
        Seriepn2.add(
                0, 0);
        Seriepn3.add(
                0, 0);
        Coleccionn.addSeries(Seriepn1);
        Coleccionn.addSeries(Seriepn2);
        Coleccionn.addSeries(Seriepn3);
        // Coleccionp2.addSeries(Seriep2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Conectado");
                    server = new ServerSocket(2000);
                    while (true) {
                        try {
                            // Thread.sleep(50);
                            socket = server.accept();
                            // textRecibido.append("Conectado... " + socket.getInetAddress().getHostName() + " " + socket.getPort() + "\n");
                            System.out.println("Paso 1");
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        String dato;
                                        int e = 0;
                                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                        System.out.println("Paso 2");
                                        while ((dato = in.readLine()) != null) {
                                            if (dato.length() > 0) {
                                                //dato.substring(0, 4);
                                                //Thread.sleep(300);
                                                n1 = Integer.parseInt(dato.substring(2, 5).trim());
                                                n2 = Integer.parseInt(dato.substring(6, 10).trim());
                                                e += 1;
                                                Seriept3.add(e, Integer.parseInt(setPoint1.getText().toString()));
                                                Seriept2.add(e, (Integer.parseInt(setPoint1.getText().toString()) + n1) / 2);
                                                Seriept1.add(e, n1);
                                                Seriepn3.add(e, Integer.parseInt(setPoint2.getText().toString()));
                                                Seriepn2.add(e, (Integer.parseInt(setPoint2.getText().toString()) + n2) / 2);
                                                Seriepn1.add(e, n2);
                                                termometro.setValue(Integer.parseInt(String.format("%1$03d", n1)));
                                                Datos.setValue(Integer.parseInt(String.format("%1$03d", n1)));
                                                termometro1.setValue(Integer.parseInt(String.format("%1$03d", n2)));
                                                Datos1.setValue(Integer.parseInt(String.format("%1$03d", n2)));
                                                //  textRecibido.append("Da1 " + String.format("%1$03d", n1) + "\n" + "Da2" + String.format("%1$03d", n2) + "\n");

                                            }
                                        }
                                    } catch (IOException ex) {
                                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }).start();
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }//GEN-LAST:event_botonConectarActionPerformed

    private void monitor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitor2ActionPerformed
       plot1.setSubrangeInfo(ThermometerPlot.NORMAL, Double.parseDouble(tempBaja2.getText().toString()), Double.parseDouble(setPoint2.getText().toString()), 0.0, 150.0);
        plot1.setSubrangePaint(0, new GradientPaint(1.0f, 2.0f, Color.BLUE, 3.0f, 4.0f, Color.BLUE));
        plot1.setSubrangeInfo(ThermometerPlot.WARNING, Double.parseDouble(setPoint2.getText().toString()), Double.parseDouble(tempAlta2.getText().toString()), 0.0, 150.0);
        plot1.setSubrangePaint(1, new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.green));
        plot1.setSubrangeInfo(ThermometerPlot.CRITICAL, Double.parseDouble(tempAlta2.getText().toString()), 150.0, 0.0, 150.0);
        plot1.setSubrangePaint(2, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.red));
        plot1.setThermometerStroke(new BasicStroke(2.0f));
        plot1.setThermometerPaint(Color.BLACK);
    }//GEN-LAST:event_monitor2ActionPerformed

    private void monitor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitor1ActionPerformed
        plot.setSubrangeInfo(ThermometerPlot.NORMAL, Double.parseDouble(tempBaja1.getText().toString()), Double.parseDouble(setPoint1.getText().toString()), 0.0, 150.0);
        plot.setSubrangePaint(0, new GradientPaint(1.0f, 2.0f, Color.BLUE, 3.0f, 4.0f, Color.BLUE));
        plot.setSubrangeInfo(ThermometerPlot.WARNING, Double.parseDouble(setPoint1.getText().toString()), Double.parseDouble(tempAlta1.getText().toString()), 0.0, 150.0);
        plot.setSubrangePaint(1, new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.green));
        plot.setSubrangeInfo(ThermometerPlot.CRITICAL, Double.parseDouble(tempAlta1.getText().toString()), 150.0, 0.0, 150.0);
        plot.setSubrangePaint(2, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.red));
        plot.setThermometerStroke(new BasicStroke(2.0f));
        plot.setThermometerPaint(Color.BLACK);
    }//GEN-LAST:event_monitor1ActionPerformed
    public void monitor() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {

                    if (n1 <= Integer.parseInt(tempBaja1.getText().toString())) {
                        try {
                            //  JOptionPane.showMessageDialog(null, "Temperatura 1 Baja Activada");
                            // tem1.setBackground(Color.BLUE);
                            alertaTemBaja.setBackground(Color.BLUE);
                            alertaTemBaja.setText("Temperatura 1");
                            Thread.sleep(1000);
                            //tem1.setBackground(Color.WHITE);
                            alertaTemBaja.setBackground(Color.WHITE);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if (n2 <= Integer.parseInt(tempBaja2.getText().toString())) {
                        try {
                            // JOptionPane.showMessageDialog(null, "Temperatura 2 Baja Activada");
                            // tem2.setBackground(Color.BLUE);
                            alertaTemBaja.setBackground(Color.BLUE);
                            alertaTemBaja.setText("Temperatura 2");
                            Thread.sleep(1000);
                            // tem2.setBackground(Color.WHITE);
                            alertaTemBaja.setBackground(Color.WHITE);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (n1 >= Integer.parseInt(tempAlta1.getText().toString())) {
                        try {
                            // JOptionPane.showMessageDialog(null, "Temperatura 2 Baja Activada");
                            // tem1.setBackground(Color.RED);
                            alertaTemAlta.setBackground(Color.RED);
                            alertaTemAlta.setText("Temperatura 1");
                            Thread.sleep(1000);
                            // tem1.setBackground(Color.WHITE);
                            alertaTemAlta.setBackground(Color.WHITE);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (n2 >= Integer.parseInt(tempAlta2.getText().toString())) {
                        try {
                            // JOptionPane.showMessageDialog(null, "Temperatura 2 Baja Activada");
                            // tem2.setBackground(Color.RED);
                            alertaTemAlta.setBackground(Color.RED);
                            alertaTemAlta.setText("Temperatura 2");
                            Thread.sleep(1000);
                            // tem2.setBackground(Color.WHITE);
                            alertaTemAlta.setBackground(Color.WHITE);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }).start();

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Principal p = new Principal();

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertaTemAlta;
    private javax.swing.JLabel alertaTemBaja;
    private javax.swing.JButton botonConectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton monitor1;
    private javax.swing.JButton monitor2;
    private javax.swing.JPanel panelG1;
    private javax.swing.JPanel panelG2;
    private javax.swing.JPanel panelGrafica;
    private javax.swing.JPanel panelGrafica2;
    private javax.swing.JTextField setPoint1;
    private javax.swing.JTextField setPoint2;
    private javax.swing.JPanel tem1;
    private javax.swing.JPanel tem3;
    private javax.swing.JTextField tempAlta1;
    private javax.swing.JTextField tempAlta2;
    private javax.swing.JTextField tempBaja1;
    private javax.swing.JTextField tempBaja2;
    // End of variables declaration//GEN-END:variables
}
