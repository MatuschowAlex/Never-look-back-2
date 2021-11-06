// Farbe
import java.awt.*;
// Hintergrund


// Fenster Einstellungen
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

// Tittel Einstellungen

// Schrift Einstellungen

// Größe des Textes
import java.awt.event.ActionListener;  
import java.awt.event.ActionEvent;
// Start Button


// MainTextPanel


public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    JButton startButton, choice1, choice2, choice3, choice4;
    Font normalFont = new Font("Times new Roman", Font.PLAIN, 28);
    JTextArea mainTextArea;
    int playerHP;
    String weapon, position;
    String A;

    ChoiceHandler choiceHandler = new ChoiceHandler();
    TitleScreenHandler tsHandler = new TitleScreenHandler();


    public static void main(String[] args) {

        new Game();
    }


    public Game() {

        // Fenster
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        // SpielName Fenster
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);


        // Beschrifttung vom Tittel Fenster
        titleNameLabel = new JLabel("Never look back");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        // Start Button Einstelunngen 1
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        // Start Button Beschriftungen
        startButton = new JButton("Play Now");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        // Hinzügen des Labels
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        // Sichtbarkeit des Fensters
        window.setVisible(true);
    }

    public void createGameScreen() {

        // letztes Fenster verschwinden lassen
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);


        // Einstellungen für zweites Fenster
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);


        // 1.2 Fenster
        mainTextArea = new JTextArea("You wake up in front of a castle.\nA Guard is standing in front of the castle.\nWhat do you want to do? ");
        mainTextArea.setBounds(100, 100, 600, 350);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);


        // Einstellung der 4 Buttons
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(50, 350, 800, 400);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);


        // Button 1
        choice1 = new JButton("look around you");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);


        // Button 2
        choice2 = new JButton("");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        // Button 3
        choice3 = new JButton("");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        // Button 4
        choice4 = new JButton("");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);


        // HP
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 650, 90);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        // Weapon
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();
    }

    public void playerSetup() {

        // HP + Weapon zu Variable machen
        playerHP = 15;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();

    }

    public void townGate() {

        //1 Interaktion aufwachen

        position = "townGate";
        mainTextArea.setText("You wake up in front of a castle.\nA Guard is standing next to the Town gate.\nWhat you want to do?");
        choice1.setText("Talk to him");
        choice2.setText("Fight him");
        choice3.setText("Leave");
        choice4.setText("Take a moment to think");
    }

    public void talkGuard() {

        // Guard Antwortet
        position = "talkGuard";
        mainTextArea.setText("Guard: I never saw you here before.\nWhat do you want?");
        choice1.setText("Ask if you can go in");
        choice2.setText("Attack him");
        choice3.setText("Try to take his weapon");
        choice4.setText("Run away");
    }

    public void attackGuard() {

        // Guard Attackiert dich
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey dont be stupid!\n\nThe Stranger fought you back and hit you hard.\n (Your receive 3 damage)");
        playerHP = playerHP - 3;
        hpLabelNumber.setText("" + playerHP);

        // Entscheidung treffen nach Damage
        choice1.setText("Apologize and Talk to the Guard again");
        choice2.setText("Attack the Guard Again");
        choice3.setText("Take a moment to think");
        choice4.setText("RUN away");

    }

    public void attackGuard2() {

        // Guard Attackiert dich
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey dont be stupid!\n\nThe Stranger fought you back and hit you hard.");

        // Entscheidung treffen nach Damage
        choice1.setText("Apologize and Talk to the Guard again");
        choice2.setText("Attack the Guard Again");
        choice3.setText("Take a moment to think");
        choice4.setText("RUN away");

    }

    public void RunAway() {

        //Run away for sure
        position = "RunAway";
        mainTextArea.setText("I knew you would end up here!\nDont worry there is a special\nplace for people who ran away");

        choice1.setText("See special place");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void SP() {

        //Special place for runners
        position = "SP";
        window.setVisible(false);


    }

    public void moment2() {

        //rethink your IDEA
        position = "moment2";
        mainTextArea.setText("Here are your Options:\n1.Apologize and Talk\n2.Attack him again\nRun away");

        choice1.setText("I know what I want to do");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void Attack2() {

        //Guard entwickelt sich
        position = "Attack2";
        mainTextArea.setText("Guard:You have the audacity to attack me again?\nNow you will see how it feels to disrespect me." +
                "\n(The Guard takes his Secret Sword and cuts your head off)" + "\nYou lost all your HP");
        playerHP = playerHP - 12;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("YOU HAVE FAILED!");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void CloseGame() {

        //Game schließt sich
        position = "CloseGame";
        window.setVisible(false);


    }

    public void crossRoad() {

        //Aufgeben ist keine Option
        position = "crossRoad";
        mainTextArea.setText("Giving up is not an Option.\nTry to take all your faith and move forward.");

        choice1.setText("I will try from the start");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void moment() {

        //Take a moment to think
        position = "moment";
        mainTextArea.setText("This could decide your future: \nTalk to the Guard\nAttack him\nOr even try to leave?");

        choice1.setText("I know what I want to do");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void InsideTown() {

        //Asking if you can go inside the Town
        position = "InsideTown";
        mainTextArea.setText("You have to Answer the following question:\nWhat made a knight different from other\nsoldiers during the Middle Ages?");

        choice1.setText("He was able to slay Dragon");
        choice2.setText("He knew which princess to marry");
        choice3.setText("He knew how to fight on a horseback");
        choice4.setText("I dont know");
    }

    //CASE UND SWITCH
    public void wrong1() {

        // erste falsche Antwort
        position = "wrong1";
        mainTextArea.setText("OPS!You decided wrong!\nBy the Law of the Town you must be punished!" + "\nA Guard throw a potato at your head!" +
                "\nYou lost 2 HP!");
        playerHP = playerHP - 2;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("Go back and Try again");
        choice2.setText("Try to fight with the Guard");
        choice3.setText("Take a moment to think");
        choice4.setText("RUN");
    }

    //CASE UND SWITCH
    public void wrong2() {

        // Zweite falsche Antwort
        position = "wrong2";
        mainTextArea.setText("OPS!You decided wrong!\nBy the Law of the Town you must be punished!" + "\nA Guard throw a potato at your head!" +
                "\nYou lost 2 HP!");
        playerHP = playerHP - 2;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("Go back and Try again");
        choice2.setText("Try to fight with the Guard");
        choice3.setText("Take a moment to think");
        choice4.setText("RUN");
    }

    //CASE UND SWITCH
    public void wrong3() {

        // Zweite falsche Antwort
        position = "wrong3";
        mainTextArea.setText("OPS!You decided wrong!\nBy the Law of the Town you must be punished!" + "\nA Guard throw a potato at your head!" +
                "\nYou lost 2 HP!");
        playerHP = playerHP - 2;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("Go back and Try again");
        choice2.setText("Try to fight with the Guard");
        choice3.setText("Take a moment to think");
        choice4.setText("RUN");
    }

    public void Brother() {

        //Hilfestellung
        position = "Brother";
        mainTextArea.setText("When I was 6 and Brother was half my age\nthat means he is 3");

        choice1.setText("Okay so he is just 3 years younger, understood");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void moment3() {

        //rethink answer to go inside
        position = "moment3";
        mainTextArea.setText("Here are your Options:\n1.He knows how to slay Dragon\n2.He knew which princess to marry\n3.He knew how to fight on a horseback\n");

        choice1.setText("I know what I want to do");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void Horseback() {

        //Correct Answer + dont go inside the Town hinzufügen
        position = "Horseback";
        mainTextArea.setText("Guard:You are correct!\n(You can see the gate opening)\nBe careful who you talk to");

        choice1.setText("Alright thank you so much");
        choice2.setText("What do you mean by that");
        choice3.setText("Dont go inside the Town");
        choice4.setText("Attack the Guard");


    }

    public void ARS() {

        //Dont go inside the Town
        position = "ARS";
        mainTextArea.setText("An Archer from the castle saw how you didnt went inside the Town.\nHe finds you suspicious looking\n" +
                "and shoots and Arrow ind your head!"+ "\nYou lost 6 HP");
        playerHP = playerHP - 6;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("Try to take the Arrow out and cover it with your hand");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void TakeOUT() {

        //Pfeil rausnehmen

        position = "TakeOUT";
        mainTextArea.setText("You have sucessfully removed the Arrow.\nBut the hole was to big to cover it with your hand.");
        playerHP = playerHP - 6;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("I now understand that I shouldnt try to go back!");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void Stp() {

        //Blutverlust
        position = "STp";
        window.setVisible(false);

    }


    public void What() {

        //What do you mean by that?
        position = "What";
        mainTextArea.setText("Guard:Some creatures in the Town are different and maybe a bit dangerous");

        choice1.setText("Thanks for the heads up!I will go in.");
        choice2.setText("I cant do this");
        choice3.setText("");
        choice4.setText("");

    }
    public void Cant(){

        //I cant do this
        position = "Cant";
        mainTextArea.setText("The Guard sees you are scared\nand not ready to go inside" +
                "\nGuard:Weaklings wont surwive around here\nHe put you to sleep.You cant move");


        choice1.setText("I need rethink my actions.\nI will start from the beginning");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void CantN(){

        //NEW Start
    }

    public void Sign() {

        //Sign of Math
        position = "Sign";
        mainTextArea.setText("There is a Sign right after you come in that says:"
                + "\nMessage for everybody who wants to pass this town!\nSolve this Problem and you will be granted a price!"
                + "\nWhen I was 6 my brother was half my age. I am now 36 years old, how hold is my brother?");

        choice1.setText("36");
        choice2.setText("28");
        choice3.setText("33");
        choice4.setText("18");
    }

    public void SignAn() {

        //Richtige Antwort auf Sign
        position = "SignAn";
        mainTextArea.setText("This is correct!\nA little kid comes running to you and gives you an\nApple.");

        choice1.setText("eat it");
        choice2.setText("throw it at the child");
        choice3.setText("put it in your pocket");
        choice4.setText("dont take it");

    }

    public void PutPocket(){

        //put it in your pocket

        position = "PutPocket";
        mainTextArea.setText("You tried to put the apple in your pocket.\nThere is no pocket and the apple falls down.");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void NextWA(){

        //Apfel auf Kind geschmießen
        position = "NextWA";
        mainTextArea.setText("HEADSHOT!You hit the Kid perfectly on the head." + "\nUnfortunately the father of the kid is a Wizard" +
                "\nWizard:HOW CAN YOU THROW THINGS AT A CHILD??"+"\nHe casts a spell of fire on you and you take 999\nDamage. You are burnt to ashes!");

        playerHP = playerHP -999;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("Think about my actions and be nicer next time.");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void EatApple() {

        //Appfel essen
        position = "EatApple";
        mainTextArea.setText("The Apple restored 4 HP of yours");
        playerHP = playerHP + 4;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("See whats next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void Next(){

        //last Puzzle
        position = "Next";
        mainTextArea.setText("In front of you is a crossroad:\nThe left side looks safe, people are walking there." +
                "\nThe right side looks very empty and scary.\nWhich side do you choose?");

        choice1.setText("Go left");
        choice2.setText("Go right");
        choice3.setText("RUN");
        choice4.setText("");
    }

    public void left(){

        //left side
        position = "left";
        mainTextArea.setText("You have run into a trap!\nAll the people on the road run to\ntowards you and take all your things."+
                "\nThe last person shoots you in the head.\nYou lost 100 HP");

        playerHP = playerHP -100;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("Now I know which path I should take");
        choice2.setText("I still dont know what I should do");
        choice3.setText("");
        choice4.setText("");

    }

    public void leftleft(){

        //left left side
        position = "leftleft";
        mainTextArea.setText("If you ended up here to read this,\nyou clearly need help,please\nread more books!");

        choice1.setText("Yes I will");
        choice2.setText("Yes I will");
        choice3.setText("Yes I will");
        choice4.setText("Yes I will");
    }

    public void right(){

        //right side
        position = "right";
        mainTextArea.setText("A Woman is running towards you, and hugs you.\nWife:\nFinally you home I thought you are dead" +"\nappraently you lost your memory and now \nyou" +
                " found your home" );

        choice1.setText("YOU Made it to the End");
        choice2.setText("Thanks for playing along");
        choice3.setText("This was my first project");
        choice4.setText("Be strong and always come home");

    }
    public void AlexM(){

        //credits ALEX
        position = "AlexM";
        mainTextArea.setText("My name is Alexander Matuschow.\n I am 24 years old and this was\nmy first project ever." +
                "\nI hope you someohow enjoyed it");

        choice1.setText("This wont be the last Game");
        choice2.setText("There will be much more");
        choice3.setText("It will get much better");
        choice4.setText("Never look back only move forward!");
    }

    public void TakeWeapon() {


        //Take his Weapon
        position = "TakeWeapon";
        mainTextArea.setText("Guard:\nCongratulations! You earned a new weapon!\nNow you have a Knight Sword\nThe Guard didnt even notice");

        weapon = "Knight Sword";
        weaponLabelName.setText(weapon);

        choice1.setText("Talk with the Guard again");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            createGameScreen();


        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Möglichkeit zu entscheiden

            String yourChoice = event.getActionCommand();

            // Vorgabe für die Postition des Spielers
            switch (position) {
                // Aufwachen vor dem Schloss
                case "townGate":
                    switch (yourChoice) {
                        case "c1": talkGuard(); break;
                        case "c2": attackGuard(); break;
                        case "c3": crossRoad(); break;
                        case "c4": moment(); break;
                    }
                    // Notwending um Nächstes fesnter auszuführen
                    break;
                // Spreche mit dem Guard !!!! Run Away einfügen und Weapon Klauen!!!
                case "talkGuard":
                    switch (yourChoice) {
                        case "c1": InsideTown(); break;
                        case "c2": attackGuard(); break;
                        case "c3": TakeWeapon(); break;
                        case "c4": crossRoad(); break;
                    }
                    // Notwending um Nächstes fesnter auszuführen
                    break;
                // Attackiere den Guard
                case "attackGuard":
                    switch (yourChoice) {
                        case "c1": talkGuard(); break;
                        case "c2": Attack2(); break;
                        case "c3": moment2(); break;
                        case "c4": RunAway(); break;

                    }
                    break;
                //Rethink your Actions part 2
                case "moment2":
                    switch (yourChoice) {
                        case "c1": attackGuard2(); break;
                    }
                    break;
                // Aufgeben ist keine Option
                case "crossRoad":
                    switch (yourChoice) {
                        case "c1": townGate();break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "moment":
                    switch (yourChoice) {
                        case "c1": townGate(); break;

                    }
                    break;
                // Asking if you can go Inside
                case "InsideTown":
                    switch (yourChoice) {
                        case "c1": wrong1(); break;
                        case "c2": wrong2(); break;
                        case "c3": Horseback(); break;
                        case "c4": RunAway(); break;

                    }
                    break;
                case "wrong1":
                    switch (yourChoice) {
                        case "c1": InsideTown(); break;
                        case "c2": Attack2(); break;
                        case "c3": moment3(); break;
                        case "c4": RunAway(); break;
                    }
                    break;
                case "wrong2":
                    switch (yourChoice) {
                        case "c1": InsideTown(); break;
                        case "c2": Attack2(); break;
                        case "c3": moment3(); break;
                        case "c4": RunAway(); break;
                    }
                    break;
                case "wrong3":
                    switch (yourChoice) {
                        case "c1": Sign(); break;
                        case "c2": Attack2(); break;
                        case "c3": Brother(); break;
                        case "c4": RunAway(); break;
                    }
                    break;
                case "Brother":
                    switch (yourChoice) {
                        case "c1": Sign(); break;
                        case "c2":
                        case "c3":
                        case "c4":
                    }
                    break;
                case "moment3":
                    switch (yourChoice) {
                        case "c1": InsideTown(); break;
                    }
                    break;
                // Waffe Klauen
                case "TakeWeapon":
                    switch (yourChoice) {
                        case "c1": talkGuard(); break;
                    }
                    break;
                // Richtige Antwort auf Frage vom Guard
                case "Horseback":
                    switch (yourChoice) {
                        case "c1": Sign(); break;
                        case "c2": What(); break;
                        case "c3": ARS(); break;
                        case "c4": attackGuard(); break;
                    }
                    break;
                // Bogenschütze schießt auf dich
                case "ARS":
                    switch (yourChoice) {
                        case "c1": TakeOUT(); break;
                        case "c2":
                        case "c3":
                        case "c4":
                    }
                 break;
                    //TakeOUT
                case "TakeOUT":
                    switch (yourChoice) {
                        case "c1": SP(); break;
                        case "c2":
                        case "c3":
                        case "c4":
                    }
                    break;
                    case "Sign":
                        switch (yourChoice) {
                            case "c1": wrong3(); break;
                            case "c2": wrong3(); break;
                            case "c3": SignAn(); break;
                            case "c4": wrong3(); break;
                            }
                            break;
                        case "SignAn":
                            switch (yourChoice) {
                                case "c1": EatApple(); break;
                                case "c2": NextWA(); break;
                                case "c3":
                                case "c4": Next(); break;
                            }
                        break;
                    case "EatApple":
                        switch (yourChoice){
                            case "c1": Next(); break;
                            case "c2":
                            case "c3":
                            case "c4":
                        }
                        break;
                    case "Next":
                        switch (yourChoice){
                            case "c1": left(); break;
                            case "c2": right(); break;
                            case "c3": RunAway(); break;
                            case "c4":
                        }
                    break;
                    case "right":
                        switch(yourChoice){
                            case "c1": AlexM(); break;
                            case "c2": AlexM(); break;
                            case "c3": AlexM(); break;
                            case "c4": AlexM(); break;
                        }
                    break;
                    case "AlexM":
                        switch(yourChoice){
                            case "c1": CloseGame(); break;
                            case "c2": CloseGame(); break;
                            case "c3": CloseGame(); break;
                            case "c4": CloseGame(); break;
                        }
                        break;
                    case "left":
                        switch (yourChoice){
                            case "c1": CloseGame(); break;
                            case "c2": leftleft(); break;
                        }
                        break;
                    case "leftleft":
                        switch(yourChoice){
                            case "c1": CloseGame(); break;
                            case "c2": CloseGame(); break;
                            case "c3": CloseGame(); break;
                            case "c4": CloseGame(); break;
                        }
                        break;
                        case "NextWA":
                            switch(yourChoice){
                                case "c1": SP(); break;

                            }
                            break;
                        case "What":
                            switch (yourChoice) {
                                case "c1": Sign(); break;
                                case "c2": Cant(); break;
                                case "c3":
                                case "c4":
                            }
                        break;
                        //Cant
                        case "Cant":
                            switch (yourChoice){
                                case "c1": townGate();break;
                                case "c2":
                                    case "c3":
                                  case "c4":
                              }
                            break;
                        case "Attack2":
                            switch (yourChoice) {
                                case "c1": CloseGame(); break;
                            }
                            break;
                        case "attackGuard2":
                            switch (yourChoice) {
                                case "c1": InsideTown(); break;
                                case "c2": Attack2(); break;
                                case "c3": moment2(); break;
                                case "c4": RunAway(); break;
                            }
                            break;
                        case "RunAway":
                            switch (yourChoice) {
                                case "c1": SP(); break;
                            }
                            break;
                    }
            }
        }
    }

