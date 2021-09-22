package it.uniud.mads.jlibbig.proverif.gui.pages.home.logic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HomeVariables {

    private static StringProperty response = new SimpleStringProperty("");

    private static StringProperty errorCode = new SimpleStringProperty("");
    private static StringProperty errorMessage = new SimpleStringProperty("");
    private static StringProperty errorClass = new SimpleStringProperty("");

    private static StringProperty models = new SimpleStringProperty("");

    private static StringProperty modelId = new SimpleStringProperty("");
    private static StringProperty fileId = new SimpleStringProperty("");

    private static StringProperty modelInputListFiles = new SimpleStringProperty("");
    private static StringProperty modelOutputTextListFiles = new SimpleStringProperty("");
    private static StringProperty modelOutputHtmlListFiles = new SimpleStringProperty("");

    private static StringProperty fileInputContent = new SimpleStringProperty("");
    private static StringProperty fileOutputTextContent = new SimpleStringProperty("");
    private static StringProperty fileToUploadProVerif = new SimpleStringProperty("");
    private static StringProperty fileToUploadBigraph = new SimpleStringProperty("");
    private static StringProperty fileToUploadIntegrative = new SimpleStringProperty("");

    private static StringProperty fileProverifCheckChosed = new SimpleStringProperty("");
    private static StringProperty fileBigraphCheckChosed = new SimpleStringProperty("");
    private static StringProperty fileIntegrativeCheckChosed = new SimpleStringProperty("");

    private static StringProperty outputUrl = new SimpleStringProperty("");

    /**
     * @return the response
     */
    public static StringProperty getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public static void setResponse(String response) {
        HomeVariables.response.set(response);
    }

    /**
     * @return the errorCode
     */
    public static StringProperty getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public static void setErrorCode(String errorCode) {
        HomeVariables.errorCode.set(errorCode);
    }

    /**
     * @return the errorMessage
     */
    public static StringProperty getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public static void setErrorMessage(String errorMessage) {
        HomeVariables.errorMessage.set(errorMessage);
    }

    /**
     * @return the errorClass
     */
    public static StringProperty getErrorClass() {
        return errorClass;
    }

    /**
     * @param errorClass the errorClass to set
     */
    public static void setErrorClass(String errorClass) {
        HomeVariables.errorClass.set(errorClass);
    }

    /**
     * @return the models
     */
    public static StringProperty getModels() {
        return models;
    }

    /**
     * @param models the models to set
     */
    public static void setModels(String models) {
        HomeVariables.models.set(models);
    }

    /**
     * @return the modelId
     */
    public static StringProperty getModelId() {
        return modelId;
    }

    /**
     * @param modelId the modelId to set
     */
    public static void setModelId(String modelId) {
        HomeVariables.modelId.set(modelId);
    }

    /**
     * @return the modelInputListFiles
     */
    public static StringProperty getModelInputListFiles() {
        return modelInputListFiles;
    }

    /**
     * @param modelInputListFiles the modelInputListFiles to set
     */
    public static void setModelInputListFiles(String modelInputListFiles) {
        HomeVariables.modelInputListFiles.set(modelInputListFiles);
    }

    /**
     * @return the modelOutputTextListFiles
     */
    public static StringProperty getModelOutputTextListFiles() {
        return modelOutputTextListFiles;
    }

    /**
     * @param modelOutputTextListFiles the modelOutputTextListFiles to set
     */
    public static void setModelOutputTextListFiles(String modelOutputTextListFiles) {
        HomeVariables.modelOutputTextListFiles.set(modelOutputTextListFiles);
    }

    /**
     * @return the modelOutputHtmlListFiles
     */
    public static StringProperty getModelOutputHtmlListFiles() {
        return modelOutputHtmlListFiles;
    }

    /**
     * @param modelOutputHtmlListFiles the modelOutputHtmlListFiles to set
     */
    public static void setModelOutputHtmlListFiles(String modelOutputHtmlListFiles) {
        HomeVariables.modelOutputHtmlListFiles.set(modelOutputHtmlListFiles);
    }

    /**
     * @return the fileId
     */
    public static StringProperty getFileId() {
        return fileId;
    }

    /**
     * @param fileId the fileId to set
     */
    public static void setFileId(String fileId) {
        HomeVariables.fileId.set(fileId);
    }

    /**
     * @return the fileInputContent
     */
    public static StringProperty getFileInputContent() {
        return fileInputContent;
    }

    /**
     * @param fileInputContent the fileInputContent to set
     */
    public static void setFileInputContent(String fileInputContent) {
        HomeVariables.fileInputContent.set(fileInputContent);
    }

    /**
     * @return the fileToUploadProVerif
     */
    public static StringProperty getFileToUploadProVerif() {
        return fileToUploadProVerif;
    }

    /**
     * @param fileToUploadProVerif the fileToUploadProVerif to set
     */
    public static void setFileToUploadProVerif(String fileToUploadProVerif) {
        HomeVariables.fileToUploadProVerif.set(fileToUploadProVerif);
    }

    /**
     * @return the fileToUploadBigraph
     */
    public static StringProperty getFileToUploadBigraph() {
        return fileToUploadBigraph;
    }

    /**
     * @param fileToUploadBigraph the fileToUploadBigraph to set
     */
    public static void setFileToUploadBigraph(String fileToUploadBigraph) {
        HomeVariables.fileToUploadBigraph.set(fileToUploadBigraph);
    }

    /**
     * @return the fileToUploadIntegrative
     */
    public static StringProperty getFileToUploadIntegrative() {
        return fileToUploadIntegrative;
    }

    /**
     * @param fileToUploadIntegrative the fileToUploadIntegrative to set
     */
    public static void setFileToUploadIntegrative(String fileToUploadIntegrative) {
        HomeVariables.fileToUploadIntegrative.set(fileToUploadIntegrative);
    }

    /**
     * @return the fileProverifCheckChosed
     */
    public static StringProperty getFileProverifCheckChosed() {
        return fileProverifCheckChosed;
    }

    /**
     * @param fileProverifCheckChosed the fileProverifCheckChosed to set
     */
    public static void setFileProverifCheckChosed(String fileProverifCheckChosed) {
        HomeVariables.fileProverifCheckChosed.set(fileProverifCheckChosed);
    }

    /**
     * @return the fileBigraphCheckChosed
     */
    public static StringProperty getFileBigraphCheckChosed() {
        return fileBigraphCheckChosed;
    }

    /**
     * @param fileBigraphCheckChosed the fileBigraphCheckChosed to set
     */
    public static void setFileBigraphCheckChosed(String fileBigraphCheckChosed) {
        HomeVariables.fileBigraphCheckChosed.set(fileBigraphCheckChosed);
    }

    /**
     * @return the fileIntegrativeCheckChosed
     */
    public static StringProperty getFileIntegrativeCheckChosed() {
        return fileIntegrativeCheckChosed;
    }

    /**
     * @param fileIntegrativeCheckChosed the fileIntegrativeCheckChosed to set
     */
    public static void setFileIntegrativeCheckChosed(String fileIntegrativeCheckChosed) {
        HomeVariables.fileIntegrativeCheckChosed.set(fileIntegrativeCheckChosed);
    }

    /**
     * @return the outputUrl
     */
    public static StringProperty getOutputUrl() {
        return outputUrl;
    }

    /**
     * @param outputUrl the outputUrl to set
     */
    public static void setOutputUrl(String outputUrl) {
        HomeVariables.outputUrl.set(outputUrl);
    }

    /**
     * @return the fileOutputTextContent
     */
    public static StringProperty getFileOutputTextContent() {
        return fileOutputTextContent;
    }

    /**
     * @param fileOutputTextContent the fileOutputTextContent to set
     */
    public static void setFileOutputTextContent(String fileOutputTextContent) {
        HomeVariables.fileOutputTextContent.set(fileOutputTextContent);
    }

    public static void resetproperties() {
        response.set("");
        errorCode.set("");
        errorMessage.set("");
        errorClass.set("");
        models.set("");
        modelId.set("");
        fileId.set("");
        modelInputListFiles.set("");
        modelOutputTextListFiles.set("");
        modelOutputHtmlListFiles.set("");
        fileInputContent.set("");
        fileOutputTextContent.set("");
        fileToUploadProVerif.set("");
        fileToUploadBigraph.set("");
        fileToUploadIntegrative.set("");
        fileProverifCheckChosed.set("");
        fileBigraphCheckChosed.set("");
        fileIntegrativeCheckChosed.set("");
        outputUrl.set("");
    }

    public static void resetErrors() {
        errorCode.set("");
        errorMessage.set("");
        errorClass.set("");
    }
}
