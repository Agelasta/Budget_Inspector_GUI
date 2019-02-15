import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JarController {

    private JarModel jarModel;
    private JarView jarView;

    public JarController(JarModel jarModel, JarView jarView) {
        this.jarModel = jarModel;
        this.jarView = jarView;
        this.jarView.addCalculateListener(new CalculateListener());
        this.jarView.addCustomListener(new CustomizeListener());
        this.jarView.addSaveListener(new SaveListener());
        this.jarView.addCustomCalculateListener(new CustomCalculateListener());
        this.jarView.addCheckListener(new CheckListener());
        this.jarView.addDefaultListener(new DefaultListener());
        this.jarView.addRoundListener(new RoundListener());
        this.jarView.addExitListener(new ExitListener());
        this.jarView.addLearnListener(new LearnListener());
    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                double salary = jarView.getSalary();
                if (salary <= 0) {
                    jarView.showWarning("Please enter value bigger than 0");
                } else {
                    jarModel.setNecessities(salary);
                    jarModel.setFinancial(salary);
                    jarModel.setLongTerm(salary);
                    jarModel.setEducation(salary);
                    jarModel.setPlay(salary);
                    jarModel.setGive(salary);

                    jarView.setNecessities(jarModel.getNecessities());
                    jarView.setFinancial(jarModel.getFinancial());
                    jarView.setLongTerm(jarModel.getLongTerm());
                    jarView.setEducation(jarModel.getEducation());
                    jarView.setPlay(jarModel.getPlay());
                    jarView.setGive(jarModel.getGive());
                }
            } catch (NumberFormatException ex) {
                jarView.showWarning("Please enter a number");
            }
        }
    }

    class CustomCalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                double salary = jarView.getSalary();
                double necessitiesCustom = jarView.getCustomNecessitiesRate();
                double financialCustom = jarView.getCustomFinancialRate();
                double longTermCustom = jarView.getCustomLongTermRate();
                double educationCustom = jarView.getCustomEducationRate();
                double playCustom = jarView.getCustomPlayRate();
                double giveCustom = jarView.getCustomGiveRate();

                if (salary <= 0) {
                    jarView.showWarning("Please enter value bigger than 0");
                } else {

                    if ((jarModel.addRates(necessitiesCustom, financialCustom, educationCustom, longTermCustom,
                            playCustom, giveCustom)) != 10000) {
                        jarView.showWarning("Total amount of percentage values must equal 100");
                    } else {
                        jarModel.setCustomNecessities(salary, necessitiesCustom);
                        jarModel.setCustomFinancial(salary, financialCustom);
                        jarModel.setCustomLongTerm(salary, longTermCustom);
                        jarModel.setCustomEducation(salary, educationCustom);
                        jarModel.setCustomPlay(salary, playCustom);
                        jarModel.setCustomGive(salary, giveCustom);

                        jarView.setNecessities(jarModel.getNecessities());
                        jarView.setFinancial(jarModel.getFinancial());
                        jarView.setLongTerm(jarModel.getLongTerm());
                        jarView.setEducation(jarModel.getEducation());
                        jarView.setPlay(jarModel.getPlay());
                        jarView.setGive(jarModel.getGive());
                    }
                }
            } catch (NumberFormatException ex) {
                jarView.showWarning("Please enter a number");
            }
        }
    }

    class LearnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            URI url = null;
            try {
                url = new URI("https://blog.harveker.com/6-step-money-managing-system/");
            } catch (URISyntaxException e1) {
                jarView.showError("Unknown error");
            }
            try {
                Desktop.getDesktop().browse(url);
            } catch (IOException e1) {
                jarView.showError("Connection error");
            }
        }
    }

    class RoundListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String result = jarView.getNecessities();
                result = result.replace(",", ".");
                jarView.setNecessities(jarModel.roundNecessities(Double.valueOf(result)));

                String result1 = jarView.getFinancial();
                result1 = result1.replace(",", ".");
                jarView.setFinancial(jarModel.roundFinancial(Double.valueOf(result1)));

                String result2 = jarView.getLongTerm();
                result2 = result2.replace(",", ".");
                jarView.setLongTerm(jarModel.roundLongTerm(Double.valueOf(result2)));

                String result3 = jarView.getEducation();
                result3 = result3.replace(",", ".");
                jarView.setEducation(jarModel.roundEducation(Double.valueOf(result3)));

                String result4 = jarView.getPlay();
                result4 = result4.replace(",", ".");
                jarView.setPlay(jarModel.roundPlay(Double.valueOf(result4)));

                String result5 = jarView.getGive();
                result5 = result5.replace(",", ".");
                jarView.setGive(jarModel.roundGive(Double.valueOf(result5)));
            } catch (NumberFormatException ex) {
                jarView.showError("Unsupported operation");
            }
        }
    }

    class CheckListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (jarView.getCheck1().isSelected()) {
                jarView.getNecessitiesLabel().setEditable(true);
                jarView.getNecessitiesRate().setEditable(true);
            } else {
                jarView.getNecessitiesLabel().setEditable(false);
                jarView.getNecessitiesRate().setEditable(false);
                jarView.setNecessitiesRate(0);
            }

            if (jarView.getCheck2().isSelected()) {
                jarView.getFinancialLabel().setEditable(true);
                jarView.getFinancialRate().setEditable(true);
            } else {
                jarView.getFinancialLabel().setEditable(false);
                jarView.getFinancialRate().setEditable(false);
                jarView.setFinancialRate(0);
            }

            if (jarView.getCheck3().isSelected()) {
                jarView.getLongTermLabel().setEditable(true);
                jarView.getLongTermRate().setEditable(true);
            } else {
                jarView.getLongTermLabel().setEditable(false);
                jarView.getLongTermRate().setEditable(false);
                jarView.setLongTermRate(0);
            }

            if (jarView.getCheck4().isSelected()) {
                jarView.getEducationLabel().setEditable(true);
                jarView.getEducationRate().setEditable(true);
            } else {
                jarView.getEducationLabel().setEditable(false);
                jarView.getEducationRate().setEditable(false);
                jarView.setEducationRate(0);
            }

            if (jarView.getCheck5().isSelected()) {
                jarView.getPlayLabel().setEditable(true);
                jarView.getPlayRate().setEditable(true);
            } else {
                jarView.getPlayLabel().setEditable(false);
                jarView.getPlayRate().setEditable(false);
                jarView.setPlayRate(0);
            }

            if (jarView.getCheck6().isSelected()) {
                jarView.getGiveLabel().setEditable(true);
                jarView.getGiveRate().setEditable(true);
            } else {
                jarView.getGiveLabel().setEditable(false);
                jarView.getGiveRate().setEditable(false);
                jarView.setGiveRate(0);
            }
        }
    }


    class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            StringBuilder message = new StringBuilder();

            if (jarView.getCheck1().isSelected()) {
                message.append(jarView.getNecessitiesLabel().getText() +
                        " = " + jarView.getNecessities() + System.lineSeparator());
            }
            if (jarView.getCheck2().isSelected()) {
                message.append(jarView.getFinancialLabel().getText() +
                        " = " + jarView.getFinancial() + System.lineSeparator());
            }
            if (jarView.getCheck3().isSelected()) {
                message.append(jarView.getLongTermLabel().getText() +
                        " = " + jarView.getLongTerm() + System.lineSeparator());
            }
            if (jarView.getCheck4().isSelected()) {
                message.append(jarView.getEducationLabel().getText() +
                        " = " + jarView.getEducation() + System.lineSeparator());
            }
            if (jarView.getCheck5().isSelected()) {
                message.append(jarView.getPlayLabel().getText() +
                        " = " + jarView.getPlay() + System.lineSeparator());
            }
            if (jarView.getCheck6().isSelected()) {
                message.append(jarView.getGiveLabel().getText() +
                        " = " + jarView.getGive() + System.lineSeparator());
            }

            jarView.saveFile(message.toString());
        }
    }

    class CustomizeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ToolTipManager manager = ToolTipManager.sharedInstance();
            manager.setEnabled(false);

            jarView.getButtonCalculate().setVisible(false);
            jarView.getButtonCustomCalculate().setVisible(true);
            jarView.getButtonCustom().setEnabled(false);

            jarView.getCheck1().setVisible(true);
            jarView.getCheck2().setVisible(true);
            jarView.getCheck3().setVisible(true);
            jarView.getCheck4().setVisible(true);
            jarView.getCheck5().setVisible(true);
            jarView.getCheck6().setVisible(true);

            jarView.getNecessitiesLabel().setEditable(true);
            jarView.getNecessitiesRate().setEditable(true);

            jarView.getFinancialLabel().setEditable(true);
            jarView.getFinancialRate().setEditable(true);

            jarView.getLongTermLabel().setEditable(true);
            jarView.getLongTermRate().setEditable(true);

            jarView.getEducationLabel().setEditable(true);
            jarView.getEducationRate().setEditable(true);

            jarView.getPlayLabel().setEditable(true);
            jarView.getPlayRate().setEditable(true);

            jarView.getGiveLabel().setEditable(true);
            jarView.getGiveRate().setEditable(true);

            jarView.setNecessities(0);
            jarView.setFinancial(0);
            jarView.setLongTerm(0);
            jarView.setEducation(0);
            jarView.setPlay(0);
            jarView.setGive(0);
        }
    }

    class DefaultListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ToolTipManager manager = ToolTipManager.sharedInstance();
            manager.setEnabled(true);

            jarView.getCheck1().setSelected(true);
            jarView.getCheck2().setSelected(true);
            jarView.getCheck3().setSelected(true);
            jarView.getCheck4().setSelected(true);
            jarView.getCheck5().setSelected(true);
            jarView.getCheck6().setSelected(true);

            jarView.getCheck1().setVisible(false);
            jarView.getCheck2().setVisible(false);
            jarView.getCheck3().setVisible(false);
            jarView.getCheck4().setVisible(false);
            jarView.getCheck5().setVisible(false);
            jarView.getCheck6().setVisible(false);

            jarView.getButtonCustom().setEnabled(true);

            jarView.getNecessitiesLabel().setText("Necessities");
            jarView.getFinancialLabel().setText("Financial");
            jarView.getLongTermLabel().setText("LongTerm");
            jarView.getEducationLabel().setText("Education");
            jarView.getPlayLabel().setText("Play");
            jarView.getGiveLabel().setText("Give");

            jarView.getNecessitiesLabel().setEditable(false);
            jarView.getNecessitiesRate().setEditable(false);
            jarView.setNecessitiesRate(55);

            jarView.getFinancialLabel().setEditable(false);
            jarView.getFinancialRate().setEditable(false);
            jarView.setFinancialRate(10);

            jarView.getLongTermLabel().setEditable(false);
            jarView.getLongTermRate().setEditable(false);
            jarView.setLongTermRate(10);

            jarView.getEducationLabel().setEditable(false);
            jarView.getEducationRate().setEditable(false);
            jarView.setEducationRate(10);

            jarView.getPlayLabel().setEditable(false);
            jarView.getPlayRate().setEditable(false);
            jarView.setPlayRate(10);

            jarView.getGiveLabel().setEditable(false);
            jarView.getGiveRate().setEditable(false);
            jarView.setGiveRate(5);

            jarView.setSalary("");
            jarView.setNecessities("");
            jarView.setFinancial("");
            jarView.setLongTerm("");
            jarView.setEducation("");
            jarView.setPlay("");
            jarView.setGive("");
        }
    }

    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.exit(0);
        }
    }
}



