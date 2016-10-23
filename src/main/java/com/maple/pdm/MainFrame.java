package com.maple.pdm;

import com.maple.pdm.core.GlobalParameter;
import com.maple.pdm.log.LogTool;
import com.maple.pdm.utils.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by gjf on 2016/10/22.
 */
public class MainFrame extends JFrame {

    JPanel panelPdmFilePath, panelJavaRootPath, panelPojoPackage, panelMapperPackage, panelMapPath, panelHandleInfo, panelRemovePrefix, panelRun;
    JFileChooser jfc = new JFileChooser();

    //定义组件
    JButton jb1, jb2 = null;
    JRadioButton jrb1, jrb2 = null;
    JPanel jp1, jp2, jp3, jp4 = null;
    JTextField jtf = null;
    JLabel jlb1, jlb2, jlb3 = null;
    JPasswordField jpf = null;
    ButtonGroup bg = null;

    public MainFrame() {
        GlobalParameter globalParameter = GlobalParameter.getInstance();
        globalParameter.initByConfig();
        jfc.setCurrentDirectory(new File(globalParameter.getJavaRootSrc()));
        Font font = new Font("宋体", Font.PLAIN, 20);
        Dimension textFieldDimension = new Dimension(400, 30);
        Dimension labelDimension = new Dimension(200, 30);

        //pdmFile路径
        panelPdmFilePath = new JPanel();
        panelPdmFilePath.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPdmFilePath = new JLabel("pdm文件：", JLabel.RIGHT);
        labelPdmFilePath.setFont(font);
        labelPdmFilePath.setPreferredSize(labelDimension);
        panelPdmFilePath.add(labelPdmFilePath);
        final JTextField textFieldPdmFilePath = new JTextField();
        textFieldPdmFilePath.setPreferredSize(textFieldDimension);
        textFieldPdmFilePath.setText(globalParameter.getPdmPath());
        panelPdmFilePath.add(textFieldPdmFilePath);
        JButton buttonPdmFilePath = new JButton("...");
        panelPdmFilePath.add(buttonPdmFilePath);
        buttonPdmFilePath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfc.setFileSelectionMode(0);// 设定只能选择到文件
                int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
                if (state == 1) {
                    return;
                } else {
                    File f = jfc.getSelectedFile();// f为选择到的目录
                    textFieldPdmFilePath.setText(f.getAbsolutePath().replaceAll("\\\\", "/"));
                }
            }
        });

        //java源文件根目录
        panelJavaRootPath = new JPanel();
        panelJavaRootPath.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelJavaRootPath = new JLabel("java源文件根目录：", JLabel.RIGHT);
        labelJavaRootPath.setFont(font);
        labelJavaRootPath.setPreferredSize(labelDimension);
        panelJavaRootPath.add(labelJavaRootPath);
        final JTextField textFieldJavaRootPath = new JTextField();
        textFieldJavaRootPath.setPreferredSize(textFieldDimension);
        textFieldJavaRootPath.setText(globalParameter.getJavaRootSrc());
        panelJavaRootPath.add(textFieldJavaRootPath);
        JButton buttonJavaRootPath = new JButton("...");
        panelJavaRootPath.add(buttonJavaRootPath);
        buttonJavaRootPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfc.setFileSelectionMode(1);// 设定只能选择到文件夹
                int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
                if (state == 1) {
                    return;
                } else {
                    File f = jfc.getSelectedFile();// f为选择到的目录
                    textFieldJavaRootPath.setText(StringUtil.transformToDirectory(f.toString()));
                }
            }
        });

        //映射文件所在路径
        panelMapPath = new JPanel();
        panelMapPath.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelMapPath = new JLabel("映射文件所在路径：", JLabel.RIGHT);
        labelMapPath.setFont(font);
        labelMapPath.setPreferredSize(labelDimension);
        panelMapPath.add(labelMapPath);
        final JTextField textFieldMapPath = new JTextField();
        textFieldMapPath.setPreferredSize(textFieldDimension);
        textFieldMapPath.setText(globalParameter.getMapPath());
        panelMapPath.add(textFieldMapPath);
        JButton buttonMapPath = new JButton("...");
        panelMapPath.add(buttonMapPath);
        buttonMapPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfc.setFileSelectionMode(1);// 设定只能选择到文件夹
                int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
                if (state == 1) {
                    return;
                } else {
                    File f = jfc.getSelectedFile();// f为选择到的目录
                    textFieldMapPath.setText(StringUtil.transformToDirectory(f.toString()));
                }
            }
        });

        //实体类所在包
        panelPojoPackage = new JPanel();
        panelPojoPackage.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPojoPackage = new JLabel("实体类所在包：", JLabel.RIGHT);
        labelPojoPackage.setFont(font);
        labelPojoPackage.setPreferredSize(labelDimension);
        panelPojoPackage.add(labelPojoPackage);
        final JTextField textFieldPojoPackage = new JTextField();
        textFieldPojoPackage.setPreferredSize(textFieldDimension);
        textFieldPojoPackage.setText(globalParameter.getPojoPackage());
        panelPojoPackage.add(textFieldPojoPackage);

        //接口类所在包
        panelMapperPackage = new JPanel();
        panelMapperPackage.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelMapperPackage = new JLabel("mybatis接口所在包：", JLabel.RIGHT);
        labelMapperPackage.setFont(font);
        labelMapperPackage.setPreferredSize(labelDimension);
        panelMapperPackage.add(labelMapperPackage);
        final JTextField textFieldMapperPackage = new JTextField();
        textFieldMapperPackage.setPreferredSize(textFieldDimension);
        textFieldMapperPackage.setText(globalParameter.getMapperPackage());
        panelMapperPackage.add(textFieldMapperPackage);

        //是否移除前缀
        panelRemovePrefix = new JPanel();
        panelRemovePrefix.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelRemovePrefix = new JLabel("是否移除前缀：", JLabel.RIGHT);
        labelRemovePrefix.setFont(font);
        labelRemovePrefix.setPreferredSize(labelDimension);
        panelRemovePrefix.add(labelRemovePrefix);
        ButtonGroup groupRemovePrefix = new ButtonGroup();
        boolean propertyRemovePrefix = globalParameter.isRemovePrefix();
        final JRadioButton removePrefix = new JRadioButton("是", propertyRemovePrefix);
        JRadioButton notRemovePrefix = new JRadioButton("否", !propertyRemovePrefix);
        groupRemovePrefix.add(removePrefix);
        groupRemovePrefix.add(notRemovePrefix);
        panelRemovePrefix.add(removePrefix);
        panelRemovePrefix.add(notRemovePrefix);
        final JButton buttonRun = new JButton("开始");
        panelRemovePrefix.add(buttonRun);

        //处理信息
        panelHandleInfo = new JPanel();
        final JTextArea area = new JTextArea(8, 45);
        area.setEditable(false );
        area.setFont(new Font(null, Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(area);
        area.setLineWrap(true);
        panelHandleInfo.add(scrollPane);

        //Add the listener to initial parameters.
        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonRun.setEnabled(false);

                //Set global parameters.
                GlobalParameter globalParameter = GlobalParameter.getInstance();
                boolean needRemovePrefix = removePrefix.isSelected();
                String pdmFile = textFieldPdmFilePath.getText();
                String javaRootPath = textFieldJavaRootPath.getText();
                String mapPath = textFieldMapPath.getText();
                String pojoPackage = textFieldPojoPackage.getText();
                String mapperPackage = textFieldMapperPackage.getText();

                globalParameter.init(needRemovePrefix, pdmFile, javaRootPath, pojoPackage, mapperPackage, mapPath);

                LogTool.setLogPanel(area);
                LogTool.writeToPanelLine("Begin");

                PDMTool tool = new PDMTool();
                tool.runTools();

                LogTool.writeToPanelLine("Complete!!!");
                buttonRun.setEnabled(true);
            }
        });

        //Add all panel.
        panelPdmFilePath.setBounds(0, 0, 700, 50);
        panelJavaRootPath.setBounds(0, 50, 700, 50);
        panelMapPath.setBounds(0, 100, 700, 50);
        panelPojoPackage.setBounds(0, 150, 700, 50);
        panelMapperPackage.setBounds(0, 200, 700, 50);
        panelRemovePrefix.setBounds(0, 250, 700, 50);
        panelHandleInfo.setBounds(0, 300, 700, 200);

        this.add(panelPdmFilePath);
        this.add(panelJavaRootPath);
        this.add(panelMapPath);
        this.add(panelPojoPackage);
        this.add(panelMapperPackage);
        this.add(panelRemovePrefix);
