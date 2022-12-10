package com.baseball.part4githubupload;

//* *****************************************************************************************
// * Title: BaseballDriverFX
// * Author: Sean Laverty
// * Course Section: CMIS202-ONL1 (Seidel) Fall 2022
// * File: BaseballDriverFX.java
// * Description: Runs the application through the start method, setting the scene and stage.
// * ****************************************************************************************

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class BaseballDriverFX extends Application {

    // ComboBox's for choice selection
    private static ComboBox<String> comboBox1;
    private static ComboBox<String> comboBox2;

    //Text area for displaying text
    private static TextArea taData = new TextArea();
    private static TextArea taData1;
    private static TextArea taData2;
    private static TextArea taData3;
    private static TextArea taData4;
    private static TextArea taData5;
    private static TextArea taData6;
    private static TextArea taData7;
    private static TextArea taData8;
    private static TextArea taData9;
    private static TextArea taData10;
    private static TextArea taData11;
    private static TextArea taData12;
    private static TextArea taData13;
    private static TextArea taData14;
    private static TextArea taData15;

    // Buttons
    private static Button btSelect1;
    private static Button btSelect2;

    // GridPane
    private static GridPane gp1;
    private static GridPane gp2;

    //Single dimensional array that represents the Opening Menu
    private static String[] menuOne = {
            "SortPlayers", "SavePlayer", "ViewSavedPlayer", "PlayerListViewMapDesign",
            "ArrayStackTest","LinkedStackTest","PlayerLinkedList","SearchPlayer", "BST/MultiTread"};

    // Single dimensional array that represents hitters for testing
    private static Player[] hitters = {
            new Hitter("Adley Rutschman  ", "  C", 101, 398),
            new Hitter("Gunner Henderson ", " 3B", 30, 116),
            new Hitter("Cedric Mullins   \t", " CF", 157, 608),
            new Hitter("Ryan Mountcastle ", " 1B", 139, 555),
            new Hitter("Anthony Santander", "RF", 138, 574),
            new Hitter("Kyle Stowers     \t", "OF", 23, 91),
            new Hitter("Terrin Vavra     \t", "UT", 23, 89),
            new Hitter("Ryan McKenna     ", "OF", 37, 156),
            new Hitter("Austin Hays      \t", "LF", 134, 535),
            new Hitter("Ramon Urias      \t", "2B", 100, 403),
            new Hitter("Jorge Mateo      \t", "SS", 109, 494)};

    // Player objects used for testing (Hitters)
    private static Player adely = new Hitter("Adley Rutschman\t", " C\t", 101, 398);
    private static Player gunner = new Hitter("Gunner Henderson\t", "3B\t", 30, 116);
    private static Player cedric = new Hitter("Cedric Mullins\t\t", "CF\t", 157, 608);
    private static Player mountie = new Hitter("Ryan Mountcastle\t", "1B\t", 139, 555);
    private static Player tony = new Hitter("Anthony Santander\t", "RF\t", 138, 574);
    private static Player stowers = new Hitter("Kyle Stowers\t\t", "OF\t", 23, 91);
    private static Player vavra = new Hitter("Terrin Vavra\t\t", "UT\t", 23, 89);
    private static Player hays = new Hitter("Austin Hays\t\t", "LF\t", 134, 535);
    private static Player urias = new Hitter("Ramon Urias\t\t", "2B\t", 100, 403);
    private static Player mateo = new Hitter("Jorge Mateo\t\t", "SS\t", 109, 494);
    private static Player mckenna = new Hitter("Ryan McKenna\t\t", "OF\t", 37, 156);

    // Single dimensional array that represents pitchers for testing
    private static Player[] pitchers = {
            new Pitcher("Jorden Lyles    ", "SP", 88, 179.0),
            new Pitcher("Dean Kremer     ", "SP", 45, 125.1),
            new Pitcher("Kyle Bradish    ", "SP", 64, 117.2),
            new Pitcher("Spencer Watkins", "SP", 55, 105.1),
            new Pitcher("Tyler Wells     ", "SP", 49, 103.2),
            new Pitcher("Austin Voth     ", "SP", 28, 83.0),
            new Pitcher("Dylan Tate      ", "RP", 25, 73.2),
            new Pitcher("Bryan Baker     ", "RP", 27, 69.2),
            new Pitcher("Felix Bautista   ", "CL", 16, 65.2),
            new Pitcher("Cionel Perez    ", "RP", 9, 57.2),
            new Pitcher("DL Hall         ", "RP", 9, 13.2)};

    // Player objects used for testing (Pitchers)
    private static Player lyles =
            new Pitcher("Jorden Lyles\t", "SP\t", 88, 179.0);
    private static Player kremer =
            new Pitcher("Dean Kremer\t", "SP\t", 45, 125.1);
    private static Player bradish =
            new Pitcher("Kyle Bradish\t", "SP\t", 64, 117.2);
    private static Player watkins =
            new Pitcher("Spencer Watkins\t", "SP\t", 55, 105.1);
    private static Player wells =
            new Pitcher("Tyler Wells\t\t", "SP\t", 49, 103.2);
    private static Player voth =
            new Pitcher("Austin Voth\t", "SP\t", 28, 83.0);
    private static Player tate =
            new Pitcher("Dylan Tate\t\t", "RP\t", 25, 73.2);
    private static Player baker =
            new Pitcher("Bryan Baker\t", "RP\t", 27, 69.2);
    private static Player felix =
            new Pitcher("Felix Bautista\t","CL\t", 16, 65.2);
    private static Player perez =
            new Pitcher("Cionel Perez\t", "RP\t", 9, 57.2);
    private static Player hall =
            new Pitcher("DL Hall\t\t", "RP\t", 9, 13.2);

    @Override
    public void start(Stage stage) throws IOException {
        // Hitter menu options created form combobox1
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll(menuOne);
        comboBox1 = new ComboBox<>(options);
        comboBox1.setPromptText("Hitter");
        comboBox1.setItems(options);
        comboBox1.setEditable(false);

        // Pitcher menu options created form combobox2
        ObservableList<String> options1 = FXCollections.observableArrayList();
        options1.addAll(menuOne);
        comboBox2 = new ComboBox<>(options1);
        comboBox2.setPromptText("Pitcher");
        comboBox2.setItems(options1);
        comboBox2.setEditable(false);

//        ObservableList<String> options2 = FXCollections.observableArrayList();
//        options2.addAll(menuOne);
//        comboBox3 = new ComboBox<>(options2);
//        comboBox3.setPromptText("Other");
//        comboBox3.setItems(options2);
//        comboBox3.setEditable(false);

        // HBox used for the two comboBox choice menus
        HBox hBox = new HBox();
        hBox.setSpacing(10);
//        hBox.getChildren().addAll(comboBox1,comboBox2, comboBox3);
        hBox.getChildren().addAll(comboBox1,comboBox2);

        // Flow plane used for the buttons to activate the comboBox selections
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(0, 10, 20, 15));
        flowPane.setHgap(10);
        flowPane.setAlignment(Pos.CENTER);
        btSelect1 = new Button("Select Hitter");
        btSelect2 = new Button("Select Pitcher");
        flowPane.getChildren().addAll(btSelect1, btSelect2);

//------------------------------------------------------------------------------

        // Button selection for the hitter menu (setOnAction)
        btSelect1.setOnAction(actionEvent -> {

            // gets the selection from the comboBox
            String value = comboBox1.getSelectionModel().getSelectedItem();

            // wraps the data in taData textArea
            taData.setWrapText(true);

            // Selection one from the hitter calls the sort players option and activates the code inside
            if (Objects.equals(value, "SortPlayers")){

                // Calls the FxUtility class and the getYesNo method asks the user
                // if they want to sort the list of player from the singleD hitter array
                // by there batting average
                FxUtility.getYesNo("Sorting BY: ", "Do you want the Hitters" +
                        "\nsorted by their AVG");

                //taData.setText(value + "\nSortedByAverage:\n");

                // Sets the value selection at the top of the taData textArea
                taData.setText(value);

                // Calls the SortingUtility and the mergeSort method to sort the hitters by
                // there batting average
                SortingUtility.mergeSort(hitters, new HitterAverageComparator());

                // Use the list interface to create an arraylist to add the hitters array of players
                List<Player> hitterList1 = new ArrayList<>(Arrays.stream(hitters).toList());

                // Returns an array containing all the elements in this list in proper sequence
                // With the proper size
                Object[] hitter = hitterList1.toArray(new Player[hitterList1.size()]);

                // Appends the array containing all the elements in this list in proper sequence
                // To the TextArea taData
                for (Object bat: hitter) {
                    taData.appendText("\n" + bat.toString());
                }

                // Appends the size of the array containing all the elements
                taData.appendText("\nSize Of List: " + hitter.length);

                // Create a scene and place the pane in the stage
                Scene scene = new Scene(taData);
                Stage stage1 = new Stage();
                stage1.setScene(scene); // Place the scene in the stage
                stage1.setWidth(400);
                stage1.setHeight(500);
                stage1.show(); // Display the stage

            }//Objects.equals(value, "SortPlayers").

            // Selection two from the hitter ComboBox calls the SavePlayer
            // option and activates the code inside
            else if (Objects.equals(value, "SavePlayer")){

                // Calls the FxUtility class and the getYesNo method asks the user
                // if they want to save the Hitters list
                FxUtility.getYesNo("SaveHitters", "Do you want to save the Hitters?");

                // Create an output stream for file o.dat
                try (ObjectOutputStream outputStream = new ObjectOutputStream(
                        new BufferedOutputStream(new FileOutputStream("o.dat", true)))) {

                    // Write hitters to the object output stream
                    outputStream.write(hitters.length);

                    // Catches the exceptions
                } catch (FileNotFoundException x) {
                    x.printStackTrace();
                } catch (IOException xx) {
                    System.out.println(" IO Error ");
                }
            } // Objects.equals(value, "SavePlayer").

            // Selection three from the hitter ComboBox calls the ViewSavedPlayer
            // option and activates the code inside
            else if (Objects.equals(value, "ViewSavedPlayer")){

                // Calls the FxUtility class and the getYesNo method asks the user
                // if they want to load the saved hitters list
                FxUtility.getYesNo("SavedHitters",
                        "Do you want to load the saved Hitters?");

                // Create an input stream for file o.dat
                try (ObjectInputStream inputStream = new ObjectInputStream(
                        new BufferedInputStream(new FileInputStream("o.dat")))) {

                    // create a new text area from the existing one to append the save sorted
                    // hitters to the TextArea taData
                    taData = new TextArea(value);

                    //  Appends a title for the text area
                    taData.appendText("Loaded Batters\n");

                    //calls the display method to append the sorted list to the new taData textArea
                    display(hitters);

                    // Append the size of the list to the text area
                    taData.appendText("Size Of List: " + hitters.length);
                    // Create a scene and place the pane in the stage
                    Scene scene = new Scene(taData);
                    Stage stage1 = new Stage();
                    stage1.setScene(scene);// Place the scene in the stage
                    stage1.setWidth(400);
                    stage1.setHeight(480);
                    stage1.show();// Display the stage

                    // Catches the exceptions
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } // Objects.equals(value, "ViewSavedPlayer")

            // Selection four from the hitter ComboBox calls the PlayerListViewMapDesign
            // option and activates the code inside
            else if(Objects.equals(value, "PlayerListViewMapDesign")){

                // Calls the listViewHittersMap() method
                listViewHittersMap();

            } // Objects.equals(value, "PlayerListViewMapDesign")

            // Selection five from the hitter ComboBox calls the ArrayStackTest
            // option and activates the code inside
            else if (Objects.equals(value, "ArrayStackTest")){

                // initializes taData1
                taData1 = new TextArea();

                // Calls the ArrayStack and creates an ArrayStack object with a capacity of 10
                ArrayStack stack = new ArrayStack(10);

                // Pushes the player objects into the stack
                stack.push(adely);
                stack.push(gunner);
                stack.push(cedric);
                stack.push(mountie);
                stack.push(tony);
                stack.push(stowers);
                stack.push(vavra);
                stack.push(hays);
                stack.push(urias);
                stack.push(mateo);

                // pops the player objects out of the array stack and appends them to the textArea
                for(int i = stack.top-1; i >= 0; i--){
                    taData1.appendText(stack.pop() + "\n");
                }

                // Create a scene and place the pane in the stage
                Scene scene = new Scene(taData1);
                Stage stage1 = new Stage();
                stage1.setScene(scene);// Place the scene in the stage
                stage1.setWidth(400);
                stage1.setHeight(480);
                stage1.show();// Display the stage

            } // Objects.equals(value, "ArrayStackTest")

            // Selection six from the hitter ComboBox calls the LinkedStackTest
            // option and activates the code inside
            else if (Objects.equals(value, "LinkedStackTest")){

                // initializes taData2
                taData2 = new TextArea();

                // creates a linkedStack object to push players into the linkedStack
                LinkedStack linkedStack = new LinkedStack();

                // Pushes the player objects into the stack
                linkedStack.push(adely);
                linkedStack.push(gunner);
                linkedStack.push(cedric);
                linkedStack.push(mountie);
                linkedStack.push(tony);
                linkedStack.push(stowers);
                linkedStack.push(vavra);
                linkedStack.push(hays);
                linkedStack.push(urias);
                linkedStack.push(mateo);

                // pops the player objects out of the array stack and appends them to the textArea
                for (Player player : linkedStack.stack) {
                    taData2.appendText(player + "\n");
                }

                // Create a scene and place the pane in the stage
                Scene scene = new Scene(taData2);
                Stage stage1 = new Stage();
                stage1.setScene(scene);// Place the scene in the stage
                stage1.setWidth(400);
                stage1.setHeight(480);
                stage1.show(); // Display the stage

            } // Objects.equals(value, "LinkedStackTest")

            // Selection seven from the hitter ComboBox calls the PlayerLinkedList
            // option and activates the code inside
            else if (Objects.equals(value, "PlayerLinkedList")){

                // initializes taData2
                taData3 = new TextArea();

                // Creates a PlayerLinkedList object
                PlayerLinkedList playerLinkedList = new PlayerLinkedList();

                // testings add to front
                playerLinkedList.addToFront(adely);
                playerLinkedList.addToFront(gunner);
                playerLinkedList.addToFront(cedric);
                playerLinkedList.addToFront(mountie);
                // testings add to end
                playerLinkedList.addToEnd(tony);
                playerLinkedList.addToEnd(stowers);
                playerLinkedList.addToEnd(vavra);
                // testing add before
                playerLinkedList.addBefore(hays, cedric);
                playerLinkedList.addBefore(urias, mountie);
                playerLinkedList.addBefore(mateo, vavra);

                // Appends the players from te doubly linked list to the textArea
                PlayerNode current = playerLinkedList.head;
                taData3.appendText("HEAD -> \n\t ");
                while(current !=null){
                    taData3.appendText(current + " <=> ");
                    current = current.getNext();
                }
                taData3.appendText(" null ");

                // Create a scene and place the pane in the stage
                Scene scene = new Scene(taData3);
                Stage stage1 = new Stage();
                stage1.setScene(scene); // Place the scene in the stage
                stage1.setWidth(450);
                stage1.setHeight(400);
                stage1.show();// Display the stage

            }// Objects.equals(value, "PlayerLinkedList")

            // Selection eight from the hitter ComboBox calls the SearchPlayer
            // option and activates the code inside
            else if (Objects.equals(value, "SearchPlayer")){

                // Creates a new TextField object
                TextField tfRetrieve = new TextField();

                // Creates two buttons for the gridPane
                Button btRetrieve = new Button("Retrieve");
                Button btHelp = new Button("Rules/Help");
                Button btView = new Button("ViewHashTable");

                // initializes the gridPane
                gp2 = new GridPane();

                // sets the Vgap and Hgap
                gp2.setVgap(5);
                gp2.setHgap(5);

                // sets the padding and insets
                gp2.setPadding(new Insets(10, 5, 5, 5));

                // creates a label for the textFiled adds to gridPane
                gp2.add(new Label(" Key: "), 0, 0);

                // Adds the tfRetrieve button to the gridPane
                gp2.add(tfRetrieve, 1, 0);

                // Creates a HBox object
                HBox hbx = new HBox();
                hbx.setSpacing(5);
                // adds the buttons to the HBox
                hbx.getChildren().addAll(btRetrieve, btHelp, btView);

                // Sets the alignment of the HBox in the scene
                hbx.setAlignment(Pos.CENTER);

                // Label object showing the keys
                Label exLabel = new Label("Keys:\n C,1B, 2B, 3B, SS, LF, RF, CF, OF, OF1,UT, DH");

                // Borderpane object to set the hBox gridPane and label in
                BorderPane bp = new BorderPane();
                bp.setPadding(new Insets(5, 5, 5, 8));
                bp.setTop(gp2);
                bp.setCenter(hbx);
                bp.setBottom(exLabel);

                // Creates a ChainedHashtable object
                ChainedHashtable ht = new ChainedHashtable();

                // Puts the player objects in the ChainedHashtable and assigns the keys to the players
                ht.put("C", adely);
                ht.put("3B", gunner);
                ht.put("CF", cedric);
                ht.put("1B", mountie);
                ht.put("RF", tony);
                ht.put("OF", stowers);
                ht.put("OF1", mckenna);
                ht.put("UT", vavra);
                ht.put("LF", hays);
                ht.put("SS", mateo);
                ht.put("2B", urias);

                // btRetrieve.setOnAction
                btRetrieve.setOnAction(s -> {

                    // initializes  taData4
                    taData4 = new TextArea();

                    // gets and appends the player from the player objects in the ChainedHashtable
                    // puts in the textArea
                    taData4.appendText(String.valueOf(ht.get(tfRetrieve.getText())));

                    // Create a scene and place the pane in the stage
                    Scene scene2 = new Scene(taData4);
                    Stage stage2 = new Stage();
                    stage2.setScene(scene2);// Set the stage title
                    stage2.setWidth(400);
                    stage2.setHeight(200);
                    stage2.show();// Display the stage
                }); // Retrieve button

                // btHelp.setOnAction to describe the process of searching for the player
                btHelp.setOnAction(x -> {

                    // Calls the FxUtility class and the showFXMessage method
                    // describing the rules and process
                    FxUtility.showFXMessage("Instructions", "There are 12 types of hitters for a Lineup\n" +
                                    "\n Use these as keys to retrieve the hitters",
                            " C,1B, 2B, 3B, SS, LF, RF, CF, OF, OF1, UT, DH");
                }); // help button

                // View Button for seeing what the chained hash table looks like under the covers
                // Time Complexity of O(n)
                btView.setOnAction(actionEvent1 -> {
                    taData15 = new TextArea();

                    for (int i = 0; i < ht.hashtable.length; i++) {
                        if (ht.hashtable[i].isEmpty()){
                            taData15.appendText("Position " + i + ": empty\n");
                        }
                        else{
                            taData15.appendText("Position " + i + ": " + "");
                            for (StoredPlayer storedPlayer : ht.hashtable[i]) {
                                taData15.appendText(storedPlayer.player + " " + " -> ");
                            }
                            taData15.appendText(" null\n");

                        }
                    }

                    // Create a scene and place the pane in the stage
                    Scene scene2 = new Scene(taData15);
                    Stage stage2 = new Stage();
                    stage2.setScene(scene2);// Place the scene in the stage
                    stage2.setWidth(500);
                    stage2.setHeight(500);
                    stage2.show();// Display the stage
                });

                // Create a scene and place the pane in the stage
                Scene scene2 = new Scene(bp);
                Stage stage2 = new Stage();
                stage2.setScene(scene2); // Place the scene in the stage
                stage2.setWidth(275);
                stage2.setHeight(195);
                stage2.show();// Display the stage

            } // Objects.equals(value, "SearchPlayer")

            // Selection nine from the hitter ComboBox calls the BST/MultiTread
            // option and activates the code inside
            else if (Objects.equals(value, "BST/MultiTread")){

                // Calls the bstHitters method
                bstHitters();

            } // Objects.equals(value, "BST/MultiTread")

        }); //  btSelect1
//------------------------------------------------------------------------------

        // Button selection for the pitcher menu (setOnAction)
        btSelect2.setOnAction(actionEvent -> {

            // gets the selection from the comboBox
            String value1 = comboBox2.getSelectionModel().getSelectedItem();

            // Selection one from the pitcher calls the sort players option and activates the code inside
            if (Objects.equals(value1, "SortPlayers")){

                // initializes  taData7
                taData7 = new TextArea();

                // Calls the FxUtility class and the getYesNo method asks the user
                // if they want to sort the list of player from the singleD pitcher array
                // by there Earned Run Average
                FxUtility.getYesNo("Sorting BY: ", "Do you want the pitchers" +
                        "\nsorted by their ERA");

                // Sets the value selection at the top of the taData textArea
                taData7.setText(value1);

                // Calls the SortingUtility and the mergeSort method to sort the pitchers by
                // there ERA
                SortingUtility.mergeSort(pitchers, new ERAComparator());

                // Use the list interface to create an arraylist to add the pitchers array of players
                List<Player> pitcherList = new ArrayList<>(Arrays.stream(pitchers).toList());

                // Returns an array containing all the elements in this list in proper sequence
                // With the proper size
                Object[] pitcher = pitcherList.toArray(new Player[pitcherList.size()]);

                // Appends the array containing all the elements in this list in proper sequence
                // To the TextArea taData7
                for (Object pitch: pitcher) {
                    taData7.appendText("\n" + pitch.toString());
                }

                // Appends the size of the array containing all the elements
                taData7.appendText("\nSize Of List: " + pitcher.length);

                // Create a scene and place the pane in the stage
                Scene scene = new Scene(taData7);
                Stage stage1 = new Stage();
                stage1.setScene(scene);// Place the scene in the stage
                stage1.setWidth(400);
                stage1.setHeight(500);
                stage1.show();// Display the stage

            } // Objects.equals(value1, "SortPlayers")

            // Selection two from the pitchers ComboBox calls the SavePlayer
            // option and activates the code inside
            else if (Objects.equals(value1, "SavePlayer")){

                // Calls the FxUtility class and the getYesNo method asks the user
                // if they want to save the pitchers list
                FxUtility.getYesNo("SavePitchers", "Do you want to save the Pitchers?");

                // Create an output stream for file o.dat
                try (ObjectOutputStream outputStream = new ObjectOutputStream(
                        new BufferedOutputStream(new FileOutputStream("o.dat", true)))) {

                    // Write hitters to the object output stream
                    outputStream.write(pitchers.length);

                    // Catches the exceptions
                } catch (IOException x) {
                    x.printStackTrace(); // prints the stacktrace
                }
            } // Objects.equals(value1, "SavePlayer")

            // Selection three from the pitcher ComboBox calls the ViewSavedPlayer
            // option and activates the code inside
            else if (Objects.equals(value1, "ViewSavedPlayer")){

                // Calls the FxUtility class and the getYesNo method asks the user
                // if they want to load the saved pitchers list
                FxUtility.getYesNo("SavedPitchers",
                        "Do you want to load the saved Pitchers?");

                // Create an input stream for file o.dat
                try (ObjectInputStream inputStream = new ObjectInputStream(
                        new BufferedInputStream(new FileInputStream("o.dat")))) {

                    // create a new text area from the existing one to append the save sorted
                    // pitchers to the TextArea taData
                    taData7 = new TextArea(value1);

                    //  Appends a title for the text area
                    taData7.appendText("Loaded pitchers\n");

                    //calls the displaySavedPitcher method to append the
                    // sorted list to the new taData textArea
                    displaySavedPitcher(pitchers);

                    // Append the size of the list to the text area
                    taData7.appendText("Size Of List: " + pitchers.length);

                    // Create a scene and place the pane in the stage
                    Scene scene = new Scene(taData7);
                    Stage stage1 = new Stage();
                    stage1.setScene(scene);// Place the scene in the stage
                    stage1.setWidth(400);
                    stage1.setHeight(480);
                    stage1.show();// Display the stage

                    // Catches the exceptions
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }// Objects.equals(value1, "ViewSavedPlayer")

            // Selection four from the hitter ComboBox calls the PlayerListViewMapDesign
            // option and activates the code inside
            else if(Objects.equals(value1, "PlayerListViewMapDesign")){

                // Calls the listViewPitchersMap method
                listViewPitchersMap();

            } // Objects.equals(value1, "PlayerListViewMapDesign")

            // Selection five from the pitcher ComboBox calls the ArrayStackTest
            // option and activates the code inside
            else if (Objects.equals(value1, "ArrayStackTest")){

                // initializes taData8
                taData8 = new TextArea();

                // Calls the ArrayStack and creates an ArrayStack object with a capacity of 10
                ArrayStack stack = new ArrayStack(10);

                // Pushes the player objects into the stack
                stack.push(lyles);
                stack.push(kremer);
                stack.push(bradish);
                stack.push(watkins);
                stack.push(wells);
                stack.push(voth);
                stack.push(tate);
                stack.push(baker);
                stack.push(felix);
                stack.push(perez);
                // tests the double the size with increasing the capacity to 11
                stack.push(hall);

                // pops the player objects out of the array stack and appends them to the textArea
                for(int i = stack.top-1; i >= 0; i--){
                    taData8.appendText(stack.pop() + "\n");
                }
                // Create a scene and place the pane in the stage
                Scene scene = new Scene(taData8);
                Stage stage1 = new Stage();
                stage1.setScene(scene);// Place the scene in the stage
                stage1.setWidth(400);
                stage1.setHeight(480);
                stage1.show();// Display the stage

            } // Objects.equals(value1, "ArrayStackTest")

            // Selection six from the pitcher ComboBox calls the PlayerLinkedList
            // option and activates the code inside
            else if (Objects.equals(value1, "LinkedStackTest")){
                // initializes taData9
                taData9 = new TextArea();

                // Creates a player linked stack object
                LinkedStack linkedStack = new LinkedStack();

                // Pushes the player objects into the linkedStack
                linkedStack.push(lyles);
                linkedStack.push(kremer);
                linkedStack.push(bradish);
                linkedStack.push(watkins);
                linkedStack.push(wells);
                linkedStack.push(voth);
                linkedStack.push(tate);
                linkedStack.push(baker);
                linkedStack.push(felix);
                linkedStack.push(perez);
                linkedStack.push(hall);

                // pops and appends the pushed player objects to the textArea
                for (Player player : linkedStack.stack) {
                    taData9.appendText(player + "\n");
                }
                // Create a scene and place the pane in the stage
                Scene scene = new Scene(taData9);
                Stage stage1 = new Stage();
                stage1.setScene(scene); // Place the scene in the stage
                stage1.setWidth(400);
                stage1.setHeight(480);
                stage1.show();// Display the stage

            } // Objects.equals(value1, "LinkedStackTest")

            // Selection seven from the hitter ComboBox calls the PlayerLinkedList
            // option and activates the code inside
            else if (Objects.equals(value1, "PlayerLinkedList")){

                // initializes taData9
                taData10 = new TextArea();

                // Creates a PlayerLinkedList object
                PlayerLinkedList playerLinkedList = new PlayerLinkedList();

                // testings add to front
                playerLinkedList.addToFront(lyles);
                playerLinkedList.addToFront(kremer);
                playerLinkedList.addToFront(bradish);
                playerLinkedList.addToFront(watkins);
                // testings add to end
                playerLinkedList.addToEnd(wells);
                playerLinkedList.addToEnd(voth);
                playerLinkedList.addToEnd(tate);
                // testing add before
                playerLinkedList.addBefore(baker, wells);
                playerLinkedList.addBefore(felix, kremer);
                playerLinkedList.addBefore(perez, tate);
                playerLinkedList.addBefore(hall, watkins);

                // Appends the players from te doubly linked list to the textArea
                PlayerNode current = playerLinkedList.head;
                taData10.appendText("HEAD -> \n\t ");
                while(current !=null){
                    taData10.appendText(current + " <=> ");
                    current = current.getNext();
                }
                taData10.appendText(" null ");

                // Create a scene and place the pane in the stage
                Scene scene = new Scene(taData10);
                Stage stage1 = new Stage();
                stage1.setScene(scene); // Place the scene in the stage
                stage1.setWidth(450);
                stage1.setHeight(400);
                stage1.show(); // Display the stage

            } // Objects.equals(value1, "PlayerLinkedList")

            // Selection eight from the pitcher ComboBox calls the SearchPlayer
            // option and activates the code inside
            else if (Objects.equals(value1, "SearchPlayer")){

                // Creates a new TextField object
                TextField tfRetrieve = new TextField();
                // Creates two buttons for the gridPane
                Button btRetrieve = new Button("Retrieve");
                Button btHelp = new Button("Rules/Help");
                Button btView = new Button("ViewHashTable");

                // initializes the gridPane
                gp1 = new GridPane();

                // sets the Vgap & Hgap
                gp1.setVgap(5);
                gp1.setHgap(5);

                // sets the padding and insets
                gp1.setPadding(new Insets(10, 5, 5, 5));

                // creates a label for the textFiled adds to gridPane
                gp1.add(new Label("Key:"), 0, 0);

                // Adds the tfRetrieve button to the gridPane
                gp1.add(tfRetrieve, 1, 0);

                // Creates a HBox object
                HBox hbx = new HBox();
                hbx.setSpacing(8);
                // adds the buttons to the HBox
                hbx.getChildren().addAll(btRetrieve, btHelp, btView);

                // Sets the alignment of the HBox in the scene
                hbx.setAlignment(Pos.CENTER);

                // Label object showing the keys
                Label exLabel = new Label("Keys:\n SP1-6, RP1-4, CL");

                // Borderpane object to set the hBox gridPane and label in
                BorderPane bp = new BorderPane();
                bp.setPadding(new Insets(5, 5, 5, 5));
                bp.setTop(gp1);
                bp.setCenter(hbx);
                bp.setBottom(exLabel);

                // Creates a ChainedHashtable object
                ChainedHashtable ht = new ChainedHashtable();

                // Puts the player objects in the ChainedHashtable and assigns the keys to the players
                ht.put("SP1", lyles);
                ht.put("SP2", bradish);
                ht.put("SP3", kremer);
                ht.put("SP4", watkins);
                ht.put("SP5", wells);
                ht.put("SP6", voth);
                ht.put("RP1", tate);
                ht.put("RP2", baker);
                ht.put("CL", felix);
                ht.put("RP3", perez);
                ht.put("RP4", hall);

                // btRetrieve.setOnAction
                btRetrieve.setOnAction(s -> {

                    // initializes  taData11
                    taData11 = new TextArea();

                    // gets and appends the player from the player objects in the ChainedHashtable
                    // puts in the textArea
                    taData11.appendText(String.valueOf(ht.get(tfRetrieve.getText())));

                    // Create a scene and place the pane in the stage
                    Scene scene2 = new Scene(taData11);
                    Stage stage2 = new Stage();
                    stage2.setScene(scene2);// Place the scene in the stage
                    stage2.setWidth(400);
                    stage2.setHeight(200);
                    stage2.show();// Display the stage
                });

                // btHelp.setOnAction to describe the process of searching for the player
                btHelp.setOnAction(x -> {

                    // Calls the FxUtility class and the showFXMessage method
                    // describing the rules and process
                    FxUtility.showFXMessage("Instructions",
                            "There are 3 types of pitchers for a Lineup\n" +
                                    "Use these as keys to retrieve the pitchers",
                            " SP1-6, CL, RP1-4");
                });

                // View Button for seeing what the chained hash table looks like under the covers
                // Time Complexity of O(n)
                btView.setOnAction(actionEvent1 -> {
                    taData14 = new TextArea();

                    for (int i = 0; i < ht.hashtable.length; i++) {
                        if (ht.hashtable[i].isEmpty()){
                            taData14.appendText("Position " + i + ": empty\n");
                        }
                        else{
                            taData14.appendText("Position " + i + ": " + "");
                            for (StoredPlayer storedPlayer : ht.hashtable[i]) {
                                taData14.appendText(storedPlayer.player + " " + " -> ");
                            }
                            taData14.appendText(" null\n");
                        }
                    }

                    // Create a scene and place the pane in the stage
                    Scene scene2 = new Scene(taData14);
                    Stage stage2 = new Stage();
                    stage2.setScene(scene2);// Place the scene in the stage
                    stage2.setWidth(500);
                    stage2.setHeight(500);
                    stage2.show();// Display the stage
                });

                // Create a scene and place the pane in the stage
                Scene scene2 = new Scene(bp);
                Stage stage2 = new Stage();
                stage2.setScene(scene2); // Set the scene in the stage
//                stage2.setWidth(240);
//                stage2.setHeight(195);
                stage2.setWidth(280);
                stage2.setHeight(195);
                stage2.show();// Display the stage

            }// Objects.equals(value1, "SearchPlayer")

            // Selection Nine from the pitcher ComboBox calls the BST/MultiTread
            // option and activates the code inside
            else if (Objects.equals(value1, "BST/MultiTread")){

                // Calls the bstPitchers method
                bstPitchers();

            } // Objects.equals(value1, "BST/MultiTread")
        });

//------------------------------------------------------------------------------
        // Creates a borderpane, sets padding, and sets top and center
        Image img = new Image("C:\\Users\\seanl\\Baseball Analitics Project\\Part4\\Os.jpg");
        HBox h = new HBox();
        h.setAlignment(Pos.CENTER);
        h.setPadding(new Insets(45, 5, 35, 5));
        h.getChildren().add(new ImageView(img));

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(15, 5, 40, 5));
        pane.setTop(hBox);
        pane.setCenter(h);
        pane.setBottom(flowPane);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 340, 265);
        stage.setTitle("Baseball++");// Set the stage title
        stage.setScene(scene); // Set the scene in the stage
        stage.show();// Display the stage
    }
    //------------------------------------------------------------------------------
    public static void main(String[] args) {
        launch();
    }
