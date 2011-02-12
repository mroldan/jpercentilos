/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import jpercentilos.res.*;
import jpercentilos.res.Dimensionizable.*;
import jpercentilos.res.Length.*;
import jpercentilos.res.PatientProfile.DataNotFoundException;
import jpercentilos.res.PatientProfile.Sexo;
import org.netbeans.microedition.lcdui.WaitScreen;
import org.netbeans.microedition.util.SimpleCancellableTask;

/**
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class GMUI extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command CalculateCommand;
    private Command backCommand;
    private Command exitCommand1;
    private Command helpCommand;
    private Command cancelCommand;
    private Command okCommand;
    private Command okCommand1;
    private Command cancelCommand1;
    private Command exitCommand2;
    private Command okCommand2;
    private Form InputDataScreen;
    private StringItem stringItem;
    private ChoiceGroup sexChoice;
    private TextField heightField;
    private TextField ageField;
    private ChoiceGroup ageChoice;
    private TextField weightField;
    private TextField headPerimeterField;
    private ChoiceGroup heightChoice;
    private ChoiceGroup weightChoice;
    private ChoiceGroup headPerimeterChoice;
    private Spacer spacer;
    private Form OutputDataScreen;
    private StringItem IMCOutput;
    private StringItem HPOutput;
    private StringItem heightOutput;
    private StringItem weightOutput;
    private StringItem WeightHeightOutput;
    private StringItem IMCValueOutput;
    private WaitScreen waitScreen;
    private Alert alert;
    private SimpleCancellableTask task;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The GMUI constructor.
     */
    public GMUI() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getInputDataScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == InputDataScreen) {//GEN-BEGIN:|7-commandAction|1|23-preAction
            if (command == CalculateCommand) {//GEN-END:|7-commandAction|1|23-preAction
                // Get the Values in Input fields.
                switchDisplayable(null, getWaitScreen());
//                Patient.Sexo sexo;
//                switch (sexChoice.getSelectedIndex()) {
//                    case 0:
//                        sexo = Patient.Sexo.VARÓN;
//                        break;
//                    case 1:
//                        sexo = Patient.Sexo.MUJER;
//                        break;
//                    default:
//                        sexo = Patient.Sexo.VARÓN;
//                }
//                int age;
//                double weight;
//                double height;
//                double headPerimeter;
//                try {
//                    age = getAge();
//                } catch (Exception e) {
//                    age = -1;
//                }
//                try {
//                    weight = getWeightInKg();
//                } catch (Exception e) {
//                    weight = -1;
//                }
//                try {
//                    height = getHeightInCm();
//                } catch (Exception e) {
//                    height = -1;
//                }
//                try {
//                    headPerimeter = getHeadPerimeter();
//                } catch (Exception e) {
//                    headPerimeter = -1;
//                }
//                Patient p = new Patient(sexo, new Age(age, AgeUnit.DÍA), new Height(headPerimeter, LengthUnit.M), headPerimeter, weight);
                switchDisplayable(null, getWaitScreen());//GEN-LINE:|7-commandAction|2|23-postAction
                // write post-action user code here
//                try {
//                    weightOutput.setText(formatCentile(p.getWeightCentile()));
//                } catch (DataNotFoundException ex) {
//                    weightOutput.setText("--");
//                }
//                try {
//                    heightOutput.setText(formatCentile(p.getHeightCentile()));
//                } catch (DataNotFoundException ex) {
//                    heightOutput.setText("--");
//                }
//                try {
//                    HPOutput.setText(formatCentile(p.getPCCentile()));
//                } catch (DataNotFoundException ex) {
//                    HPOutput.setText("--");
//                }
//                try {
//                    IMCOutput.setText(formatCentile(p.getIMCCentile()));
//                } catch (DataNotFoundException ex) {
//                    IMCOutput.setText("--");
//                }
                // Show calculated data.
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|3|19-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|4|19-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|27-preAction
        } else if (displayable == OutputDataScreen) {
            if (command == backCommand) {//GEN-END:|7-commandAction|5|27-preAction
                // write pre-action user code here
                switchDisplayable(null, getInputDataScreen());//GEN-LINE:|7-commandAction|6|27-postAction
                // write post-action user code here
            } else if (command == exitCommand1) {//GEN-LINE:|7-commandAction|7|29-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|8|29-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|120-preAction
        } else if (displayable == alert) {
            if (command == okCommand2) {//GEN-END:|7-commandAction|9|120-preAction
                // write pre-action user code here
                switchDisplayable(null, getInputDataScreen());//GEN-LINE:|7-commandAction|10|120-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|114-preAction
        } else if (displayable == waitScreen) {
            if (command == WaitScreen.FAILURE_COMMAND) {//GEN-END:|7-commandAction|11|114-preAction
                // write pre-action user code here
                switchDisplayable(getAlert(), getInputDataScreen());//GEN-LINE:|7-commandAction|12|114-postAction
                // write post-action user code here
            } else if (command == WaitScreen.SUCCESS_COMMAND) {//GEN-LINE:|7-commandAction|13|113-preAction
                // write pre-action user code here
                switchDisplayable(null, getOutputDataScreen());//GEN-LINE:|7-commandAction|14|113-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|7-postCommandAction
        }//GEN-END:|7-commandAction|15|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|16|
    //</editor-fold>//GEN-END:|7-commandAction|16|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: InputDataScreen ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of InputDataScreen component.
     * @return the initialized component instance
     */
    public Form getInputDataScreen() {
        if (InputDataScreen == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            InputDataScreen = new Form(null, new Item[] { getStringItem(), getSexChoice(), getAgeField(), getAgeChoice(), getHeightField(), getHeightChoice(), getWeightField(), getWeightChoice(), getHeadPerimeterField(), getHeadPerimeterChoice(), getSpacer() });//GEN-BEGIN:|14-getter|1|14-postInit
            InputDataScreen.addCommand(getExitCommand());
            InputDataScreen.addCommand(getCalculateCommand());
            InputDataScreen.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return InputDataScreen;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|16-getter|0|16-preInit
            // write pre-init user code here
            stringItem = new StringItem("Bienvenido!", "Ingrese los datos del paciente y presione \"Siguiente\"", Item.PLAIN);//GEN-LINE:|16-getter|1|16-postInit
            // write post-init user code here
        }//GEN-BEGIN:|16-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|16-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: CalculateCommand ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of CalculateCommand component.
     * @return the initialized component instance
     */
    public Command getCalculateCommand() {
        if (CalculateCommand == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            CalculateCommand = new Command("Calcular", Command.OK, 0);//GEN-LINE:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return CalculateCommand;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|26-getter|1|26-postInit
            // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of exitCommand1 component.
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return exitCommand1;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: OutputDataScreen ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of OutputDataScreen component.
     * @return the initialized component instance
     */
    public Form getOutputDataScreen() {
        if (OutputDataScreen == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            OutputDataScreen = new Form("Percentilos", new Item[] { getIMCValueOutput(), getWeightOutput(), getHeightOutput(), getHPOutput(), getIMCOutput(), getWeightHeightOutput() });//GEN-BEGIN:|24-getter|1|24-postInit
            OutputDataScreen.addCommand(getBackCommand());
            OutputDataScreen.addCommand(getExitCommand1());
            OutputDataScreen.setCommandListener(this);//GEN-END:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return OutputDataScreen;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: sexChoice ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of sexChoice component.
     * @return the initialized component instance
     */
    public ChoiceGroup getSexChoice() {
        if (sexChoice == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            sexChoice = new ChoiceGroup("Sexo:", Choice.POPUP);//GEN-BEGIN:|32-getter|1|32-postInit
            sexChoice.append("Var\u00F3n", null);
            sexChoice.append("Mujer", null);
            sexChoice.setSelectedFlags(new boolean[] { true, false });//GEN-END:|32-getter|1|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return sexChoice;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ageField ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of ageField component.
     * @return the initialized component instance
     */
    public TextField getAgeField() {
        if (ageField == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            ageField = new TextField("Edad:", "5", 5, TextField.NUMERIC);//GEN-BEGIN:|36-getter|1|36-postInit
            ageField.setLayout(ImageItem.LAYOUT_DEFAULT);
            ageField.setPreferredSize(-1, -1);//GEN-END:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return ageField;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: heightField ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of heightField component.
     * @return the initialized component instance
     */
    public TextField getHeightField() {
        if (heightField == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            heightField = new TextField("Talla:", "65", 6, TextField.DECIMAL);//GEN-LINE:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return heightField;
    }
    //</editor-fold>//GEN-END:|38-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: weightField ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of weightField component.
     * @return the initialized component instance
     */
    public TextField getWeightField() {
        if (weightField == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            weightField = new TextField("Peso:", "7.4", 6, TextField.DECIMAL);//GEN-LINE:|40-getter|1|40-postInit
            // write post-init user code here
        }//GEN-BEGIN:|40-getter|2|
        return weightField;
    }
    //</editor-fold>//GEN-END:|40-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: headPerimeterField ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of headPerimeterField component.
     * @return the initialized component instance
     */
    public TextField getHeadPerimeterField() {
        if (headPerimeterField == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            headPerimeterField = new TextField("PC:", "45", 6, TextField.DECIMAL);//GEN-LINE:|41-getter|1|41-postInit
            // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return headPerimeterField;
    }
    //</editor-fold>//GEN-END:|41-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ageChoice ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initiliazed instance of ageChoice component.
     * @return the initialized component instance
     */
    public ChoiceGroup getAgeChoice() {
        if (ageChoice == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            ageChoice = new ChoiceGroup(null, Choice.POPUP);//GEN-BEGIN:|43-getter|1|43-postInit
            ageChoice.append("d\u00EDas", null);
            ageChoice.append("meses", null);
            ageChoice.append("a\u00F1os", null);
            ageChoice.setLayout(ImageItem.LAYOUT_DEFAULT);
            ageChoice.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);
            ageChoice.setSelectedFlags(new boolean[] { false, true, false });//GEN-END:|43-getter|1|43-postInit
            // write post-init user code here
        }//GEN-BEGIN:|43-getter|2|
        return ageChoice;
    }
    //</editor-fold>//GEN-END:|43-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: heightChoice ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of heightChoice component.
     * @return the initialized component instance
     */
    public ChoiceGroup getHeightChoice() {
        if (heightChoice == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            heightChoice = new ChoiceGroup(null, Choice.POPUP);//GEN-BEGIN:|47-getter|1|47-postInit
            heightChoice.append("m", null);
            heightChoice.append("cm", null);
            heightChoice.setSelectedFlags(new boolean[] { false, true });//GEN-END:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return heightChoice;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: weightChoice ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of weightChoice component.
     * @return the initialized component instance
     */
    public ChoiceGroup getWeightChoice() {
        if (weightChoice == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            weightChoice = new ChoiceGroup(null, Choice.POPUP);//GEN-BEGIN:|50-getter|1|50-postInit
            weightChoice.append("kg", null);
            weightChoice.append("g", null);
            weightChoice.setSelectedFlags(new boolean[] { false, false });//GEN-END:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return weightChoice;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: headPerimeterChoice ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of headPerimeterChoice component.
     * @return the initialized component instance
     */
    public ChoiceGroup getHeadPerimeterChoice() {
        if (headPerimeterChoice == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            headPerimeterChoice = new ChoiceGroup(null, Choice.POPUP);//GEN-BEGIN:|53-getter|1|53-postInit
            headPerimeterChoice.append("cm", null);
            headPerimeterChoice.append("mm", null);
            headPerimeterChoice.setSelectedFlags(new boolean[] { false, false });//GEN-END:|53-getter|1|53-postInit
            // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return headPerimeterChoice;
    }
    //</editor-fold>//GEN-END:|53-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: weightOutput ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of weightOutput component.
     * @return the initialized component instance
     */
    public StringItem getWeightOutput() {
        if (weightOutput == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            weightOutput = new StringItem("Peso/Edad:", "--");//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return weightOutput;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: heightOutput ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initiliazed instance of heightOutput component.
     * @return the initialized component instance
     */
    public StringItem getHeightOutput() {
        if (heightOutput == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            heightOutput = new StringItem("Talla/Edad:", "--");//GEN-LINE:|57-getter|1|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return heightOutput;
    }
    //</editor-fold>//GEN-END:|57-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: HPOutput ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initiliazed instance of HPOutput component.
     * @return the initialized component instance
     */
    public StringItem getHPOutput() {
        if (HPOutput == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            HPOutput = new StringItem("PC/Edad:", "--");//GEN-LINE:|58-getter|1|58-postInit
            // write post-init user code here
        }//GEN-BEGIN:|58-getter|2|
        return HPOutput;
    }
    //</editor-fold>//GEN-END:|58-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: IMCOutput ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of IMCOutput component.
     * @return the initialized component instance
     */
    public StringItem getIMCOutput() {
        if (IMCOutput == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            IMCOutput = new StringItem("IMC/Edad:", "--");//GEN-LINE:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return IMCOutput;
    }
    //</editor-fold>//GEN-END:|59-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: helpCommand ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initiliazed instance of helpCommand component.
     * @return the initialized component instance
     */
    public Command getHelpCommand() {
        if (helpCommand == null) {//GEN-END:|61-getter|0|61-preInit
            // write pre-init user code here
            helpCommand = new Command("Help", Command.HELP, 0);//GEN-LINE:|61-getter|1|61-postInit
            // write post-init user code here
        }//GEN-BEGIN:|61-getter|2|
        return helpCommand;
    }
    //</editor-fold>//GEN-END:|61-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|67-getter|0|67-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|67-getter|0|67-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|67-getter|1|67-postInit
            // write post-init user code here
        }//GEN-BEGIN:|67-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|67-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initiliazed instance of cancelCommand component.
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|70-getter|1|70-postInit
            // write post-init user code here
        }//GEN-BEGIN:|70-getter|2|
        return cancelCommand;
    }
    //</editor-fold>//GEN-END:|70-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand1 ">//GEN-BEGIN:|74-getter|0|74-preInit
    /**
     * Returns an initiliazed instance of cancelCommand1 component.
     * @return the initialized component instance
     */
    public Command getCancelCommand1() {
        if (cancelCommand1 == null) {//GEN-END:|74-getter|0|74-preInit
            // write pre-init user code here
            cancelCommand1 = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|74-getter|1|74-postInit
            // write post-init user code here
        }//GEN-BEGIN:|74-getter|2|
        return cancelCommand1;
    }
    //</editor-fold>//GEN-END:|74-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|76-getter|1|76-postInit
            // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|76-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: spacer ">//GEN-BEGIN:|83-getter|0|83-preInit
    /**
     * Returns an initiliazed instance of spacer component.
     * @return the initialized component instance
     */
    public Spacer getSpacer() {
        if (spacer == null) {//GEN-END:|83-getter|0|83-preInit
            // write pre-init user code here
            spacer = new Spacer(16, 300);//GEN-LINE:|83-getter|1|83-postInit
            // write post-init user code here
        }//GEN-BEGIN:|83-getter|2|
        return spacer;
    }
    //</editor-fold>//GEN-END:|83-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand2 ">//GEN-BEGIN:|106-getter|0|106-preInit
    /**
     * Returns an initiliazed instance of exitCommand2 component.
     * @return the initialized component instance
     */
    public Command getExitCommand2() {
        if (exitCommand2 == null) {//GEN-END:|106-getter|0|106-preInit
            // write pre-init user code here
            exitCommand2 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|106-getter|1|106-postInit
            // write post-init user code here
        }//GEN-BEGIN:|106-getter|2|
        return exitCommand2;
    }
    //</editor-fold>//GEN-END:|106-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: waitScreen ">//GEN-BEGIN:|110-getter|0|110-preInit
    /**
     * Returns an initiliazed instance of waitScreen component.
     * @return the initialized component instance
     */
    public WaitScreen getWaitScreen() {
        if (waitScreen == null) {//GEN-END:|110-getter|0|110-preInit
            // write pre-init user code here
            waitScreen = new WaitScreen(getDisplay());//GEN-BEGIN:|110-getter|1|110-postInit
            waitScreen.setTitle("waitScreen");
            waitScreen.setCommandListener(this);
            waitScreen.setTask(getTask());//GEN-END:|110-getter|1|110-postInit
            // write post-init user code here
        }//GEN-BEGIN:|110-getter|2|
        return waitScreen;
    }
    //</editor-fold>//GEN-END:|110-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: task ">//GEN-BEGIN:|115-getter|0|115-preInit
    /**
     * Returns an initiliazed instance of task component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask() {
        if (task == null) {//GEN-END:|115-getter|0|115-preInit
            // write pre-init user code here
            task = new SimpleCancellableTask();//GEN-BEGIN:|115-getter|1|115-execute
            task.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|115-getter|1|115-execute
                    // write task-execution user code here
                    Patient p = createPatient();
                    System.out.println("Paciente creado");
                    showResults(p);
                }//GEN-BEGIN:|115-getter|2|115-postInit
            });//GEN-END:|115-getter|2|115-postInit
            // write post-init user code here
        }//GEN-BEGIN:|115-getter|3|
        return task;
    }
    //</editor-fold>//GEN-END:|115-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|119-getter|0|119-preInit
    /**
     * Returns an initiliazed instance of okCommand2 component.
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {//GEN-END:|119-getter|0|119-preInit
            // write pre-init user code here
            okCommand2 = new Command("Ok", Command.OK, 0);//GEN-LINE:|119-getter|1|119-postInit
            // write post-init user code here
        }//GEN-BEGIN:|119-getter|2|
        return okCommand2;
    }
    //</editor-fold>//GEN-END:|119-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|118-getter|0|118-preInit
    /**
     * Returns an initiliazed instance of alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {//GEN-END:|118-getter|0|118-preInit
            // write pre-init user code here
            alert = new Alert("alert", "Error!", null, AlertType.ERROR);//GEN-BEGIN:|118-getter|1|118-postInit
            alert.addCommand(getOkCommand2());
            alert.setCommandListener(this);
            alert.setTimeout(10000);//GEN-END:|118-getter|1|118-postInit
            // write post-init user code here
        }//GEN-BEGIN:|118-getter|2|
        return alert;
    }
    //</editor-fold>//GEN-END:|118-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: WeightHeightOutput ">//GEN-BEGIN:|122-getter|0|122-preInit
    /**
     * Returns an initiliazed instance of WeightHeightOutput component.
     * @return the initialized component instance
     */
    public StringItem getWeightHeightOutput() {
        if (WeightHeightOutput == null) {//GEN-END:|122-getter|0|122-preInit
            // write pre-init user code here
            WeightHeightOutput = new StringItem("Peso/Talla:", "--");//GEN-LINE:|122-getter|1|122-postInit
            // write post-init user code here
        }//GEN-BEGIN:|122-getter|2|
        return WeightHeightOutput;
    }
    //</editor-fold>//GEN-END:|122-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: IMCValueOutput ">//GEN-BEGIN:|123-getter|0|123-preInit
    /**
     * Returns an initiliazed instance of IMCValueOutput component.
     * @return the initialized component instance
     */
    public StringItem getIMCValueOutput() {
        if (IMCValueOutput == null) {//GEN-END:|123-getter|0|123-preInit
            // write pre-init user code here
            IMCValueOutput = new StringItem("IMC:", "--");//GEN-LINE:|123-getter|1|123-postInit
            // write post-init user code here
        }//GEN-BEGIN:|123-getter|2|
        return IMCValueOutput;
    }
    //</editor-fold>//GEN-END:|123-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    private Age getAge() {
        try {
            double res = Double.parseDouble(ageField.getString());
            AgeUnit unit;
            switch (ageChoice.getSelectedIndex()) {
                case 0:
                    unit = AgeUnit.DÍA;
                    break;
                case 1:
                    unit = AgeUnit.MES;
                    break;
                case 2:
                    unit = AgeUnit.AÑO;
                    break;
                default:
                    unit = AgeUnit.AÑO;
            }
            System.out.println("Age Read: " + res + " " + unit.toString());
            return new Age(res, unit);
        } catch (NumberFormatException numberFormatException) {
            return Age.NA;
        }
    }

    private Weight getWeight() {
        try {
            double kg = Double.parseDouble(weightField.getString());
            WeightUnit unit;
            switch (weightChoice.getSelectedIndex()) {
                case 0:
                    unit = WeightUnit.KG;
                    break;
                case 1:
                    unit = WeightUnit.G;
                    break;
                default:
                    unit = WeightUnit.KG;
            }
            System.out.println("Weight read: " + kg + " " + unit.toString());
            return new Weight(kg, unit);
        } catch (NumberFormatException numberFormatException) {
            return Weight.NA;
        }
    }

    private Height getHeight() {
        try {
            double cm = Double.parseDouble(heightField.getString());
            LengthUnit unit;
            switch (heightChoice.getSelectedIndex()) {
                case 0:
                    unit = LengthUnit.M;
                    break;
                case 1:
                    unit = LengthUnit.CM;
                    break;
                default:
                    unit = LengthUnit.M;
            }
            System.out.println("Height read: " + cm + " " + unit.toString());
            return new Height(cm, unit);
        } catch (NumberFormatException numberFormatException) {
            return (Height) Height.NA;
        }
    }

    private HeadPerimeter getHeadPerimeter() {
        try {
            double cm = Double.parseDouble(headPerimeterField.getString());
            LengthUnit unit;
            switch (headPerimeterChoice.getSelectedIndex()) {
                case 0:
                    unit = LengthUnit.CM;
                    break;
                case 1:
                    unit = LengthUnit.MM;
                    break;
                default:
                    unit = LengthUnit.CM;
            }
            System.out.println("Head Perimeter read: " + cm + " " + unit.toString());
            return new HeadPerimeter(cm, unit);
        } catch (NumberFormatException numberFormatException) {
            return (HeadPerimeter) HeadPerimeter.NA;
        }
    }

    private String formatCentile(double value) {
        String s = String.valueOf(value * 100);
        if (s.length() > 5) {
            s = s.substring(0, 5);
        }
        return s + "%";
    }

    private Sexo getSexo() {
        Patient.Sexo sexo;
        switch (sexChoice.getSelectedIndex()) {
            case 0:
                sexo = Patient.Sexo.VARÓN;
                break;
            case 1:
                sexo = Patient.Sexo.MUJER;
                break;
            default:
                sexo = Patient.Sexo.VARÓN;
        }
        return sexo;
    }

    private Patient createPatient() {
        Sexo sexo = getSexo();
        Age age = getAge();
        Weight weight = getWeight();
        Height height = getHeight();
        HeadPerimeter headPerimeter = getHeadPerimeter();
        return new Patient(sexo, age, height, headPerimeter, weight);
    }

    private void showResults(Patient patient) {
        try {
            double imc = patient.getIMC();
            String s = String.valueOf(imc);
            s = (s.length() > 6) ? s.substring(0, 6) : s;
            getIMCValueOutput().setText(s);
        } catch (DataNotFoundException ex) {
            ex.printStackTrace();
            showEmpty(getIMCValueOutput());
        }
        TablaPercentilos.Tipo[] tipo = TablaPercentilos.Tipo.values();
        for (int i = 0; i < tipo.length; i++) {
            if (patient.isTableAvailable(tipo[i])) {
                TablaPercentilos tabla = patient.getTabla(tipo[i]);
                double observed,
                        inputValue;
                try {
                    observed = patient.getValueFor(tipo[i]);
                    inputValue = patient.getInputValueFor(tipo[i]);
                    showCentile(tabla, observed, inputValue, getOutputStringItem(tipo[i]));
                } catch (InvalidUnitException ex) {
                    ex.printStackTrace();
                    showEmpty(getOutputStringItem(tipo[i]));
                } catch (PatientProfile.DataNotFoundException ex){
                    ex.printStackTrace();
                    showEmpty(getOutputStringItem(tipo[i]));
                }
            } else {
                showEmpty(getOutputStringItem(tipo[i]));
            }
        }
    }

    private StringItem getOutputStringItem(TablaPercentilos.Tipo tipo) {
        if (tipo == TablaPercentilos.Tipo.TALLA_A_EDAD) {
            return getHeightOutput();
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_EDAD) {
            return getWeightOutput();
        } else if (tipo == TablaPercentilos.Tipo.PC_A_EDAD) {
            return getHPOutput();
        } else if (tipo == TablaPercentilos.Tipo.IMC_A_EDAD) {
            return getIMCOutput();
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_TALLA) {
            return getWeightHeightOutput();
        } else {
            return null; // Should not happend
        }
    }

    private void showCentile(TablaPercentilos tabla, double observed, double value, StringItem outputStringItem) {
        double centile = tabla.getCentile(observed, value);
        outputStringItem.setText(formatCentile(centile));
    }

    private void showEmpty(StringItem outputStringItem) {
        outputStringItem.setText("--");
    }
}
