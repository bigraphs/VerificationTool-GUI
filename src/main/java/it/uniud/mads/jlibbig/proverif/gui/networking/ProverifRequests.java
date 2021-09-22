package it.uniud.mads.jlibbig.proverif.gui.networking;

import java.io.IOException;

import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.Conflict409Exception;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.GeneralException;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.InternalServerError500Exception;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.NotFound404Exception;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.UnsupportedMediaType415Exception;

public class ProverifRequests {

    /**
     * Get all the models in the server
     * 
     * @return the json string represents all models
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws NotFound404Exception
     */
    public static String getModels()
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        return HttpRequests.get("models");
    }

    /**
     * Get a single model in the server
     * 
     * @param model the wanted model
     * @return the json string represents the wanted model
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws NotFound404Exception
     */
    public static String getModel(String model)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model;
        return HttpRequests.get(url);
    }

    /**
     * Post a new model in the server
     * 
     * @param model the new model wanted
     * @return the json string with the server response
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws UnsupportedMediaType415Exception
     * @throws Conflict409Exception
     * @throws NotFound404Exception
     */
    public static String postModel(String model) throws NotFound404Exception, Conflict409Exception,
            UnsupportedMediaType415Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model;
        return HttpRequests.post("POST", url, null, null, null, null, null, null);
    }

    /**
     * Delete a model in the server
     * 
     * @param model the model to be deleted
     * @return the json string represent the server response
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws NotFound404Exception
     */
    public static String deleteModel(String model)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model;
        return HttpRequests.delete(url);
    }

    /**
     * Get the input file
     * 
     * @param model    the model of the input file wanted
     * @param filename the filename wanted
     * @return the json string represent the input file
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws NotFound404Exception
     */
    public static String getInputFile(String model, String filename)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/input/text/" + filename;
        return HttpRequests.get(url);
    }

    /**
     * Post the input file
     * 
     * @param model    the model of the input file
     * @param filename the name of the input file
     * @param filebody the body of the input file
     * @return the json string represent the server response
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws UnsupportedMediaType415Exception
     * @throws Conflict409Exception
     * @throws NotFound404Exception
     */
    public static String postInputFile(String model, String filename, String typeArg1, String filebody1,
            String typeArg2, String filebody2) throws NotFound404Exception, Conflict409Exception,
            UnsupportedMediaType415Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/input/text/" + filename;
        return HttpRequests.post("POST", url, typeArg1, filebody1, typeArg2, filebody2, null, null);
    }

    /**
     * Post the input file
     * 
     * @param model    the model of the input file
     * @param filename the name of the input file
     * @param filebody the body of the input file
     * @return the json string represent the server response
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws UnsupportedMediaType415Exception
     * @throws Conflict409Exception
     * @throws NotFound404Exception
     */
    public static String putInputFile(String model, String filename, String typeArg1, String filebody1, String typeArg2,
            String filebody2) throws NotFound404Exception, Conflict409Exception, UnsupportedMediaType415Exception,
            InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/input/text/" + filename;
        return HttpRequests.post("PUT", url, typeArg1, filebody1, typeArg2, filebody2, null, null);
    }

    /**
     * Delete the input file
     * 
     * @param model    the model of the input file
     * @param filename the name of the input file
     * @return the json string represent the server response
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws NotFound404Exception
     */
    public static String deleteInputFile(String model, String filename)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/input/text/" + filename;
        return HttpRequests.delete(url);
    }

    /**
     * Post a verify
     * 
     * @param model    the model of the file name to verify
     * @param filename the file name to verify
     * @return the json string represent the server response
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws UnsupportedMediaType415Exception
     * @throws Conflict409Exception
     * @throws NotFound404Exception
     */
    public static String postVerify(String model, String filename, String typeArg1, String filebody1, String typeArg2,
            String filebody2, String typeArg3, String filebody3) throws NotFound404Exception, Conflict409Exception,
            UnsupportedMediaType415Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/verify/" + filename;
        return HttpRequests.post("POST", url, typeArg1, filebody1, typeArg2, filebody2, typeArg3, filebody3);
    }

    /**
     * Post a verify
     * 
     * @param model    the model of the file name to verify
     * @param filename the file name to verify
     * @return the json string represent the server response
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws UnsupportedMediaType415Exception
     * @throws Conflict409Exception
     * @throws NotFound404Exception
     */
    public static String putVerify(String model, String filename, String typeArg1, String filebody1, String typeArg2,
            String filebody2, String typeArg3, String filebody3) throws NotFound404Exception, Conflict409Exception,
            UnsupportedMediaType415Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/verify/" + filename;
        return HttpRequests.post("PUT", url, typeArg1, filebody1, typeArg2, filebody2, typeArg3, filebody3);
    }

    /**
     * Get the proverif output of the text-mode
     * 
     * @param model    the model of the output filename
     * @param filename the output filename
     * @return the json string represents the proverif output of text-mode
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws NotFound404Exception
     */
    public static String getOutputText(String model, String filename)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/output/text/" + filename;
        return HttpRequests.get(url);
    }

    /**
     * Delete the proverif output of the text-mode
     * 
     * @param model    the model of the output filename
     * @param filename the output filename
     * @return the jdon string represents the server response
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws NotFound404Exception
     */
    public static String deleteOutputText(String model, String filename)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/output/text/" + filename;
        return HttpRequests.delete(url);
    }

    /**
     * Get the proverif output of the html-mode
     * 
     * @param model the model of the output filename
     * @return the json string represents the proverif output of html-mode
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws NotFound404Exception
     */
    public static String getOutputHtml(String model)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/output/html/index.html";
        return HttpRequests.get(url);
    }

    /**
     * Delete the proverif output of the html-mode
     * 
     * @param model the model of the output filename
     * @return the jdon string represents the server response
     * @throws IOException
     * @throws GeneralException
     * @throws InternalServerError500Exception
     * @throws NotFound404Exception
     */
    public static String deleteOutputHtml(String model)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        String url = "models/" + model + "/output/html/index.html";
        return HttpRequests.delete(url);

    }
}
