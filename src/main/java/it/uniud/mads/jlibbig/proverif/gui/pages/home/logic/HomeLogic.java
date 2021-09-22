package it.uniud.mads.jlibbig.proverif.gui.pages.home.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONObject;

import it.uniud.mads.jlibbig.proverif.gui.networking.ProverifRequests;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.Conflict409Exception;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.GeneralException;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.InternalServerError500Exception;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.NotFound404Exception;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.UnsupportedMediaType415Exception;
import it.uniud.mads.jlibbig.proverif.gui.pages.home.layout.HomeScene;
import it.uniud.mads.jlibbig.proverif.gui.utils.Validator;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class HomeLogic {

    public static void saveInputFileButtonBehaviour(Stage window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        String initialFileName = HomeVariables.getModelId().getValue() + "_" + HomeVariables.getFileId().getValue()
                + "_input.txt";
        fileChooser.setInitialFileName(initialFileName);
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        // Opening a dialog box
        File file = fileChooser.showSaveDialog(window);
        if (file != null) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(file);
                writer.println(HomeVariables.getFileInputContent().getValue());
                writer.close();
            } catch (IOException ex) {
                HomeVariables.setErrorCode("400");
                HomeVariables.setErrorMessage("File not saved, something went wrong.");
                HomeVariables.setErrorClass("IOException");
            }
        }
    }

    public static void saveOutputTextButtonBehaviour(Stage window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        String initialFileName = HomeVariables.getModelId().getValue() + "_" + HomeVariables.getFileId().getValue()
                + "_output.txt";
        fileChooser.setInitialFileName(initialFileName);
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        // Opening a dialog box
        File file = fileChooser.showSaveDialog(window);
        if (file != null) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(file);
                writer.println(HomeVariables.getFileOutputTextContent().getValue());
                writer.close();
            } catch (IOException ex) {
                HomeVariables.setErrorCode("400");
                HomeVariables.setErrorMessage("File not saved, something went wrong.");
                HomeVariables.setErrorClass("IOException");
            }
        }
    }

    public static void openUrlOutputButtonBehaviour() {
        String url = HomeVariables.getOutputUrl().getValue();
        if (!(url.isBlank())) {
            String os = System.getProperty("os.name").toLowerCase();
            Runtime rt = Runtime.getRuntime();
            try {
                if (os.indexOf("win") >= 0) {
                    // this doesn't support showing urls in the form of "page.html#nameLink"
                    rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.indexOf("mac") >= 0) {
                    rt.exec("open " + url);
                } else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {
                    // Do a best guess on unix until we get a platform independent way
                    // Build a list of browsers to try, in this order.
                    String[] browsers = { "epiphany", "google-chrome", "firefox", "mozilla", "konqueror", "netscape",
                            "opera", "links", "lynx" };
                    // Build a command string which looks like "browser1 "url" || browser2 "url"
                    // ||..."
                    StringBuffer cmd = new StringBuffer();
                    for (int i = 0; i < browsers.length; i++)
                        cmd.append((i == 0 ? "" : " || ") + browsers[i] + " \"" + url + "\" ");
                    rt.exec(new String[] { "sh", "-c", cmd.toString() });
                } else {
                    HomeVariables.setErrorCode("400");
                    HomeVariables.setErrorMessage("No compatible OS");
                    HomeVariables.setErrorClass("");
                }
            } catch (Exception f) {
                HomeVariables.setErrorCode("400");
                HomeVariables.setErrorMessage("Cannot open the link, Here is the link: " + url);
                HomeVariables.setErrorClass("");
            }
        } else {
            HomeVariables.setErrorCode("400");
            HomeVariables.setErrorMessage("No url could be load");
            HomeVariables.setErrorClass("");
        }
    }

    public static void uploadInputFileProverifButtonBehaviour(Stage window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("ProVerif", "*.pv*"));
        // Opening a dialog box
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                String result = "";
                while ((line = reader.readLine()) != null) {
                    result += line + " ";
                }
                HomeVariables.setFileToUploadProVerif(result);
                HomeVariables.setFileProverifCheckChosed("File Choosed");
            } catch (Exception f) {
                HomeVariables.setErrorCode("400");
                HomeVariables.setErrorMessage("File not load, something went wrong. Try Again");
                HomeVariables.setErrorClass("");
            }
        }
    }

    public static void uploadInputFileBigraphButtonBehaviour(Stage window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Json", "*.json*"));
        // Opening a dialog box
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                String result = "";
                while ((line = reader.readLine()) != null) {
                    result += line + " ";
                }
                HomeVariables.setFileToUploadBigraph(result);
                HomeVariables.setFileBigraphCheckChosed("File Choosed");
            } catch (Exception f) {
                HomeVariables.setErrorCode("400");
                HomeVariables.setErrorMessage("File not load, something went wrong. Try Again");
                HomeVariables.setErrorClass("");
            }
        }
    }

    public static void uploadInputFileIntegrativeButtonBehaviout(Stage window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Json", "*.json*"));
        // Opening a dialog box
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                String result = "";
                while ((line = reader.readLine()) != null) {
                    result += line + " ";
                }
                HomeVariables.setFileToUploadIntegrative(result);
                HomeVariables.setFileIntegrativeCheckChosed("File Choosed");
            } catch (Exception f) {
                HomeVariables.setErrorCode("400");
                HomeVariables.setErrorMessage("File not load, something went wrong. Try Again");
                HomeVariables.setErrorClass("");
            }
        }
    }

    public static void sendButtonBehaviour() {
        ChoiceBox<String> requestInputBox = HomeScene.getRequestTypeChoiceBox();
        TextField model = HomeScene.getModelInputField();
        TextField file = HomeScene.getFileInputField();
        try {
            switch (requestInputBox.getValue()) {
                case "Get Models List":
                    HomeVariables.resetErrors();
                    String responseGetModelList = ProverifRequests.getModels();
                    JSONObject jsonGetModelList = new JSONObject(responseGetModelList);
                    HomeVariables
                            .setModels(printModels(jsonGetModelList.getJSONObject("Response").getJSONArray("Models")));
                    break;
                case "Get Model":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        String responseGetModel = ProverifRequests.getModel(model.getText());
                        JSONObject jsonGetModel = new JSONObject(responseGetModel);
                        HomeVariables.setModelId(jsonGetModel.getJSONObject("Response").getString("Model"));
                        HomeVariables.setModelInputListFiles(
                                printModels(jsonGetModel.getJSONObject("Response").getJSONArray("Input")));
                        HomeVariables.setModelOutputTextListFiles(
                                printModels(jsonGetModel.getJSONObject("Response").getJSONArray("OutputText")));
                        HomeVariables.setModelOutputHtmlListFiles(
                                printModels(jsonGetModel.getJSONObject("Response").getJSONArray("OutputHtml")));
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Post Model":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        String responsePostModel = ProverifRequests.postModel(model.getText());
                        JSONObject jsonPostModel = new JSONObject(responsePostModel);
                        HomeVariables.setResponse(jsonPostModel.getJSONObject("Response").getString("Result"));
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Delete Model":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        String responseDeleteModel = ProverifRequests.deleteModel(model.getText());
                        JSONObject jsonDeleteModel = new JSONObject(responseDeleteModel);
                        HomeVariables.setResponse(jsonDeleteModel.getJSONObject("Response").getString("Result"));
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Get Input File":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            String responseGetInput = ProverifRequests.getInputFile(model.getText(), file.getText());
                            JSONObject jsonGetInput = new JSONObject(responseGetInput);
                            HomeVariables.setModelId(jsonGetInput.getJSONObject("Response").getString("Model"));
                            HomeVariables.setFileId(jsonGetInput.getJSONObject("Response").getString("File"));
                            HomeVariables
                                    .setFileInputContent(jsonGetInput.getJSONObject("Response").getString("Result"));
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Post Input File (Json)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadBigraph().getValue().isBlank())) {
                                if (!(HomeVariables.getFileToUploadIntegrative().getValue().isBlank())) {
                                    String responsePostInput = ProverifRequests.postInputFile(model.getText(),
                                            file.getText(), "DataJsonBigraph",
                                            HomeVariables.getFileToUploadBigraph().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip(),
                                            "DataJsonIntegrative",
                                            HomeVariables.getFileToUploadIntegrative().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip());
                                    JSONObject jsonPostInput = new JSONObject(responsePostInput);
                                    HomeVariables
                                            .setResponse(jsonPostInput.getJSONObject("Response").getString("Result"));
                                } else {
                                    HomeVariables.setErrorCode("400");
                                    HomeVariables.setErrorMessage("Upload a Json Integrative file.");
                                    HomeVariables.setErrorClass("");

                                }
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Json Bigraph file.");
                                HomeVariables.setErrorClass("");

                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Post Input File (ProVerif)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadProVerif().getValue().isBlank())) {
                                String responsePostInput = ProverifRequests.postInputFile(model.getText(),
                                        file.getText(), "DataProverif",
                                        HomeVariables.getFileToUploadProVerif().getValue().replaceAll("\n", " ")
                                                .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                .replaceAll(System.getProperty("line.separator"), " ").strip(),
                                        null, null);
                                JSONObject jsonPostInput = new JSONObject(responsePostInput);
                                HomeVariables.setResponse(jsonPostInput.getJSONObject("Response").getString("Result"));
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Proverif file.");
                                HomeVariables.setErrorClass("");
                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Put Input File (Json)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadBigraph().getValue().isBlank())) {
                                if (!(HomeVariables.getFileToUploadIntegrative().getValue().isBlank())) {
                                    String responsePutInput = ProverifRequests.putInputFile(model.getText(),
                                            file.getText(), "DataJsonBigraph",
                                            HomeVariables.getFileToUploadBigraph().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip(),
                                            "DataJsonIntegrative",
                                            HomeVariables.getFileToUploadIntegrative().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip());
                                    JSONObject jsonPostInput = new JSONObject(responsePutInput);
                                    HomeVariables
                                            .setResponse(jsonPostInput.getJSONObject("Response").getString("Result"));
                                } else {
                                    HomeVariables.setErrorCode("400");
                                    HomeVariables.setErrorMessage("Upload a Json Integrative file.");
                                    HomeVariables.setErrorClass("");

                                }
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Json Bigraph file.");
                                HomeVariables.setErrorClass("");

                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Put Input File (ProVerif)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadProVerif().getValue().isBlank())) {
                                String responsePutInput = ProverifRequests.putInputFile(model.getText(), file.getText(),
                                        "DataProverif",
                                        HomeVariables.getFileToUploadProVerif().getValue().replaceAll("\n", " ")
                                                .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                .replaceAll(System.getProperty("line.separator"), " ").strip(),
                                        null, null);
                                JSONObject jsonPostInput = new JSONObject(responsePutInput);
                                HomeVariables.setResponse(jsonPostInput.getJSONObject("Response").getString("Result"));
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Proverif file.");
                                HomeVariables.setErrorClass("");
                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Delete Input File":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            String responseDeleteInput = ProverifRequests.deleteInputFile(model.getText(),
                                    file.getText());
                            JSONObject jsonDeleteInput = new JSONObject(responseDeleteInput);
                            HomeVariables.setResponse(jsonDeleteInput.getJSONObject("Response").getString("Result"));
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Post Verification (Both)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadBigraph().getValue().isBlank())) {
                                if (!(HomeVariables.getFileToUploadIntegrative().getValue().isBlank())) {
                                    String responsePostVerification = ProverifRequests.postVerify(model.getText(),
                                            file.getText(), "VerificationType", "both", "DataJsonBigraph",
                                            HomeVariables.getFileToUploadBigraph().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip(),
                                            "DataJsonIntegrative",
                                            HomeVariables.getFileToUploadIntegrative().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip());
                                    JSONObject jsonPostVerification = new JSONObject(responsePostVerification);
                                    HomeVariables.setModelId(jsonPostVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("Model"));
                                    HomeVariables.setFileId(jsonPostVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("File"));
                                    HomeVariables.setFileOutputTextContent(jsonPostVerification
                                            .getJSONObject("Response").getJSONObject("OutputText").getString("Result"));
                                    HomeVariables.setOutputUrl(
                                            jsonPostVerification.getJSONObject("Response").getString("OutputHtml"));
                                } else {
                                    HomeVariables.setErrorCode("400");
                                    HomeVariables.setErrorMessage("Upload a Json Integrative file.");
                                    HomeVariables.setErrorClass("");

                                }
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Json Bigraph file.");
                                HomeVariables.setErrorClass("");

                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Put Verification (Both)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadBigraph().getValue().isBlank())) {
                                if (!(HomeVariables.getFileToUploadIntegrative().getValue().isBlank())) {
                                    String responsePutVerification = ProverifRequests.putVerify(model.getText(),
                                            file.getText(), "VerificationType", "both", "DataJsonBigraph",
                                            HomeVariables.getFileToUploadBigraph().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip(),
                                            "DataJsonIntegrative",
                                            HomeVariables.getFileToUploadIntegrative().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip());
                                    JSONObject jsonPutVerification = new JSONObject(responsePutVerification);
                                    HomeVariables.setModelId(jsonPutVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("Model"));
                                    HomeVariables.setFileId(jsonPutVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("File"));
                                    HomeVariables.setFileOutputTextContent(jsonPutVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("Result"));
                                    HomeVariables.setOutputUrl(
                                            jsonPutVerification.getJSONObject("Response").getString("OutputHtml"));
                                } else {
                                    HomeVariables.setErrorCode("400");
                                    HomeVariables.setErrorMessage("Upload a Json Integrative file.");
                                    HomeVariables.setErrorClass("");

                                }
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Json Bigraph file.");
                                HomeVariables.setErrorClass("");

                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Post Verification (Text)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadBigraph().getValue().isBlank())) {
                                if (!(HomeVariables.getFileToUploadIntegrative().getValue().isBlank())) {
                                    String responsePostVerification = ProverifRequests.postVerify(model.getText(),
                                            file.getText(), "VerificationType", "text", "DataJsonBigraph",
                                            HomeVariables.getFileToUploadBigraph().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip(),
                                            "DataJsonIntegrative",
                                            HomeVariables.getFileToUploadIntegrative().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip());
                                    JSONObject jsonPostVerification = new JSONObject(responsePostVerification);
                                    HomeVariables.setModelId(jsonPostVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("Model"));
                                    HomeVariables.setFileId(jsonPostVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("File"));
                                    HomeVariables.setFileOutputTextContent(jsonPostVerification
                                            .getJSONObject("Response").getJSONObject("OutputText").getString("Result"));
                                } else {
                                    HomeVariables.setErrorCode("400");
                                    HomeVariables.setErrorMessage("Upload a Json Integrative file.");
                                    HomeVariables.setErrorClass("");

                                }
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Json Bigraph file.");
                                HomeVariables.setErrorClass("");

                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Put Verification (Text)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadBigraph().getValue().isBlank())) {
                                if (!(HomeVariables.getFileToUploadIntegrative().getValue().isBlank())) {
                                    String responsePutVerification = ProverifRequests.putVerify(model.getText(),
                                            file.getText(), "VerificationType", "text", "DataJsonBigraph",
                                            HomeVariables.getFileToUploadBigraph().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip(),
                                            "DataJsonIntegrative",
                                            HomeVariables.getFileToUploadIntegrative().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip());
                                    JSONObject jsonPutVerification = new JSONObject(responsePutVerification);
                                    HomeVariables.setModelId(jsonPutVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("Model"));
                                    HomeVariables.setFileId(jsonPutVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("File"));
                                    HomeVariables.setFileOutputTextContent(jsonPutVerification.getJSONObject("Response")
                                            .getJSONObject("OutputText").getString("Result"));
                                } else {
                                    HomeVariables.setErrorCode("400");
                                    HomeVariables.setErrorMessage("Upload a Json Integrative file.");
                                    HomeVariables.setErrorClass("");

                                }
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Json Bigraph file.");
                                HomeVariables.setErrorClass("");

                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Post Verification (Html)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadBigraph().getValue().isBlank())) {
                                if (!(HomeVariables.getFileToUploadIntegrative().getValue().isBlank())) {
                                    String responsePostVerification = ProverifRequests.postVerify(model.getText(),
                                            file.getText(), "VerificationType", "html", "DataJsonBigraph",
                                            HomeVariables.getFileToUploadBigraph().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip(),
                                            "DataJsonIntegrative",
                                            HomeVariables.getFileToUploadIntegrative().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip());
                                    JSONObject jsonPostVerification = new JSONObject(responsePostVerification);
                                    HomeVariables.setOutputUrl(
                                            jsonPostVerification.getJSONObject("Response").getString("OutputHtml"));
                                } else {
                                    HomeVariables.setErrorCode("400");
                                    HomeVariables.setErrorMessage("Upload a Json Integrative file.");
                                    HomeVariables.setErrorClass("");

                                }
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Json Bigraph file.");
                                HomeVariables.setErrorClass("");

                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Put Verification (Html)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            if (!(HomeVariables.getFileToUploadBigraph().getValue().isBlank())) {
                                if (!(HomeVariables.getFileToUploadIntegrative().getValue().isBlank())) {
                                    String responsePutVerification = ProverifRequests.putVerify(model.getText(),
                                            file.getText(), "VerificationType", "html", "DataJsonBigraph",
                                            HomeVariables.getFileToUploadBigraph().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip(),
                                            "DataJsonIntegrative",
                                            HomeVariables.getFileToUploadIntegrative().getValue().replaceAll("\n", " ")
                                                    .replaceAll("\r", "").replaceAll("\t", " ").replaceAll(" +", " ")
                                                    .replaceAll(System.getProperty("line.separator"), " ")
                                                    .replaceAll("\"", "\\\\\"").strip());
                                    JSONObject jsonPutVerification = new JSONObject(responsePutVerification);
                                    HomeVariables.setOutputUrl(
                                            jsonPutVerification.getJSONObject("Response").getString("OutputHtml"));
                                } else {
                                    HomeVariables.setErrorCode("400");
                                    HomeVariables.setErrorMessage("Upload a Json Integrative file.");
                                    HomeVariables.setErrorClass("");

                                }
                            } else {
                                HomeVariables.setErrorCode("400");
                                HomeVariables.setErrorMessage("Upload a Json Bigraph file.");
                                HomeVariables.setErrorClass("");

                            }
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Post Verification Only (Text)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            String responsePostVerification = ProverifRequests.postVerify(model.getText(),
                                    file.getText(), "VerificationType", "text", null, null, null, null);
                            JSONObject jsonPostVerification = new JSONObject(responsePostVerification);
                            HomeVariables.setResponse(jsonPostVerification.getJSONObject("Response").getString("Result")
                                    + ". Output Ready.");
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Put Verification Only (Text)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            String responsePutVerification = ProverifRequests.putVerify(model.getText(), file.getText(),
                                    "VerificationType", "text", null, null, null, null);
                            JSONObject jsonPutVerification = new JSONObject(responsePutVerification);
                            HomeVariables.setResponse(jsonPutVerification.getJSONObject("Response").getString("Result")
                                    + ". Output Ready.");
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Post Verification Only (Html)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            String responsePostVerification = ProverifRequests.postVerify(model.getText(),
                                    file.getText(), "VerificationType", "html", null, null, null, null);
                            JSONObject jsonPostVerification = new JSONObject(responsePostVerification);
                            HomeVariables.setResponse(jsonPostVerification.getJSONObject("Response").getString("Result")
                                    + ". Output Ready.");
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Put Verification Only (Html)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            String responsePutVerification = ProverifRequests.putVerify(model.getText(), file.getText(),
                                    "VerificationType", "html", null, null, null, null);
                            JSONObject jsonPutVerification = new JSONObject(responsePutVerification);
                            HomeVariables.setResponse(jsonPutVerification.getJSONObject("Response").getString("Result")
                                    + ". Output Ready.");
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Get Output (Text)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            String responseGetOutput = ProverifRequests.getOutputText(model.getText(), file.getText());
                            JSONObject jsonGetOutput = new JSONObject(responseGetOutput);
                            HomeVariables.setModelId(jsonGetOutput.getJSONObject("Response").getString("Model"));
                            HomeVariables.setFileId(jsonGetOutput.getJSONObject("Response").getString("File"));
                            HomeVariables.setFileOutputTextContent(
                                    jsonGetOutput.getJSONObject("Response").getString("Result"));

                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Get Output (Html)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        String responseGetOutput = ProverifRequests.getOutputHtml(model.getText());
                        JSONObject jsonGetOutput = new JSONObject(responseGetOutput);
                        HomeVariables.setOutputUrl(jsonGetOutput.getJSONObject("Response").getString("url"));
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Delete Output (Text)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        if (Validator.isNotEmpty(file)) {
                            String responseDeleteOutput = ProverifRequests.deleteOutputText(model.getText(),
                                    file.getText());
                            JSONObject jsonDeleteOutput = new JSONObject(responseDeleteOutput);
                            HomeVariables.setResponse(jsonDeleteOutput.getJSONObject("Response").getString("Result"));
                        } else {
                            HomeVariables.setErrorCode("400");
                            HomeVariables.setErrorMessage("Specify a File Name");
                            HomeVariables.setErrorClass("");
                        }
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                case "Delete Output (Html)":
                    HomeVariables.resetErrors();
                    if (Validator.isNotEmpty(model)) {
                        String responseDeleteOutput = ProverifRequests.deleteOutputHtml(model.getText());
                        JSONObject jsonDeleteOutput = new JSONObject(responseDeleteOutput);
                        HomeVariables.setResponse(jsonDeleteOutput.getJSONObject("Response").getString("Result"));
                    } else {
                        HomeVariables.setErrorCode("400");
                        HomeVariables.setErrorMessage("Specify a Model");
                        HomeVariables.setErrorClass("");
                    }
                    break;
                default:
                    System.out.println("Invalid request type");
                    break;
            }
        } catch (NotFound404Exception | InternalServerError500Exception | GeneralException | IOException
                | Conflict409Exception | UnsupportedMediaType415Exception e) {
            try {
                JSONObject json = new JSONObject(e.getMessage());
                try {
                    HomeVariables.setErrorCode("500");
                    HomeVariables.setErrorMessage(json.getString("Error"));
                    HomeVariables.setErrorClass(json.getString("Exception"));
                } catch (org.json.JSONException f) {
                    try {
                        HomeVariables.setErrorCode(json.getJSONObject("Response").getString("code"));
                        HomeVariables.setErrorMessage(
                                json.getJSONObject("Response").getJSONObject("error").getString("message"));
                        HomeVariables.setErrorClass("");

                    } catch (org.json.JSONException g) {
                        try {
                            HomeVariables.setErrorCode("500");
                            HomeVariables.setErrorMessage(json.getString("message"));
                            HomeVariables.setErrorClass("");
                        } catch (org.json.JSONException h) {
                            try {
                                HomeVariables.setErrorCode("500");
                                String mex = json.getString("Response");
                                mex = mex.split("\n")[0];
                                HomeVariables.setErrorMessage(mex);
                                HomeVariables.setErrorClass("");
                            } catch (org.json.JSONException l) {
                                try {
                                    HomeVariables.setErrorCode("400");
                                    HomeVariables.setErrorMessage(l.getMessage());
                                    HomeVariables.setErrorClass(l.getClass() + "");
                                } catch (Exception m) {
                                    HomeVariables.setErrorCode("500");
                                    HomeVariables.setErrorMessage("Server Error Unknown");
                                    HomeVariables.setErrorClass("");
                                }
                            }
                        }
                    }
                }
            } catch (org.json.JSONException a) {
                try {
                    HomeVariables.setErrorCode("500");
                    HomeVariables.setErrorMessage(e.getMessage());
                    HomeVariables.setErrorClass(e.getClass() + "");
                } catch (Exception b) {
                    HomeVariables.setErrorCode("500");
                    HomeVariables.setErrorMessage("Server Error Unknown");
                    HomeVariables.setErrorClass("");
                }
            }

        }
    }

    private static String printModels(JSONArray models) {
        String results = "";
        for (int i = 0; i < models.length(); i++) {
            results += models.getString(i) + ",\n";
        }
        if (!(results.isBlank())) {
            results = results.substring(0, results.length() - 2);
        }
        return results;
    }

}
