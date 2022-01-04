package com.example.discord2test;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.*;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/***
 * A class that exists to take the data from a MessageRow and put it into a nice javafx format.
 */
public class ProcessedMessage {

    private final MessagesRow message;
    private final VoteButtons buttons; //buttons is a new holder class for some stuff to tidy up this class: its too damn big
    private final Discord2Controller controller;
    public Text voteSum;
    public ImageView imageView;
    private Text author, text, date;
    private boolean hasImage = false;

    //a constructor which takes a message row, kinda makes more sense this way
    public ProcessedMessage(MessagesRow row, Discord2Controller controller) {
        this.controller = controller;
        buttons = new VoteButtons(controller, this); //set up our new buttons class

        this.message = row;

        this.author = new Text(message.Author);
        this.text = new Text(message.Text);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy").withLocale(Locale.UK).withZone(ZoneId.systemDefault());
        String formatted = formatter.format(message.TimeSent);

        this.date = new Text(formatted);

        this.voteSum = new Text(Integer.toString(message.VoteSum));

        //currently only accounts for PNGs
        if (message.FileExtension != null) {
            hasImage = message.FileExtension.equals("png");
        }

    }

    //this class should only be called once! if charlie ever has an error because he thinks
    //this method returns a stored Hbox, tell him he's stupid.
    public HBox GetHbox() {
        //returns a HBOX with the three texts in it - javafx shits the bed if you try add duplicate kids
        // and the vote arrows
        HBox toReturn = new HBox(8, author, text, date, buttons.getBox(), voteSum);

        //if it has an image, add the image and requisite shit
        if (hasImage) {
            Button revealButton = new Button("Img");

            //create an image and assign it to an image view
            Image image = new Image(message.FileData);
            imageView = new ImageView(image);
            imageView.setVisible(false);
            imageView.setManaged(false);

            //todo give this functionality
            Button downloadButton = new Button("Download");

            toReturn.getChildren().addAll(revealButton, imageView, downloadButton);

            revealButton.setOnAction(e -> {
                imageView.setVisible(!imageView.isVisible());
                imageView.setManaged(!imageView.isManaged());
            });

        }
        return toReturn;
    }


    //currently these getters and setters are useless, will keep them here until release so testing.
    public Text getAuthor() {
        return author;
    }

    public void setAuthor(Text author) {
        this.author = author;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Text getDate() {
        return date;
    }

    public void setDate(Text date) {
        this.date = date;
    }

    public void UpdateVoteSum(int newSum) {
        voteSum.setText(Integer.toString(newSum));
    }

    public MessagesRow getMessageRow() {
        return message;
    }

    public int getMessageID() {
        return message.MessageID;
    }

    public VoteButtons getButtons() {
        return buttons;
    }

    public void setColours(boolean userMsg) {

        Color authorColour = userMsg ? colours.authorIsMe : colours.authorIsSomeoneElse;

        author.setFill(authorColour);
        text.setFill(colours.content);
        date.setFill(colours.date);

    }

}

class colours {

    public static Color
            authorIsMe = Color.RED,
            authorIsSomeoneElse = Color.BLUE,
            content = Color.BLACK,
            date = Color.color(0.5f, 0.5f, 0.5f);
}