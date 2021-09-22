package it.uniud.mads.jlibbig.proverif.gui.constants;

public class Constants {

    private static final int sceneWidth = 1000;
    private static final int sceneHeight = 450;
    private static final int sceneMinWidth = 1000;
    private static final int sceneMinHeight =  450;
    private static final String[] proverifRequests = {"Get Models List", "Get Model", "Post Model", "Delete Model", "Get Input File", "Post Input File (Json)", "Post Input File (ProVerif)", "Put Input File (Json)", "Put Input File (ProVerif)", "Delete Input File", "Post Verification (Both)", "Post Verification (Text)", "Post Verification (Html)", "Put Verification (Both)", "Put Verification (Text)", "Put Verification (Html)", "Post Verification Only (Text)", "Post Verification Only (Html)", "Put Verification Only (Text)", "Put Verification Only (Html)", "Get Output (Text)", "Delete Output (Text)", "Get Output (Html)", "Delete Output (Html)"};
    private static final String proverifDefaultRequest = "Get Models List";
    
    // private static final String httpBaseUrl = "http://172.19.0.3:5001/";
    private static final String httpBaseUrl = "http://localhost:8080/";
    
    
    /**
     * @return the scenewidth
     */
    public static int getScenewidth() {
        return sceneWidth;
    }

    /**
     * @return the sceneheight
     */
    public static int getSceneheight() {
        return sceneHeight;
    }

    /**
     * @return the proverifrequests
     */
    public static String[] getProverifrequests() {
        return proverifRequests;
    }

    /**
     * @return the sceneminwidth
     */
    public static int getSceneminwidth() {
        return sceneMinWidth;
    }

    /**
     * @return the sceneminheight
     */
    public static int getSceneminheight() {
        return sceneMinHeight;
    }

    /**
     * @return the httpbaseurl
     */
    public static String getHttpbaseurl() {
        return httpBaseUrl;
    }

    /**
     * @return the proverifdefaultrequest
     */
    public static String getProverifdefaultrequest() {
        return proverifDefaultRequest;
    }
}