//------------------------------------------------------------------------------

    // method for displaying stats on a textArea
    private <E> void display(E[] a) {
        taData.setText(null);
        for (E t : a) {
            taData.appendText(t.toString() + "\n");
        }
    }// method

    // method for displaying stats on a textArea
    private <E> void displaySavedPitcher(E[] b){
        taData7.setText(null);
        for (E t : b) {
            taData7.appendText(t.toString() + "\n");
        }
    }
//------------------------------------------------------------------------------\

    public void bstHitters(){
        // initialize taData5
        taData5 = new TextArea();
        // sets setEditable to false
        taData5.setEditable(false);

        // initialize taData5
        taData6 = new TextArea();
        // sets setEditable to false
        taData6.setEditable(false);

        // Creates a new Binary search tree
        BST<String> tree1 = new BST<>();

        // inserts players into the tree
        tree1.insert(adely + "");
        tree1.insert(gunner + "");
        tree1.insert(cedric + "");
        tree1.insert(mountie + "");
        tree1.insert(tony + "");


        // New Thread that adds three players then traversals them forward
        new Thread(() ->{
//            try{
            // Sets the threads priority
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            // sets the treads name
            Thread.currentThread().setName("Forward and on ward");
            // inserts its own players into the tree
            tree1.insert(stowers + "");
            tree1.insert(vavra + "");
            tree1.insert(hays + "");

            // Appends the players to the text area
            for (String s : tree1) {
                taData5.appendText(s);
            }
            //Thread.yield();
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }).start(); // Starts the Tread

        // New Thread that adds three players then traversals them backward
        new Thread(() -> {
//            try{
            // Sets the Thread Priority bellow the Forward and on ward Thread
            //Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
            // Names the Thread
            Thread.currentThread().setName("Backward and well backward");
            // Adds its own unique players to the tree
            tree1.insert(mckenna + "");
            tree1.insert(urias + "");
            tree1.insert(mateo + "");

            //Backward traversal
            ListIterator<String> iterator = tree1.iterator(tree1.getSize());
            while (iterator.hasPrevious()) {
                taData6.appendText(iterator.previous());
            }
//                //Thread.yield();
//                Thread.sleep(5);
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }).start(); // Starts the tread

        // Creates the borderpane, padding/insets
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5, 5, 5, 5));

        // sets the top pane as taData5 which is the forward Thread traversal output of the tree
        pane.setTop(taData5);

        // Creates a split-pane for the center of the borderpane
        // describing the two textures and the treads name
        pane.setCenter(new SplitPane(
                new Label("Above forward traversal Thread: \"Forward and on ward\" " +
                        "\nBelow reverse traversal Thread: \"Backward and well backward\"")));

        // Sets the bottom pane as the second Thread which adds different player then its counterpart and
        // travers them backward
        pane.setBottom(taData6);

        // Sets the scene
        Scene scene = new Scene(pane);
        Stage stage1 = new Stage();
        stage1.setTitle("BST/MultiThread/Hitters"); // Set the stage title
        stage1.setScene(scene); // Sets the scene in the stage
        stage1.setWidth(500);
        stage1.setHeight(500);
        stage1.show();// Display the stage

    } //  bstHitters method