//        this.add(panelRun);
        this.add(panelHandleInfo);

        this.setLayout(null);
        this.setTitle("PDM解析器");//窗体标签
        this.setSize(700, 600);//窗体大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭JFrame
        this.setVisible(true);//显示窗体

        //锁定窗体
        this.setResizable(false);
    }

    /**
     * Main component:
     * RemovePrefix, JavaRootPath, PojoPackage, MapperPackage, MapPath, Run, HandleInfo
     *
     * @param mainFrame
     */
    private void initComponent(MainFrame mainFrame) {
        panelJavaRootPath = new JPanel();
        panelPojoPackage = new JPanel();
        panelMapperPackage = new JPanel();
        panelMapPath = new JPanel();
        panelHandleInfo = new JPanel();
        panelRemovePrefix = new JPanel();
        panelRun = new JPanel();

        JLabel labelJavaRootPath = new JLabel("java源文件根目录");
        JLabel labelPojoPackage = new JLabel("实体类所在包");
        JLabel labelMapperPackage = new JLabel("mybatis接口所在包");
        JLabel labelMapPath = new JLabel("映射文件所在路径");
        JLabel labelHandleInfo = new JLabel("处理信息");
        JLabel labelRemovePrefix = new JLabel("是否移除前缀");

        JButton labelRun = new JButton("开始");

        panelJavaRootPath.add(labelJavaRootPath);
        panelPojoPackage.add(labelPojoPackage);
        panelMapperPackage.add(labelMapperPackage);
        panelMapPath.add(labelMapPath);
        panelHandleInfo.add(labelHandleInfo);
        panelRemovePrefix.add(labelRemovePrefix);
        panelRun.add(labelRun);

        mainFrame.add(panelJavaRootPath);
        mainFrame.add(panelPojoPackage);
        mainFrame.add(panelMapperPackage);
        mainFrame.add(panelMapPath);
        mainFrame.add(panelHandleInfo);
        mainFrame.add(panelRemovePrefix);
        mainFrame.add(panelRun);
    }

    public static void main(String[] args) {
        GlobalParameter.getInstance().initByConfig();
        LogTool logTool = new LogTool();
        logTool.start();
        MainFrame mainFrame = new MainFrame();
//        main.sho
//        mainFrame.showFrame();
    }
}
