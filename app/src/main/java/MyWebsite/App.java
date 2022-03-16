/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package MyWebsite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.*;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(App.class);
        logger.error("HATA!!");
        int port = Integer.parseInt(System.getenv("PORT"));
        logger.error("Current port number:" + port);


        get("/", (req, res) -> "Hello, World!!!");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          sc1.close();
          System.out.println(inputList);

          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          sc2.close();
          System.out.println(inputList2);

          String input3 = req.queryParams("input3").replaceAll("\\s","");
          Double input3AsDouble = Double.parseDouble(input3);

          boolean result = App.isEqualArrayListAndMeanIsBiggerElement(inputList, inputList2 ,input3AsDouble);

          Map<String, Boolean> map = new HashMap<String, Boolean>();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map<String, String> map = new HashMap<String, String>();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static boolean isEqualArrayListAndMeanIsBiggerElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, Double k){
        if(arr1 == null || arr2 == null){
            return false;
        }
        
        Collections.sort(arr1);
        Collections.sort(arr2);
        for(int i = 0; i < arr1.size(); i++)
            if(arr1.get(i) != arr2.get(i)){
                return false;
            }
                

        double count = 0;
        for(int i = 0; i < arr1.size(); i++)
            count += arr1.get(i);
        double sum = count / arr1.size();
        if( sum > k)
            return true;
        return false;
    }
 
}
