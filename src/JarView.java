import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class JarView extends JFrame {

    private DecimalFormat formatter = new DecimalFormat("#.##");
    private FileWriter writer;

    private String welcomeText = "WELCOME TO MY SIMPLE PROGRAM DIVIDING YOUR INCOME INTO 6 SMALLER ACCOUNTS";
    private String info1 = "This application is based on the innovative saving method created by Harv Eker.";
    private String info2 = "You can overwrite application default settings by customizing your own.";

    private JLabel welcome = new JLabel(welcomeText);
    private JLabel welcome2 = new JLabel(info1);
    private JLabel welcome3 = new JLabel(info2);
    private JLabel salaryLabel = new JLabel("Enter your total income");

    private JTextField necessitiesLabel = new JTextField("Necessities", 20);
    private JTextField financialLabel = new JTextField("Financial", 20);
    private JTextField longTermLabel = new JTextField("LongTerm", 20);
    private JTextField educationLabel = new JTextField("Education", 20);
    private JTextField playLabel = new JTextField("Play", 20);
    private JTextField giveLabel = new JTextField("Give", 20);

    private JCheckBox check1 = new JCheckBox();
    private JCheckBox check2 = new JCheckBox();
    private JCheckBox check3 = new JCheckBox();
    private JCheckBox check4 = new JCheckBox();
    private JCheckBox check5 = new JCheckBox();
    private JCheckBox check6 = new JCheckBox();

    private JTextField necessitiesRate = new JTextField("55%", 3);
    private JTextField financialRate = new JTextField("10%", 3);
    private JTextField longTermRate = new JTextField("10%", 3);
    private JTextField educationRate = new JTextField("10%", 3);
    private JTextField playRate = new JTextField("10%", 3);
    private JTextField giveRate = new JTextField("5%", 3);

    private JTextField salary = new JTextField(8);
    private JTextField necessities = new JTextField(7);
    private JTextField financial = new JTextField(7);
    private JTextField longTerm = new JTextField(7);
    private JTextField education = new JTextField(7);
    private JTextField play = new JTextField(7);
    private JTextField give = new JTextField(7);

    private JButton buttonCalculate = new JButton("Calculate");
    private JButton buttonCustom = new JButton("Customize");
    private JButton buttonSave = new JButton("Save to file");
    private JButton buttonCustomCalculate = new JButton("Calculate");
    private JButton buttonDefault = new JButton("Restore default settings");
    private JButton buttonRound = new JButton("Round");
    private JButton buttonExit = new JButton("Exit");
    private JButton buttonLearn = new JButton("Learn the idea");

    private JPanel panel = new JPanel();
    private Image icon = Toolkit.getDefaultToolkit().getImage("coin.png");
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);


    JarView() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(552, 550);
        this.setLocation(450, 200);
        this.setTitle("6 JARS");
        this.setResizable(false);
        this.setIconImage(icon);

        this.add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

        necessitiesLabel.setToolTipText("Living expenses (food, bills, rent etc.)");
        financialLabel.setToolTipText("Investments (stocks, funds, passive incomes etc.)");
        longTermLabel.setToolTipText("Savings (big purchases, unexpected expenses, rainy day fund etc.)");
        educationLabel.setToolTipText("Personal development (courses, books, coaching etc.)");
        playLabel.setToolTipText("Entertainment (fun, parties, whims etc.)");
        giveLabel.setToolTipText("Charity (donations, helping the needy, crowdfunding etc.)");

        ToolTipManager manager = ToolTipManager.sharedInstance();
        manager.setInitialDelay(700);
        manager.setDismissDelay(5500);

        buttonCalculate.setCursor(cursor);
        buttonLearn.setCursor(cursor);
        buttonDefault.setCursor(cursor);
        buttonSave.setCursor(cursor);
        buttonCustom.setCursor(cursor);
        buttonCustomCalculate.setCursor(cursor);
        buttonExit.setCursor(cursor);
        buttonRound.setCursor(cursor);

        necessitiesLabel.setEditable(false);
        financialLabel.setEditable(false);
        longTermLabel.setEditable(false);
        educationLabel.setEditable(false);
        playLabel.setEditable(false);
        giveLabel.setEditable(false);

        necessitiesRate.setEditable(false);
        financialRate.setEditable(false);
        longTermRate.setEditable(false);
        educationRate.setEditable(false);
        playRate.setEditable(false);
        giveRate.setEditable(false);

        necessities.setEditable(false);
        financial.setEditable(false);
        longTerm.setEditable(false);
        education.setEditable(false);
        play.setEditable(false);
        give.setEditable(false);

        check1.setSelected(true);
        check2.setSelected(true);
        check3.setSelected(true);
        check4.setSelected(true);
        check5.setSelected(true);
        check6.setSelected(true);

        check1.setVisible(false);
        check2.setVisible(false);
        check3.setVisible(false);
        check4.setVisible(false);
        check5.setVisible(false);
        check6.setVisible(false);

        buttonCustomCalculate.setVisible(false);

        panel.add(welcome);
        panel.add(welcome2);
        panel.add(welcome3);
        panel.add(salaryLabel);
        panel.add(salary);
        panel.add(necessitiesLabel);
        panel.add(check1);
        panel.add(necessitiesRate);
        panel.add(necessities);
        panel.add(financialLabel);
        panel.add(check2);
        panel.add(financialRate);
        panel.add(financial);
        panel.add(longTermLabel);
        panel.add(check3);
        panel.add(longTermRate);
        panel.add(longTerm);
        panel.add(educationLabel);
        panel.add(check4);
        panel.add(educationRate);
        panel.add(education);
        panel.add(playLabel);
        panel.add(check5);
        panel.add(playRate);
        panel.add(play);
        panel.add(giveLabel);
        panel.add(check6);
        panel.add(giveRate);
        panel.add(give);
        panel.add(buttonCustom);
        panel.add(buttonRound);
        panel.add(buttonSave);
        panel.add(buttonCustomCalculate);
        panel.add(buttonCalculate);
        panel.add(buttonDefault);
        panel.add(buttonLearn);
        panel.add(buttonExit);
    }


    public double getSalary() {
        String salary = this.salary.getText();
        salary = salary.replace(",", ".");
        return Double.parseDouble(salary);
    }

    public String getNecessities() {
        return necessities.getText();
    }

    public String getFinancial() {
        return financial.getText();
    }

    public String getLongTerm() {
        return longTerm.getText();
    }

    public String getEducation() {
        return education.getText();
    }

    public String getPlay() {
        return play.getText();
    }

    public String getGive() {
        return give.getText();
    }


    public void setNecessities(double result) {
        necessities.setText(String.valueOf(formatter.format(result)));
    }

    public void setFinancial(double result) {
        financial.setText(String.valueOf(formatter.format(result)));
    }

    public void setLongTerm(double result) {
        longTerm.setText(String.valueOf(formatter.format(result)));
    }

    public void setEducation(double result) {
        education.setText(String.valueOf(formatter.format(result)));
    }

    public void setPlay(double result) {
        play.setText(String.valueOf(formatter.format(result)));
    }

    public void setGive(double result) {
        give.setText(String.valueOf(formatter.format(result)));
    }


    public void setNecessitiesRate(double rate) {
        necessitiesRate.setText(String.valueOf((int) rate) + "%");
    }

    public void setFinancialRate(double rate) {
        financialRate.setText(String.valueOf((int) rate) + "%");
    }

    public void setLongTermRate(double rate) {
        longTermRate.setText(String.valueOf((int) rate) + "%");
    }

    public void setEducationRate(double rate) {
        educationRate.setText(String.valueOf((int) rate) + "%");
    }

    public void setPlayRate(double rate) {
        playRate.setText(String.valueOf((int) rate) + "%");
    }

    public void setGiveRate(double rate) {
        giveRate.setText(String.valueOf(((int) rate) + "%"));
    }


    public double getCustomNecessitiesRate() {
        String percentage = necessitiesRate.getText();
        percentage = percentage.replace("%", "");
        percentage = percentage.replace(",", ".");
        return (Double.parseDouble(percentage) / 100);
    }

    public double getCustomFinancialRate() {
        String percentage = financialRate.getText();
        percentage = percentage.replace("%", "");
        percentage = percentage.replace(",", ".");
        return (Double.parseDouble(percentage) / 100);
    }

    public double getCustomLongTermRate() {
        String percentage = longTermRate.getText();
        percentage = percentage.replace("%", "");
        percentage = percentage.replace(",", ".");
        return (Double.parseDouble(percentage) / 100);
    }

    public double getCustomEducationRate() {
        String percentage = educationRate.getText();
        percentage = percentage.replace("%", "");
        percentage = percentage.replace(",", ".");
        return (Double.parseDouble(percentage) / 100);
    }

    public double getCustomPlayRate() {
        String percentage = playRate.getText();
        percentage = percentage.replace("%", "");
        percentage = percentage.replace(",", ".");
        return (Double.parseDouble(percentage) / 100);
    }

    public double getCustomGiveRate() {
        String percentage = giveRate.getText();
        percentage = percentage.replace("%", "");
        percentage = percentage.replace(",", ".");
        return (Double.parseDouble(percentage) / 100);
    }



    public void setSalary(String placeholder) {
        salary.setText(placeholder);
    }

    public void setNecessities(String placeholder) {
        necessities.setText(placeholder);
    }

    public void setFinancial(String placeholder) {
        financial.setText(placeholder);
    }

    public void setLongTerm(String placeholder) {
        longTerm.setText(placeholder);
    }

    public void setEducation(String placeholder) {
        education.setText(placeholder);
    }

    public void setPlay(String placeholder) {
        play.setText(placeholder);
    }

    public void setGive(String placeholder) {
        give.setText(placeholder);
    }


    public JTextField getNecessitiesLabel() {
        return necessitiesLabel;
    }

    public JTextField getFinancialLabel() {
        return financialLabel;
    }

    public JTextField getLongTermLabel() {
        return longTermLabel;
    }

    public JTextField getEducationLabel() {
        return educationLabel;
    }

    public JTextField getPlayLabel() {
        return playLabel;
    }

    public JTextField getGiveLabel() {
        return giveLabel;
    }


    public JTextField getNecessitiesRate() {
        return necessitiesRate;
    }

    public JTextField getFinancialRate() {
        return financialRate;
    }

    public JTextField getLongTermRate() {
        return longTermRate;
    }

    public JTextField getEducationRate() {
        return educationRate;
    }

    public JTextField getPlayRate() {
        return playRate;
    }

    public JTextField getGiveRate() {
        return giveRate;
    }


    public JCheckBox getCheck1() {
        return check1;
    }

    public JCheckBox getCheck2() {
        return check2;
    }

    public JCheckBox getCheck3() {
        return check3;
    }

    public JCheckBox getCheck4() {
        return check4;
    }

    public JCheckBox getCheck5() {
        return check5;
    }

    public JCheckBox getCheck6() {
        return check6;
    }


    public JButton getButtonCalculate() {
        return buttonCalculate;
    }

    public JButton getButtonCustomCalculate() {
        return buttonCustomCalculate;
    }

    public JButton getButtonCustom() {
        return buttonCustom;
    }


    public void addCalculateListener(ActionListener listener) {
        buttonCalculate.addActionListener(listener);
    }

    public void addCustomListener(ActionListener listener) {
        buttonCustom.addActionListener(listener);
    }

    public void addSaveListener(ActionListener listener) {
        buttonSave.addActionListener(listener);
    }

    public void addCustomCalculateListener(ActionListener listener) {
        buttonCustomCalculate.addActionListener(listener);
    }

    public void addDefaultListener(ActionListener listener) {
        buttonDefault.addActionListener(listener);
    }

    public void addRoundListener(ActionListener listener) {
        buttonRound.addActionListener(listener);
    }

    public void addExitListener(ActionListener listener) {
        buttonExit.addActionListener(listener);
    }

    public void addLearnListener(ActionListener listener) {
        buttonLearn.addActionListener(listener);
    }

    public void addCheckListener(ActionListener listener) {
        check1.addActionListener(listener);
        check2.addActionListener(listener);
        check3.addActionListener(listener);
        check4.addActionListener(listener);
        check5.addActionListener(listener);
        check6.addActionListener(listener);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showWarning(String message) {
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public void saveFile(String message) {

        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();

        if (file != null) {
            try {
                writer = new FileWriter(file + ".txt");
                writer.write(message);
                writer.close();
            } catch (IOException e) {
                this.showError("File not saved");
            }
        }
    }
}