module com.baseball.part4githubupload {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.baseball.part4githubupload to javafx.fxml;
    exports com.baseball.part4githubupload;
}