//------------------------------------------------------------------------------

    public void bstPitchers(){
        // initialize taData12
        taData12 = new TextArea();
        // taData12 setEditable to false
        taData12.setEditable(false);

        // initialize taData13
        taData13 = new TextArea();
        // taData13 setEditable to false
        taData13.setEditable(false);

        // Creates a binary search tree object
        BST<String> tree2 = new BST<>();

        // inserts pitcher obects to the tree
        tree2.insert(lyles + "");
        tree2.insert(kremer + "");
        tree2.insert(bradish + "");
        tree2.insert(watkins + "");
        tree2.insert(wells + "");

        // New Thread that adds three players then traversals them forward
        new Thread(() ->{
//            try{
            // Sets the threads priority
            var i = 8;
            Thread.currentThread().setPriority((i));
            // Sets the thread's name
            Thread.currentThread().setName("Forward");
            // Forward Thread inserts its own player objects to the tree
            tree2.insert(tate + "");
            tree2.insert(hall + "");
            tree2.insert(felix + "");

            // Appends the players to the text area
            for (String s : tree2) {
                taData12.appendText(s);
            }
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }).start(); // Starts the Thread

        // New Thread that adds three players then traversals them backward
        new Thread(() -> {
//            try{
            // Sets the Threads priority
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            // names the Thread
            Thread.currentThread().setName("Backward");
            // Adds its own player to the tree
            tree2.insert(perez + "");
            tree2.insert(baker + "");
            tree2.insert(voth + "");

            //Backward traversal
            ListIterator<String> iterator = tree2.iterator(tree2.getSize());
            while (iterator.hasPrevious()) {
                taData13.appendText(iterator.previous());
            }
//                Thread.sleep(5);
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }).start(); // starts the tread

        // Creates the borderpane, padding/insets
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5, 5, 5, 5));

        // sets the top pane as taData5 which is the forward Thread traversal output of the tree
        pane.setTop(taData12);

        // Creates a split-pane for the center of the borderpane
        // describing the two textures and the treads name
        pane.setCenter(new SplitPane(
                new Label("Above forward traversal Thread: \"Forward\" " +
                        "\nBelow reverse traversal Thread: \"Backward\"")));

        // Sets the bottom pane as the second Thread which adds
        // different player then its counterpart and travers them backward
        pane.setBottom(taData13);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane);
        Stage stage1 = new Stage();
        stage1.setTitle("BST/MultiThread/Pitchers");// Set the stage title
        stage1.setScene(scene);// place scene in the stage
        stage1.setWidth(500);
        stage1.setHeight(500);
        stage1.show();// Display the stage
    } // bstPitchers method

    //------------------------------------------------------------------------------
    // List the hitters using list view with the hitters sorted
    // by there era and map the player based on there position.
    public void listViewHittersMap() {
        // Set up the model which is two lists of Players and a filter criteria
        ReadOnlyObjectProperty<ObservableList<Player>> playersProperty =
                new SimpleObjectProperty<>(FXCollections.observableArrayList());

        ReadOnlyObjectProperty<FilteredList<Player>> viewablePlayersProperty =
                new SimpleObjectProperty<FilteredList<Player>>(
                        new FilteredList<>(playersProperty.get()));

        ObjectProperty<Predicate<? super Player>> filterProperty =
                viewablePlayersProperty.get().predicateProperty();

        // Build the UI
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(4);

        // new HBox
        HBox hbox = new HBox();
        hbox.setSpacing(2);

        // ToggleGroup
        ToggleGroup filterTG = new ToggleGroup();

        // The toggleHandler action wills set the filter based on the TB selected
        EventHandler<ActionEvent> toggleHandler = (event) -> {
            ToggleButton tb = (ToggleButton) event.getSource();
            Predicate<Player> filter = (Predicate<Player>) tb.getUserData();
            filterProperty.set(filter);
        };

        ToggleButton tbShowAll = new ToggleButton("Show All");
        tbShowAll.setSelected(true);
        tbShowAll.setToggleGroup(filterTG);
        tbShowAll.setOnAction(toggleHandler);
        tbShowAll.setUserData((Predicate<Player>) (Player p) -> true);

        // Create a distinct list of player positions from the Player objects, then create
        // ToggleButtons
        SortingUtility.mergeSort(hitters, new HitterAverageComparator());
        List<ToggleButton> tbs = Arrays.stream(hitters)
                .map(Player::getPosition)
                .distinct()
                .map((name) -> {
                    ToggleButton tb = new ToggleButton(name);
                    tb.setToggleGroup(filterTG);
                    tb.setOnAction(toggleHandler);
                    tb.setUserData((Predicate<Player>) (Player p) -> name.equals(p.getPosition()));
                    return tb;
                }).toList();

        hbox.getChildren().add(tbShowAll);
        hbox.getChildren().addAll(tbs);

        // Create a ListView bound to the viewablePlayers property
        ListView<Player> lv = new ListView<>();
        lv.itemsProperty().bind(viewablePlayersProperty);

        vbox.getChildren().addAll(hbox, lv);
        // set up scene and stage
        Scene scene = new Scene(vbox);
        Stage stage4 = new Stage();
        stage4.setScene(scene);
        stage4.setOnShown((evt) -> {
            playersProperty.get().addAll(hitters);
        });
        stage4.show();
    } //listHitterMapViewMap()
