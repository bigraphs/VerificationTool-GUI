package it.uniud.mads.jlibbig.proverif.gui.pages.home.logic;

import it.uniud.mads.jlibbig.proverif.gui.pages.home.layout.HomeScene;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.GridPane;

public class HomeLogicDynamic {

    public static void setScene(ObservableValue<? extends String> v, String oldValue, String newValue) {
        GridPane sideGrid = HomeScene.getRightSideGrid();
        GridPane centerGrid = HomeScene.getCenterGrid();

        if (newValue.equals("Get Models List")) {
            setModelsListView(sideGrid, centerGrid);
        } else if (newValue.equals("Get Model")) {
            setModelView(sideGrid, centerGrid);
        } else if (newValue.equals("Post Model") || newValue.equals("Delete Model")
                || newValue.equals("Delete Output (Html)")) {
            setPostDeleteModelOutputView(sideGrid, centerGrid);
        } else if (newValue.equals("Get Input File")) {
            setGetInputView(sideGrid, centerGrid);
        } else if (newValue.equals("Post Input File (Json)") || newValue.equals("Put Input File (Json)")) {
            setPostPutInputJsonView(sideGrid, centerGrid);
        } else if (newValue.equals("Post Input File (ProVerif)") || newValue.equals("Put Input File (ProVerif)")) {
            setPostPutInputProverifView(sideGrid, centerGrid);
        } else if (newValue.equals("Delete Input File")) {
            setDeleteInputView(sideGrid, centerGrid);
        } else if (newValue.equals("Post Verification (Both)") || newValue.equals("Put Verification (Both)")) {
            setPostPutVerificationBothView(sideGrid, centerGrid);
        } else if (newValue.equals("Post Verification (Text)") || newValue.equals("Put Verification (Text)")) {
            setPostPutVerificationTextView(sideGrid, centerGrid);
        } else if (newValue.equals("Post Verification (Html)") || newValue.equals("Put Verification (Html)")) {
            setPostPutVerificationHtmlView(sideGrid, centerGrid);
        } else if (newValue.equals("Post Verification Only (Text)") || newValue.equals("Post Verification Only (Html)")
                || newValue.equals("Put Verification Only (Text)") || newValue.equals("Put Verification Only (Html)")) {
            setPostPutVerificationOnlyView(sideGrid, centerGrid);
        } else if (newValue.equals("Get Output (Html)")) {
            setGetOutputHtmlView(sideGrid, centerGrid);
        } else if (newValue.equals("Get Output (Text)")) {
            setGetOutputTextView(sideGrid, centerGrid);
        } else if (newValue.equals("Delete Output (Text)")) {
            setDeleteOutputTextView(sideGrid, centerGrid);
        }
    }

