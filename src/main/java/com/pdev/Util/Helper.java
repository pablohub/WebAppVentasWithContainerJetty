package com.pdev.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Helper {

    public static boolean isNullOrEmpty(String value){
        return value == null || value.isEmpty();
    }

    public static int toInt(String value){
        try{
            return Integer.parseInt(value);
        }catch (Exception e){}
        return 0;
    }

    public static void printJson(HttpServletResponse resp, String data) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();
    }
    public static String getJson(HttpServletRequest req) throws IOException{
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line + "\n");
            line = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }

}