//------------------------------------------------------------------------------


    public void listViewPitchersMap() {
        // Set up the model which is two lists of Players and a filter criteria
        ReadOnlyObjectProperty<ObservableList<Player>> playersProperty =
                new SimpleObjectProperty<>(FXCollections.observableArrayList());

        ReadOnlyObjectProperty<FilteredList<Player>> viewablePlayersProperty =
                new SimpleObjectProperty<FilteredList<Player>>(
                        new FilteredList<>(playersProperty.get()));

        ObjectProperty<Predicate<? super Player>> filterProperty =
                viewablePlayersProperty.get().predicateProperty();

        // Build the UI
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(4);

        HBox hbox = new HBox();
        hbox.setSpacing(2);

        ToggleGroup filterTG = new ToggleGroup();

        // The toggleHandler action wills set the filter based on the TB selected
        EventHandler<ActionEvent> toggleHandler = (event) -> {
            ToggleButton tb = (ToggleButton) event.getSource();
            Predicate<Player> filter = (Predicate<Player>) tb.getUserData();
            filterProperty.set(filter);
        };

        ToggleButton tbShowAll = new ToggleButton("Show All");
        tbShowAll.setSelected(true);
        tbShowAll.setToggleGroup(filterTG);
        tbShowAll.setOnAction(toggleHandler);
        tbShowAll.setUserData((Predicate<Player>) (Player p) -> true);

        // Create a distinct list of player positions from the Player objects, then create
        // ToggleButtons
        SortingUtility.mergeSort(pitchers, new ERAComparator());
        List<ToggleButton> tbs = Arrays.stream(pitchers)
                .map((p) -> p.getPosition())
                .distinct()
                .map((name) -> {
                    ToggleButton tb = new ToggleButton(name);
                    tb.setToggleGroup(filterTG);
                    tb.setOnAction(toggleHandler);
                    tb.setUserData((Predicate<Player>) (Player p) -> name.equals(p.getPosition()));
                    return tb;
                }).toList();

        hbox.getChildren().add(tbShowAll);
        hbox.getChildren().addAll(tbs);

        // Create a ListView bound to the viewablePlayers property
        ListView<Player> lv = new ListView<>();
        lv.itemsProperty().bind(viewablePlayersProperty);

        vbox.getChildren().addAll(hbox, lv);

        Scene scene = new Scene(vbox);
        Stage stage4 = new Stage();
        stage4.setScene(scene);
        stage4.setOnShown((evt) -> {
            playersProperty.get().addAll(pitchers);
        });
        stage4.show();
    } //listPitchersMapViewMap

} // BaseballDriverFX