    private static void setModelsListView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelListLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelListContent(), 1, 0);
        centerGrid.getChildren().addAll(HomeScene.getModelListLabel(), HomeScene.getModelListContent());
    }

    private static void setModelView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelIdLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelIdContent(), 1, 0);
        GridPane.setConstraints(HomeScene.getModelInputListLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getModelInputListContent(), 1, 1);
        GridPane.setConstraints(HomeScene.getModelOutputTextListLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getModelOutputTextListContent(), 1, 2);
        GridPane.setConstraints(HomeScene.getModelOutputHtmlListLabel(), 0, 3);
        GridPane.setConstraints(HomeScene.getModelOutputHtmlListContent(), 1, 3);
        centerGrid.getChildren().addAll(HomeScene.getModelIdLabel(), HomeScene.getModelIdContent(),
                HomeScene.getModelInputListLabel(), HomeScene.getModelInputListContent(),
                HomeScene.getModelOutputTextListLabel(), HomeScene.getModelOutputTextListContent(),
                HomeScene.getModelOutputHtmlListLabel(), HomeScene.getModelOutputHtmlListContent());
    }

    private static void setPostDeleteModelOutputView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getResponseContent(), 1, 0);
        centerGrid.getChildren().addAll(HomeScene.getResponseLabel(), HomeScene.getResponseContent());
    }

    private static void setGetInputView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelIdLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelIdContent(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileIdLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileIdContent(), 1, 1);
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getSaveInputFile(), 1, 2);
        centerGrid.getChildren().addAll(HomeScene.getModelIdLabel(), HomeScene.getModelIdContent(),
                HomeScene.getFileIdLabel(), HomeScene.getFileIdContent(), HomeScene.getResponseLabel(),
                HomeScene.getSaveInputFile());
    }

    private static void setPostPutInputJsonView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        GridPane.setConstraints(HomeScene.getFileInputBigraphLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getUploadInputFileBigraph(), 1, 2);
        GridPane.setConstraints(HomeScene.getFileInputBigraphContent(), 2, 2);
        GridPane.setConstraints(HomeScene.getFileInputIntegrativeLabel(), 0, 3);
        GridPane.setConstraints(HomeScene.getUploadInputFileIntegrative(), 1, 3);
        GridPane.setConstraints(HomeScene.getFileInputIntegrativeContent(), 2, 3);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField(), HomeScene.getFileInputBigraphLabel(),
                HomeScene.getUploadInputFileBigraph(), HomeScene.getFileInputBigraphContent(),
                HomeScene.getFileInputIntegrativeLabel(), HomeScene.getUploadInputFileIntegrative(),
                HomeScene.getFileInputIntegrativeContent());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getResponseContent(), 1, 0);
        centerGrid.getChildren().addAll(HomeScene.getResponseLabel(), HomeScene.getResponseContent());
    }

    private static void setPostPutInputProverifView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        GridPane.setConstraints(HomeScene.getFileInputProVerifLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getUploadInputFileProverif(), 1, 2);
        GridPane.setConstraints(HomeScene.getFileInputProVerifContent(), 2, 2);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField(), HomeScene.getFileInputProVerifLabel(),
                HomeScene.getUploadInputFileProverif(), HomeScene.getFileInputProVerifContent());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getResponseContent(), 1, 0);
        centerGrid.getChildren().addAll(HomeScene.getResponseLabel(), HomeScene.getResponseContent());
    }

    private static void setDeleteInputView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getResponseContent(), 1, 0);
        centerGrid.getChildren().addAll(HomeScene.getResponseLabel(), HomeScene.getResponseContent());
    }

    private static void setPostPutVerificationBothView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        GridPane.setConstraints(HomeScene.getFileInputBigraphLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getUploadInputFileBigraph(), 1, 2);
        GridPane.setConstraints(HomeScene.getFileInputBigraphContent(), 2, 2);
        GridPane.setConstraints(HomeScene.getFileInputIntegrativeLabel(), 0, 3);
        GridPane.setConstraints(HomeScene.getUploadInputFileIntegrative(), 1, 3);
        GridPane.setConstraints(HomeScene.getFileInputIntegrativeContent(), 2, 3);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField(), HomeScene.getFileInputBigraphLabel(),
                HomeScene.getUploadInputFileBigraph(), HomeScene.getFileInputBigraphContent(),
                HomeScene.getFileInputIntegrativeLabel(), HomeScene.getUploadInputFileIntegrative(),
                HomeScene.getFileInputIntegrativeContent());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelIdLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelIdContent(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileIdLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileIdContent(), 1, 1);
        GridPane.setConstraints(HomeScene.getUrlOutputLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getOpenUrlOutput(), 1, 2);
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 3);
        GridPane.setConstraints(HomeScene.getSaveOutputTextFile(), 1, 3);
        centerGrid.getChildren().addAll(HomeScene.getModelIdLabel(), HomeScene.getModelIdContent(),
                HomeScene.getFileIdLabel(), HomeScene.getFileIdContent(), HomeScene.getUrlOutputLabel(),
                HomeScene.getOpenUrlOutput(), HomeScene.getResponseLabel(), HomeScene.getSaveOutputTextFile());
    }

    private static void setPostPutVerificationTextView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        GridPane.setConstraints(HomeScene.getFileInputBigraphLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getUploadInputFileBigraph(), 1, 2);
        GridPane.setConstraints(HomeScene.getFileInputBigraphContent(), 2, 2);
        GridPane.setConstraints(HomeScene.getFileInputIntegrativeLabel(), 0, 3);
        GridPane.setConstraints(HomeScene.getUploadInputFileIntegrative(), 1, 3);
        GridPane.setConstraints(HomeScene.getFileInputIntegrativeContent(), 2, 3);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField(), HomeScene.getFileInputBigraphLabel(),
                HomeScene.getUploadInputFileBigraph(), HomeScene.getFileInputBigraphContent(),
                HomeScene.getFileInputIntegrativeLabel(), HomeScene.getUploadInputFileIntegrative(),
                HomeScene.getFileInputIntegrativeContent());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelIdLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelIdContent(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileIdLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileIdContent(), 1, 1);
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getSaveInputFile(), 1, 2);
        centerGrid.getChildren().addAll(HomeScene.getModelIdLabel(), HomeScene.getModelIdContent(),
                HomeScene.getFileIdLabel(), HomeScene.getFileIdContent(), HomeScene.getResponseLabel(),
                HomeScene.getSaveInputFile());
    }

    private static void setPostPutVerificationHtmlView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        GridPane.setConstraints(HomeScene.getFileInputBigraphLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getUploadInputFileBigraph(), 1, 2);
        GridPane.setConstraints(HomeScene.getFileInputBigraphContent(), 2, 2);
        GridPane.setConstraints(HomeScene.getFileInputIntegrativeLabel(), 0, 3);
        GridPane.setConstraints(HomeScene.getUploadInputFileIntegrative(), 1, 3);
        GridPane.setConstraints(HomeScene.getFileInputIntegrativeContent(), 2, 3);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField(), HomeScene.getFileInputBigraphLabel(),
                HomeScene.getUploadInputFileBigraph(), HomeScene.getFileInputBigraphContent(),
                HomeScene.getFileInputIntegrativeLabel(), HomeScene.getUploadInputFileIntegrative(),
                HomeScene.getFileInputIntegrativeContent());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getUrlOutputLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getOpenUrlOutput(), 1, 1);
        centerGrid.getChildren().addAll(HomeScene.getUrlOutputLabel(), HomeScene.getOpenUrlOutput());
    }

    private static void setPostPutVerificationOnlyView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getResponseContent(), 1, 0);
        centerGrid.getChildren().addAll(HomeScene.getResponseLabel(), HomeScene.getResponseContent());
    }

    private static void setGetOutputHtmlView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getUrlOutputLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getOpenUrlOutput(), 1, 1);
        centerGrid.getChildren().addAll(HomeScene.getUrlOutputLabel(), HomeScene.getOpenUrlOutput());
    }

    private static void setGetOutputTextView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelIdLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelIdContent(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileIdLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileIdContent(), 1, 1);
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 2);
        GridPane.setConstraints(HomeScene.getSaveInputFile(), 1, 2);
        centerGrid.getChildren().addAll(HomeScene.getModelIdLabel(), HomeScene.getModelIdContent(),
                HomeScene.getFileIdLabel(), HomeScene.getFileIdContent(), HomeScene.getResponseLabel(),
                HomeScene.getSaveInputFile());
    }

    private static void setDeleteOutputTextView(GridPane sideGrid, GridPane centerGrid) {
        HomeVariables.resetproperties();
        sideGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getModelLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getModelInputField(), 1, 0);
        GridPane.setConstraints(HomeScene.getFileLabel(), 0, 1);
        GridPane.setConstraints(HomeScene.getFileInputField(), 1, 1);
        sideGrid.getChildren().addAll(HomeScene.getModelLabel(), HomeScene.getModelInputField(),
                HomeScene.getFileLabel(), HomeScene.getFileInputField());
        centerGrid.getChildren().clear();
        GridPane.setConstraints(HomeScene.getResponseLabel(), 0, 0);
        GridPane.setConstraints(HomeScene.getResponseContent(), 1, 0);
        centerGrid.getChildren().addAll(HomeScene.getResponseLabel(), HomeScene.getResponseContent());
    }

}
