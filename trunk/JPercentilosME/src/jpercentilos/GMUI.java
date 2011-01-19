/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpercentilos;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class GMUI extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command nextCommand;
    private Command backCommand;
    private Command exitCommand1;
    private Form InputDataScreen;
    private StringItem stringItem;
    private ChoiceGroup sexChoice;
    private TextField heightField;
    private TextField ageField;
    private TextField weightField;
    private TextField headPerimeterField;
    private ChoiceGroup ageChoice;
    private ChoiceGroup heightChoice;
    private ChoiceGroup weightChoice;
    private ChoiceGroup headPerimeterChoice;
    private Form OutputDataScreen;
    private StringItem stringItem1;
    private StringItem stringItem2;
    private StringItem stringItem3;
    private StringItem stringItem4;
    private StringItem stringItem5;
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
        if (displayable == InputDataScreen) {//GEN-BEGIN:|7-commandAction|1|19-preAction
            if (command == exitCommand) {//GEN-END:|7-commandAction|1|19-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|2|19-postAction
                // write post-action user code here
            } else if (command == nextCommand) {//GEN-LINE:|7-commandAction|3|23-preAction
                // write pre-action user code here
                switchDisplayable(null, getOutputDataScreen());//GEN-LINE:|7-commandAction|4|23-postAction
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
            }//GEN-BEGIN:|7-commandAction|9|7-postCommandAction
        }//GEN-END:|7-commandAction|9|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|10|
    //</editor-fold>//GEN-END:|7-commandAction|10|

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
            InputDataScreen = new Form(null, new Item[] { getStringItem(), getSexChoice(), getAgeField(), getAgeChoice(), getHeightField(), getHeightChoice(), getWeightField(), getWeightChoice(), getHeadPerimeterField(), getHeadPerimeterChoice() });//GEN-BEGIN:|14-getter|1|14-postInit
            InputDataScreen.addCommand(getExitCommand());
            InputDataScreen.addCommand(getNextCommand());
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: nextCommand ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of nextCommand component.
     * @return the initialized component instance
     */
    public Command getNextCommand() {
        if (nextCommand == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            nextCommand = new Command("Siguiente", Command.OK, 0);//GEN-LINE:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return nextCommand;
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
            OutputDataScreen = new Form("Percentilos", new Item[] { getStringItem1(), getStringItem2(), getStringItem3(), getStringItem4(), getStringItem5() });//GEN-BEGIN:|24-getter|1|24-postInit
            OutputDataScreen.addCommand(getBackCommand());
            OutputDataScreen.addCommand(getExitCommand1());
            OutputDataScreen.setCommandListener(this);//GEN-END:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return OutputDataScreen;
    }
    //</editor-fold>//GEN-END:|24-getter|2|
    //</editor-fold>

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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ageField ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of ageField component.
     * @return the initialized component instance
     */
    public TextField getAgeField() {
        if (ageField == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            ageField = new TextField("Edad:", "", 7, TextField.NUMERIC);//GEN-BEGIN:|36-getter|1|36-postInit
            ageField.setLayout(ImageItem.LAYOUT_DEFAULT);
            ageField.setPreferredSize(-1, -1);//GEN-END:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return ageField;
    }
    //</editor-fold>//GEN-END:|36-getter|2|
    //</editor-fold>



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: heightField ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of heightField component.
     * @return the initialized component instance
     */
    public TextField getHeightField() {
        if (heightField == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            heightField = new TextField("Talla:", "", 6, TextField.DECIMAL);//GEN-LINE:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return heightField;
    }
    //</editor-fold>//GEN-END:|38-getter|2|
    //</editor-fold>



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: weightField ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of weightField component.
     * @return the initialized component instance
     */
    public TextField getWeightField() {
        if (weightField == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            weightField = new TextField("Peso:", "", 6, TextField.DECIMAL);//GEN-LINE:|40-getter|1|40-postInit
            // write post-init user code here
        }//GEN-BEGIN:|40-getter|2|
        return weightField;
    }
    //</editor-fold>//GEN-END:|40-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: headPerimeterField ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of headPerimeterField component.
     * @return the initialized component instance
     */
    public TextField getHeadPerimeterField() {
        if (headPerimeterField == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            headPerimeterField = new TextField("PC:", "", 6, TextField.ANY);//GEN-LINE:|41-getter|1|41-postInit
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
            ageChoice.append("Choice Element 1", null);
            ageChoice.append("Choice Element 2", null);
            ageChoice.append("Choice Element 3", null);
            ageChoice.setLayout(ImageItem.LAYOUT_DEFAULT);
            ageChoice.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);
            ageChoice.setSelectedFlags(new boolean[] { false, false, false });//GEN-END:|43-getter|1|43-postInit
            // write post-init user code here
        }//GEN-BEGIN:|43-getter|2|
        return ageChoice;
    }
    //</editor-fold>//GEN-END:|43-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: heightChoice ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of heightChoice component.
     * @return the initialized component instance
     */
    public ChoiceGroup getHeightChoice() {
        if (heightChoice == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            heightChoice = new ChoiceGroup(null, Choice.POPUP);//GEN-BEGIN:|47-getter|1|47-postInit
            heightChoice.append("Choice Element 1", null);
            heightChoice.append("Choice Element 2", null);
            heightChoice.setSelectedFlags(new boolean[] { false, false });//GEN-END:|47-getter|1|47-postInit
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
            weightChoice.append("Choice Element 1", null);
            weightChoice.append("Choice Element 2", null);
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
            headPerimeterChoice.append("Choice Element 1", null);
            headPerimeterChoice.append("Choice Element 2", null);
            headPerimeterChoice.setSelectedFlags(new boolean[] { false, false });//GEN-END:|53-getter|1|53-postInit
            // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return headPerimeterChoice;
    }
    //</editor-fold>//GEN-END:|53-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of stringItem1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            stringItem1 = new StringItem("stringItem1", null);//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return stringItem1;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initiliazed instance of stringItem2 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            stringItem2 = new StringItem("stringItem2", null);//GEN-LINE:|57-getter|1|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return stringItem2;
    }
    //</editor-fold>//GEN-END:|57-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem3 ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initiliazed instance of stringItem3 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem3() {
        if (stringItem3 == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            stringItem3 = new StringItem("stringItem3", null);//GEN-LINE:|58-getter|1|58-postInit
            // write post-init user code here
        }//GEN-BEGIN:|58-getter|2|
        return stringItem3;
    }
    //</editor-fold>//GEN-END:|58-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem4 ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of stringItem4 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem4() {
        if (stringItem4 == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            stringItem4 = new StringItem("stringItem4", null);//GEN-LINE:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return stringItem4;
    }
    //</editor-fold>//GEN-END:|59-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem5 ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of stringItem5 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem5() {
        if (stringItem5 == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            stringItem5 = new StringItem("stringItem5", null);//GEN-LINE:|60-getter|1|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|2|
        return stringItem5;
    }
    //</editor-fold>//GEN-END:|60-getter|2|



    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
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

}
