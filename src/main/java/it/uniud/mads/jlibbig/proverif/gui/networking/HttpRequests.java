package it.uniud.mads.jlibbig.proverif.gui.networking;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import it.uniud.mads.jlibbig.proverif.gui.constants.Constants;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.Conflict409Exception;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.GeneralException;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.InternalServerError500Exception;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.NotFound404Exception;
import it.uniud.mads.jlibbig.proverif.gui.networking.exceptions.UnsupportedMediaType415Exception;

public class HttpRequests {

    /**
     * Send generic http-get request to proverif server.
     * 
     * @param url the address for the get request without the base address
     * @return the result of the get request
     * @throws NotFound404Exception            if the server's response code is 404
     * @throws InternalServerError500Exception if the server's response code is 500
     * @throws GeneralException                if the server's response code is any
     *                                         over 300 but is not 404 or 500
     * @throws IOException
     */
    protected static String get(String url)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        HttpURLConnection connection = null;
        try {
            URL formattedUrl = new URL(Constants.getHttpbaseurl() + url);
            connection = (HttpURLConnection) formattedUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            // Get Response
            int responseCode = connection.getResponseCode();
            if (responseCode < 300) {
                return readStream(connection.getInputStream());
            } else if (responseCode == 404) {
                String response = readStream(connection.getErrorStream());
                throw new NotFound404Exception(response);
            } else if (responseCode == 500) {
                String response = readStream(connection.getErrorStream());
                throw new InternalServerError500Exception(response);
            } else {
                String response = readStream(connection.getErrorStream());
                throw new GeneralException(response);
            }
        } catch (IOException e) {
            String response = "{ \"Exception\": \"" + e.getClass() + "\", \"Error\": "
            + e.getLocalizedMessage() + " }";
            throw new IOException(response);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * Send generic http-post/put request to proverif server.
     * 
     * @param type          the type of request, post or put
     * @param url           the address for the post/put request without the base
     *                      address
     * @param propertyKey   the request's property key
     * @param propertyValue the request's property value
     * @return the result of the post/put request
     * @throws NotFound404Exception             if the server's response code is 404
     * @throws Conflict409Exception             if the server's response code is 409
     * @throws UnsupportedMediaType415Exception if the server's response code is 415
     * @throws InternalServerError500Exception  if the server's response code is 500
     * @throws GeneralException                 if the server's response code is any
     *                                          over 300 but is not 404, 409, 415 or
     *                                          500
     * @throws IOException
     */
    protected static String post(String type, String url, String propertyKey1, String propertyValue1, String propertyKey2, String propertyValue2,  String propertyKey3, String propertyValue3)
            throws NotFound404Exception, Conflict409Exception, UnsupportedMediaType415Exception,
            InternalServerError500Exception, GeneralException, IOException {
        HttpURLConnection connection = null;
        try {
            URL formattedUrl = new URL(Constants.getHttpbaseurl() + url);
            connection = (HttpURLConnection) formattedUrl.openConnection();
            connection.setRequestMethod(type);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            // Send Request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            String requestBody1 = "{\"" + propertyKey1 + "\": \"" + propertyValue1 + "\", \"" + propertyKey2 + "\": \"" + propertyValue2 + "\", \"" + propertyKey3 + "\": \"" + propertyValue3 + "\"}";
            wr.writeBytes(requestBody1);
            wr.flush();
            wr.close();
            // Get Response
            int responseCode = connection.getResponseCode();
            if (responseCode < 300) {
                return readStream(connection.getInputStream());
            } else if (responseCode == 404) {
                String response = readStream(connection.getErrorStream());
                throw new NotFound404Exception(response);
            } else if (responseCode == 409) {
                String response = readStream(connection.getErrorStream());
                throw new Conflict409Exception(response);
            } else if (responseCode == 415) {
                String response = readStream(connection.getErrorStream());
                throw new UnsupportedMediaType415Exception(response);
            } else if (responseCode == 500) {
                String response = readStream(connection.getErrorStream());
                throw new InternalServerError500Exception(response);
            } else {
                String response = readStream(connection.getErrorStream());
                System.out.println(response);
                throw new GeneralException(response);
            }
        } catch (IOException e) {
            String response = "{ \"Exception\": \"" + e.getClass() + "\", \"Error\": "
            + e.getLocalizedMessage() + " }";
            throw new IOException(response);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * Send generic http-delete request to proverif server.
     * 
     * @param url the address for the delete request without the base address
     * @return the result of the delete request
     * @throws NotFound404Exception            if the server's response code is 404
     * @throws InternalServerError500Exception if the server's response code is 500
     * @throws GeneralException                if the server's response code is any
     *                                         over 300 but is not 404 or 500
     * @throws IOException                     
     */
    protected static String delete(String url)
            throws NotFound404Exception, InternalServerError500Exception, GeneralException, IOException {
        HttpURLConnection connection = null;
        try {
            URL formattedUrl = new URL(Constants.getHttpbaseurl() + url);
            connection = (HttpURLConnection) formattedUrl.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            // Get Response
            int responseCode = connection.getResponseCode();
            if (responseCode < 300) {
                return readStream(connection.getInputStream());
            } else if (responseCode == 404) {
                String response = readStream(connection.getErrorStream());
                throw new NotFound404Exception(response);
            } else if (responseCode == 500) {
                String response = readStream(connection.getErrorStream());
                throw new InternalServerError500Exception(response);
            } else {
                String response = readStream(connection.getErrorStream());
                throw new GeneralException(response);
            }
        } catch (IOException e) {
            String response = "{ \"Exception\": \"" + e.getClass() + "\", \"Error\": "
            + e.getLocalizedMessage() + " }";
            throw new IOException(response);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * Read the stream from the server.
     * 
     * @param stream the stream
     * @return the string with the content of the stream
     */
    protected static String readStream(InputStream stream) {
        try {
            InputStream str = stream;
            BufferedReader bufferStream = new BufferedReader(new InputStreamReader(str));
            StringBuffer response = new StringBuffer();
            String line;
            while ((line = bufferStream.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }
            stream.close();
            return response.toString();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
            return null;
        }
    }
}
