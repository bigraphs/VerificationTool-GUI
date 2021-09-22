package it.uniud.mads.jlibbig.proverif.gui.pages.home.layout;

import it.uniud.mads.jlibbig.proverif.gui.constants.Constants;
import it.uniud.mads.jlibbig.proverif.gui.pages.home.logic.HomeLogic;
import it.uniud.mads.jlibbig.proverif.gui.pages.home.logic.HomeLogicDynamic;
import it.uniud.mads.jlibbig.proverif.gui.pages.home.logic.HomeVariables;
import it.uniud.mads.jlibbig.proverif.gui.widget.ButtonStandard;
import it.uniud.mads.jlibbig.proverif.gui.widget.Column;
import it.uniud.mads.jlibbig.proverif.gui.widget.DropDownMenu;
import it.uniud.mads.jlibbig.proverif.gui.widget.Grid;
import it.uniud.mads.jlibbig.proverif.gui.widget.Labels;
import it.uniud.mads.jlibbig.proverif.gui.widget.Row;
import it.uniud.mads.jlibbig.proverif.gui.widget.TextInputField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScene {

    private static VBox rightSideColumn;
    private static VBox errorLabelColumn;
    private static VBox errorContentColumn;

    private static HBox requestTypeLine;
    private static HBox buttonSendLine;
    private static HBox topRow;

    private static ChoiceBox<String> requestTypeChoiceBox;

    private static GridPane rightSideGrid;
    private static GridPane centerGrid;

    private static TextField modelInputField;
    private static TextField fileInputField;

    private static Label requestTypeLabel;
    private static Label modelLabel;
    private static Label fileLabel;
    private static Label responseLabel;
    private static Label responseContent;
    private static Label modelListLabel;
    private static Label modelListContent;
    private static Label modelInputListLabel;
    private static Label modelInputListContent;
    private static Label modelOutputTextListLabel;
    private static Label modelOutputTextListContent;
    private static Label modelOutputHtmlListLabel;
    private static Label modelOutputHtmlListContent;
    private static Label modelIdLabel;
    private static Label modelIdContent;
    private static Label fileIdLabel;
    private static Label fileIdContent;
    private static Label urlOutputLabel;
    private static Label fileInputProVerifLabel;
    private static Label fileInputProVerifContent;
    private static Label fileInputBigraphLabel;
    private static Label fileInputBigraphContent;
    private static Label fileInputIntegrativeLabel;
    private static Label fileInputIntegrativeContent;
    private static Label errorCodeLabel;
    private static Label errorCodeContent;
    private static Label errorMessageLabel;
    private static Label errorMessageContent;
    private static Label errorClassLabel;
    private static Label errorClassContent;

    private static Button buttonSend;
    private static Button saveInputFile;
    private static Button saveOutputTextFile;
    private static Button openUrlOutput;
    private static Button uploadInputFileProverif;
    private static Button uploadInputFileBigraph;
    private static Button uploadInputFileIntegrative;

    private static BorderPane layout;

    public static Scene home(Stage window) {

        createRightSideColumn(window);
        createCenterGrid(window);
        createTopRow();
        createLayout();

        // Set listener
        requestTypeChoiceBox.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> HomeLogicDynamic.setScene(v, oldValue, newValue));

        // Scene
        Scene homeScene = new Scene(layout, Constants.getScenewidth(), Constants.getSceneheight());
        return homeScene;
    }

    private static void createLayout() {
        layout = new BorderPane();
        // BorderPane.setAlignment(sideColumn, Pos.TOP_RIGHT);
        // BorderPane.setAlignment(topRow, Pos.TOP_LEFT);
        // BorderPane.setAlignment(centerGrid, Pos.TOP_LEFT);
        layout.setRight(rightSideColumn);
        layout.setTop(topRow);
        layout.setCenter(centerGrid);
        layout.setMinSize(Constants.getSceneminwidth(), Constants.getSceneminheight());
    }

    private static void createRightSideColumn(Stage window) {
        // Type Line
        requestTypeLine = Row.create();
        requestTypeLabel = Labels.create("Type of request:");
        requestTypeChoiceBox = DropDownMenu.create(Constants.getProverifrequests(),
                Constants.getProverifdefaultrequest());
        requestTypeLine.getChildren().addAll(requestTypeLabel, requestTypeChoiceBox);
        // Side Grid
        rightSideGrid = Grid.create();
        modelLabel = Labels.create("Model:");
        modelInputField = TextInputField.create("Model's name");
        fileLabel = Labels.create("File:");
        fileInputField = TextInputField.create("File's name");

        fileInputProVerifLabel = Labels.create("File Proverif:");
        fileInputProVerifContent = Labels.createBinded(HomeVariables.getFileProverifCheckChosed());
        uploadInputFileProverif = ButtonStandard.createButton("Load");
        uploadInputFileProverif.setOnAction(e -> HomeLogic.uploadInputFileProverifButtonBehaviour(window));

        fileInputBigraphLabel = Labels.create("Json Bigraph:");
        fileInputBigraphContent = Labels.createBinded(HomeVariables.getFileBigraphCheckChosed());
        uploadInputFileBigraph = ButtonStandard.createButton("Load");
        uploadInputFileBigraph.setOnAction(e -> HomeLogic.uploadInputFileBigraphButtonBehaviour(window));

        fileInputIntegrativeLabel = Labels.create("Json Integrative:");
        fileInputIntegrativeContent = Labels.createBinded(HomeVariables.getFileIntegrativeCheckChosed());
        uploadInputFileIntegrative = ButtonStandard.createButton("Load");
        uploadInputFileIntegrative.setOnAction(e -> HomeLogic.uploadInputFileIntegrativeButtonBehaviout(window));
        // Button Line
        buttonSendLine = Row.create();
        buttonSend = ButtonStandard.createButton("Send");
        buttonSend.setOnAction(e -> HomeLogic.sendButtonBehaviour());
        buttonSendLine.getChildren().add(buttonSend);
        // Side Column
        rightSideColumn = Column.create();
        rightSideColumn.getChildren().addAll(requestTypeLine, rightSideGrid, buttonSendLine);
    }

    private static void createCenterGrid(Stage window) {
        responseLabel = Labels.create("Response:");
        responseContent = Labels.createBinded(HomeVariables.getResponse());

        modelListLabel = Labels.create("Models:");
        modelListContent = Labels.createBinded(HomeVariables.getModels());

        modelIdLabel = Labels.create("Model:");
        modelIdContent = Labels.createBinded(HomeVariables.getModelId());

        fileIdLabel = Labels.create("FileName:");
        fileIdContent = Labels.createBinded(HomeVariables.getFileId());

        saveInputFile = ButtonStandard.createButton("Save");
        saveInputFile.setOnAction(e -> HomeLogic.saveInputFileButtonBehaviour(window));

        saveOutputTextFile = ButtonStandard.createButton("Save");
        saveOutputTextFile.setOnAction(e -> HomeLogic.saveOutputTextButtonBehaviour(window));

        urlOutputLabel = Labels.create("Result:");
        openUrlOutput = ButtonStandard.createButton("Open");
        openUrlOutput.setOnAction(e -> HomeLogic.openUrlOutputButtonBehaviour());

        modelInputListLabel = Labels.create("Input Files:");
        modelInputListContent = Labels.createBinded(HomeVariables.getModelInputListFiles());

        modelOutputTextListLabel = Labels.create("Output Text Files:");
        modelOutputTextListContent = Labels.createBinded(HomeVariables.getModelOutputTextListFiles());

        modelOutputHtmlListLabel = Labels.create("Output Html Files:");
        modelOutputHtmlListContent = Labels.createBinded(HomeVariables.getModelOutputHtmlListFiles());

        centerGrid = Grid.create(Pos.TOP_LEFT, 10, 20, new Insets(10, 30, 10, 30), 200, 200);
        GridPane.setConstraints(modelListLabel, 0, 0);
        GridPane.setConstraints(modelListContent, 1, 0);
        centerGrid.getChildren().clear();
        centerGrid.getChildren().addAll(modelListLabel, modelListContent);
    }

    private static void createTopRow() {
        errorCodeLabel = Labels.create("Error Code:");
        errorCodeContent = Labels.createBinded(HomeVariables.getErrorCode());

        errorMessageLabel = Labels.create("Error Message:");
        errorMessageContent = Labels.createBinded(HomeVariables.getErrorMessage());

        errorClassLabel = Labels.create("Error Class:");
        errorClassContent = Labels.createBinded(HomeVariables.getErrorClass());

        errorLabelColumn = Column.create(Pos.CENTER_LEFT, 10);
        errorContentColumn = Column.create(Pos.CENTER_LEFT, 10);
        errorLabelColumn.getChildren().addAll(errorCodeLabel, errorMessageLabel, errorClassLabel);
        errorContentColumn.getChildren().addAll(errorCodeContent, errorMessageContent, errorClassContent);
        // Top Row
        topRow = Row.create(Pos.TOP_LEFT, 8, new Insets(10, 30, 50, 30));
        topRow.getChildren().addAll(errorLabelColumn, errorContentColumn);
    }

    /**
     * @return the rightSideColumn
     */
    public static VBox getRightSideColumn() {
        return rightSideColumn;
    }

    /**
     * @param rightSideColumn the rightSideColumn to set
     */
    public static void setRightSideColumn(VBox rightSideColumn) {
        HomeScene.rightSideColumn = rightSideColumn;
    }

    /**
     * @return the errorLabelColumn
     */
    public static VBox getErrorLabelColumn() {
        return errorLabelColumn;
    }

    /**
     * @param errorLabelColumn the errorLabelColumn to set
     */
    public static void setErrorLabelColumn(VBox errorLabelColumn) {
        HomeScene.errorLabelColumn = errorLabelColumn;
    }

    /**
     * @return the errorContentColumn
     */
    public static VBox getErrorContentColumn() {
        return errorContentColumn;
    }

    /**
     * @param errorContentColumn the errorContentColumn to set
     */
    public static void setErrorContentColumn(VBox errorContentColumn) {
        HomeScene.errorContentColumn = errorContentColumn;
    }

    /**
     * @return the requestTypeLine
     */
    public static HBox getRequestTypeLine() {
        return requestTypeLine;
    }

    /**
     * @param requestTypeLine the requestTypeLine to set
     */
    public static void setRequestTypeLine(HBox requestTypeLine) {
        HomeScene.requestTypeLine = requestTypeLine;
    }

    /**
     * @return the buttonSendLine
     */
    public static HBox getButtonSendLine() {
        return buttonSendLine;
    }

    /**
     * @param buttonSendLine the buttonSendLine to set
     */
    public static void setButtonSendLine(HBox buttonSendLine) {
        HomeScene.buttonSendLine = buttonSendLine;
    }

    /**
     * @return the topRow
     */
    public static HBox getTopRow() {
        return topRow;
    }

    /**
     * @param topRow the topRow to set
     */
    public static void setTopRow(HBox topRow) {
        HomeScene.topRow = topRow;
    }

    /**
     * @return the requestTypeChoiceBox
     */
    public static ChoiceBox<String> getRequestTypeChoiceBox() {
        return requestTypeChoiceBox;
    }

    /**
     * @param requestTypeChoiceBox the requestTypeChoiceBox to set
     */
    public static void setRequestTypeChoiceBox(ChoiceBox<String> requestTypeChoiceBox) {
        HomeScene.requestTypeChoiceBox = requestTypeChoiceBox;
    }

    /**
     * @return the rightSideGrid
     */
    public static GridPane getRightSideGrid() {
        return rightSideGrid;
    }

    /**
     * @param rightSideGrid the rightSideGrid to set
     */
    public static void setRightSideGrid(GridPane rightSideGrid) {
        HomeScene.rightSideGrid = rightSideGrid;
    }

    /**
     * @return the centerGrid
     */
    public static GridPane getCenterGrid() {
        return centerGrid;
    }

    /**
     * @param centerGrid the centerGrid to set
     */
    public static void setCenterGrid(GridPane centerGrid) {
        HomeScene.centerGrid = centerGrid;
    }

    /**
     * @return the modelInputField
     */
    public static TextField getModelInputField() {
        return modelInputField;
    }

    /**
     * @param modelInputField the modelInputField to set
     */
    public static void setModelInputField(TextField modelInputField) {
        HomeScene.modelInputField = modelInputField;
    }

    /**
     * @return the fileInputField
     */
    public static TextField getFileInputField() {
        return fileInputField;
    }

    /**
     * @param fileInputField the fileInputField to set
     */
    public static void setFileInputField(TextField fileInputField) {
        HomeScene.fileInputField = fileInputField;
    }

    /**
     * @return the requestTypeLabel
     */
    public static Label getRequestTypeLabel() {
        return requestTypeLabel;
    }

    /**
     * @param requestTypeLabel the requestTypeLabel to set
     */
    public static void setRequestTypeLabel(Label requestTypeLabel) {
        HomeScene.requestTypeLabel = requestTypeLabel;
    }

    /**
     * @return the modelLabel
     */
    public static Label getModelLabel() {
        return modelLabel;
    }

    /**
     * @param modelLabel the modelLabel to set
     */
    public static void setModelLabel(Label modelLabel) {
        HomeScene.modelLabel = modelLabel;
    }

    /**
     * @return the fileLabel
     */
    public static Label getFileLabel() {
        return fileLabel;
    }

    /**
     * @param fileLabel the fileLabel to set
     */
    public static void setFileLabel(Label fileLabel) {
        HomeScene.fileLabel = fileLabel;
    }

    /**
     * @return the responseLabel
     */
    public static Label getResponseLabel() {
        return responseLabel;
    }

    /**
     * @param responseLabel the responseLabel to set
     */
    public static void setResponseLabel(Label responseLabel) {
        HomeScene.responseLabel = responseLabel;
    }

    /**
     * @return the responseContent
     */
    public static Label getResponseContent() {
        return responseContent;
    }

    /**
     * @param responseContent the responseContent to set
     */
    public static void setResponseContent(Label responseContent) {
        HomeScene.responseContent = responseContent;
    }

    /**
     * @return the modelListLabel
     */
    public static Label getModelListLabel() {
        return modelListLabel;
    }

    /**
     * @param modelListLabel the modelListLabel to set
     */
    public static void setModelListLabel(Label modelListLabel) {
        HomeScene.modelListLabel = modelListLabel;
    }

    /**
     * @return the modelListContent
     */
    public static Label getModelListContent() {
        return modelListContent;
    }

    /**
     * @param modelListContent the modelListContent to set
     */
    public static void setModelListContent(Label modelListContent) {
        HomeScene.modelListContent = modelListContent;
    }

    /**
     * @return the modelInputListLabel
     */
    public static Label getModelInputListLabel() {
        return modelInputListLabel;
    }

    /**
     * @param modelInputListLabel the modelInputListLabel to set
     */
    public static void setModelInputListLabel(Label modelInputListLabel) {
        HomeScene.modelInputListLabel = modelInputListLabel;
    }

    /**
     * @return the modelInputListContent
     */
    public static Label getModelInputListContent() {
        return modelInputListContent;
    }

    /**
     * @param modelInputListContent the modelInputListContent to set
     */
    public static void setModelInputListContent(Label modelInputListContent) {
        HomeScene.modelInputListContent = modelInputListContent;
    }

    /**
     * @return the modelOutputTextListLabel
     */
    public static Label getModelOutputTextListLabel() {
        return modelOutputTextListLabel;
    }

    /**
     * @param modelOutputTextListLabel the modelOutputTextListLabel to set
     */
    public static void setModelOutputTextListLabel(Label modelOutputTextListLabel) {
        HomeScene.modelOutputTextListLabel = modelOutputTextListLabel;
    }

    /**
     * @return the modelOutputTextListContent
     */
    public static Label getModelOutputTextListContent() {
        return modelOutputTextListContent;
    }

    /**
     * @param modelOutputTextListContent the modelOutputTextListContent to set
     */
    public static void setModelOutputTextListContent(Label modelOutputTextListContent) {
        HomeScene.modelOutputTextListContent = modelOutputTextListContent;
    }

    /**
     * @return the modelOutputHtmlListLabel
     */
    public static Label getModelOutputHtmlListLabel() {
        return modelOutputHtmlListLabel;
    }

    /**
     * @param modelOutputHtmlListLabel the modelOutputHtmlListLabel to set
     */
    public static void setModelOutputHtmlListLabel(Label modelOutputHtmlListLabel) {
        HomeScene.modelOutputHtmlListLabel = modelOutputHtmlListLabel;
    }

    /**
     * @return the modelOutputHtmlListContent
     */
    public static Label getModelOutputHtmlListContent() {
        return modelOutputHtmlListContent;
    }

    /**
     * @param modelOutputHtmlListContent the modelOutputHtmlListContent to set
     */
    public static void setModelOutputHtmlListContent(Label modelOutputHtmlListContent) {
        HomeScene.modelOutputHtmlListContent = modelOutputHtmlListContent;
    }

    /**
     * @return the modelIdLabel
     */
    public static Label getModelIdLabel() {
        return modelIdLabel;
    }

    /**
     * @param modelIdLabel the modelIdLabel to set
     */
    public static void setModelIdLabel(Label modelIdLabel) {
        HomeScene.modelIdLabel = modelIdLabel;
    }

    /**
     * @return the modelIdContent
     */
    public static Label getModelIdContent() {
        return modelIdContent;
    }

    /**
     * @param modelIdContent the modelIdContent to set
     */
    public static void setModelIdContent(Label modelIdContent) {
        HomeScene.modelIdContent = modelIdContent;
    }

    /**
     * @return the fileIdLabel
     */
    public static Label getFileIdLabel() {
        return fileIdLabel;
    }

    /**
     * @param fileIdLabel the fileIdLabel to set
     */
    public static void setFileIdLabel(Label fileIdLabel) {
        HomeScene.fileIdLabel = fileIdLabel;
    }

    /**
     * @return the fileIdContent
     */
    public static Label getFileIdContent() {
        return fileIdContent;
    }

    /**
     * @param fileIdContent the fileIdContent to set
     */
    public static void setFileIdContent(Label fileIdContent) {
        HomeScene.fileIdContent = fileIdContent;
    }

    /**
     * @return the urlOutputLabel
     */
    public static Label getUrlOutputLabel() {
        return urlOutputLabel;
    }

    /**
     * @param urlOutputLabel the urlOutputLabel to set
     */
    public static void setUrlOutputLabel(Label urlOutputLabel) {
        HomeScene.urlOutputLabel = urlOutputLabel;
    }

    /**
     * @return the fileInputProVerifLabel
     */
    public static Label getFileInputProVerifLabel() {
        return fileInputProVerifLabel;
    }

    /**
     * @param fileInputProVerifLabel the fileInputProVerifLabel to set
     */
    public static void setFileInputProVerifLabel(Label fileInputProVerifLabel) {
        HomeScene.fileInputProVerifLabel = fileInputProVerifLabel;
    }

    /**
     * @return the fileInputProVerifContent
     */
    public static Label getFileInputProVerifContent() {
        return fileInputProVerifContent;
    }

    /**
     * @param fileInputProVerifContent the fileInputProVerifContent to set
     */
    public static void setFileInputProVerifContent(Label fileInputProVerifContent) {
        HomeScene.fileInputProVerifContent = fileInputProVerifContent;
    }

    /**
     * @return the fileInputBigraphLabel
     */
    public static Label getFileInputBigraphLabel() {
        return fileInputBigraphLabel;
    }

    /**
     * @param fileInputBigraphLabel the fileInputBigraphLabel to set
     */
    public static void setFileInputBigraphLabel(Label fileInputBigraphLabel) {
        HomeScene.fileInputBigraphLabel = fileInputBigraphLabel;
    }

    /**
     * @return the fileInputBigraphContent
     */
    public static Label getFileInputBigraphContent() {
        return fileInputBigraphContent;
    }

    /**
     * @param fileInputBigraphContent the fileInputBigraphContent to set
     */
    public static void setFileInputBigraphContent(Label fileInputBigraphContent) {
        HomeScene.fileInputBigraphContent = fileInputBigraphContent;
    }

    /**
     * @return the fileInputIntegrativeLabel
     */
    public static Label getFileInputIntegrativeLabel() {
        return fileInputIntegrativeLabel;
    }

    /**
     * @param fileInputIntegrativeLabel the fileInputIntegrativeLabel to set
     */
    public static void setFileInputIntegrativeLabel(Label fileInputIntegrativeLabel) {
        HomeScene.fileInputIntegrativeLabel = fileInputIntegrativeLabel;
    }

    /**
     * @return the fileInputIntegrativeContent
     */
    public static Label getFileInputIntegrativeContent() {
        return fileInputIntegrativeContent;
    }

    /**
     * @param fileInputIntegrativeContent the fileInputIntegrativeContent to set
     */
    public static void setFileInputIntegrativeContent(Label fileInputIntegrativeContent) {
        HomeScene.fileInputIntegrativeContent = fileInputIntegrativeContent;
    }

    /**
     * @return the errorCodeLabel
     */
    public static Label getErrorCodeLabel() {
        return errorCodeLabel;
    }

    /**
     * @param errorCodeLabel the errorCodeLabel to set
     */
    public static void setErrorCodeLabel(Label errorCodeLabel) {
        HomeScene.errorCodeLabel = errorCodeLabel;
    }

    /**
     * @return the errorCodeContent
     */
    public static Label getErrorCodeContent() {
        return errorCodeContent;
    }

    /**
     * @param errorCodeContent the errorCodeContent to set
     */
    public static void setErrorCodeContent(Label errorCodeContent) {
        HomeScene.errorCodeContent = errorCodeContent;
    }

    /**
     * @return the errorMessageLabel
     */
    public static Label getErrorMessageLabel() {
        return errorMessageLabel;
    }

    /**
     * @param errorMessageLabel the errorMessageLabel to set
     */
    public static void setErrorMessageLabel(Label errorMessageLabel) {
        HomeScene.errorMessageLabel = errorMessageLabel;
    }

    /**
     * @return the errorMessageContent
     */
    public static Label getErrorMessageContent() {
        return errorMessageContent;
    }

    /**
     * @param errorMessageContent the errorMessageContent to set
     */
    public static void setErrorMessageContent(Label errorMessageContent) {
        HomeScene.errorMessageContent = errorMessageContent;
    }

    /**
     * @return the errorClassLabel
     */
    public static Label getErrorClassLabel() {
        return errorClassLabel;
    }

    /**
     * @param errorClassLabel the errorClassLabel to set
     */
    public static void setErrorClassLabel(Label errorClassLabel) {
        HomeScene.errorClassLabel = errorClassLabel;
    }

    /**
     * @return the errorClassContent
     */
    public static Label getErrorClassContent() {
        return errorClassContent;
    }

    /**
     * @param errorClassContent the errorClassContent to set
     */
    public static void setErrorClassContent(Label errorClassContent) {
        HomeScene.errorClassContent = errorClassContent;
    }

    /**
     * @return the buttonSend
     */
    public static Button getButtonSend() {
        return buttonSend;
    }

    /**
     * @param buttonSend the buttonSend to set
     */
    public static void setButtonSend(Button buttonSend) {
        HomeScene.buttonSend = buttonSend;
    }

    /**
     * @return the saveInputFile
     */
    public static Button getSaveInputFile() {
        return saveInputFile;
    }

    /**
     * @param saveInputFile the saveInputFile to set
     */
    public static void setSaveInputFile(Button saveInputFile) {
        HomeScene.saveInputFile = saveInputFile;
    }

    /**
     * @return the saveOutputTextFile
     */
    public static Button getSaveOutputTextFile() {
        return saveOutputTextFile;
    }

    /**
     * @param saveOutputTextFile the saveOutputTextFile to set
     */
    public static void setSaveOutputTextFile(Button saveOutputTextFile) {
        HomeScene.saveOutputTextFile = saveOutputTextFile;
    }

    /**
     * @return the openUrlOutput
     */
    public static Button getOpenUrlOutput() {
        return openUrlOutput;
    }

    /**
     * @param openUrlOutput the openUrlOutput to set
     */
    public static void setOpenUrlOutput(Button openUrlOutput) {
        HomeScene.openUrlOutput = openUrlOutput;
    }

    /**
     * @return the uploadInputFileProverif
     */
    public static Button getUploadInputFileProverif() {
        return uploadInputFileProverif;
    }

    /**
     * @param uploadInputFileProverif the uploadInputFileProverif to set
     */
    public static void setUploadInputFileProverif(Button uploadInputFileProverif) {
        HomeScene.uploadInputFileProverif = uploadInputFileProverif;
    }

    /**
     * @return the uploadInputFileBigraph
     */
    public static Button getUploadInputFileBigraph() {
        return uploadInputFileBigraph;
    }

    /**
     * @param uploadInputFileBigraph the uploadInputFileBigraph to set
     */
    public static void setUploadInputFileBigraph(Button uploadInputFileBigraph) {
        HomeScene.uploadInputFileBigraph = uploadInputFileBigraph;
    }

    /**
     * @return the uploadInputFileIntegrative
     */
    public static Button getUploadInputFileIntegrative() {
        return uploadInputFileIntegrative;
    }

    /**
     * @param uploadInputFileIntegrative the uploadInputFileIntegrative to set
     */
    public static void setUploadInputFileIntegrative(Button uploadInputFileIntegrative) {
        HomeScene.uploadInputFileIntegrative = uploadInputFileIntegrative;
    }

    /**
     * @return the layout
     */
    public static BorderPane getLayout() {
        return layout;
    }

    /**
     * @param layout the layout to set
     */
    public static void setLayout(BorderPane layout) {
        HomeScene.layout = layout;
    }
}
